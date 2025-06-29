package com.Rainaudi.CasaInteligente;

import javax.swing.*;
import java.awt.*;

public class VentanaCerrable extends JFrame {
    //Creamos las variables
    private PanelDibujo panel;
    private CirculoGrafico luzCocina;
    private RectanguloGrafico alarmaEntrada;
    private TrianguloGrafico sensorCocina;
    private TrianguloGrafico sensorLiving;

    //Creamos variables booleanas para alternar encendido/apagado
    private boolean luzEncendida = false;
    private boolean alarmaActivada = false;
    private boolean sensorActivo = false;

    //Metodo
    public VentanaCerrable() {

        setTitle("Simulador de Casa Inteligente"); //Titulo de nuestra ventana
        setSize(700, 500); //Le damos tamaño a  nuestra ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Le damos la accion al boton de cerrar de la pestaña
        setLayout(new BorderLayout());

        //Realizamos una instancia
        panel = new PanelDibujo();

        //Creamos las habitaciones con sus tamaños
        panel.agregarFigura(new RectanguloGrafico(149, 50, 150, 100, Color.LIGHT_GRAY)); // Cocina
        panel.agregarFigura(new RectanguloGrafico(300, 50, 150, 100, Color.LIGHT_GRAY)); // Entrada
        panel.agregarFigura(new RectanguloGrafico(300, 151, 150, 100, Color.LIGHT_GRAY)); // Living

        //Creamos los sensores con sus tamaños
        luzCocina = new CirculoGrafico(212, 85, 25, Color.GRAY);
        alarmaEntrada = new RectanguloGrafico(280, 55, 15, 15, Color.GRAY);
        sensorCocina = new TrianguloGrafico(440, 55, 15, Color.GRAY);
        sensorLiving = new TrianguloGrafico(440, 230, 15, Color.GRAY);

        //Agregamos los sensores al panel
        panel.agregarFigura(luzCocina);
        panel.agregarFigura(alarmaEntrada);
        panel.agregarFigura(sensorCocina);
        panel.agregarFigura(sensorLiving);

        //Centramos el panel en el centro de la ventana
        add(panel, BorderLayout.CENTER);

        //Creamos los botones del panel
        JPanel botones = new JPanel();

        //Creamos el boton de luz de la cocina
        JButton botonLuz = new JButton("Encender/Apagar luz cocina");
        botonLuz.addActionListener(e -> {
            luzEncendida = !luzEncendida;
            luzCocina.cambiarColor(luzEncendida ? Color.YELLOW : Color.GRAY);
            JOptionPane.showMessageDialog(this, luzEncendida ? "Luz encendida en la cocina" : "Luz apagada en la cocina");
            panel.repaint();
        });

        //Creamos el boton de la alarma de la entrada
        JButton botonAlarma = new JButton("Activar/Desactivar alarma entrada");
        botonAlarma.addActionListener(e -> {
            alarmaActivada = !alarmaActivada;
            alarmaEntrada.cambiarColor(alarmaActivada ? Color.RED : Color.GRAY);
            JOptionPane.showMessageDialog(this, alarmaActivada ? "Alarma activada en la entrada" : "Alarma desactivada en la entrada");
            panel.repaint();
        });

        //Creamos el boton del sensor del living
        JButton botonMovimiento = new JButton("Activar/Desactivar sensores");
        botonMovimiento.addActionListener(e -> {
            sensorActivo = !sensorActivo;
            sensorCocina.cambiarColor(sensorActivo ? Color.GREEN : Color.GRAY);
            sensorLiving.cambiarColor(sensorActivo ? Color.GREEN : Color.GRAY);
            JOptionPane.showMessageDialog(this, sensorActivo ? "Sensores activados" : "Sensores desactivados");
            panel.repaint();
        });

        //Agregamos botones a la pestaña
        botones.add(botonLuz);
        botones.add(botonAlarma);
        botones.add(botonMovimiento);

        //Agregamos los botones en la parte de abajo de nuestra pestaña
        add(botones, BorderLayout.SOUTH);
    }
}
