package com.guatedroid;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;



public class LoginM extends VerticalLayout implements View {
    private String usuarioSesion = "";
    private String codigo = "";
    private Navigator navigatores;

    public LoginM(String codigo,Navigator navigatores){
        this.codigo = codigo;
        this.navigatores = navigatores;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event){

        setSizeFull();
        removeAllComponents();
        VerticalLayout marcoL = new VerticalLayout();
        Panel Marco = new Panel();

        Label label = new Label("Colegio El Roble \n Examenes Prueba MINEDUC");
        TextField usuario = new TextField("Usuario:");
        PasswordField contraseña = new PasswordField("Contraseña:");

        Button login = new Button("Ingresar");

        login.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {

                ingresoComprobar(usuario.getValue(),contraseña.getValue());
                Notification.show("Ha ingresado");
            }
        });

        marcoL.addComponent(label);
        marcoL.addComponent(usuario);
        marcoL.addComponent(contraseña);
        marcoL.addComponent(login);

        Marco.setContent(marcoL);

        addComponent(Marco);
        setComponentAlignment(Marco, Alignment.MIDDLE_CENTER);

    }

    public void ingresoComprobar(String usuario, String contraseña){
        //por ahora este método solo dejará pasar.
        usuarioSesion = usuario;
        //falta distinguir entre alumno y profesor
        AlumnoM alumno = new AlumnoM(usuarioSesion,codigo,navigatores);
        navigatores.addView("MenuAlumno"+usuarioSesion,alumno);
        ProfesorM profesor = new ProfesorM(usuarioSesion,codigo,navigatores);
        navigatores.addView("MenuProfesor"+usuarioSesion,profesor);
        if(profe(usuarioSesion)==true){
            navigatores.navigateTo("MenuProfesor"+usuarioSesion);
        } else {
            navigatores.navigateTo("MenuAlumno"+usuarioSesion);
        }
        System.out.println(usuario);
    }

    public boolean profe(String usuarioSesion){
        if(usuarioSesion.contains("0") || usuarioSesion.contains("1") || usuarioSesion.contains("2") || usuarioSesion.contains("3") || usuarioSesion.contains("4") || usuarioSesion.contains("5") || usuarioSesion.contains("6") || usuarioSesion.contains("7") || usuarioSesion.contains("8") || usuarioSesion.contains("9")){
            return false;
        } else {
            return true;
        }
    }

}
