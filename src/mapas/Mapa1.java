package mapas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.applet.AudioClip;
import clases.Movimiento;

public class Mapa1 extends javax.swing.JFrame {

    // OBJETO MOVIMIENTO
    private Movimiento movimiento;
    // VARIABLES PARA LA POSICION DEL PERSONAJE
    private int posX,posY;
    //VARIABLE PARA EL CONTADOR
    public int contador = 1;
    // TEMPORIZADOR PARA EL MOVIMIENTO HORIZONTAL
    public Timer reloj;
    // VARIABLE PARA SONIDO
    public AudioClip sonido;
    
    // CARGAMOS LAS IMAGENES
    public void cargarImagen()
    {
        // CARGA IMAGEN DE FONDO
        ImageIcon fondo1 = new ImageIcon(getClass().getResource("/imagenes/fondo.jpg"));
        Icon imagenFondo = new ImageIcon(fondo1.getImage().getScaledInstance(fondo.getWidth(),fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(imagenFondo);
        
        // CARGA IMAGEN DEL TITULO
        ImageIcon titulo = new ImageIcon(getClass().getResource("/imagenes/Titulo.png"));
        Icon imagenTitulo = new ImageIcon(titulo.getImage().getScaledInstance(lblTitulo.getWidth(),lblTitulo.getHeight(), Image.SCALE_DEFAULT));
        lblTitulo.setIcon(imagenTitulo);
        
        // CARGA IMAGEN DEL NIVEL
        ImageIcon nivel1 = new ImageIcon(getClass().getResource("/imagenes/nivel1.png"));
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
        Icon imagenTriangulo = new ImageIcon(triangulo.getImage().getScaledInstance(jLabel3.getWidth(),jLabel3.getHeight(), Image.SCALE_DEFAULT));
        jLabel3.setIcon(imagenTriangulo);
        jLabel4.setIcon(imagenTriangulo);
        jLabel17.setIcon(imagenTriangulo);
        jLabel18.setIcon(imagenTriangulo);
        
        // CARGA IMAGEN CUADRADO
        ImageIcon cuadrado = new ImageIcon(getClass().getResource("/imagenes/cuadrado.png"));
        Icon imagenCuadrado = new ImageIcon(cuadrado.getImage().getScaledInstance(jLabel7.getWidth(),jLabel7.getHeight(), Image.SCALE_DEFAULT));
        jLabel7.setIcon(imagenCuadrado);
        jLabel12.setIcon(imagenCuadrado);
        jLabel19.setIcon(imagenCuadrado);
        
        // CARGA IMAGEN DEL INICAR EL JUEGO
        ImageIcon inicio = new ImageIcon(getClass().getResource("/imagenes/jugar.png"));
        Icon imagenJuego = new ImageIcon(inicio.getImage().getScaledInstance(play.getWidth(),play.getHeight(), Image.SCALE_DEFAULT));
        play.setIcon(imagenJuego);
        
        // CARGAMOS EL INTENTO
        Intento.setText(String.valueOf("INTENTOS: " + contador));
        
        // INSTANCIAMOS EL OBJETO
        movimiento = new Movimiento(this);

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
                    movimiento.iniciarSalto();
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
                for (JLabel obstaculo : movimiento.obstaculos) 
                {
                    Rectangle obs = obstaculo.getBounds();
                    if (pj.intersects(obs)) 
                    {
                        movimiento.colisionJuego();
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
        sonido = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/map1.wav"));
        sonido.play();
    }
    
    public void siguienteMapa()
    {
        Mapa2 x = new Mapa2();
        x.show();
    }
    
    public Mapa1() {
        initComponents();
        ventana();
        cargarImagen();

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Geo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        nivel = new javax.swing.JLabel();
        lblPor = new javax.swing.JLabel();
        play = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        Intento = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Geo.setForeground(new java.awt.Color(255, 255, 255));
        Geo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                GeoKeyPressed(evt);
            }
        });
        getContentPane().add(Geo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 50, 50));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 1360, 110));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, 60, 50));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 530, 60, 50));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setAlignmentY(0.0F);
        jLabel7.setIconTextGap(0);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 530, 50, 50));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setAlignmentY(0.0F);
        jLabel12.setIconTextGap(0);
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 530, 50, 50));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 530, 60, 50));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 530, 60, 50));
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 310, 50, 50));
        getContentPane().add(nivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 30, 140, 60));
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
        getContentPane().add(play, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 120, 100));
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 770, 160));

        Intento.setFont(new java.awt.Font("Haettenschweiler", 1, 36)); // NOI18N
        Intento.setForeground(new java.awt.Color(102, 102, 255));
        getContentPane().add(Intento, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 40, 230, 40));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1360, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GeoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_GeoKeyPressed

    }//GEN-LAST:event_GeoKeyPressed

    private void playKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_playKeyReleased
        
    }//GEN-LAST:event_playKeyReleased

    private void playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseClicked
        
        moverPersonaje();
        Intento.setText(String.valueOf("INTENTOS: " + contador));
        play.setVisible(false);
    }//GEN-LAST:event_playMouseClicked

    private void playKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_playKeyPressed

    }//GEN-LAST:event_playKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {

    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mapa1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mapa1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mapa1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mapa1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Mapa1 map = new Mapa1();
                map.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel Geo;
    public static javax.swing.JLabel Intento;
    private javax.swing.JLabel fondo;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel18;
    public javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblPor;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel nivel;
    public javax.swing.JLabel play;
    // End of variables declaration//GEN-END:variables
}
