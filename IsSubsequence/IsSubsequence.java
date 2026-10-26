package Tema2_EstructurasLineales.IsSubsequence;

/*
*   Victor José Ramirez Zavala
*   Problema: IsSubsequence
*
*   Determinar si una serie de caracteres es subsecuente.
*
*   Entrada:
*       s
*       t 
*
*   Salida:
*       "Si es subsecuencia." si es subsecuencia.
*       "No es subsecuencia." en caso contrario.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IsSubsequence {
    String s, t;
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
        s = reader.next();
        t = reader.next();
    }

    public void resuelve() {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        if (i == s.length()) {
            System.out.println("Si es subsecuencia.");
        } else {
            System.out.println("No es subsecuencia.");
        }
    }

    public static void main(String[] args) {
        IsSubsequence id = new IsSubsequence();

        id.leerDatos();
        id.resuelve();
    }
}
