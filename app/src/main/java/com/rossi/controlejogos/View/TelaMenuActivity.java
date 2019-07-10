package com.rossi.controlejogos.View;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.rossi.controlejogos.R;
import com.rossi.controlejogos.control.MainControle;

public class TelaMenuActivity extends Activity {

    private MainControle control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_menu);

        control = new MainControle(this);
    }

    public void telaCadastro(View v) {
        control.telaCadastroAction();
    }

    public void telaListar(View v){
        control.telaListarAction();
    }

    public void telaCep(View v){control.telaEndereoAction();}

    public void sairP(View v){
        control.fecharJanelaAction();
    }

}
