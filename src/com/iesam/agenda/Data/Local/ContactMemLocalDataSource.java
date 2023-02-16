package com.iesam.agenda.Data.Local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.agenda.Domain.Models.Contacto;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ContactMemLocalDataSource {

    private static ContactMemLocalDataSource instance = null;

    private Gson gson = new Gson();

    private final Type typeContactList = new TypeToken<ArrayList<Contacto>>() {
    }.getType();


}


