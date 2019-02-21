package pvista;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

public class Menu {
    private JFrame Ventana;
    private JButton Jugar;
    private JButton AcercaDe;
    private JButton Ayuda;
    private JButton Salir;
    private volatile boolean EsVisible;
    private Clip clip; //Sonido por emitir
    private final String path = "/pcontrolador/"; //Ruta para el sonido
    
    //Inicializar la ventana
    public Menu(JFrame forma){
        Ventana = forma;
        EsVisible = true;
    }

    //Cargar los elementos en el titulo
    public void loadTitleScreen() {
        int tbx = 230;
        int tby = 45;
        
        //tableroImage = ImageIO.read(new File(path));
        Play("batalla");

        Jugar = new JButton("Jugar");
        Jugar.setSize(tbx,tby);
        Jugar.setLocation((Ventana.getSize().width/2)-(Jugar.getSize().width/2),200);    
        Jugar.setFont(new java.awt.Font("Arial", 0, 36));
        Jugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MetodosUtiles.Cuantosbarcos();
                Ventana.remove(Jugar);
                Ventana.remove(Ayuda);
                Ventana.remove(AcercaDe);
                Ventana.remove(Salir);
                Ventana.getContentPane().revalidate();
                
                Ventana.repaint();
                EsVisible = false;
            }
        });
        
        AcercaDe = new JButton("Acerca de");
        AcercaDe.setSize(tbx,tby);
        AcercaDe.setLocation((Ventana.getSize().width/2)-(AcercaDe.getSize().width/2),300);
        AcercaDe.setFont(new java.awt.Font("Arial", 0, 36));
        AcercaDe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MetodosUtiles.Acercade();
            }
        });
        
        Ayuda = new JButton("Ayuda");
        Ayuda.setSize(tbx,tby);
        Ayuda.setLocation((Ventana.getSize().width/2)-(Ayuda.getSize().width/2),400);
        Ayuda.setFont(new java.awt.Font("Arial", 0, 36));
        Ayuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MetodosUtiles.Instrucciones();
            }
        });
        
        Salir = new JButton("Salir");
        Salir.setSize(tbx,tby);
        Salir.setLocation((Ventana.getSize().width/2)-(Salir.getSize().width/2),500);
        Salir.setFont(new java.awt.Font("Arial", 0, 36));
        Salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        Jugar.setVisible(true);
        AcercaDe.setVisible(true);
        Ayuda.setVisible(true);
        Salir.setVisible(true);
        //label.setVisible(true);

        Ventana.getContentPane().add(Jugar);
        Ventana.getContentPane().add(AcercaDe);
        Ventana.getContentPane().add(Ayuda);
        Ventana.getContentPane().add(Salir);
        //Ventana.getContentPane().add(label);
        Ventana.setVisible(true);
    }
    
    //Determinar si el menu esta visible 
    public boolean EsVVisible(){
        return EsVisible;
    }
    
    public void Play(String value){
        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(path+value+".wav")));
            clip.loop(0);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
