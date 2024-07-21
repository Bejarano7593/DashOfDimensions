package mapas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.applet.AudioClip;
import clases.Movimiento3;

public class Mapa3 extends javax.swing.JFrame {

    // OBJETO MOVIMIENTO
    private Movimiento3 mov3;
    // VARIABLES PARA LA POSICION DEL PERSONAJE
    private int posX,posY;
    public int contador = 1;
    // TEMPORIZADOR PARA EL MOVIMIENTO HORIZONTAL
    public Timer reloj;
    // VARIABLE PARA SONIDO
    public AudioClip sonido;
    
    // CARGAMOS LAS IMAGENES
    public void cargarImagen()
    {
        // CARGA IMAGEN DE FONDO
        ImageIcon fondo1 = new ImageIcon(getClass().getResource("/imagenes/fondo3.jpg"));
        Icon imagenFondo = new ImageIcon(fondo1.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(imagenFondo);
        
        // CARGA IMAGEN DEL TITULO
        ImageIcon titulo = new ImageIcon(getClass().getResource("/imagenes/Titulo.png"));
        Icon imagenTitulo = new ImageIcon(titulo.getImage().getScaledInstance(lblTitulo.getWidth(),lblTitulo.getHeight(), Image.SCALE_DEFAULT));
        lblTitulo.setIcon(imagenTitulo);
        
        // CARGA IMAGEN DEL NIVEL
        ImageIcon nivel1 = new ImageIcon(getClass().getResource("/imagenes/nivel3.png"));
        Icon imagenNivel= new ImageIcon(nivel1.getImage().getScaledInstance(nivel.getWidth(),nivel.getHeight(), Image.SCALE_DEFAULT));
        nivel.setIcon(imagenNivel);
        
        // CARGA IMAGEN DEL PERSONAJE
        ImageIcon geometry = new ImageIcon(getClass().getResource("/imagenes/imagen1.png"));
        Icon imagenGeo = new ImageIcon(geometry.getImage().getScaledInstance(Geo.getWidth(),Geo.getHeight(), Image.SCALE_DEFAULT));
        Geo.setIcon(imagenGeo);
        
        // CARGA IMAGEN DEL PORTAL
        ImageIcon portal = new ImageIcon(getClass().getResource("/imagenes/portal.png"));
        Icon imagenPor = new ImageIcon(portal.getImage().getScaledInstance(lblPor.getWidth(),lblPor.getHeight(), Image.SCALE_DEFAULT));
        lblPor.setIcon(imagenPor);
        
        // CARGA IMAGEN TRIANGULO
        ImageIcon triangulo = new ImageIcon(getClass().getResource("/imagenes/triangulo.png"));
        Icon imagenTriangulo = new ImageIcon(triangulo.getImage().getScaledInstance(T2.getWidth(),T2.getHeight(), Image.SCALE_DEFAULT));
        T2.setIcon(imagenTriangulo);
        T3.setIcon(imagenTriangulo);
        
        // CARGA IMAGEN TRIANGULO INVERTIDO
        ImageIcon tInv = new ImageIcon(getClass().getResource("/imagenes/trianguloInv.png"));
        Icon imagenTriInv= new ImageIcon(tInv.getImage().getScaledInstance(T2.getWidth(),T2.getHeight(), Image.SCALE_DEFAULT));
        Inv1.setIcon(imagenTriInv);
        
        // CARGA IMAGEN CUADRADO
        ImageIcon cuadrado = new ImageIcon(getClass().getResource("/imagenes/cuadrado.png"));
        Icon imagenCuadrado = new ImageIcon(cuadrado.getImage().getScaledInstance(C1.getWidth(),C1.getHeight(), Image.SCALE_DEFAULT));
        C1.setIcon(imagenCuadrado);
        C2.setIcon(imagenCuadrado);
        C3.setIcon(imagenCuadrado);
        
        // CARGA IMAGEN DEL INICAR EL JUEGO
        ImageIcon inicio = new ImageIcon(getClass().getResource("/imagenes/jugar.png"));
        Icon imagenJuego = new ImageIcon(inicio.getImage().getScaledInstance(play.getWidth(),play.getHeight(), Image.SCALE_DEFAULT));
        play.setIcon(imagenJuego);
        
        // INTENTOS
        Intento.setText(String.valueOf("INTENTOS: " + contador));
        
        // INSTANCIAMOS EL OBJETO
        mov3 = new Movimiento3(this);

        // AGREGAMOS UN KEYLISTENER PARA INICAR EL SALTO
        addKeyListener(new KeyListener() 
        {
            @Override
            public void keyTyped(KeyEvent e) 
            {}

            @Override
            public void keyPressed(KeyEvent e) 
            {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) 
                {
                    mov3.iniciarSalto();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) 
            {}
        });
        setFocusable(true);
        
    }
    
    public void ventana()
    {
        this.setTitle("Dash of Dimensions V.1");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    
    public void moverPersonaje() 
    {
        sonido();
        // MOVEMOS EL PERSONAJE MEDIANTE UN TEMPORIZADOR
        reloj = new Timer(10, new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                // POSICION DEL PERSONAJE
                posX = Geo.getX();
                posY = Geo.getY();
                // ASIGAMOS DE CUANTO EN CUANTO SE MOVERA EL PERSONAJE
                posX += 5;
                // ACTUALIZAMOS LA POSICION DEL PERSONAJE EN X
                Geo.setLocation(posX, posY);
                
                // VERIFICAMOS SI COLISIONA EN SU MOVIMIENTO HORIZONTAL
                Rectangle pj = Geo.getBounds();
                for (JLabel obstaculo : mov3.obstaculos) 
                {
                    Rectangle obs = obstaculo.getBounds();
                    if (pj.intersects(obs)) 
                    {
                        mov3.colisionJuego();
                        return;
                    }
                }
                
                if(posX == 1300)
                {
                    Geo.setVisible(false);
                    reloj.stop();
                    sonido.stop();
                    dispose();
                    siguienteMapa();
                }
            }
        });
        reloj.start();
    }
    
