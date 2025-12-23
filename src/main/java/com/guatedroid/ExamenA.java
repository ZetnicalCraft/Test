package com.guatedroid;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.navigator.Navigator;

public class ExamenA extends VerticalLayout implements View{
    private String respuestaUsuario = "";
    private String codigoSesion = "";
    private String usuarioSesion = "";
    private RadioButtonGroup respuestasB = new RadioButtonGroup<String>();
    public Finalizar terminado;
    private SiguientePreg siguientePregunta;
    private ObtenerPregComp preguntaCompleta;
    private int noPregunta = 0;
    private int[] idPreguntas;
    private Label textoLeer = new Label();
    private Label preguntas = new Label();
    private Navigator navigator;

    public ExamenA(String codigoSesion, String usuarioSesion, int[] idPreguntas, Navigator navigator){
        this.navigator = navigator;
        this.codigoSesion = codigoSesion;
        this.usuarioSesion = usuarioSesion;
        preguntaCompleta = new ObtenerPregComp(codigoSesion,usuarioSesion,idPreguntas);
        siguientePregunta = new SiguientePreg(codigoSesion);
        this.idPreguntas = idPreguntas;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event){
        setSizeFull();
        removeAllComponents();
        HorizontalLayout Marco = new HorizontalLayout();
        if(MyUI.debuger == true){
            System.out.println("Marco Creado");
        }
        VerticalLayout izquierdoL = new VerticalLayout();
        VerticalLayout derechoL = new VerticalLayout();

        if(MyUI.debuger == true){
            System.out.println("Vertical Layouts izquierdoL y derechoL creados");
        }
        Panel derecho = new Panel();
        Panel izquierdo =  new Panel();
        if(MyUI.debuger == true){
            System.out.println("Panel derecho e izquierdo creado");
        }


        //Texto para leer ingresado ya a su panel**

        Panel panelTextoLeer = new Panel("Texto a leer:");
        textoLeer.setValue(getTextoLeer());
        panelTextoLeer.setContent(textoLeer);
        panelTextoLeer.setWidth("50%");
        if(MyUI.debuger == true){
            System.out.println("label texto leer creado e ingresado en su panel");
        }

        //Pregunta ya ingresada a su panel**

        Panel panelPregunta = new Panel("Texto a leer:");
        preguntas.setValue(getPregunta());
        panelPregunta.setContent(preguntas);
        panelPregunta.setWidth("50%");
        if(MyUI.debuger == true){
            System.out.println("label pregunta creado e ingresado en su panelPregunta");
        }

        //Opciones Respuesta
        HorizontalLayout respuestasL= new HorizontalLayout();
        if(MyUI.debuger == true){
            System.out.println("Vertical layout respuestasL creado");
        }
        //Respuestas Button Group


        respuestasB.setItems(getRes1(),getRes2(),getRes3(),getRes4());

        VerticalLayout respuestasTexto = new VerticalLayout();

        respuestasL.addComponent(respuestasB);

        //añadir respuestasL al panel respuestas**
        Panel panelRespuestas = new Panel("Elija una de las siguientes respuestas:");
        panelRespuestas.setContent(respuestasL);
        panelRespuestas.setWidth("50%");
        if(MyUI.debuger == true){
            System.out.println("respuestasL añadido al panel Respuestas");
        }


        HorizontalLayout botonesL = new HorizontalLayout();
        if(MyUI.debuger == true){
            System.out.println("botonesL layouthorizontal creado y creado el panel botones");
        }

        Button anterior = new Button("Anterior");                              //anterior boton
        anterior.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                if(noPregunta == 0){
                    noPregunta=24;
                } else {
                    noPregunta--;
                }
                actPanelTextoLeer();
                actPanelPregunta();
                actRespuestas();
            }
        });
        if(MyUI.debuger == true){
            System.out.println("creado boton anterior");
        }

        Button siguiente = new Button("Siguiente");                              //siguiente boton
        siguiente.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                siguientePregunta.SiguientePregunta(respuestasB.getValue().toString(),noPregunta);
                System.out.println(respuestasB.getValue());
                if(noPregunta == 24){
                    noPregunta=0;
                } else {
                    noPregunta++;
                }
                actPanelTextoLeer();
                actPanelPregunta();
                actRespuestas();
            }
        });
        if(MyUI.debuger == true){
            System.out.println("creado boton siguiente");
        }


        Button finalizar = new Button("Finalizar");                              //finalizar boton
        finalizar.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                //falta confirmacion y que se finalice
                terminado = new Finalizar(codigoSesion,idPreguntas,usuarioSesion,navigator);
            }
        });
        if(MyUI.debuger == true){
            System.out.println("creado boton finalizar");
        }

        // añadir botones al botonesL
        botonesL.addComponent(anterior);
        botonesL.addComponent(siguiente);
        botonesL.addComponent(finalizar);
        if(MyUI.debuger == true){
            System.out.println("botonesL layout se le ha añadido botones anterior, siguiente y finalizar");
        }

        //añadir botonesL al panel botones**
        Panel panelBotones = new Panel();
        panelBotones.setContent(botonesL);
        panelBotones.setWidth("50%");
        if(MyUI.debuger == true){
            System.out.println("botonesL se añade al panel Botones");
        }

        //añadirtodo el anterior contenido al vertical layout izquierdoL
        izquierdoL.addComponent(panelTextoLeer);
        izquierdoL.addComponent(panelPregunta);
        izquierdoL.addComponent(panelRespuestas);
        izquierdoL.addComponent(panelBotones);
        if(MyUI.debuger == true){
            System.out.println("añadir todo el anterior contenido al vertical layout izquierdoL");
        }

        izquierdo.setContent(izquierdoL);
        if(MyUI.debuger == true){
            System.out.println("añadido el layout izquierdoL al panel izquierdo");
        }

        Label informacion = new Label("Bienvenido" + "Usuario: " + usuarioSesion);
        Button logOut = new Button("Salir");
        logOut.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {                                        // boton para logOut
                navigator.navigateTo("MenuAlumno"+usuarioSesion);
                Notification.show("Ha ingresado");
            }
        });


        //Añadir contenido al vertical layout derecho
        derechoL.addComponent(informacion);
        derechoL.addComponent(logOut);


        //añadir el vertical layout derecho al panel
        derecho.setContent(derechoL);

        //añadir al marco
        Marco.addComponent(izquierdo);
        Marco.addComponent(derecho);

        //añadir el marco a la ventana
        addComponent(Marco);
    }

    public String getTextoLeer(){
        String textoLeer = preguntaCompleta.getTextoLeer(noPregunta);
        return textoLeer;
    }
    public String getPregunta(){
        String pregunta = preguntaCompleta.getTextoPregunta(noPregunta);
        return pregunta;
    }
    public String getRes1(){
        String res1 = preguntaCompleta.getPreg1(noPregunta,"OpcionA");
        return res1;
    }
    public String getRes2(){
        String res2 = preguntaCompleta.getPreg1(noPregunta,"OpcionB");
        return res2;
    }
    public String getRes3(){
        String res3 = preguntaCompleta.getPreg1(noPregunta,"OpcionC");
        return res3;
    }
    public String getRes4(){
        String res4 = preguntaCompleta.getPreg1(noPregunta,"OpcionD");
        return res4;
    }


    public void actPanelTextoLeer(){
        textoLeer.setValue(getTextoLeer());
    }
    public void actPanelPregunta(){
        preguntas.setValue(getPregunta());
    }
    public void actRespuestas(){
        respuestasB.setItems(getRes1(),getRes2(),getRes3(),getRes4());
    }




}
