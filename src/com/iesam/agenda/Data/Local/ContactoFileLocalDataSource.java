package com.iesam.agenda.Data.Local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.agenda.Domain.Models.Contacto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ContactoFileLocalDataSource {

    private static ContactoFileLocalDataSource instance = null;

    private Gson gson = new Gson();

    private final Type typeAlumnList = new TypeToken<ArrayList<Contacto>>() {
    }.getType();

    private ContactoFileLocalDataSource() {
    }

    public void save(Contacto contacto) {
        List<Contacto> contactos = findAll();
        contactos.add(contacto);
        saveToFile(contactos);
    }

    private void saveToFile(List<Contacto> alumnos) {
        try {
            FileWriter myWriter = new FileWriter("alumnos.txt");
            myWriter.write(gson.toJson(alumnos));
            myWriter.close();
            System.out.println("Alumno guardado correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
        }
    }


    public Contacto findById(Integer alumnoId) {
        List<Contacto> contactos = findAll();
        for (Contacto contacto : contactos) {
            if (Objects.equals(contacto.getId(), alumnoId)) {
                return contacto;
            }
        }
        return null;
    }

    public List<Contacto> findAll() {
        try {
            File myObj = new File("alumnos.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeAlumnList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return new ArrayList<Contacto>();
    }

    public static ContactoFileLocalDataSource getInstance() {
        if (instance == null) {
            instance = new ContactoFileLocalDataSource();
        }
        return instance;
    }
}
