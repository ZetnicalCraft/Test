package com.guatedroid;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.navigator.Navigator;

public class AlumnoM extends VerticalLayout implements View{
    public String usuarioSesion = "";
    private ResultadosMA resultados;
    private String codigo = "";
    private Navigator navigator;

    public AlumnoM(String usuarioSesion, String codigo, Navigator navigator){
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

        Label label = new Label("Menu Alumno");
        Label vacio = new Label("\n \n");

        Button realizarExamen = new Button("Realizar Examen");                              //boton para realizar examen (falta añadir confirmationDialog)
        realizarExamen.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                new Examen(usuarioSesion,navigator);
            }
        });

        Button verPunteosAlumno = new Button("Ver Resultados Exámenes");                    //boton para ver resultados
        verPunteosAlumno.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                resultados = new ResultadosMA(usuarioSesion,navigator);
                navigator.addView("ResultadosExamenes"+usuarioSesion,resultados);
                navigator.navigateTo("ResultadosExamenes"+usuarioSesion);
                Notification.show("Resultados examenes");
            }
        });



        // añadir los botones al vertical layout izquierdo
        izquierdoL.addComponent(label);
        izquierdoL.addComponent(realizarExamen);
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



    /*public boolean comprobarSesionAbierta(){
        boolean sesionAbierta = false;

        try
        {
            BD = new ConeccionBD ("jdbc:mysql://localhost:3306/"+basededatos,"root",contrasena);
            BD.getNewConnection();

            String bim = "2";
            String query = "SELECT 'IDsesion' FROM sesiones WHERE IDusuario = '"+LoginM.usuarioSesion+"' AND abierta = 'true' ";


            try
            {
                stQuery = BD.getCurrentConnection().createStatement();
                rsRecords = stQuery.executeQuery (query);
                if(rsRecords.next()==false){

                } else{ //http://sami.virtuallypreinstalled.com/confirmdialog/
                    ConfirmDialog confirm = new ConfirmDialog();
                    confirm.show(win, "Please Confirm:", "Are you really sure?",
                            "I am", "Not quite", new ConfirmDialog.Listener() {

                                public void onClose(ConfirmDialog dialog) {
                                    if (dialog.isConfirmed()) {
                                        // Confirmed to continue
                                        feedback(dialog.isConfirmed());
                                    } else {
                                        // User did not confirm
                                        feedback(dialog.isConfirmed());
                                    }
                                }
                            });
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
        return sesionAbierta;

    }*/

}
