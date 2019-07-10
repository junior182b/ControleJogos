package com.rossi.controlejogos.control;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.rossi.controlejogos.R;
import com.rossi.controlejogos.View.TelaCadastroActivity;
import com.rossi.controlejogos.View.TelaListarActivity;
import com.rossi.controlejogos.View.TelaMenuActivity;
import com.rossi.controlejogos.dao.JogoDao;
import com.rossi.controlejogos.model.Jogo;

import java.sql.SQLException;

public class PesquisarControle {

    private Activity activity;
    private ListView lvJogo;
    private ArrayAdapter<Jogo> adapterJogos;
    private JogoDao jogoDao;
    private Jogo jogo;


    public PesquisarControle(Activity activity) {
        this.activity = activity;
        jogoDao = new JogoDao(this.activity);
        initcomponents();
    }

    private void initcomponents() {
      lvJogo = activity.findViewById(R.id.lvJogos);
        configurarListView();
        cliqueCurto();
        cliqueLongo();
    }

    public void configurarListView(){
        try {
            adapterJogos = new ArrayAdapter<>(
                    activity,
                    android.R.layout.simple_list_item_1,
                    jogoDao.getDao().queryForAll()
            );
            lvJogo.setAdapter(adapterJogos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void cliqueCurto() {
        lvJogo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                jogo = adapterJogos.getItem(position);
                AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
                alerta.setTitle("Mostrando jogo");
                alerta.setMessage(jogo.toString());
                alerta.setNeutralButton("Fechar", null);
                alerta.setPositiveButton("Editar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        jogo = (Jogo) lvJogo.getItemAtPosition(position);
                        Intent it = new Intent(activity, TelaCadastroActivity.class);
                        it.putExtra("jogo", jogo);
                        activity.startActivityForResult(it, 999);
                    }
                });
                alerta.show();
            }
        });
    }

    private void cliqueLongo() {
        lvJogo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                jogo = adapterJogos.getItem(position);
                AlertDialog.Builder alerta = new AlertDialog.Builder(activity);
                alerta.setTitle("Excluindo jogo");
                alerta.setMessage("Deseja realmente excluir o jogo " + jogo.getNome() + "?");
                alerta.setIcon(android.R.drawable.ic_menu_delete);
                alerta.setNeutralButton("Não", null);
                alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            jogoDao.getDao().delete(jogo);
                            adapterJogos.remove(jogo);
                            jogo = null;
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
                alerta.show();
                return true;
            }
        });
    }
        public void voltarAction(){
            Intent it = new Intent(activity, TelaMenuActivity.class);
            activity.startActivity(it);
        }



    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 666 && resultCode == activity.RESULT_OK) {
           jogo = (Jogo) data.getSerializableExtra("jogo");
            jogo.setNome(jogo.getNome());
            try {
                jogoDao.getDao().create(jogo);
                Toast.makeText(activity, R.string.mens_cadSuc, Toast.LENGTH_LONG).show();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            jogo = null;
        } else if (requestCode == 999 && resultCode == activity.RESULT_OK) {
            Jogo j = (Jogo) data.getSerializableExtra("jogo");
            jogo.setNome(j.getNome());
            jogo.setAno(j.getAno());
            jogo.setGenero(j.getGenero());
            jogo.setPlataforma(j.getPlataforma());
            jogo.setProdutora(j.getProdutora());
            adapterJogos.notifyDataSetChanged();
            try {
                jogoDao.getDao().update(jogo);
                Toast.makeText(activity, R.string.mens_editSuc, Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            jogo = null;
        } else if (resultCode == activity.RESULT_CANCELED) {
            Toast.makeText(activity, "Cancelou", Toast.LENGTH_SHORT).show();
        }

    }
}
