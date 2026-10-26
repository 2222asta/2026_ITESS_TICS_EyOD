package Tema2_EstructurasLineales.BestTimeToBuyAndSellStock;

/*
*   Victor José Ramirez Zavala
*   Problema 6: Best Time to Buy and Sell Stock
*
*   Encontrar la maxima ganancia posible al comprar una accion
*   y venderla posteriormente.
*
*   Entrada:
*       Un entero N que indica la cantidad de dias.
*       N numeros enteros que representan los precios de la accion.
*
*   Salida:
*       La maxima ganancia posible.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BestTimeToBuyAndSellStock {
    int n;
    int[] precios;
    FastReader reader = new FastReader();

    //no modificar
    static class FastReader {
        // BufferedReader to read input
        BufferedReader b;
        // StringTokenizer to tokenize input
        StringTokenizer s; 

        // Constructor to initialize BufferedReader
        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        // Method to read the next token as a string
        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace(); 
                }
            }
            return s.nextToken();
        }

        // Method to read the next token as an integer
        int nextInt() { 
                return Integer.parseInt(next()); 
        }

        // Method to read Char
        char nextChar() {
            return next().charAt(0);
        }

        // Method to read the next token as a long
        long nextLong() { 
            return Long.parseLong(next()); 
        }

        // Method to read the next token as a double
        double nextDouble() { 
            return Double.parseDouble(next()); 
        }

        // Method to read the next line as a string
        String nextLine() {
            String str = "";
            try {
                if (s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace(); 
            }
            return str;
        }
    }
    //no modificar

    public void leerDatos() {
        n = reader.nextInt();
        precios = new int[n];

        for (int i = 0; i < n; i++) {
            precios[i] = reader.nextInt();
        }
    }

    public void resuelve() {

        int precioMinimo = precios[0];

        int gananciaMaxima = 0;

        for (int i = 1; i < n; i++) {

            int gananciaActual = precios[i] - precioMinimo;

            if (gananciaActual > gananciaMaxima) {
                gananciaMaxima = gananciaActual;
            }

            if (precios[i] < precioMinimo) {
                precioMinimo = precios[i];
            }
        }

        System.out.println(gananciaMaxima);
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock id =
                new BestTimeToBuyAndSellStock();

        id.leerDatos();
        id.resuelve();
    }
}
