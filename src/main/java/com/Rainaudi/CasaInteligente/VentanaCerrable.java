package com.Rainaudi.CasaInteligente;

import javax.swing.*;
import java.awt.*;

public class VentanaCerrable extends JFrame {
    private CirculoGrafico luz;
    private RectanguloGrafico alarma;
    private TrianguloGrafico sensor;
    private PanelDibujo panel;

    public VentanaCerrable() {
        setTitle("Casa Inteligente Simple");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Crear sensores
        luz = new CirculoGrafico(90, 80, 30, Color.GRAY);
        alarma = new RectanguloGrafico(260, 80, 30, 30, Color.GRAY);
        sensor = new TrianguloGrafico(430, 80, 30, Color.GRAY);

        panel = new PanelDibujo(luz, alarma, sensor);
        add(panel, BorderLayout.CENTER);

        JPanel botones = new JPanel();

        JButton btnLuz = new JButton("Encender luz");
        JButton btnAlarma = new JButton("Activar alarma");
        JButton btnSensor = new JButton("Detectar movimiento");

        btnLuz.addActionListener(e -> {
            luz.cambiarColor(Color.YELLOW);
            JOptionPane.showMessageDialog(this, "Luz encendida en la cocina");
            panel.repaint();
        });

        btnAlarma.addActionListener(e -> {
            alarma.cambiarColor(Color.RED);
            JOptionPane.showMessageDialog(this, "¡Alarma activada!");
            panel.repaint();
        });

        btnSensor.addActionListener(e -> {
            sensor.cambiarColor(Color.GREEN);
            JOptionPane.showMessageDialog(this, "¡Movimiento detectado!");
            panel.repaint();
        });

        botones.add(btnLuz);
        botones.add(btnAlarma);
        botones.add(btnSensor);

        add(botones, BorderLayout.SOUTH);
    }
}
