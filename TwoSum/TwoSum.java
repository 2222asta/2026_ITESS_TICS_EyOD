package Tema2_EstructurasLineales.TwoSum;

/*
*   Victor José Ramirez Zavala
*   Problema: Two Sum
*
*   Encontrar dos elementos de un arreglo cuya suma sea igual
*   a un valor objetivo e imprimir sus índices.
*
*   Entrada:
*       N
*       N números enteros
*       Valor objetivo
*
*   Salida:
*       Los índices de la pareja encontrada.
*       "No se encontro una pareja." si no existe.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoSum {
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
        boolean encontrado = false;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == objetivo) {
                    System.out.println("Indices: " + i + ", " + j);
                    encontrado = true;
                    break;
                }
            }

            if (encontrado) {
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontro una pareja.");
        }
    }

    public static void main(String[] args) {
        TwoSum id = new TwoSum();

        id.leerDatos();
        id.resuelve();
    }
}
