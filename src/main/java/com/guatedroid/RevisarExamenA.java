package com.guatedroid;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.sql.ResultSet;
import java.sql.Statement;
import com.vaadin.navigator.Navigator;

public class RevisarExamenA extends VerticalLayout implements View {
    private int idPregunta = 1;
    private String idQuestion = "";
    public Statement stQuery;
    public ResultSet rsRecords;
    private ConeccionBD BD = null;
    private String basededatos = utileria.basededatos;
    private String contrasena = utileria.contrasena;
    private String codigoSesion = "";
    private String usuarioSesion = "";
    private Navigator navigator;

    public RevisarExamenA(String codigoSesion, String usuarioSesion, Navigator navigator){
        this.codigoSesion = codigoSesion;
        this.usuarioSesion = usuarioSesion;
        this.navigator = navigator;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event){
        removeAllComponents();
        idQuestion = obtenerIdPregunta();
        idPregunta = 1;
        HorizontalLayout contenedorL = new HorizontalLayout();
        VerticalLayout izquierdoL = new VerticalLayout();
        Panel izquierdoP = new Panel();
        VerticalLayout derechoL = new VerticalLayout();
        Panel derechoP = new Panel();

        //A continuación el lado izquierdo
        Label textoLeerL = new Label();
        Panel textoLeerP = new Panel("Este es el texto que se dió a leer: ");
        textoLeerL.setValue(textoAobtener("Lectura"));
        Label textoPreguntaL = new Label();
        Panel textoPreguntaP = new Panel("Este es el texto de lectura: ");
        textoPreguntaL.setValue(textoAobtener("Pregunta"));

        HorizontalLayout respuestasL = new HorizontalLayout();
        Label respuestaAlumno = new Label("Respuesta Alumno");
        Panel respuestasAlumnoP = new Panel("Esta es la respuesta que usted escribió: ");
        respuestaAlumno.setValue(respuestaAlumno());
        respuestasAlumnoP.setContent(respuestaAlumno);
        Label respuestaCorrecta = new Label("Respuesta Correcta");
        Panel respuestaCorrectaP = new Panel("Esta es la respuesta correcta: ");
        respuestaCorrecta.setValue(textoAobtener("Correcta"));
        respuestaCorrectaP.setContent(respuestaCorrecta);

        Button anterior = new Button("Anterior");
        anterior.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
               if(idPregunta==1){
                   idPregunta=25;
               } else {
                   idPregunta--;
               }
               idQuestion = obtenerIdPregunta();
                textoLeerL.setValue(textoAobtener("Lectura"));
                textoPreguntaL.setValue(textoAobtener("Pregunta"));
                respuestaAlumno.setValue(respuestaAlumno());
                respuestaCorrecta.setValue(textoAobtener("Correcta"));
            }
        });

        Button siguiente = new Button("Siguiente");
        siguiente.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                if(idPregunta==25){
                    idPregunta=1;
                } else {
                    idPregunta++;
                }
                idQuestion = obtenerIdPregunta();
                textoLeerL.setValue(textoAobtener("Lectura"));
                textoPreguntaL.setValue(textoAobtener("Pregunta"));
                respuestaAlumno.setValue(respuestaAlumno());
                respuestaCorrecta.setValue(textoAobtener("Correcta"));
            }
        });

        Button terminar = new Button("Terminar revisión e ir al menú");
        terminar.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                navigator.navigateTo("MenuAlumno"+usuarioSesion);
            }
        });

        Panel explicacionP = new Panel("Explicación de la respuesta correcta:");
        Label explicacionL = new Label(textoAobtener("Explicacion"));
        explicacionP.setContent(explicacionL);
        derechoL.addComponent(explicacionP);

        HorizontalLayout botonesL = new HorizontalLayout();
        botonesL.addComponent(anterior);
        botonesL.addComponent(siguiente);
        botonesL.addComponent(terminar);
        Panel botonesP = new Panel();
        botonesP.setContent(botonesL);

        respuestasL.addComponent(respuestaCorrectaP);
        respuestasL.addComponent(respuestasAlumnoP);
        textoLeerP.setContent(textoLeerL);
        textoPreguntaP.setContent(textoPreguntaL);
        izquierdoL.addComponent(textoLeerP);
        izquierdoL.addComponent(textoPreguntaP);
        izquierdoL.addComponent(respuestasL);
        izquierdoL.addComponent(botonesP);
        izquierdoP.setContent(izquierdoL);
        derechoP.setContent(derechoL);
        contenedorL.addComponent(izquierdoP);
        contenedorL.addComponent(derechoP);
        addComponent(contenedorL);
    }

    public String obtenerIdPregunta(){
        String pregunta = "noP"+Integer.toString(idPregunta);
        String idPregunta = "";
        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();
            String query = "SELECT * FROM sesiones WHERE codigo = '"+codigoSesion+"'";
            try
            {
                System.out.println(query);
                stQuery = BD.getCurrentConnection().createStatement();
                rsRecords = stQuery.executeQuery (query);
                if(rsRecords.next()){
                    idPregunta = rsRecords.getString(pregunta);
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
        return idPregunta;
    }
    public String textoAobtener(String value){
        String textoAobtener = "";
        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();
            String query = "SELECT "+value+" FROM preguntasexamen WHERE IDpregunta = '"+idQuestion+"'";
            try
            {
                System.out.println(query);
                stQuery = BD.getCurrentConnection().createStatement();
                rsRecords = stQuery.executeQuery (query);
                if(rsRecords.next()){
                    textoAobtener = rsRecords.getString(value);
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
        return textoAobtener;
    }
    public String respuestaAlumno(){
        String pregunta = "reP"+Integer.toString(idPregunta);
        String respuestaAlumno = "";
        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();
            String query = "SELECT * FROM sesiones WHERE codigo = '"+codigoSesion+"'";
            try
            {
                System.out.println(query);
                stQuery = BD.getCurrentConnection().createStatement();
                rsRecords = stQuery.executeQuery (query);
                if(rsRecords.next()){
                    respuestaAlumno = rsRecords.getString(pregunta);
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
        return respuestaAlumno;
    }
}
