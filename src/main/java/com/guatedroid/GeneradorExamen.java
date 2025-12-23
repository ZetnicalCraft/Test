package com.guatedroid;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GeneradorExamen {
    private String codigoSesion = "";
    private String usuarioSesion = "";
    public static int numeroPreguntas;
    private int[] noPreguntas; //Por ahora esto se queda por defecto. Luego se eligirá al azar.
    public Statement stQuery;
    public ResultSet rsRecords;
    private ConeccionBD BD = null;
    private String basededatos = utileria.basededatos;
    private String contrasena = utileria.contrasena;
    public int noPreguntasDisponibles = 0;

    public GeneradorExamen(String usuarioSesion){
        this.usuarioSesion=usuarioSesion;
    }
    public String getCodigoSesion() {
        return codigoSesion;
    }
    public int[] getNoPreguntas(){
        return noPreguntas;
    }
    public void inicializarExamen(){
        noPreguntas = setNoPreguntas();
        BD = null;
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss");
        String fecha = hourdateFormat.format(date);
        codigoSesion = genCodigo();
        String basededatos = "evaluacioninterna";
        String contrasena = "infobi17";

        ConeccionBD BD = null;
        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();

            try
            {

                //INSERT***************************
                Statement stQueryInsert = BD.getCurrentConnection().createStatement();
                String queryInsert = "INSERT INTO sesiones (IDusuario, codigo, horaInicio) VALUES ("+usuarioSesion+",'"+codigoSesion+"','"+fecha+"') ";
                stQueryInsert.executeUpdate(queryInsert);
                //INSERT***************************

                System.out.println("********************* SESION INICIADA ************************\n");

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
        ingresarNoPreg();
        iniciarSesion();
    }
    public void ingresarNoPreg(){
        String basededatos = "evaluacioninterna";
        String contrasena = "infobi17";
        String noPreg = "";
        int noP = 0;
        ConeccionBD BD = null;

        for(int i=1; i<=noPreguntas.length; i++){
            noPreg = "noP"+Integer.toString(i);
            noP = noPreguntas[i-1];
            try
            {
                BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
                BD.getNewConnection();

                try
                {

                    //INSERT***************************
                    Statement stQueryInsert = BD.getCurrentConnection().createStatement();
                    String queryInsert = "UPDATE sesiones SET "+noPreg+" = '"+Integer.toString(noP)+"' WHERE codigo = '"+codigoSesion+"' ";
                    stQueryInsert.executeUpdate(queryInsert);
                    //INSERT***************************

                    System.out.println("noPreg: "+noPreg+" noP:"+Integer.toString(noP)+"Query"+queryInsert);

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
    public int getIdPregunta(int noPregunta){
        return noPreguntas[noPregunta];
    }
    public String genCodigo(){
        Random random = new Random();
        int aleatorio = random.nextInt(1000);
        String alea = Integer.toString(aleatorio);
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fecha = hourdateFormat.format(date);
        String codigo = usuarioSesion +alea+fecha;
        return codigo;
    }
    public String getFecha(){
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String fecha = hourdateFormat.format(date);
        return fecha;
    }
    private void iniciarSesion(){
        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();

            try
            {

                //INSERT***************************
                Statement stQueryInsert = BD.getCurrentConnection().createStatement();
                String queryInsert = "UPDATE sesiones SET abierta = 'true' WHERE codigo = '"+codigoSesion+"' ";
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
                String queryInsert = "UPDATE sesiones SET fecha = '"+getFecha()+"' WHERE codigo = '"+codigoSesion+"' ";
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
    public void setNoPreguntasDisponibles(){
        System.out.println("Set iniciado");
        String respuesta = "";
        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();
            String query = "SELECT NoPreguntas FROM numeropreguntas";

            try
            {
                System.out.println(query);
                stQuery = BD.getCurrentConnection().createStatement();
                rsRecords = stQuery.executeQuery (query);
                if(rsRecords.next()){
                    respuesta = rsRecords.getString("NoPreguntas");
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
        System.out.println("NoPreguntas: "+respuesta);
        noPreguntasDisponibles=  Integer.parseInt(respuesta);
    }
    private int[] setNoPreguntas(){
        Random random = new Random();
        System.out.println("preguntasDisponibles: "+ Integer.toString(noPreguntasDisponibles));
        int r = noPreguntasDisponibles%25;
        System.out.println("r: " + Integer.toString(r));
        int intervalo = (noPreguntasDisponibles-r)/25;
        System.out.println("intervalo: "+Integer.toString(intervalo));
        int[] resultado = new int[25];
        for(int i=0;i<25;i++){
            int rando = random.nextInt(intervalo);
            resultado[i] = rando+(i*intervalo)+1;
        }
        for(int i=0;i<25;i++){
            System.out.print(resultado[i]+", ");
        }
        return resultado;
    }
}
