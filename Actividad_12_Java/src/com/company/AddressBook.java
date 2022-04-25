package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.io.FileWriter;

public class AddressBook {
    private HashMap<String, String> contactosHashMap = new HashMap<String, String>();
    private String contactosString = "contactos.txt";
    private BufferedReader bufferedReader = null;
    private BufferedWriter bufferedWriter = null;

    public HashMap<String, String> getContactosHashMap() {
        return contactosHashMap;
    }

    public void Load() {
        try {
            bufferedReader = new BufferedReader(new FileReader(contactosString));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] partes = line.split(",");
                contactosHashMap.put(partes[1], partes[0]);
            }
        } catch (IOException e) {
            System.out.println("IOException catched while reading: " + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }

    private void Save() {
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(contactosString));
            String line;
            for (String i : getContactosHashMap().keySet()) {
                line = (getContactosHashMap().get(i)+","+i);
                bufferedWriter.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }

    public void List() {
        System.out.println("Contactos:");
        for (String i : getContactosHashMap().keySet()) {
            System.out.println(i + " : "+getContactosHashMap().get(i));
        }
        if (getContactosHashMap().isEmpty()) {
            System.out.println("No hay contactos");
        }
    }

    public void Create(String numero, String nombre) {
        getContactosHashMap().put(numero, nombre);
        Save();
    }

    public void Delete(String numero) {
        getContactosHashMap().remove(numero);
        Save();
    }
}
