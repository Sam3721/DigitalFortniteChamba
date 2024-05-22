/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.carrera;

    import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author yerky vargas
 */
public class Carrera1 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaCarrera();
            }
        });
    }
}

abstract class Vehiculo {
    protected String nombre;
    protected JLabel personaje;
    protected JLabel meta;

    public Vehiculo(String nombre, JLabel personaje, JLabel meta) {
        this.nombre = nombre;
        this.personaje = personaje;
        this.meta = meta;
    }

    public abstract void mover();
}

class Moto extends Vehiculo implements Runnable {
    private Thread t;
    private static int lugar;

    public Moto(String nombre, JLabel personaje, JLabel meta) {
        super(nombre, personaje, meta);
        t = new Thread(this, nombre);
        t.start();
    }

    @Override
    public void run() {
        int delay;
        try {
            lugar = 1;
            delay = (int) (Math.random() * 15) + 1;
            meta.setVisible(false);
            personaje.setVisible(true);

            for (int i = 50; i <= 500; i++) {
                personaje.setLocation(i, personaje.getY());
                Thread.sleep(delay);
            }
            personaje.setVisible(false);
            meta.setVisible(true);
            meta.setText("La " + nombre + " llegó de " + lugar);
            lugar++;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void mover() {
        // Implementación del movimiento
    }
}

class VentanaCarrera extends JFrame {
    public VentanaCarrera() {
        super("Carrera de motos");
        JLabel moto1, moto2, moto3, moto1_pos, moto2_pos, moto3_pos;
        JButton inicio;

        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel ventana = new JPanel();
        ventana.setLayout(null);

        moto1 = crearMotoLabel("src/main/java/imagenes/moto1.jpg", 50, 50);
        moto2 = crearMotoLabel("src/main/java/imagenes/moto2.jpg", 50, 100);
        moto3 = crearMotoLabel("src/main/java/imagenes/moto3.jpg", 50, 150);

        moto1_pos = new JLabel();
        moto1_pos.setBounds(50, 50, 350, 50);

        moto2_pos = new JLabel();
        moto2_pos.setBounds(50, 100, 350, 50);

        moto3_pos = new JLabel();
        moto3_pos.setBounds(50, 150, 350, 50);

        inicio = new JButton("Iniciar carrera");
        inicio.setBounds(150, 200, 150, 50);
        inicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Moto("Moto1", moto1, moto1_pos);
                new Moto("Moto2", moto2, moto2_pos);
                new Moto("Moto3", moto3, moto3_pos);
            }
        });

        ventana.add(moto1);
        ventana.add(moto1_pos);
        ventana.add(moto2);
        ventana.add(moto2_pos);
        ventana.add(moto3);
        ventana.add(moto3_pos);
        ventana.add(inicio);

        add(ventana);
        setVisible(true);
    }

    private JLabel crearMotoLabel(String imagePath, int x, int y) {
        Image imagen = new ImageIcon(imagePath).getImage();
        ImageIcon icon = new ImageIcon(imagen.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
        JLabel label = new JLabel();
        label.setIcon(icon);
        label.setBounds(x, y, 50, 50);
        return label;
    }
}


