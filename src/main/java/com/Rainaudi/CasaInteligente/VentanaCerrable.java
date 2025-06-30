package com.Rainaudi.CasaInteligente;

import javax.swing.*;
import java.awt.*;

//Creamos la clase "VentanCerrable" q va a heredar de "JFrame"
public class VentanaCerrable extends JFrame {
    /*
    Creamos las figuras graficas q vamos a dibujar
    Cada una hereda de sus respectivas clases
    */
    private PanelDibujo panel;
    private CirculoGrafico luzCocina;
    private RectanguloGrafico alarmaEntrada;
    private TrianguloGrafico sensorCocina;
    private TrianguloGrafico sensorLiving;
    private TrianguloGrafico sensorEntrada;

    //Creamos variables booleanas para alternar encendido/apagado
    private boolean luzEncendida = false;
    private boolean alarmaActivada = false;
    private boolean sensorActivo = false;

    //Constructor
    public VentanaCerrable() {

        setTitle("Simulador de Casa Inteligente"); //Titulo de nuestra ventana
        setSize(700, 500); //Le damos tamaño a  nuestra ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le damos la accion al boton de cerrar de la pestaña
        setLayout(new BorderLayout());

        //Instanciamos el panel de dibujo
        panel = new PanelDibujo();

        //Creamos las habitaciones con sus tamaños
        panel.agregarFigura(new RectanguloGrafico(149, 50, 150, 100, "Entrada", Color.LIGHT_GRAY)); // Cocina
        panel.agregarFigura(new RectanguloGrafico(300, 50, 150, 100, "Cocina", Color.LIGHT_GRAY)); // Entrada
        panel.agregarFigura(new RectanguloGrafico(300, 151, 150, 100, "Living", Color.LIGHT_GRAY)); // Living

        //Creamos los sensores, luz y alarma con sus tamaños
        luzCocina = new CirculoGrafico(212, 85, 25, Color.GRAY);
        alarmaEntrada = new RectanguloGrafico(430, 130, 15, 15,"", Color.GRAY);
        sensorEntrada = new TrianguloGrafico(287, 130, 15, Color.GRAY);
        sensorCocina = new TrianguloGrafico(440, 55, 15, Color.GRAY);
        sensorLiving = new TrianguloGrafico(440, 230, 15, Color.GRAY);

        //Agregamos los sensores al panel
        panel.agregarFigura(luzCocina);
        panel.agregarFigura(alarmaEntrada);
        panel.agregarFigura(sensorEntrada);
        panel.agregarFigura(sensorCocina);
        panel.agregarFigura(sensorLiving);

        //Centramos el panel en el centro de la ventana
        add(panel, BorderLayout.CENTER);

        //Creamos los botones del panel
        JPanel botones = new JPanel();

        //Creamos la accion del boton de luz de la cocina
        JButton botonLuz = new JButton("Encender/Apagar luz cocina");
        botonLuz.addActionListener(e -> {
            //Cambiamos el estado de la luz
            luzEncendida = !luzEncendida;
            luzCocina.cambiarColor(luzEncendida ? Color.YELLOW : Color.GRAY);
            //Mostramos una ventana emergente, avisando si se encendio la luz o se apago
            JOptionPane.showMessageDialog(this, luzEncendida ? "Luz encendida en la cocina" : "Luz apagada en la cocina");
            //Actualizamos la vista, esto lo hacemos para q ver el nuevo color de la luz
            panel.repaint();
        });

        //Creamos la accion del boton de la alarma
        JButton botonAlarma = new JButton("Activar/Desactivar alarma");
        botonAlarma.addActionListener(e -> {
            //Cambiamos el estado de la alarma
            alarmaActivada = !alarmaActivada;
            alarmaEntrada.cambiarColor(alarmaActivada ? Color.RED : Color.GRAY);
            //Mostramos una ventana emergente, avisando si se activo la alarma o se desactivo
            JOptionPane.showMessageDialog(this, alarmaActivada ? "Alarma activada" : "Alarma desactivada");
            //Actualizamos la vista, esto lo hacemos para q ver el nuevo color de la alarma
            panel.repaint();
        });

        //Creamos las acciones de los botones de los sensores del living
        JButton botonMovimiento = new JButton("Activar/Desactivar sensores");
        botonMovimiento.addActionListener(e -> {
            //Cambiamos el estado del sensor
            sensorActivo = !sensorActivo;
            sensorEntrada.cambiarColor(sensorActivo ? Color.GREEN : Color.GRAY);
            sensorCocina.cambiarColor(sensorActivo ? Color.GREEN : Color.GRAY);
            sensorLiving.cambiarColor(sensorActivo ? Color.GREEN : Color.GRAY);
            //Mostramos una ventana emergente, avisando si se activo el sensor o se desactivo
            JOptionPane.showMessageDialog(this, sensorActivo ? "Sensores activados" : "Sensores desactivados");
            //Actualizamos la vista, esto lo hacemos para q ver los nuevos colores de los sensores
            panel.repaint();
        });

        /*
            "e -> {...}": es una expresion lambda, lo q hace es reaccionar a algun clic q se haga en el boton.
            "sensorActivo ? Color.GREEN : Color.Gray": es un operador ternario. Si se cumple la condicion,
            usa A o B.
        */

        //Agregamos botones a la pestaña
        botones.add(botonLuz);
        botones.add(botonAlarma);
        botones.add(botonMovimiento);

        //Agregamos los botones en la parte de abajo de nuestra pestaña
        add(botones, BorderLayout.SOUTH);
    }
}