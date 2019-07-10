package com.rossi.controlejogos.control;

import android.app.Activity;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;
import com.rossi.controlejogos.R;
import com.rossi.controlejogos.View.TelaCadastroActivity;
import com.rossi.controlejogos.View.TelaMenuActivity;
import com.rossi.controlejogos.dao.JogoDao;
import com.rossi.controlejogos.model.Jogo;

import java.sql.SQLException;

public class CadastrarControle {

    private Activity activity;
    private EditText editNome;
    private EditText editAno;
    private EditText editPlataforma;
    private EditText editGenero;
    private EditText editProdutora;
    private Jogo jogo = null;
    private JogoDao jogoDao;
    private Jogo editJogo;


    public CadastrarControle(Activity activity) {
        this.activity = activity;

        editJogo= (Jogo) activity.getIntent().getSerializableExtra("jogo");
        jogoDao = new JogoDao(this.activity);
        initComponents();

        if(editJogo !=null){
            editNome.setText(editJogo.getNome());
            editAno.setText(editJogo.getAno());
            editPlataforma.setText(editJogo.getPlataforma());
            editGenero.setText(editJogo.getGenero());
            editProdutora.setText(editJogo.getProdutora());
        }

        }


    private void initComponents() {

        editNome = activity.findViewById(R.id.editNome);
        editAno = activity.findViewById(R.id.editAno);
        editPlataforma = activity.findViewById(R.id.editPlataforma);
        editGenero = activity.findViewById(R.id.editGenero);
        editProdutora = activity.findViewById(R.id.editProdutora);
    }

    public void cadastrarAction() {

            if (jogo == null) {
                jogo = new Jogo();
            }
            jogo.setNome(editNome.getText().toString());
            jogo.setGenero(editGenero.getText().toString());
            jogo.setAno(editAno.getText().toString());
            jogo.setPlataforma(editPlataforma.getText().toString());
            jogo.setProdutora(editProdutora.getText().toString());

        if (editNome.getText().toString().trim().isEmpty()) {
            Toast.makeText(activity, R.string.mens_cadSemSuc, Toast.LENGTH_SHORT).show();
            return;
        } else if (editAno.getText().toString().trim().isEmpty()) {
            Toast.makeText(activity, R.string.mens_cadSemSuc, Toast.LENGTH_SHORT).show();
            return;
        }

            try {
                Dao.CreateOrUpdateStatus res = jogoDao.getDao().createOrUpdate(jogo);
                if (res.isCreated()){
                    Toast.makeText(activity, R.string.mens_cadSuc, Toast.LENGTH_LONG).show();
                }else if (res.isUpdated()){
                    Toast.makeText(activity, R.string.mens_editSuc, Toast.LENGTH_SHORT).show();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        Intent it = new Intent();
        it.putExtra("jogo", jogo);
        activity.setResult(activity.RESULT_OK, it);
        activity.finish();


        }

    public void voltarAction() {
        Intent it = new Intent(activity, TelaMenuActivity.class);
        activity.startActivity(it);
    }


}
