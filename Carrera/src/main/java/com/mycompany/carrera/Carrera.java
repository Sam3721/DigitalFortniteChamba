/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
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
public class Carrera {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaCarrera();
            }
        
    });
    }
}
    
class Hilo implements Runnable {

  Thread t;
  
  String nombre;
  
  JLabel personaje;
  
  JLabel meta;
  
  public static int lugar;
  
  public Hilo(String nombre, JLabel personaje, JLabel meta) {
      this.meta=meta;
      this.nombre=nombre;
      this.personaje=personaje;
      t= new Thread(this,nombre);
      t.start();
  }
   
  @Override
  public void run() {
      int delay;
      try{
          lugar=1;
          delay= (int)(Math.random()*15)+1;
          meta.setVisible(false);
          personaje.setVisible(true);
          
          for (int i=50; i<=500; i++) {
              personaje.setLocation(i, personaje.getY());
              Thread.sleep(delay);
          }
          personaje.setVisible(false);
          meta.setVisible(true);
          meta.setText("La "+ nombre+ " llegó de "+lugar);
          lugar++;
          
      }catch(Exception e) {
          System.out.println(e.getMessage());
      }
  }
}

    class VentanaCarrera1 extends JFrame {
        
        public VentanaCarrera1() {
            super("Carrera de motos");
            JLabel moto1, moto2, moto3, moto1_pos, moto2_pos, moto3_pos;
            JButton Inicio;
            
            setSize(500, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            JPanel ventana = new JPanel();
            ventana.setLayout(null);
            
            Image imagen_moto1 = new ImageIcon("src/main/java/imagenes/moto1.jpg").getImage();
            ImageIcon Icon_moto1= new ImageIcon(imagen_moto1.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            moto1= new JLabel();
            moto1.setIcon(Icon_moto1);
            moto1.setBounds(50, 50, 50, 50);
            
            Image imagen_moto2 = new ImageIcon("src/main/java/imagenes/moto2.jpg").getImage();
            ImageIcon Icon_moto2= new ImageIcon(imagen_moto2.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            moto2= new JLabel();
            moto2.setIcon(Icon_moto2);
            moto2.setBounds(50, 100, 50, 50);
            
            Image imagen_moto3 = new ImageIcon("src/main/java/imagenes/moto3.jpg").getImage();
            ImageIcon Icon_moto3= new ImageIcon(imagen_moto3.getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            moto3= new JLabel();
            moto3.setIcon(Icon_moto3);
            moto3.setBounds(50, 150, 50, 50);
            
            moto1_pos = new JLabel();
            moto1_pos.setBounds(50, 50, 350, 50);
            
            moto2_pos= new JLabel();
            moto2_pos.setBounds(50, 100, 350, 50);
            
            moto3_pos= new JLabel();
            moto3_pos.setBounds(50, 150, 350, 50);
            
            Inicio = new JButton("Iniciar carrera");
            Inicio.setBounds(150, 200, 150, 50);
            
            Inicio.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Hilo hmoto1= new Hilo("Moto1", moto1, moto1_pos);
                    Hilo hmoto2= new Hilo("Moto2", moto2, moto2_pos);
                    Hilo hmoto3= new Hilo("Moto3", moto3, moto3_pos);
                }
            
        });
            
            
            ventana.add(moto1);
            ventana.add(moto1_pos);
            ventana.add(moto2);
            ventana.add(moto2_pos);
            ventana.add(moto3);
            ventana.add(moto3_pos);
            ventana.add(Inicio);
            
            add(ventana);
            setVisible(true);
            
            
            
            
        }
        
    }

