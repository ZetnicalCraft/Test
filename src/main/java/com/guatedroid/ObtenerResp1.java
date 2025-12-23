package com.guatedroid;

import java.sql.ResultSet;
import java.sql.Statement;

public class ObtenerResp1 {
    private String textoPregunta = "";
    public Statement stQuery;
    public ResultSet rsRecords;
    private ConeccionBD BD = null;
    private String basededatos = utileria.basededatos;
    private String contrasena = utileria.contrasena;
    private String codigoSesion = "";
    private int[] idPreguntas;

    public ObtenerResp1(String codigoSesion, int[] idPreguntas){
        this.codigoSesion = codigoSesion;
        this.idPreguntas = idPreguntas;
    }

    public String getResp1() {
        return textoPregunta;
    }

    public void setResp1(int noPregunta, String Opcion) {
        int idPregunta = idPreguntas[noPregunta];

        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();

            String query = "SELECT "+Opcion+" FROM preguntasexamen WHERE IDpregunta = '"+idPregunta+"'";


            try
            {
                System.out.println(query);
                stQuery = BD.getCurrentConnection().createStatement();
                rsRecords = stQuery.executeQuery (query);
                if(rsRecords.next()){
                    textoPregunta = rsRecords.getString(Opcion);
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
