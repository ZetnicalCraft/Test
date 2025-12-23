package com.guatedroid;
/*Esta clase obtiene las preguntas completas para entregarle los datos a ExamenA.
* Obtiene los datos de subclases a las que accede*/

public class ObtenerPregComp {

    private String textoPregunta = "";
    private String textoLeer = "";
    private String preg1 ="";
    private String usuarioSesion = "";
    private String codigoSesion = "";
    private int noPregunta;
    private int[] idPreguntas;
    private ObtenerPregunta pregunta;
    private ObtenerTextoLeer textoL;
    private ObtenerResp1 res1;

    public ObtenerPregComp(String codigoSesion, String usuarioSesion, int[] idPreguntas){
        this.usuarioSesion = usuarioSesion;
        this.codigoSesion = codigoSesion;
        this.noPregunta = noPregunta;
        this.idPreguntas = idPreguntas;
        pregunta = new ObtenerPregunta(codigoSesion,idPreguntas);
        textoL = new ObtenerTextoLeer(codigoSesion,idPreguntas);
        res1 = new ObtenerResp1(codigoSesion,idPreguntas);

    }


    public String getTextoPregunta(int noPregunta) {
        setTextoPregunta(noPregunta);
        return textoPregunta;
    }

    public void setTextoPregunta(int noPregunta) {
        pregunta.setTextoPregunta(noPregunta);
        textoPregunta = pregunta.getPregunta();
    }

    public String getTextoLeer(int noPregunta) {
        setTextoLeer(noPregunta);
        return textoLeer;
    }

    public void setTextoLeer(int noPregunta) {
        textoL.setTextoLeer(noPregunta);
        textoLeer = textoL.getTextoLeer();
    }

    public String getPreg1(int noPregunta, String Opcion) {
        setPreg1(noPregunta, Opcion);
        return preg1;
    }

    public void setPreg1(int noPregunta, String Opcion) {
        res1.setResp1(noPregunta, Opcion);
        preg1 = res1.getResp1();
    }

}
