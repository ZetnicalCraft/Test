package com.guatedroid;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.*;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExamenAresultado extends VerticalLayout implements View{
    public Statement stQuery;
    public ResultSet rsRecords;
    private String codigoSesion;
    private int total=25;
    private int punteo = 0;
    private RevisarExamenA revision;
    private String usuarioSesion ="";
    private Navigator navigator;

    public ExamenAresultado(String codigoSesion, String usuarioSesion, int total, int puntaje, Navigator navigator){
        this.navigator = navigator;
        this.codigoSesion = codigoSesion;
        this.usuarioSesion = usuarioSesion;
        punteo = puntaje;
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event){
        removeAllComponents();
        HorizontalLayout contenedor = new HorizontalLayout();
        VerticalLayout izquierdoV = new VerticalLayout();
        VerticalLayout derechoV = new VerticalLayout();
        Panel izquierdoP = new Panel();
        Panel derechoP = new Panel();
        Panel tituloP = new Panel();
        Panel punteoP = new Panel();
        Panel infoUsuarioP = new Panel();
        Panel tiempoP = new Panel();

        Label puntosL = new Label();
        puntosL.setValue(puntosObtenidos()+"/100");
        Label tituloL = new Label();
        tituloL.setValue("RESULTADO EXAMEN");

        HorizontalLayout botones = new HorizontalLayout();
        Button RevisarExamen = new Button("Revisar Examen");
            RevisarExamen.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event)
            {
                revision = new RevisarExamenA(codigoSesion,usuarioSesion,navigator);
                navigator.addView("RevisarExamen"+codigoSesion,revision);
                navigator.navigateTo("RevisarExamen"+codigoSesion);
            }
        });

        Button Terminar = new Button("Terminar e ir al menú");
            Terminar.addClickListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                navigator.navigateTo("MenuAlumno"+usuarioSesion);
            }
        });

            botones.addComponent(RevisarExamen);
            botones.addComponent(Terminar);

/*
*/
        tituloP.setContent(tituloL);
        punteoP.setContent(puntosL);

        izquierdoV.addComponent(tituloP);
        izquierdoV.addComponent(punteoP);
        izquierdoV.addComponent(dona());
        izquierdoV.addComponent(botones);

        izquierdoP.setContent(izquierdoV);
        addComponent(izquierdoP);
    }
    private Chart dona(){
        int puntos = Integer.parseInt(puntosObtenidos());
        Chart chart = new Chart(ChartType.PIE);

        Configuration conf = chart.getConfiguration();

        conf.setTitle("Examen tipo Literatura Mineduc, Resultado obtenido en el examen ");

        Tooltip tooltip = new Tooltip();
        tooltip.setValueDecimals(1);
        tooltip.setPointFormat("{series.name}: <b>{point.percentage}%</b>");
        conf.setTooltip(tooltip);

        PlotOptionsPie plotOptions = new PlotOptionsPie();
        plotOptions.setAllowPointSelect(true);
        plotOptions.setCursor(Cursor.POINTER);
        plotOptions.setShowInLegend(true);
        conf.setPlotOptions(plotOptions);

        DataSeries series = new DataSeries();
        series.add(new DataSeriesItem("Incorrectas", 100-puntos));
        DataSeriesItem chrome = new DataSeriesItem("Correctas", puntos);
        chrome.setSliced(true);
        chrome.setSelected(true);
        series.add(chrome);
        conf.setSeries(series);
        chart.setSeriesVisibilityTogglingDisabled(true);
        return chart;
    }
    public String puntosObtenidos(){
        int puntos = (100*punteo)/total;
        return Integer.toString(puntos);
    }

}
