package com.guatedroid;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.navigator.Navigator;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.AxisTitle;
import com.vaadin.addon.charts.model.AxisType;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;
import com.vaadin.addon.charts.model.DateTimeLabelFormats;
import com.vaadin.addon.charts.model.PlotOptionsSpline;
import com.vaadin.addon.charts.model.YAxis;
import com.vaadin.ui.Component;



public class ResultadosMA extends VerticalLayout implements View {
    private String usuarioSesion = "";
    private ConeccionBD BD = null;
    private String basededatos = utileria.basededatos;
    private String contrasena = utileria.contrasena;
    private Navigator navigator;
    public Statement stQuery;
    public ResultSet rsRecords;

    public ResultadosMA(String usuarioSesion, Navigator navigator){
        this.usuarioSesion = usuarioSesion;
        this.navigator = navigator;
    }

    public void enter(ViewChangeListener.ViewChangeEvent event){
        HorizontalLayout contenedorL = new HorizontalLayout();

        VerticalLayout izquierdo = new VerticalLayout();
        VerticalLayout derecho = new VerticalLayout();

        izquierdo.addComponent(getChart());

        VerticalLayout info = new VerticalLayout();
        Label informacion = new Label("Bienvenido" + "Usuario: " + usuarioSesion);
        Button logOut = new Button("Salir al menú");
        logOut.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {                                        // boton para logOut
                navigator.navigateTo("MenuAlumno"+usuarioSesion);
                usuarioSesion = "";
                Notification.show("Ha ingresado");
            }
        });
        info.addComponent(informacion);
        info.addComponent(logOut);
        Panel infoP = new Panel();
        infoP.setContent(info);
        derecho.addComponent(infoP);

        Panel izquierdoP = new Panel();
        izquierdoP.setContent(izquierdo);
        contenedorL.addComponent(izquierdoP);
        contenedorL.addComponent(derecho);
        addComponent(contenedorL);
    }

    protected Component getChart() {
        String fecha = "";
        int punteo = 0;
        Chart chart = new Chart();
        chart.setHeight("450px");
        chart.setWidth("100%");

        Configuration configuration = chart.getConfiguration();
        configuration.getChart().setType(ChartType.SPLINE);

        configuration.getTitle().setText(
                "Puntos obtenidos examenes MINEDUC");
        configuration.getSubTitle().setText(
                "Todos los puntos de este año obtenidos por el alumno: "+usuarioSesion);

        configuration.getTooltip().setFormatter("");

        configuration.getxAxis().setType(AxisType.DATETIME);
        configuration.getxAxis().setDateTimeLabelFormats(
                new DateTimeLabelFormats("%e. %b", "%b"));

        YAxis yAxis = configuration.getyAxis();
        yAxis.setTitle(new AxisTitle("Puntos obtenidos "));
        yAxis.setMin(0);

        configuration
                .getTooltip()
                .setFormatter(
                        "'<b>'+ this.series.name +'</b><br/>\'+ Highcharts.dateFormat('%e. %b', this.x) +': '+ this.y +' m'");

        DataSeries ls = new DataSeries();
        ls.setPlotOptions(new PlotOptionsSpline());
        ls.setName("Puntos obtenidos sobre 100");

        try
        {
            BD = new ConeccionBD (utileria.conection+basededatos,utileria.user,contrasena);
            BD.getNewConnection();

            String query = "SELECT IDusuario,punteo,fecha FROM sesiones WHERE IDusuario = '"+usuarioSesion+"'";


            try
            {
                System.out.println(query);
                stQuery = BD.getCurrentConnection().createStatement();
                rsRecords = stQuery.executeQuery (query);
                while(rsRecords.next()){
                    fecha = rsRecords.getString("fecha");
                    punteo = rsRecords.getInt("punteo");
                    DataSeriesItem item = new DataSeriesItem(d(fecha),puntos(punteo));
                    ls.add(item);
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

        configuration.addSeries(ls);
        chart.drawChart(configuration);
        return chart;
    }


    private final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    private Instant d(String stringFormat) {
        LocalDate date;
        try {
            date = LocalDate.parse(stringFormat, df);
        } catch (DateTimeParseException e) {
            throw new RuntimeException(e);
        }
        return date.atStartOfDay().toInstant(ZoneOffset.UTC);
    }


    public int puntos(int puntos){
        int puntaje = (puntos*100)/Finalizar.total;
        return puntaje;
    }



}
