package com.guatedroid;

import java.sql.ResultSet;
import java.sql.Statement;

public class ObtenerTextoLeer {

    private String textoLeer = "";
    public Statement stQuery;
    public ResultSet rsRecords;
    private ConeccionBD BD = null;
    private static String basededatos = utileria.basededatos;
    private static String contrasena = utileria.contrasena;
    private String codigoSesion = "";
    private int[] idPreguntas;

    public ObtenerTextoLeer(String codigoSesion, int[] idPreguntas){
        this.codigoSesion = codigoSesion;
        this.idPreguntas = idPreguntas;
    }

    public String getTextoLeer() {
        return textoLeer;
    }

    public void setTextoLeer(int noPregunta){
        int idPregunta = idPreguntas[noPregunta];

        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();

            String query = "SELECT Lectura FROM preguntasexamen WHERE IDpregunta = '"+idPregunta+"'";


            try
            {
                System.out.println(query);
                stQuery = BD.getCurrentConnection().createStatement();
                rsRecords = stQuery.executeQuery (query);
                if(rsRecords.next()){
                    textoLeer = rsRecords.getString("Lectura");
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
