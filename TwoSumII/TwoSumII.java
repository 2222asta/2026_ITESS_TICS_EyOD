package Tema2_EstructurasLineales.TwoSumII;

/*
*   Victor José Ramirez Zavala
*   Problema: Two Sum II
*
*   Encontrar dos números de un arreglo ordenado cuya suma sea igual
*   a un valor objetivo utilizando dos punteros.
*
*   Entrada:
*       N
*       N números enteros ordenados
*       Valor objetivo
*
*   Salida:
*       Las posiciones de los dos números encontrados, comenzando desde 1.
*       "No se encontro una pareja." si no existe.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoSumII {
    int n;
    int[] nums;
    int objetivo;
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
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = reader.nextInt();
        }

        objetivo = reader.nextInt();
    }

    public void resuelve() {
        int izquierda = 0;
        int derecha = nums.length - 1;

        while (izquierda < derecha) {
            int suma = nums[izquierda] + nums[derecha];

            if (suma == objetivo) {
                System.out.println("Posiciones: "
                        + (izquierda + 1) + ", " + (derecha + 1));
                return;
            } else if (suma < objetivo) {
                izquierda++;
            } else {
                derecha--;
            }
        }

        System.out.println("No se encontro una pareja.");
    }

    public static void main(String[] args) {
        TwoSumII id = new TwoSumII();

        id.leerDatos();
        id.resuelve();
    }
}
