package com.guatedroid;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
    public Navigator navigator = new Navigator(this, this);
    public static boolean debuger = false;
    public LoginM Login;
    private String codigo = "";
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        codigo = genCodigo();
        Login = new LoginM(codigo,navigator);
        getPage().setTitle("Mineduc Roble");

        navigator.addView("LoginM"+codigo, Login);
        navigator.navigateTo("LoginM"+codigo);
    }

    public String genCodigo(){
        Random random = new Random();
        int aleatorio = random.nextInt(100000);
        String alea = Integer.toString(aleatorio);
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String fecha = hourdateFormat.format(date);
        String codigo =alea+fecha;
        return codigo;
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
