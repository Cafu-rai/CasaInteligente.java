package com.Rainaudi.CasaInteligente;

import java.awt.*;

//Creamos el metodo donde va a recibir los atributos de la clase padre "Triangulo"
//y implementa el metodo de "Dibujable"
public class TrianguloGrafico extends Triangulo implements Dibujable {

    Color color;

    //Constructor
    public TrianguloGrafico(int x, int y, int tamanio, Color color) {
        super(x,y,tamanio);
        this.color = color;
    }

    //Metodo para instanciar el color
    public void cambiarColor(Color nuevoColor) {
        this.color = nuevoColor;
    }

    public void dibujar(Graphics g) {
        g.setColor(color); //Lo q hacemos es cambiarle el color
        /*Creamos un array con las coordenadas X de los tres puntos del triangulo
        "{x, x + tamanio / 2, x - tamanio / 2}"
        "x": posicion horizontal del punto superior
        "x + tamanio / 2": la base derecha
        "x - tamanio / 2": la base izquierda
        */
        int[] xPoints = {x, x + tamanio / 2, x - tamanio / 2};
        /*Creamos un array con las coordenadas Y de los tres puntos del triangulo
        "{y, y + tamanio, y + tamanio}"
        "y": punto superior
        "y + tamanio": la base del triangulo
        */
        int[] yPoints = {y, y + tamanio, y + tamanio};
        //Dibuja el triangulo con el tamaño q le pasaron
        g.fillPolygon(xPoints, yPoints, 3);
    }
}