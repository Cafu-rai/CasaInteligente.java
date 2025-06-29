package com.Rainaudi.CasaInteligente;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelDibujo extends JPanel {
    ArrayList<Dibujable> figuras = new ArrayList<>();

    public void agregarFigura(Dibujable figura) {
        figuras.add(figura);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        for (Dibujable figura : figuras) {
            figura.dibujar(g);
        }
    }
}