    public void sonido()
    {
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/map3.wav"));
        sonido.play();
    }
        
    public void siguienteMapa()
    {
        Mapa4 x = new Mapa4();
        x.show();
    }
    public Mapa3() {
        initComponents();
        ventana();
        cargarImagen();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        nivel = new javax.swing.JLabel();
        Geo = new javax.swing.JLabel();
        lblPor = new javax.swing.JLabel();
        T2 = new javax.swing.JLabel();
        T3 = new javax.swing.JLabel();
        Inv1 = new javax.swing.JLabel();
        C1 = new javax.swing.JLabel();
        C2 = new javax.swing.JLabel();
        C3 = new javax.swing.JLabel();
        R4 = new javax.swing.JLabel();
        R1 = new javax.swing.JLabel();
        R2 = new javax.swing.JLabel();
        R3 = new javax.swing.JLabel();
        play = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Intento = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 770, 160));
        getContentPane().add(nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 30, 140, 60));

        Geo.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Geo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 50, 50));
        getContentPane().add(lblPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 480, 60, 100));

        T2.setForeground(new java.awt.Color(255, 255, 255));
        T2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        getContentPane().add(T2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 530, 60, 50));

        T3.setForeground(new java.awt.Color(255, 255, 255));
        T3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        getContentPane().add(T3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 530, 60, 50));

        Inv1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        getContentPane().add(Inv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 340, 60, 50));

        C1.setBackground(new java.awt.Color(0, 0, 0));
        C1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 130, 205), 2, true));
        C1.setOpaque(true);
        getContentPane().add(C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 330, 50));

        C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuadrado.png"))); // NOI18N
        C2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 130, 205)));
        getContentPane().add(C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 50, 50));

        C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuadrado.png"))); // NOI18N
        C3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 130, 205)));
        getContentPane().add(C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 340, 50, 50));

        R4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sierra.png"))); // NOI18N
        getContentPane().add(R4, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 520, 60, 60));

        R1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sierra.png"))); // NOI18N
        getContentPane().add(R1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, 60, 60));

        R2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sierra.png"))); // NOI18N
        getContentPane().add(R2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 520, 60, 60));

        R3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sierra.png"))); // NOI18N
        getContentPane().add(R3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 60, 60));

        play.setToolTipText("PLAY");
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playMouseClicked(evt);
            }
        });
        play.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                playKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                playKeyReleased(evt);
            }
        });
        getContentPane().add(play, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 120, 100));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 130, 205)));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 1360, 110));

        Intento.setFont(new java.awt.Font("Haettenschweiler", 1, 36)); // NOI18N
        Intento.setForeground(new java.awt.Color(102, 102, 255));
        getContentPane().add(Intento, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 40, 230, 40));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseClicked

        moverPersonaje();
        Intento.setText(String.valueOf("INTENTOS: " + contador));
        play.setVisible(false);
    }//GEN-LAST:event_playMouseClicked

    private void playKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_playKeyReleased
        
    }//GEN-LAST:event_playKeyReleased

    private void playKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_playKeyPressed

    }//GEN-LAST:event_playKeyPressed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mapa3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel C1;
    public javax.swing.JLabel C2;
    public javax.swing.JLabel C3;
    public javax.swing.JLabel Geo;
    public static javax.swing.JLabel Intento;
    public javax.swing.JLabel Inv1;
    public javax.swing.JLabel R1;
    public javax.swing.JLabel R2;
    public javax.swing.JLabel R3;
    public javax.swing.JLabel R4;
    public javax.swing.JLabel T2;
    public javax.swing.JLabel T3;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblPor;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel nivel;
    public javax.swing.JLabel play;
    // End of variables declaration//GEN-END:variables
}
