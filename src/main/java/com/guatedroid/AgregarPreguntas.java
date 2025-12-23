package com.guatedroid;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.shared.Registration;
import com.vaadin.ui.*;
import com.vaadin.navigator.Navigator;

import javax.sound.sampled.Line;

public class AgregarPreguntas extends VerticalLayout implements View{
    public String usuarioSesion = "";
    private String codigo = "";
    private Navigator navigator;
    private Upload sample;

    public AgregarPreguntas(String usuarioSesion, String codigo, Navigator navigator){
        this.usuarioSesion = usuarioSesion;
        this.codigo = codigo;
        this.navigator = navigator;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent evento){


        setSizeFull();
        removeAllComponents();
        HorizontalLayout Marco = new HorizontalLayout();
        VerticalLayout izquierdoL = new VerticalLayout();
        Panel izquierdo =  new Panel();

        Label label = new Label("Menu para agregar preguntas");
        Label vacio = new Label("\n \n");

        LineBreakCounter lineBreakCounter = new LineBreakCounter();
        lineBreakCounter.setSlow(true);

        sample = new Upload(null, lineBreakCounter);
        sample.setImmediateMode(true);

        UploadInfoWindow uploadInfoWindow = new UploadInfoWindow(sample, lineBreakCounter);

        sample.addStartedListener(event -> {
            if (uploadInfoWindow.getParent() == null) {
                UI.getCurrent().addWindow(uploadInfoWindow);
            }
            uploadInfoWindow.setClosable(false);
        });

        sample.addFinishedListener(event -> uploadInfoWindow.setClosable(true));

        // añadir los botones al vertical layout izquierdo
        izquierdoL.addComponent(label);
        izquierdoL.addComponent(vacio);
        izquierdoL.addComponent(sample);

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
