package com.guatedroid;
import javax.sound.sampled.Line;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2005003391
 */
public class ImpBD {
    public static Statement stQuery;
    public static ResultSet rsRecords;

    public ImpBD(ImpLineaCSV Linea, int IDpregunta){
        String basededatos = utileria.basededatos;
        String contrasena = utileria.contrasena;
        ConeccionBD BD = null;
        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();
            try
            {
                //INSERT***************************
                Statement stQueryInsert = BD.getCurrentConnection().createStatement();
                String queryInsert = "INSERT INTO preguntasexamen (IDpregunta, Lectura, Pregunta, OpcionA,  OpcionB,  OpcionC,  OpcionD, Correcta, Explicacion) VALUES ("+Integer.toString(IDpregunta)+",'"+Linea.getTextoLeer()+"','"+Linea.getPregunta()+"','"+(Linea.getOpcionA())+"','"+(Linea.getOpcionB())+"','"+(Linea.getOpcionC())+"','"+(Linea.getOpcionD())+"','"+(Linea.getCorrecta())+"','"+(Linea.getExplicacion())+"')";
                System.out.println(queryInsert);
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
