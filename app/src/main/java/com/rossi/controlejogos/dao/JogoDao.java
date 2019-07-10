package com.rossi.controlejogos.dao;

import android.content.Context;

import com.rossi.controlejogos.dao.helpers.DaoHelper;
import com.rossi.controlejogos.model.Jogo;

public class JogoDao extends DaoHelper<Jogo> {

 public JogoDao(Context c){
     super(c,Jogo.class);
    }
}

