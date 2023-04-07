import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;


/**
 * @Eduardo Villegas Rojas
 */
public class Main {

    public static void main(String[] args) {
        int AnchoVentana = 600;
          int AltoVentana = 600;
         int NumeroLineas = 6;
          int Maxvelocidad = 100;
         int MinimoVelocidad = 10;

        /**
         * Rango de dibujo
         */
        StdDraw.setXscale(0, AnchoVentana);
        StdDraw.setYscale(0, AltoVentana);
        StdDraw.enableDoubleBuffering();

/**
 * Colores de las lineas
 */
        Color[] COLORS = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.PINK };
        int[] x = new int[NumeroLineas];
        int[] y = new int[NumeroLineas];
        int[] vx = new int[NumeroLineas];
        int[] vy = new int[NumeroLineas];

        /**
         * Generar posicion inicial al azar
          */

        int x0 = (int) Math.random();
        int y0 = (int) Math.random();

        /**
         * Generar velocidad al azar
         */
        vx[0] = (int) (Math.random() * 0.01);
        vy[0] = (int) (Math.random() * 0.01);

/**
 * Obtener las lineas a dibujar
 */
        for (int i = 1; i < NumeroLineas; i++) {
            y[i] = y[i-1] + vy[i-1];
            StdDraw.setPenColor(COLORS[i]);
            StdDraw.line(x[i-1], y[i-1], x[i], y[i]);


            /**
              Rebotar si toca el borde de la pantalla
             */
            if (x[0] < 0 || x[0] > 1) {
                vx[0] = -vx[0];
                x[0] += vx[0];
                y[0] += vy[0];
            }
            if (y[0] < 0 || y[0] > 1) {
                vy[0] = -vy[0];
                x[0] += vx[0];
                y[0] += vy[0];
            }
            /**
             * Actualizar velocidades de las lineas
             */
            for (i = 1; i < NumeroLineas; i++) {
                vx[i] = vx[i-1];
                vy[i] = vy[i-1];
            }


/**
 * Generar posicion y velocidad inicial al azar despues de un tiempo
 */

            if (StdDraw.mousePressed()) {
                x[0] = (int) Math.random();
                y[0] = (int) Math.random();
                vx[0] = (int) (Math.random() * 1);
                vy[0] = (int) (Math.random() * 1);
                StdDraw.show();
                StdDraw.pause(500);
            }

            /**
             * Actualizar el dibujo y comenzar
             */
            StdDraw.show();
            StdDraw.pause(20);
            StdDraw.clear();

    }

                }
    }



