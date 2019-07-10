package com.rossi.controlejogos.View;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.rossi.controlejogos.R;
import com.rossi.controlejogos.control.MainControle;

public class MainActivity extends Activity {

    private MainControle control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        control = new MainControle(this);
    }

    public  void entrar(View v){
        control.entrarAction();
    }

    public void fechar(View v){control.fecharAction();}
}
