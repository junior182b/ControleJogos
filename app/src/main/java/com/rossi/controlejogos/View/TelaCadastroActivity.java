package com.rossi.controlejogos.View;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.rossi.controlejogos.R;
import com.rossi.controlejogos.control.CadastrarControle;

public class TelaCadastroActivity extends Activity {

    private CadastrarControle control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);
        control = new CadastrarControle(this);
    }

    public  void cadastrar(View v){
        control.cadastrarAction();
    }

    public void voltar(View v){
        control.voltarAction();
    }
}
