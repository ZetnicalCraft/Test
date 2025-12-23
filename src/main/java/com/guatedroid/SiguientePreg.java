package com.guatedroid;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Statement;

public class SiguientePreg {

    public Statement stQuery;
    public ResultSet rsRecords;
    private String textoOpen = "";
    private ConeccionBD BD = null;
    private String basededatos = "evaluacioninterna";
    private String contrasena = "infobi17";
    private String codigo = "";


    public SiguientePreg(String codigoSesion){
        codigo = codigoSesion;
    }

    public void SiguientePregunta(String respuestaUsuario, int noPregunta){
        if(isOpen()==true){
            if(isTime()==true){
                ejecutarSiguientePregunta(respuestaUsuario, noPregunta);
            } else {
                System.out.println("Se acabó el tiempo");
            }
        } else {
            System.out.println("Se cerró la sesión");
        }

    }

    public void ejecutarSiguientePregunta(String respuestaUsuario, int idPregunta){
        try{
            SiguienteBD(respuestaUsuario,idPregunta);
            System.out.println("Loco");
        }catch (Exception e0){
            System.out.println("No se pudo enviar la respuesta a la base de datos");
        }

        isTime();
    }
    private void SiguienteBD(String respuestaUsuario, int noPreg){
        String basededatos = utileria.basededatos;
        String contrasena = utileria.contrasena;
        String preg = "reP" + Integer.toString(noPreg+1);
        ConeccionBD BD = null;
        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();

            try
            {

                //INSERT***************************
                Statement stQueryInsert = BD.getCurrentConnection().createStatement();
                String queryInsert = "UPDATE sesiones SET "+preg+" = '"+respuestaUsuario+"' WHERE codigo = '"+codigo+"'";
                stQueryInsert.executeUpdate(queryInsert);
                System.out.println("Respuesta enviada:"+respuestaUsuario);
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
    private boolean isOpen(){
        boolean abierto = false;
        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();

            String query = "SELECT abierta FROM sesiones WHERE codigo = '"+codigo+"'";


            try
            {
                System.out.println(query);
                stQuery = BD.getCurrentConnection().createStatement();
                rsRecords = stQuery.executeQuery (query);
                if(rsRecords.next()){
                    textoOpen = rsRecords.getString("abierta");
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
        if(textoOpen.equals("true")){
            abierto = true;
        }
        return abierto;
    }
    private boolean isTime(){
        boolean abierto = false;
        String horaInicio = horaInicio();
        Date dateFinal = ParseFecha(horaInicio);
        Date Final = sumarHoras(dateFinal, 1);
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss");
        String horaFinal = hourdateFormat.format(Final);
        Date actual = new Date();
        DateFormat hourdateForma = new SimpleDateFormat("HH:mm:ss");
        String horaActual = hourdateForma.format(actual);
        if(actual.after(Final)){
            abierto = true;
        }
        System.out.println("HoraInicio: "+horaInicio+" Hora Final: "+horaFinal+" Hora Actual: "+horaActual);
        return abierto;
    }
    private String horaInicio(){
        String date = "";
        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();
            String query = "SELECT horaInicio FROM sesiones WHERE codigo = '"+codigo+"'";
            try
            {
                System.out.println(query);
                stQuery = BD.getCurrentConnection().createStatement();
                rsRecords = stQuery.executeQuery (query);
                if(rsRecords.next()){
                    date = rsRecords.getString("horaInicio");
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
        return date;
    }
    public Date sumarHoras(Date fecha, int horas){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.HOUR, horas);  // numero de horas a añadir, o restar en caso de horas<0

        return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas

    }
    public Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        }
        catch (ParseException ex)
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
}
