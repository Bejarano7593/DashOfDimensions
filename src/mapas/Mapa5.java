package mapas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.applet.AudioClip;
import clases.Movimiento5;
public class Mapa5 extends javax.swing.JFrame {

    // OBJETO MOVIMIENTO
    private Movimiento5 mov;
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
        ImageIcon fondo1 = new ImageIcon(getClass().getResource("/imagenes/fondo5.png"));
        Icon imagenFondo = new ImageIcon(fondo1.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(imagenFondo);
        
        // CARGA IMAGEN DEL TITULO
        ImageIcon titulo = new ImageIcon(getClass().getResource("/imagenes/Titulo.png"));
        Icon imagenTitulo = new ImageIcon(titulo.getImage().getScaledInstance(lblTitulo.getWidth(),lblTitulo.getHeight(), Image.SCALE_DEFAULT));
        lblTitulo.setIcon(imagenTitulo);
        
        // CARGA IMAGEN DEL NIVEL
        ImageIcon nivel1 = new ImageIcon(getClass().getResource("/imagenes/nivel5.png"));
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
        
        // CARGA IMAGEN LAVA
        ImageIcon lavaI = new ImageIcon(getClass().getResource("/imagenes/lava.jpg"));
        Icon imagenLava = new ImageIcon(lavaI.getImage().getScaledInstance(lava.getWidth(),lava.getHeight(), Image.SCALE_DEFAULT));
        lava.setIcon(imagenLava);
        lava1.setIcon(imagenLava);
        lava2.setIcon(imagenLava);
        lava3.setIcon(imagenLava);
        
        // CARGA IMAGEN DEL INICAR EL JUEGO
        ImageIcon inicio = new ImageIcon(getClass().getResource("/imagenes/jugar.png"));
        Icon imagenJuego = new ImageIcon(inicio.getImage().getScaledInstance(play.getWidth(),play.getHeight(), Image.SCALE_DEFAULT));
        play.setIcon(imagenJuego);
        
        // INTENTOS
        Intento.setText(String.valueOf("INTENTOS: " + contador));
        
        // OCULTAMOS LA IMAGEN DE OBSTACULO
        F1.setVisible(false);
        F2.setVisible(false);
        F3.setVisible(false);
        F4.setVisible(false);
        
        // INSTANCIAMOS EL OBJETO
        mov = new Movimiento5(this);

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
                    mov.iniciarSalto();
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
                for (JLabel obstaculo : mov.obstaculos) 
                {
                    Rectangle obs = obstaculo.getBounds();
                    if (pj.intersects(obs)) 
                    {
                        mov.colisionJuego();
                        return;
                    }
                }

                if(posX == 1300)
                {
                    
                    finJuego();
                }
            }
        });
        reloj.start();
    }
        
    public void sonido()
    {
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/map5.wav"));
        sonido.play();
    }
        
    public void finJuego()
    {
        Geo.setVisible(false);
        reloj.stop();
        sonido.stop();
        JOptionPane.showMessageDialog(null, "¡¡¡Felicidades...!!! \n Ganaste el Juego ","Dash of Dimensions", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
    public Mapa5() {
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
        play = new javax.swing.JLabel();
        R1 = new javax.swing.JLabel();
        R2 = new javax.swing.JLabel();
        C1 = new javax.swing.JLabel();
        C2 = new javax.swing.JLabel();
        C3 = new javax.swing.JLabel();
        F1 = new javax.swing.JLabel();
        F4 = new javax.swing.JLabel();
        F2 = new javax.swing.JLabel();
        F3 = new javax.swing.JLabel();
        lava = new javax.swing.JLabel();
        lava1 = new javax.swing.JLabel();
        lava2 = new javax.swing.JLabel();
        lava3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        Intento = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 770, 160));
        getContentPane().add(nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 30, 140, 60));

        Geo.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Geo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 50, 50));
        getContentPane().add(lblPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 480, 60, 100));

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

        R1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sierraA.png"))); // NOI18N
        getContentPane().add(R1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 300, 64, 64));

        R2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sierraA.png"))); // NOI18N
        getContentPane().add(R2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 64, 64));

        C1.setBackground(new java.awt.Color(64, 77, 181));
        C1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        C1.setOpaque(true);
        getContentPane().add(C1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 110, 50));

        C2.setBackground(new java.awt.Color(64, 77, 181));
        C2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        C2.setOpaque(true);
        getContentPane().add(C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 220, 50));

        C3.setBackground(new java.awt.Color(64, 77, 181));
        C3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        C3.setOpaque(true);
        getContentPane().add(C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 310, 220, 50));

        F1.setForeground(new java.awt.Color(255, 255, 255));
        F1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F1.setAlignmentY(0.0F);
        F1.setIconTextGap(0);
        getContentPane().add(F1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, 160, 40));

        F4.setForeground(new java.awt.Color(255, 255, 255));
        F4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F4.setAlignmentY(0.0F);
        F4.setIconTextGap(0);
        getContentPane().add(F4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 550, 170, 40));

        F2.setForeground(new java.awt.Color(255, 255, 255));
        F2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F2.setAlignmentY(0.0F);
        F2.setIconTextGap(0);
        getContentPane().add(F2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 550, 170, 40));

        F3.setForeground(new java.awt.Color(255, 255, 255));
        F3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        F3.setAlignmentY(0.0F);
        F3.setIconTextGap(0);
        getContentPane().add(F3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 550, 170, 40));

        lava.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lava, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 600, 200, 90));

        lava1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lava1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 600, 200, 90));

        lava2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lava2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 600, 200, 90));

        lava3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lava3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 600, 200, 90));

        jLabel2.setBackground(new java.awt.Color(19, 15, 54));
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 580, 140, 110));

        jLabel23.setBackground(new java.awt.Color(19, 15, 54));
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel23.setOpaque(true);
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 580, 90, 110));

        jLabel24.setBackground(new java.awt.Color(19, 15, 54));
        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel24.setOpaque(true);
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 580, 80, 110));

        jLabel25.setBackground(new java.awt.Color(19, 15, 54));
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel25.setOpaque(true);
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 160, 110));

        jLabel26.setBackground(new java.awt.Color(19, 15, 54));
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel26.setOpaque(true);
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 580, 90, 110));

        Intento.setFont(new java.awt.Font("Haettenschweiler", 1, 36)); // NOI18N
        Intento.setForeground(new java.awt.Color(102, 102, 255));
        getContentPane().add(Intento, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 40, 230, 40));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 600));

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
                new Mapa5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel C1;
    public javax.swing.JLabel C2;
    public javax.swing.JLabel C3;
    public javax.swing.JLabel F1;
    public javax.swing.JLabel F2;
    public javax.swing.JLabel F3;
    public javax.swing.JLabel F4;
    public javax.swing.JLabel Geo;
    public static javax.swing.JLabel Intento;
    public javax.swing.JLabel R1;
    public javax.swing.JLabel R2;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    public javax.swing.JLabel lava;
    public javax.swing.JLabel lava1;
    public javax.swing.JLabel lava2;
    public javax.swing.JLabel lava3;
    private javax.swing.JLabel lblPor;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel nivel;
    public javax.swing.JLabel play;
    // End of variables declaration//GEN-END:variables
}
