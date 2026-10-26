package Tema2_EstructurasLineales.Anagram;

/*
*   Victor José Ramirez Zavala
*   Problema: Anagram
*
*   Determinar si dos palabras son anagramas, es decir, si contienen
*   las mismas letras con la misma frecuencia, aunque estén en distinto orden.
*
*   Entrada:
*       Dos palabras formadas por letras minúsculas de la 'a' a la 'z'.
*
*   Salida:
*       "Si son anagramas." si las palabras son anagramas.
*       "No son anagramas." en caso contrario.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Anagram {
    String palabra1, palabra2;
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

    String leerFrase() {
    try {
        return reader.b.readLine();
    } catch (IOException e) {
        e.printStackTrace();
        return "";
        }
    }

    public void leerDatos() {
    palabra1 = leerFrase();
    palabra2 = leerFrase();
    }

    public void resuelve() {
    palabra1 = palabra1.replace(" ", "");
    palabra2 = palabra2.replace(" ", "");

    int[] letras = new int[26];
    boolean anagrama = true;

    if (palabra1.length() != palabra2.length()) {
        anagrama = false;
    } else {
        for (int i = 0; i < palabra1.length(); i++) {
            letras[palabra1.charAt(i) - 'a']++;
            letras[palabra2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < letras.length; i++) {
            if (letras[i] != 0) {
                anagrama = false;
                break;
            }
        }
    }

    if (anagrama) {
        System.out.println("Si son anagramas.");
    } else {
        System.out.println("No son anagramas.");
    }
}

    public static void main(String[] args) {
        Anagram id = new Anagram();

        id.leerDatos();
        id.resuelve();
    }
}
