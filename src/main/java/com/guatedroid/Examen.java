package com.guatedroid;

import com.vaadin.navigator.Navigator;

public class Examen {
    private int noPregunta = 0;
    private int idPregunta = 0;
    private String codigoSesion = "";
    private String usuarioSesion = "";
    private Navigator navigator;

    public Examen(String usuarioSesion,Navigator navigator){
        this.navigator = navigator;
        this.usuarioSesion = usuarioSesion;
        noPregunta = 0;
        GeneradorExamen generador = new GeneradorExamen(usuarioSesion);
        System.out.println("Llamando preguntas disponibles.");
        generador.setNoPreguntasDisponibles();
        generador.inicializarExamen();
        codigoSesion = generador.getCodigoSesion();
        ExamenA examen = new ExamenA(codigoSesion,this.usuarioSesion,generador.getNoPreguntas(),navigator);
        navigator.addView("ExamenMineduc"+codigoSesion,examen);
        navigator.navigateTo("ExamenMineduc"+codigoSesion);

    }

}
