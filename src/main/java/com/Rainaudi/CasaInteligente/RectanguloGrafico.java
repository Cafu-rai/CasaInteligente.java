package com.Rainaudi.CasaInteligente;

import java.awt.*;

//Creamos la clase "RectanguloGrafico" donde va a heredar los atributos de la clase padre "Rectangulo"
//y implementa el metodo de "Dibujable"
public class RectanguloGrafico extends Rectangulo implements Dibujable {

    Color color;

    //Constructor
    public RectanguloGrafico(int x, int y, int ancho, int alto, String nombre, Color color) {
        //Con "super" llamamos al metodo de la clase padre "Circulo" y hereda los atributos
        super(x,y,ancho,alto,nombre);
        this.color = color;
    }

    //Metodo para instanciar el color
    public void cambiarColor(Color nuevoColor) {
        this.color = nuevoColor;
    }

    //Metodo donde se instancia lo q hay q g
    @Override
    public void dibujar(Graphics g) {
        g.setColor(color); //Lo q hacemos es cambiarle el color
        //Hacemos q dibuje nuestro rectangulo, enviandole la posicion y las dimensiones
        g.fillRect((int) x, (int) y, (int) ancho, (int) alto);
        //Le damos un color a los nombres de las habitaciones
        g.setColor(Color.BLACK);
        //Le asignamos el nombre y posicion a los textos.
        g.drawString(nombre, (int)x + 5, (int) y + 15);
    }
}