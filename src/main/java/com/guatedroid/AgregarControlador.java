package com.guatedroid;

import java.sql.ResultSet;
import java.sql.Statement;

public class AgregarControlador {
    private ImportarCSV importar;
    public static Statement stQuery;
    public static ResultSet rsRecords;
    public  AgregarControlador(String todoElTexto){
        borrarBaseDatos();
        System.out.println("Todo el texto: "+todoElTexto);
        String[] textoLineas = todoElTexto.split("\n");
        System.out.println("Numero de ciclos que se deberían de hacer: " +textoLineas.length);
        for(int i = 0;i<textoLineas.length;i++){
            System.out.println("Comenzando linea: " +(i+1));
            importar = new ImportarCSV(textoLineas[i],i+1);
        }
        noPreguntas(textoLineas.length);
    }
    public void borrarBaseDatos(){
        String basededatos = utileria.basededatos;
        String contrasena = utileria.contrasena;
        ConeccionBD BD = null;
        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();
            try
            {
               //DELETE***************************
                Statement stQueryDelete = BD.getCurrentConnection().createStatement();
                String queryDelete = "DELETE FROM preguntasexamen";
                stQueryDelete.executeUpdate(queryDelete);
                //DELETE***************************

                BD.closeConnection();
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }
        catch (Exception e0)
        {
            e0.printStackTrace();
        }
    }
    public void noPreguntas(int noPreguntas){
        String basededatos = utileria.basededatos;
        String contrasena = utileria.contrasena;
        ConeccionBD BD = null;
        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();
            try
            {
                //DELETE***************************
                Statement stQueryDelete = BD.getCurrentConnection().createStatement();
                String queryDelete = "DELETE FROM numeropreguntas";
                stQueryDelete.executeUpdate(queryDelete);
               //DELETE***************************
                //INSERT***************************
                Statement stQueryInsert = BD.getCurrentConnection().createStatement();
                String queryInsert = "INSERT INTO numeropreguntas (NoPreguntas) VALUES ("+Integer.toString(noPreguntas)+")";
                System.out.println(queryInsert);
                stQueryInsert.executeUpdate(queryInsert);
                //INSERT***************************
                BD.closeConnection();
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }
        catch (Exception e0)
        {
            e0.printStackTrace();
        }
    }
}
