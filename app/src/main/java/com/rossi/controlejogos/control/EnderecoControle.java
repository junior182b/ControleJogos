package com.rossi.controlejogos.control;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


import com.rossi.controlejogos.R;
import com.rossi.controlejogos.dao.EnderecoDao;
import com.rossi.controlejogos.dao.helpers.EnderecoResposta;
import com.rossi.controlejogos.model.Endereco;

import java.util.concurrent.ExecutionException;

public class EnderecoControle {

    private Activity activity;
    private EditText cepInformado;
    private String cep;
    private TextView lvCep;
    EnderecoDao enderecoDao;
    Endereco endereco;

    public EnderecoControle(Activity activity) {
        this.activity = activity;
        enderecoDao= new EnderecoDao(activity);
        initcomponets();
    }

    private void initcomponets() {

        lvCep = activity.findViewById(R.id.respostaCEP);
        cepInformado = activity.findViewById(R.id.cep_informado);
    }



 public void buscarCep() {
     final LinearLayout linearLayout = activity.findViewById(R.id.linear_layout_main);

     cep = cepInformado.getText().toString();

     if (cep == null || cep.isEmpty()) {
         Snackbar.make(linearLayout, "Favor informar um CEP válido",
                 Snackbar.LENGTH_SHORT).show();
     } else {

         try {
             Endereco retorno = new EnderecoResposta(cep).execute().get();
             lvCep.setText(retorno.toString());
         } catch (InterruptedException e) {
             e.printStackTrace();
         } catch (ExecutionException e) {
             e.printStackTrace();
         }

     }
 }


}
