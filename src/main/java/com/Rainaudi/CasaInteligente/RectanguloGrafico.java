package com.Rainaudi.CasaInteligente;

import java.awt.*;

public class RectanguloGrafico extends Rectangulo implements Dibujable {

    Color color;

    public RectanguloGrafico(int x, int y, int ancho, int alto, Color color) {
        super(x,y,ancho,alto);
        this.color = color;
    }

    public void cambiarColor(Color nuevoColor) {
        this.color = nuevoColor;
    }

    @Override
    public void dibujar(Graphics dibujar) {
        dibujar.setColor(color);
        dibujar.fillRect((int) x, (int) y, (int) ancho, (int) alto);
    }
}