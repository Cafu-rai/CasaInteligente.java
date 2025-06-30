package com.Rainaudi.CasaInteligente;

import java.awt.*;

//Creamos el metodo donde va a heredar los atributos de la clase padre "Rectangulo"
//y implementa el metodo de "Dibujable"
public class RectanguloGrafico extends Rectangulo implements Dibujable {

    Color color;

    //Constructor
    public RectanguloGrafico(int x, int y, int ancho, int alto, Color color) {
        //Con "super" llamamos al metodo de la clase padre "Circulo" y hereda los atributos
        super(x,y,ancho,alto);
        this.color = color;
    }

    //Metodo para instanciar el color
    public void cambiarColor(Color nuevoColor) {
        this.color = nuevoColor;
    }

    //Metodo donde se instancia lo q hay q g
    public void dibujar(Graphics g) {
        g.setColor(color); //Lo q hacemos es cambiarle el color
        //Hacemos q dibuje nuestro rectangulo, enviandole la posicion y las dimensiones
        g.fillRect((int) x, (int) y, (int) ancho, (int) alto);
    }
}