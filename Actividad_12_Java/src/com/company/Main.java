package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String opcion = null;
        String numero = null;
        String nombre = null;
        boolean loop = true;
	    AddressBook ab = new AddressBook();
        ab.Load();

        System.out.println("Agenda de contactos teléfonicos");

        while (loop) {
            System.out.println("\n¿Qué deseas hacer?\n1)Ver contactos\t\t2)Agregar un contacto\n3)Borrar un contacto\t4)Salir");
            try {
                opcion = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            char inputChar = opcion.charAt(0);

            switch (inputChar) {
                case '1':
                    ab.List();
                    break;
                case '2':
                    System.out.println("Ingresa el nombre del contacto:");
                    try {
                        nombre = reader.readLine();
                        System.out.println("Ingresa el número del contacto:");
                        numero = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ab.Create(numero, nombre);
                    break;
                case '3':
                    System.out.println("Ingresa el número del contacto que deseas eliminar:");
                    try {
                        numero = reader.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ab.Delete(numero);
                    break;
                case '4':
                    loop = false;
                    break;
                default:
                    System.out.println("Ingresa una opción valida");
            }
        }
    }
}
