package com.guatedroid;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2005003391
 */
public class ImpLineaCSV {
    private String textoLeer = "";
    private String pregunta = "";
    private String opcionA = "";
    private String opcionB = "";
    private String opcionC = "";
    private String opcionD = "";
    private String correcta = "";
    private String explicacion = "";

    public ImpLineaCSV(){

    }

    public ImpLineaCSV(String textoLeer, String pregunta, String opcionA, String opcionB, String opcionC, String opcionD,String correcta,String explicacion){
        this.pregunta = pregunta;
        this.textoLeer = textoLeer;
        this.opcionA = opcionA;
        this.opcionB = opcionB;
        this.opcionC = opcionC;
        this.opcionD = opcionD;
        this.correcta = correcta;
        this.explicacion = explicacion;
    }

    public String getTextoLeer() {
        return textoLeer;
    }

    public void setTextoLeer(String textoLeer) {
        this.textoLeer = textoLeer;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getOpcionA() {
        return opcionA;
    }

    public void setOpcionA(String opcionA) {
        this.opcionA = opcionA;
    }

    public String getOpcionB() {
        return opcionB;
    }

    public void setOpcionB(String opcionB) {
        this.opcionB = opcionB;
    }

    public String getOpcionC() {
        return opcionC;
    }

    public void setOpcionC(String opcionC) {
        this.opcionC = opcionC;
    }

    public String getOpcionD() {
        return opcionD;
    }

    public void setOpcionD(String opcionD) {
        this.opcionD = opcionD;
    }

    public String getCorrecta() {
        return correcta;
    }

    public void setCorrecta(String correcta) {
        this.correcta = correcta;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }
}
