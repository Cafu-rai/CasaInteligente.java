package com.Rainaudi.CasaInteligente;

import javax.swing.*;
import java.awt.*;

public class PanelDibujo extends JPanel {
    //Figuras fijas
    RectanguloGrafico cocina, entrada, patio;
    CirculoGrafico luz;
    RectanguloGrafico alarma;
    TrianguloGrafico sensor;

    public PanelDibujo(CirculoGrafico luz, RectanguloGrafico alarma, TrianguloGrafico sensor) {
        this.luz = luz;
        this.alarma = alarma;
        this.sensor = sensor;

        //Habitaciones como rectángulos grandes
        cocina = new RectanguloGrafico(220, 50, 150, 100, Color.LIGHT_GRAY);
        entrada = new RectanguloGrafico(50, 50, 150, 100, Color.LIGHT_GRAY);
        patio = new RectanguloGrafico(390, 50, 150, 100, Color.LIGHT_GRAY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        cocina.dibujar(g);
        entrada.dibujar(g);
        patio.dibujar(g);

        luz.dibujar(g);
        alarma.dibujar(g);
        sensor.dibujar(g);
    }
}


