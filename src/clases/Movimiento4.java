package clases;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import mapas.Mapa4;
public class Movimiento4 {
    //OBJETOS
    private Mapa4 mapa; 

    //VARIABLES PARA SALTO PARABOLICO
    public int altMaxima;
    public int tSalto = 0;
    public int salJuego = 0;
    public int salDuracion = 38;
    public int velInicialY = 0;
    public double gravedad = 0.5;
    public double velHorizontal = 10.0;
    public double progreso;
    // LISTA DE OBJETOS PARA COLICION
    public List<JLabel> obstaculos = new ArrayList<>();
    // VARIABLE PARA CONTROL DEL SALTO
    public boolean bandera = false;
    public boolean perder = false;
    // VARIABLE PARA OPCION DE CONTINUAR O SALIR
    private int op;
    
    public Timer reloj;

    public Movimiento4(Mapa4 map) 
    {
        this.mapa = map;
        // ALTURA MAXIMA DEL SALTO
        altMaxima = 200;
        tSalto = (int) Math.sqrt((2.0 * altMaxima) / gravedad);
        //TEMPORIZADOR PARA EL SALTO
        reloj = new Timer(20, new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                saltoP();
            }
        });
        //AÑADIMOS LOS OBSTACULOS A UNA LISTA
        obstaculos.add(mapa.T1);
        obstaculos.add(mapa.T2);
        obstaculos.add(mapa.T3);
        obstaculos.add(mapa.T4);
        obstaculos.add(mapa.T5);
        obstaculos.add(mapa.C1);
        obstaculos.add(mapa.C2);
        obstaculos.add(mapa.C3);
        obstaculos.add(mapa.R1);
        obstaculos.add(mapa.R2);
        obstaculos.add(mapa.R3);
        obstaculos.add(mapa.R4);
        obstaculos.add(mapa.lava);
    }

    public void iniciarSalto() 
    {
        //PREGUNTAMOS SI EL TEMPORIZADOR ESTA EN EJECUCION
        if (!reloj.isRunning()) 
        {
            reloj.start();
            velInicialY = this.mapa.Geo.getY();
            bandera = true;
            salJuego = 0;
        }
    }

    public void saltoP() 
    {
        // VARIABLES PARA LA POSICION DEL PERSONAJE
        int x = this.mapa.Geo.getX();
        int y = this.mapa.Geo.getY();
        // PREGUNTAMOS SI LA BANDERA CAMBIO SU VALOR
        if (bandera) 
        {
            salJuego++;
            if (salJuego <= salDuracion) 
            {
                progreso = (double) salJuego / salDuracion;
                altMaxima = 150;
                // ASIGNAMOS ECUACION PARABOLICA
                y = velInicialY - ((int) (altMaxima * 4 * progreso * (1 - progreso)));
            } 
            else 
            {
                bandera = false;
                y = velInicialY;
                reloj.stop();
            }
        } 
        else 
        {
            // SI NO ESTA SALTANDO EL PERSONAJE CONTINUA EL MOVIMIENTO A LA DERECHA
            x += (int) velHorizontal;
            
        }
        this.mapa.Geo.setLocation(x, y);
    }

    public void reiniciarJuego()
    {
        this.mapa.Geo.setLocation(0,530);
        this.mapa.play.setVisible(true);
    }
    
    public void colisionJuego()
    {
        mapa.contador++;
        mapa.sonido.stop();
        reloj.stop();
        this.mapa.reloj.stop();
        //PREGUNTAMOS SI QUIERE VOLVER A JUGAR
        op = JOptionPane.showConfirmDialog(null, "¿Quieres volver a jugar?", "Dash of Dimensions", JOptionPane.YES_NO_OPTION);
        // SI SU RESPUESTA SI SI, REINICIA EL JUEGO
        if (op == JOptionPane.YES_OPTION)
        {
            reiniciarJuego();
        } 
        else 
        {
            // SI SU RESPUESTA ES NO, MANDAMOS UN MENSAJE Y SALIMOS DEL PROGRAMA
            JOptionPane.showMessageDialog(null, "¡Gracias por Juegar!","Dash of Dimensions",JOptionPane.INFORMATION_MESSAGE);
            mapa.sonido.stop();
            System.exit(0);
        }
    }
}
