package com.rossi.controlejogos.dao;

import android.content.Context;

import com.rossi.controlejogos.dao.helpers.DaoHelper;
import com.rossi.controlejogos.model.Endereco;
import com.rossi.controlejogos.model.Jogo;

public class EnderecoDao extends DaoHelper<Endereco> {
    public EnderecoDao(Context c){
        super(c,Endereco.class);
    }
}

