package com.Rainaudi.CasaInteligente;

import java.awt.*;

public class TrianguloGrafico extends Triangulo implements Dibujable {

    Color color;

    public TrianguloGrafico(int x, int y, int tamanio, Color color) {
        super(x,y,tamanio);
        this.color = color;
    }

    public void cambiarColor(Color nuevoColor) {
        this.color = nuevoColor;
    }

    @Override
    public void dibujar(Graphics g) {
        g.setColor(color);
        int[] xPoints = {x, x + tamanio / 2, x - tamanio / 2};
        int[] yPoints = {y, y + tamanio, y + tamanio};
        g.fillPolygon(xPoints, yPoints, 3);
    }
}