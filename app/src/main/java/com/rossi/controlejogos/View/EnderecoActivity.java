package com.rossi.controlejogos.View;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.rossi.controlejogos.R;
import com.rossi.controlejogos.control.EnderecoControle;

public class EnderecoActivity extends Activity {
private EnderecoControle controle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endereco);
        controle = new EnderecoControle(this);
    }

    public void buscar_cep(View v){
        controle.buscarCep();
    }
}
