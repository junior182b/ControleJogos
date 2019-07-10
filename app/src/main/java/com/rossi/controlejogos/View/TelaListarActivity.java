package com.rossi.controlejogos.View;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rossi.controlejogos.R;

import com.rossi.controlejogos.control.PesquisarControle;

public class TelaListarActivity extends Activity {

    private PesquisarControle control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_listar);
        control = new PesquisarControle(this);
    }



    public void voltar(View v) {
        control.voltarAction();
    }


    @Override
    protected void onResume() {
        super.onResume();
        control.configurarListView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        control.onActivityResult(requestCode, resultCode, data);
    }

}

