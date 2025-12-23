package com.guatedroid;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vaadin.navigator.Navigator;

public class Finalizar {
    public Statement stQuery;
    public ResultSet rsRecords;
    private ConeccionBD BD = null;
    private static String basededatos = utileria.basededatos;
    private static String contrasena = utileria.contrasena;
    private int puntaje = 0;
    private String codigoSesion = "";
    public static int total = 25;
    private int[] idPreguntas;
    private ExamenAresultado resultadoDespliegue;
    private Navigator navigator;

    Finalizar(String codigoSesion, int[] idPreguntas, String usuarioSesion,Navigator navigator){
        this.navigator = navigator;
        this.codigoSesion = codigoSesion;
        this.idPreguntas = idPreguntas;
        setPuntaje();
        finalizarSesion();
        resultadoDespliegue = new ExamenAresultado(codigoSesion,usuarioSesion,total,puntaje,navigator);
        navigator.addView("ResultadoExamen"+codigoSesion,resultadoDespliegue);
        navigator.navigateTo("ResultadoExamen"+codigoSesion);
    }

    public void setCodigoSesion(String codigo) {
        codigoSesion = codigo;
    }

    private void setPuntaje(){
        String respuesta = "";
        String correcta = "";
        System.out.println("EMPIEZA ANÁLISIS");
        int puntos = 0;
        for(int i=0;i<total;i++){
            int idPregunta = idPreguntas[i];
            respuesta = RespuestaUsuarioBD(i+1);
            correcta = RespuestaCorrectaBD(idPregunta);
            System.out.println("CICLO:"+i);
            if(respuesta.equals("respuestaVacia") || correcta.equals("respuestaVacia")){

            } else {
                if(respuesta.equals(correcta)){
                    System.out.println("Respuesta: " +respuesta+ " Correcta: "+correcta);
                    System.out.println(correcta);
                    puntos++;
                }
            }

        }
        puntaje = puntos;
        puntosBD();
    }

    private void puntosBD(){
        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();

            try
            {

                //INSERT***************************
                Statement stQueryInsert = BD.getCurrentConnection().createStatement();
                String queryInsert = "UPDATE sesiones SET punteo = '"+puntaje+"' WHERE codigo = '"+codigoSesion+"'";
                stQueryInsert.executeUpdate(queryInsert);
                //INSERT***************************

//                //DELETE***************************
//                Statement stQueryDelete = BD.getCurrentConnection().createStatement();
//                String queryDelete = "DELETE FROM bimestres WHERE bimestres.bimestre = '5' ";
//                stQueryDelete.executeUpdate(queryDelete);
//                //DELETE***************************

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

    private String RespuestaUsuarioBD(int i){
        String resp = "";
        String respuestaUsuario = "";
        resp = "reP" + Integer.toString(i);
        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();

            String query = "SELECT "+resp+" FROM sesiones WHERE codigo = '"+codigoSesion+"'";


            try
            {
                System.out.println(query);
                stQuery = BD.getCurrentConnection().createStatement();
                rsRecords = stQuery.executeQuery (query);
                if(rsRecords.next()){
                    respuestaUsuario = rsRecords.getString(resp);
                    System.out.println("Respuesta: "+respuestaUsuario);
                } else {
                    respuestaUsuario = "";
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

        return respuestaUsuario;
    }

    private String RespuestaCorrectaBD(int idPregunta){
        String correcta ="";
        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();

            String query = "SELECT Correcta FROM preguntasexamen WHERE IDpregunta = '"+idPregunta+"'";


            try
            {
                System.out.println(query);
                stQuery = BD.getCurrentConnection().createStatement();
                rsRecords = stQuery.executeQuery (query);
                if(rsRecords.next()){
                    correcta = rsRecords.getString("Correcta");
                    System.out.println("Correcta: "+correcta);
                } else {
                    correcta = "";
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
        return correcta;
    }

    private void finalizarSesion(){
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss");
        String fecha = hourdateFormat.format(date);
        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();

            try
            {

                //INSERT***************************
                Statement stQueryInsert = BD.getCurrentConnection().createStatement();
                String queryInsert = "UPDATE sesiones SET abierta = 'false' WHERE codigo = '"+codigoSesion+"' ";
                stQueryInsert.executeUpdate(queryInsert);
                //INSERT***************************

//                //DELETE***************************
//                Statement stQueryDelete = BD.getCurrentConnection().createStatement();
//                String queryDelete = "DELETE FROM bimestres WHERE bimestres.bimestre = '5' ";
//                stQueryDelete.executeUpdate(queryDelete);
//                //DELETE***************************

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
        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();

            try
            {

                //INSERT***************************
                Statement stQueryInsert = BD.getCurrentConnection().createStatement();
                String queryInsert = "UPDATE sesiones SET horaFinal = '"+fecha+"' WHERE codigo = '"+codigoSesion+"' ";
                stQueryInsert.executeUpdate(queryInsert);
                //INSERT***************************

//                //DELETE***************************
//                Statement stQueryDelete = BD.getCurrentConnection().createStatement();
//                String queryDelete = "DELETE FROM bimestres WHERE bimestres.bimestre = '5' ";
//                stQueryDelete.executeUpdate(queryDelete);
//                //DELETE***************************

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
