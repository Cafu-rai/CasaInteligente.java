package com.Rainaudi.CasaInteligente;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//Creamos nuestra clase "PanelDibujo" q va a heredar de JPanel
public class PanelDibujo extends JPanel {
    //Creamos un ArrayList, el cual, almacena objetos de la interfaz "Dibujable"
    ArrayList<Dibujable> figuras = new ArrayList<>();

    //Metodo el cual vamos a agregar una nueva figura a la lista "figuras"
    public void agregarFigura(Dibujable figura) {
        figuras.add(figura);
    }

    //Metodo para lo q vayamos a dibujar en la ventana
    @Override
    public void paintComponent(Graphics g) {
        //Llamamos al metodo de JPanel para q prepare todo antes de dibujar
        super.paintComponent(g);
        //Recorremos todas las figuras q fueron creadas y
        //llamamos la metodo "dibujar(g)" pasandole el objeto "Graphics"
        for (Dibujable figura : figuras) {
            figura.dibujar(g);
        }
    }
} //Con estos metodos nos ayuda a q el diseño sea modular y extensible, donde podamos agregar figuras sin tocar el panel.