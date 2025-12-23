package com.guatedroid;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.navigator.Navigator;

public class ProfesorM extends VerticalLayout implements View{
    public String usuarioSesion = "";
    private ResultadosMP resultados;
    private AgregarPreguntas preguntas;
    private String codigo = "";
    private Navigator navigator;


    public ProfesorM(String usuarioSesion, String codigo, Navigator navigator){
        this.usuarioSesion = usuarioSesion;
        this.codigo = codigo;
        this.navigator = navigator;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event){


        setSizeFull();
        removeAllComponents();
        HorizontalLayout Marco = new HorizontalLayout();
        VerticalLayout izquierdoL = new VerticalLayout();
        Panel izquierdo =  new Panel();

        Label label = new Label("Menu Profesor");
        Label vacio = new Label("\n \n");

        Button agregarPreguntas = new Button("Agregar archivo de preguntas");                              //boton para realizar examen (falta añadir confirmationDialog)
        agregarPreguntas.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                preguntas = new AgregarPreguntas(usuarioSesion,codigo,navigator);
                navigator.addView("AgregarPreguntas"+usuarioSesion,preguntas);
                navigator.navigateTo("AgregarPreguntas"+usuarioSesion);
            }
        });

        Button verPunteosAlumno = new Button("Ver Resultados Exámenes Alumnos");                    //boton para ver resultados
        verPunteosAlumno.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                resultados = new ResultadosMP(usuarioSesion,navigator);
                navigator.addView("ResultadosExamenesAlumnos"+usuarioSesion,resultados);
                navigator.navigateTo("ResultadosExamenesAlumnos"+usuarioSesion);
            }
        });



        // añadir los botones al vertical layout izquierdo
        izquierdoL.addComponent(label);
        izquierdoL.addComponent(agregarPreguntas);
        izquierdoL.addComponent(verPunteosAlumno);
        izquierdoL.addComponent(vacio);

        //añadir el vertical layout izq al panel
        izquierdo.setContent(izquierdoL);

        //añadir el panel al horizontal layout Marco
        Marco.addComponent(izquierdo);


        Panel derecho = new Panel();
        VerticalLayout derechoL = new VerticalLayout();

        Label informacion = new Label("Bienvenido" + "Usuario: " + usuarioSesion);
        Button logOut = new Button("Salir");
        logOut.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {                                        // boton para logOut
                navigator.navigateTo("LoginM"+codigo);
                Notification.show("Ha ingresado");
            }
        });

        //Añadir contenido al vertical layout derecho
        derechoL.addComponent(informacion);
        derechoL.addComponent(logOut);

        //añadir el vertical layout der al panel
        derecho.setContent(derechoL);

        //añadir el panel al horizontal layout Marco
        Marco.addComponent(derecho);


        //Añadiendo el marco a la ventana
        addComponent(Marco);
    }
}
