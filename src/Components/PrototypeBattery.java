/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Console;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author Acer
 */
public class PrototypeBattery extends JPanel {

   final int min = 0;
   final int max = 100;

   int i = 0;
   public int r,g,b;
   //zmienne predkosci ladowania [delay]
   int cs = 200; //ladowanie
   int ds = 800; //roz
 //---
    public JPanel panel;
    public JFrame frame;
    public JProgressBar batteryBar;
    javax.swing.JCheckBox chargingCB, dischargingCB; 
    JTextField chargSpeed,disSpeed;
    Timer t, td;
    public Button buttonC;
    public PrototypeBattery() {
        
//kontrolki
        panel = new JPanel();
            
//panel.setLayout(null);
        
         chargSpeed = new JTextField("Speed ms");
         disSpeed = new JTextField();
       
        batteryBar = new JProgressBar(min, max);
        chargingCB = new javax.swing.JCheckBox("⚡");
        dischargingCB = new JCheckBox("⚡"); //ikony zamiast słów
        chargingCB.setForeground(Color.GREEN);
        dischargingCB.setForeground(Color.red);
        buttonC = new Button("Color");
        chargingCB.setToolTipText("Charging"); //tooltipy
        dischargingCB.setToolTipText("Discharging");
        chargingCB.setFont(new Font("", Font.PLAIN, 30));
        dischargingCB.setFont(new Font("", Font.PLAIN, 30));
           Random random = new Random();
//end kotnrolki
        batteryBar.setStringPainted(true);
        chargingCB.setMnemonic(KeyEvent.VK_C);

        dischargingCB.setMnemonic(KeyEvent.VK_D);

        chargingCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (chargingCB.isSelected()) {
                    t.start();
             
                    
                    
                } else {
                    t.stop();
                }
            }
        });
        dischargingCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dischargingCB.isSelected()) {
                    td.start();
                } else {
                    td.stop();
                }
            }
        });

        t = new Timer(cs, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i == max) {
                    t.stop();
                } else {
                    i++;
                    batteryBar.setValue(i);
                    if (i<20) panel.setBackground(Color.red);
                    if (i>20 && i<40) panel.setBackground(Color.YELLOW);
                    if (i>40) panel.setBackground(Color.GREEN);
                 
                        System.out.println("Bateria: " + i + "%");
   
                }
            }
        });
        td = new Timer(ds, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i == min) {
                    td.stop();
                } else {
                    i--;
                    batteryBar.setValue(i);
                     if (i<20) panel.setBackground(Color.red);
                    if (i>20 && i<40) panel.setBackground(Color.YELLOW);
                    if (i>40) panel.setBackground(Color.GREEN);
                 System.out.println("Bateria: " + i + "%");
                }
            }
        });
       
      
        
        this.setBackground(randomColor());
       
        add(panel);
        add(batteryBar);
        add(chargingCB);
        add(dischargingCB);
 
        event m = new event();
        this.addMouseListener(m);
    
  
    }

 public Color randomColor(){
        r = (int) (Math.random()*255);
        g = (int) (Math.random()*255);
        b = (int) (Math.random()*255);
       return (new Color(r,g,b));

 }
 public class event implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
           //.setBackground(randomColor());
            Components.PrototypeBattery.super.setBackground(randomColor());
            System.out.print("R: " + r + " ");
            System.out.print("G: " + g + " ");
            System.out.println("B: " + b + " ");
         
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }}
 
