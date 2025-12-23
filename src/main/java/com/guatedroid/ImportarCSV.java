package com.guatedroid;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class ImportarCSV {
    private ImpLineaCSV Linea = new ImpLineaCSV();

    public ImportarCSV(String lineaTemporal, int IDpregunta){
        System.out.println("ImportarCSV");
        String [] x = lineaTemporal.split(",");
        Linea.setTextoLeer(x[0]);
        Linea.setPregunta(x[1]);
        Linea.setOpcionA(x[2]);
        Linea.setOpcionB(x[3]);
        Linea.setOpcionC(x[4]);
        Linea.setOpcionD(x[5]);
        Linea.setCorrecta(x[6]);
        Linea.setExplicacion(x[7]);
        new ImpBD(Linea,IDpregunta);

    }
}