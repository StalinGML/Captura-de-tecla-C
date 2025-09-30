package com.mycompany.capturadeteclac;

/**
 * Tarea Semana 16: Captura de tecla "C" en Java Swing
 * Desarrollado por: Stalin Mendieta
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CapturaDeTeclaC extends JFrame {

    private JList<String> lista;
    private JButton boton;

    public CapturaDeTeclaC() {
        // Configuración de la ventana
        setTitle("Ejercicio de Captura de Tecla 'C'");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana

        // --- Lista de elementos ---
        String[] elementos = {"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4"};
        lista = new JList<>(elementos);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollLista = new JScrollPane(lista);

        // --- Botón de ejemplo ---
        boton = new JButton("Botón de Prueba");
        // Acción sencilla del botón
        boton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, 
                "Selección realizada.", 
                "Acción del Botón", 
                JOptionPane.INFORMATION_MESSAGE);
        });

        // --- Panel principal con bordes y espaciado ---
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.add(scrollLista, BorderLayout.CENTER);
        panelPrincipal.add(boton, BorderLayout.SOUTH);

        // --- Key Binding: Capturar tecla 'C' SOLO cuando la lista tiene el foco ---
        InputMap inputMap = lista.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap actionMap = lista.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "accionC");
        actionMap.put("accionC", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("--------------------------------------------------");
                System.out.println("TECLA 'C' DETECTADA SOBRE LA LISTA");
                if (lista.getSelectedIndex() != -1) {
                    System.out.println("Elemento seleccionado: " + lista.getSelectedValue());
                } else {
                    System.out.println("Ningún elemento seleccionado.");
                }
                System.out.println("--------------------------------------------------");
            }
        });

        add(panelPrincipal);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CapturaDeTeclaC().setVisible(true);
        });
    }
}