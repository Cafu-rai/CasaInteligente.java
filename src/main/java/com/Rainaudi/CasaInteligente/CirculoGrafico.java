package com.Rainaudi.CasaInteligente;

import java.awt.*;

public class CirculoGrafico extends Circulo implements Dibujable {

    Color color;

    public CirculoGrafico(int x, int y, int radio, Color color) {
        super(x, y, radio);
        this.color = color;
    }

    public void cambiarColor(Color nuevoColor) {
        this.color = nuevoColor;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        g.fillOval( (int)x, (int)y, (int)radio, (int)radio );
    }
}