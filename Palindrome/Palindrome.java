package Tema2_EstructurasLineales.Palindrome;

/*
*   Victor José Ramirez Zavala
*   Problema: Valid Palindrome
*
*   Determinar si una cadena es un palíndromo, ignorando los espacios,
*   signos de puntuación y diferencias entre mayúsculas y minúsculas.
*
*   Entrada:
*       Una línea de texto.
*
*   Salida:
*       "Es palindromo." si el texto es un palíndromo.
*       "No es palindromo." en caso contrario.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Palindrome {
    String texto;
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
        try {
            texto = reader.b.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            texto = "";
        }
    }

    public void resuelve() {
        int izquierda = 0;
        int derecha = texto.length() - 1;
        boolean palindromo = true;

        while (izquierda < derecha) {
            char a = texto.charAt(izquierda);
            char b = texto.charAt(derecha);

            if (!Character.isLetterOrDigit(a)) {
                izquierda++;
            } else if (!Character.isLetterOrDigit(b)) {
                derecha--;
            } else {
                a = Character.toLowerCase(a);
                b = Character.toLowerCase(b);

                if (a != b) {
                    palindromo = false;
                    break;
                }

                izquierda++;
                derecha--;
            }
        }

        if (palindromo) {
            System.out.println("Es palindromo.");
        } else {
            System.out.println("No es palindromo.");
        }
    }

    public static void main(String[] args) {
        Palindrome id = new Palindrome();

        id.leerDatos();
        id.resuelve();
    }
}
