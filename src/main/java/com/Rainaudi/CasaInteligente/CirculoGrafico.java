package com.Rainaudi.CasaInteligente;

import java.awt.*;

//Creamos la clase "CirculoGrafico" donde va a heredar los atributos de la clase padre "Circulo"
//y implementa el metodo de "Dibujable"
public class CirculoGrafico extends Circulo implements Dibujable {

    Color color;

    //Constructor
    public CirculoGrafico(int x, int y, int radio, Color color) {
        //Con "super" llamamos al metodo de la clase padre "Circulo" y hereda los atributos
        super(x, y, radio);
        this.color = color;
    }

    //Metodo para instanciar el color
    public void cambiarColor(Color nuevoColor) {
        this.color = nuevoColor;
    }

    //Metodo donde se instancia lo q hay q dibujar
    //"Graphics g" es un objeto q representa donde se va a dibujar
    public void dibujar(Graphics g) {
        g.setColor(color); //Lo q hacemos es cambiarle el color
        //"fillOval" dibuja un circulo, es un metodo de "Graphics"
        //en donde le damos los valores de x e y; y el radio para q lo dibuje como queremos
        g.fillOval( (int)x, (int)y, (int)radio, (int)radio );
    }
}