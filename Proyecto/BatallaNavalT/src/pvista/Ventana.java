package pvista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import pmodelo.LogicaJuego;

public class Ventana extends JFrame{
    public  JFrame vJuego;
    
    //Darle dimensiones graficas a la ventana 
    public void DimensionVentana(JFrame ventana) {
        vJuego = ventana;
        vJuego.getContentPane().setLayout(null);
        vJuego.getContentPane().setBackground(Color.white);
        vJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vJuego.setPreferredSize(new Dimension (1022,600));
        vJuego.setTitle("Batalla Naval");
        vJuego.setResizable(false);
        vJuego.pack();
        vJuego.setVisible(true);
        vJuego.repaint();
    }
    
    public Ventana() {
    }
    
    //Cargar todo elemento grafico en la ventana 
    public void CargarElementos(JFrame ventana, Tablero t, JLabel nMovimientos) {
        
        JLabel info = new JLabel();
        nMovimientos.setSize(250,40);
        nMovimientos.setLocation(12, 512 );
        nMovimientos.setFont(new java.awt.Font("Arial", 0, 18));

        t.setSize(1002,496);
        t.setLocation(10, 10);
        t.setBackground(Color.white);
        
        ventana.getContentPane().add(nMovimientos);
        
        ventana.getContentPane().add(t);
        ventana.addMouseListener(t);
        
        ventana.repaint();
        ventana.setVisible(true);
    }
    
    //Pintar el fin del juego.
    public void finalizar(JFrame v, Tablero t, JLabel m, int caso) throws Exception {
        JLabel res = new JLabel();
        JLabel PJ = new JLabel();
        JLabel PPC = new JLabel();
        m.setText("Disparos disponibles: " + Integer.toString(0));
        v.getContentPane().remove(t);
        PJ.setText("PUNTAJE JUGADOR: " + t.getDisparo().getAciertosjugador());
        PJ.setLocation(400, 400);
        PJ.setSize(300, 20);
        PJ.setFont(new java.awt.Font("Arial", 0, 14));
        v.getContentPane().add(PJ);
        v.repaint();
        PPC.setText("PUNTAJE PC: " + t.getDisparo().getAciertospc());
        PPC.setLocation(400, 440);
        PPC.setSize(300, 20);
        PPC.setFont(new java.awt.Font("Arial", 0, 14));
        v.getContentPane().add(PPC);
        v.repaint();
        
        switch (caso){
            case 0: {
            
            try { Thread.sleep(5000); 
            } catch(InterruptedException e ) 
            { System.out.println("x"); }
            res.setText("USTED HA GANADO");
            res.setLocation(300, 300);
            res.setSize(400, 40);
            res.setFont(new java.awt.Font("Arial", 0, 36));
            v.getContentPane().add(res);
            v.repaint();
            try { Thread.sleep(5000); 
            } catch(InterruptedException e ) 
            { System.out.println("x"); }
            new LogicaJuego().Iniciar();
            System.exit(0);
            }
            case 1: {
            
            try { Thread.sleep(5000); 
            } catch(InterruptedException e ) 
            { System.out.println("x"); }
            res.setText("PC HA GANADO");
            res.setLocation(300, 300);
            res.setSize(400, 40);
            res.setFont(new java.awt.Font("Arial", 0, 36));
            v.getContentPane().add(res);
            v.repaint();
            try { Thread.sleep(5000); 
            } catch(InterruptedException e ) 
            { System.out.println("x"); }
            new LogicaJuego().Iniciar();
            System.exit(0);
            }
            case 2: {
            
            try { Thread.sleep(5000); 
            } catch(InterruptedException e ) 
            { System.out.println("x"); }
            res.setText("HUBO UN EMPATE");
            res.setLocation(300, 300);
            res.setSize(400, 40);
            res.setFont(new java.awt.Font("Arial", 0, 36));
            v.getContentPane().add(res);
            v.repaint();
            try { Thread.sleep(5000); 
            } catch(InterruptedException e ) 
            { System.out.println("x"); }
            
            new LogicaJuego().Iniciar();
            System.exit(0);
            }
            
        }
    }
}
