package com.rossi.controlejogos.control;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import com.rossi.controlejogos.View.EnderecoActivity;
import com.rossi.controlejogos.View.MainActivity;
import com.rossi.controlejogos.View.TelaCadastroActivity;
import com.rossi.controlejogos.View.TelaListarActivity;
import com.rossi.controlejogos.View.TelaMenuActivity;

public class MainControle {
    private Activity activity;


    public MainControle(Activity activity) {
        this.activity = activity;
    }

    public void entrarAction() {
        Intent it = new Intent(activity, TelaMenuActivity.class);
        activity.startActivity(it);
    }

    public void fecharJanelaAction() {
            Intent intent = new Intent( activity,MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |    Intent.FLAG_ACTIVITY_CLEAR_TASK);
            activity.startActivity(intent);
            activity.finish();

        }

    public void fecharAction(){

            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage("Voce quer mesmo sair?");
            builder.setCancelable(true);
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    activity.finish();
                    System.exit(0);

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });
            AlertDialog alert = builder.create();
            alert.show();

        }


    public void telaCadastroAction() {
        Intent it = new Intent(activity, TelaCadastroActivity.class);
        activity.startActivity(it);
    }

    public void telaListarAction() {
        Intent it = new Intent(activity, TelaListarActivity.class);
        activity.startActivity(it);
    }

    public void telaEndereoAction(){
        Intent it = new Intent(activity, EnderecoActivity.class);
        activity.startActivity(it);
    }

}
