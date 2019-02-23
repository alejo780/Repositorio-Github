package pvista;

import pmodelo.EstadoBarco;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import pcontrolador.Disparo;


public class Tablero extends JPanel implements MouseListener{
    private BufferedImage tableroImage;
    private Object[][] matriz;
    private Object[][] matriz2;
    private Disparo disparo = new Disparo(); 
    
    /*
    * Cuando no hay una matriz para el arreglo
    */
   public Tablero() {
           this(new Object[15][15], new Object[15][15], "tablero.png");
   }

   /*
    * Cuando conozco la matriz de ambos jugadores
    */
   public Tablero(Object[][] arr, Object[][] arr2) {
           this(arr, arr2, "tablero.png");
   }

   /*
    * Cuando conozco la matriz de los jugadores y la ruta de imagen
    */
   public Tablero(Object[][] arr, Object[][] arr2, String path) {
           matriz = arr;
           matriz2 = arr2;
           try {
                   tableroImage = ImageIO.read(new File(path));
           } catch (IOException e) {
                   System.out.println("Failed to load image");
           }
   }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.drawImage(tableroImage, 0, 0, this);
        g2.drawImage(tableroImage, 506, 0, this);

        for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    
                    int px = (2+(33*i));
                    int py = (2+(33*j));
                    if(matriz[i][j].getClass().getName().equals("pmodelo.EstadoBarco")){
                        g2.drawImage(((EstadoBarco) matriz[i][j]).getShipImage(), px, py, this);
                    } else if ((int)matriz[i][j] == 0) {
                        g2.drawImage(new ImageIcon("oculto.png").getImage(), px, py, this);
                    } else if (this.matriz[i][j].getClass().getName().equals("pmodelo.EstadoBarco")
                        && ((EstadoBarco)this.matriz[i][j]).pDestruida()) {
                        g2.drawImage(((EstadoBarco) matriz[i][j]).getShipImage(), px, py, this);
                    } else if ((int)matriz[i][j] == 1) {
                        g2.drawImage(new ImageIcon("agua.png").getImage(), px, py, this);
                    }
                }
        }
        
        for (int i = 0; i < matriz2.length; i++) {
                for (int j = 0; j < matriz2[i].length; j++) {
                    
                    int px = (506+2+(33*i));
                    int py = (2+(33*j));
                    if(matriz2[i][j].getClass().getName().equals("pmodelo.EstadoBarco")){
                        g2.drawImage(((EstadoBarco) matriz2[i][j]).getShipImage(), px, py, this);
                    } else if ((int)matriz2[i][j] == 0) {
                        g2.drawImage(new ImageIcon("oculto.png").getImage(), px, py, this);
                    } else if (this.matriz2[i][j].getClass().getName().equals("pmodelo.EstadoBarco")
                        && ((EstadoBarco)this.matriz2[i][j]).pDestruida()) {
                        g2.drawImage(((EstadoBarco) matriz2[i][j]).getShipImage(), px, py, this);
                    } else if ((int)matriz2[i][j] == 1) {
                        g2.drawImage(new ImageIcon("agua.png").getImage(), px, py, this);
                    }
                }
        }

    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        
        if (e.getClickCount() == 2){
            if (e.getX() > 516 && e.getX() < 1012) {
                if (e.getY() > 10 && e.getY() < 526) {
                    disparo.Actualizar(matriz, matriz2, e.getX(), e.getY());
                }
            }
        }
    }
    
    @Override 
    public void mouseClicked(MouseEvent e){
        
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    
    /**
     * Obtener el disparo que se ha dado en este tablero 
     * @return 
     */
    public Disparo getDisparo() {
        return this.disparo;
    }
  
}