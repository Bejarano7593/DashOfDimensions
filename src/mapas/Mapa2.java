package mapas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.applet.AudioClip;
import clases.Movimiento2;

public class Mapa2 extends javax.swing.JFrame {

    // OBJETO MOVIMIENTO
    private Movimiento2 mov2;
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
        ImageIcon fondo1 = new ImageIcon(getClass().getResource("/imagenes/fondo2.jpg"));
        Icon imagenFondo = new ImageIcon(fondo1.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(imagenFondo);
        
        // CARGA IMAGEN DEL TITULO
        ImageIcon titulo = new ImageIcon(getClass().getResource("/imagenes/Titulo.png"));
        Icon imagenTitulo = new ImageIcon(titulo.getImage().getScaledInstance(lblTitulo.getWidth(),lblTitulo.getHeight(), Image.SCALE_DEFAULT));
        lblTitulo.setIcon(imagenTitulo);
        
        // CARGA IMAGEN DEL NIVEL
        ImageIcon nivel1 = new ImageIcon(getClass().getResource("/imagenes/nivel2.png"));
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
        Icon imagenTriangulo = new ImageIcon(triangulo.getImage().getScaledInstance(T1.getWidth(),T1.getHeight(), Image.SCALE_DEFAULT));
        T1.setIcon(imagenTriangulo);
        T2.setIcon(imagenTriangulo);
        T3.setIcon(imagenTriangulo);
        T4.setIcon(imagenTriangulo);
        T5.setIcon(imagenTriangulo);
        
        // CARGA IMAGEN TRIANGULO INVERTIDO
        ImageIcon tInv = new ImageIcon(getClass().getResource("/imagenes/trianguloInv.png"));
        Icon imagenTriInv= new ImageIcon(tInv.getImage().getScaledInstance(T1.getWidth(),T1.getHeight(), Image.SCALE_DEFAULT));
        Inv1.setIcon(imagenTriInv);
        Inv2.setIcon(imagenTriInv);
        Inv3.setIcon(imagenTriInv);
        Inv4.setIcon(imagenTriInv);
        Inv5.setIcon(imagenTriInv);
        Inv6.setIcon(imagenTriInv);
        Inv7.setIcon(imagenTriInv);
        Inv8.setIcon(imagenTriInv);
        
        // CARGA IMAGEN CUADRADO
        ImageIcon cuadrado = new ImageIcon(getClass().getResource("/imagenes/cuadrado.png"));
        Icon imagenCuadrado = new ImageIcon(cuadrado.getImage().getScaledInstance(Inv8.getWidth(),Inv8.getHeight(), Image.SCALE_DEFAULT));
        C2.setIcon(imagenCuadrado);
        C3.setIcon(imagenCuadrado);
        C4.setIcon(imagenCuadrado);
        C5.setIcon(imagenCuadrado);
        
        // CARGA IMAGEN DEL INICAR EL JUEGO
        ImageIcon inicio = new ImageIcon(getClass().getResource("/imagenes/jugar.png"));
        Icon imagenJuego = new ImageIcon(inicio.getImage().getScaledInstance(play.getWidth(),play.getHeight(), Image.SCALE_DEFAULT));
        play.setIcon(imagenJuego);
        
        // INTENTOS
        Intento.setText(String.valueOf("INTENTOS: " + contador));
        
        // INSTANCIAMOS EL OBJETO
        mov2 = new Movimiento2(this);

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
                    mov2.iniciarSalto();
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
                for (JLabel obstaculo : mov2.obstaculos) 
                {
                    Rectangle obs = obstaculo.getBounds();
                    if (pj.intersects(obs)) 
                    {
                        mov2.colisionJuego();
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
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/map2.wav"));
        sonido.play();
    }
        
    public void siguienteMapa()
    {
        Mapa3 x = new Mapa3();
        x.show();
    }
    public Mapa2() {
        initComponents();
        ventana();
        cargarImagen();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        Geo = new javax.swing.JLabel();
        lblPor = new javax.swing.JLabel();
        nivel = new javax.swing.JLabel();
        T1 = new javax.swing.JLabel();
        T2 = new javax.swing.JLabel();
        T3 = new javax.swing.JLabel();
        T4 = new javax.swing.JLabel();
        T5 = new javax.swing.JLabel();
        Inv1 = new javax.swing.JLabel();
        Inv2 = new javax.swing.JLabel();
        Inv3 = new javax.swing.JLabel();
        Inv4 = new javax.swing.JLabel();
        Inv5 = new javax.swing.JLabel();
        Inv6 = new javax.swing.JLabel();
        play = new javax.swing.JLabel();
        Inv7 = new javax.swing.JLabel();
        Inv8 = new javax.swing.JLabel();
        C2 = new javax.swing.JLabel();
        C3 = new javax.swing.JLabel();
        C4 = new javax.swing.JLabel();
        C5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Intento = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 770, 160));

        Geo.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Geo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 50, 50));
        getContentPane().add(lblPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 480, 60, 100));
        getContentPane().add(nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 30, 140, 60));

        T1.setForeground(new java.awt.Color(255, 255, 255));
        T1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        getContentPane().add(T1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 530, 60, 50));

        T2.setForeground(new java.awt.Color(255, 255, 255));
        T2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        getContentPane().add(T2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 530, 60, 50));

        T3.setForeground(new java.awt.Color(255, 255, 255));
        T3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        T3.setMaximumSize(new java.awt.Dimension(60, 50));
        T3.setMinimumSize(new java.awt.Dimension(60, 50));
        getContentPane().add(T3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 530, 60, 50));

        T4.setForeground(new java.awt.Color(255, 255, 255));
        T4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        T4.setMaximumSize(new java.awt.Dimension(60, 50));
        T4.setMinimumSize(new java.awt.Dimension(60, 50));
        getContentPane().add(T4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 530, 60, 50));

        T5.setForeground(new java.awt.Color(255, 255, 255));
        T5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        getContentPane().add(T5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 530, 60, 50));

        Inv1.setForeground(new java.awt.Color(255, 255, 255));
        Inv1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        Inv1.setMaximumSize(new java.awt.Dimension(60, 50));
        Inv1.setMinimumSize(new java.awt.Dimension(60, 50));
        getContentPane().add(Inv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 60, 50));

        Inv2.setForeground(new java.awt.Color(255, 255, 255));
        Inv2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        Inv2.setMaximumSize(new java.awt.Dimension(60, 50));
        Inv2.setMinimumSize(new java.awt.Dimension(60, 50));
        getContentPane().add(Inv2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 60, 50));

        Inv3.setForeground(new java.awt.Color(255, 255, 255));
        Inv3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        Inv3.setMaximumSize(new java.awt.Dimension(60, 50));
        Inv3.setMinimumSize(new java.awt.Dimension(60, 50));
        getContentPane().add(Inv3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 340, 60, 50));

        Inv4.setForeground(new java.awt.Color(255, 255, 255));
        Inv4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        getContentPane().add(Inv4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 60, 50));

        Inv5.setForeground(new java.awt.Color(255, 255, 255));
        Inv5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        getContentPane().add(Inv5, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 370, 60, 50));

        Inv6.setForeground(new java.awt.Color(255, 255, 255));
        Inv6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        getContentPane().add(Inv6, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 330, 60, 50));

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

        Inv7.setForeground(new java.awt.Color(255, 255, 255));
        Inv7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        getContentPane().add(Inv7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 400, 60, 50));

        Inv8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangulo.png"))); // NOI18N
        getContentPane().add(Inv8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 350, 60, 50));

        C2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuadrado.png"))); // NOI18N
        C2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 19, 237)));
        getContentPane().add(C2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 50, 50));

        C3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuadrado.png"))); // NOI18N
        C3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 19, 237)));
        getContentPane().add(C3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 530, 50, 50));

        C4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuadrado.png"))); // NOI18N
        C4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 19, 237)));
        getContentPane().add(C4, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 530, 50, 50));

        C5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuadrado.png"))); // NOI18N
        C5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 19, 237)));
        getContentPane().add(C5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, 50, 50));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cuadrado.png"))); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 19, 237)));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 1360, 110));

        Intento.setFont(new java.awt.Font("Haettenschweiler", 1, 36)); // NOI18N
        Intento.setForeground(new java.awt.Color(102, 0, 102));
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
                Mapa2 map = new Mapa2();
                map.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel C2;
    public javax.swing.JLabel C3;
    public javax.swing.JLabel C4;
    public javax.swing.JLabel C5;
    public javax.swing.JLabel Geo;
    public static javax.swing.JLabel Intento;
    public javax.swing.JLabel Inv1;
    public javax.swing.JLabel Inv2;
    public javax.swing.JLabel Inv3;
    public javax.swing.JLabel Inv4;
    public javax.swing.JLabel Inv5;
    public javax.swing.JLabel Inv6;
    public javax.swing.JLabel Inv7;
    public javax.swing.JLabel Inv8;
    public javax.swing.JLabel T1;
    public javax.swing.JLabel T2;
    public javax.swing.JLabel T3;
    public javax.swing.JLabel T4;
    public javax.swing.JLabel T5;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblPor;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel nivel;
    public javax.swing.JLabel play;
    // End of variables declaration//GEN-END:variables
}
