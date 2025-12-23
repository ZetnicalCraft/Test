package com.guatedroid;

import java.sql.ResultSet;
import java.sql.Statement;

public class ObtenerPregunta {
    private String textoPregunta = "";
    private Statement stQuery;
    private ResultSet rsRecords;
    private ConeccionBD BD = null;
    private static String basededatos = utileria.basededatos;
    private static String contrasena = utileria.contrasena;
    private int[] idPreguntas;
    private String codigoSesion;
    public ObtenerPregunta(String codigoSesion, int[] idPreguntas){
        this.codigoSesion = codigoSesion;
        this.idPreguntas = idPreguntas;
    }

    public String getPregunta() {
        return textoPregunta;
    }

    public void setTextoPregunta(int noPregunta) {
        int idPregunta = idPreguntas[noPregunta];

        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();

            String query = "SELECT Pregunta FROM preguntasexamen WHERE IDpregunta = '"+idPregunta+"'";


            try
            {
                System.out.println(query);
                stQuery = BD.getCurrentConnection().createStatement();
                rsRecords = stQuery.executeQuery (query);
                if(rsRecords.next()){
                    textoPregunta = rsRecords.getString("Pregunta");
                }
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
