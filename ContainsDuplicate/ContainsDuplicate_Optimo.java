package Tema2_EstructurasLineales.ContainsDuplicate;

/*
*   Victor José Ramirez Zavala
*   Problema: Contains Duplicate - Versión Óptima
*
*   Determinar si un arreglo de N números enteros contiene
*   elementos repetidos utilizando un HashSet.
*
*   Entrada:
*       N
*       N números enteros
*
*   Salida:
*       "Hay elementos repetidos." si existen duplicados.
*       "No hay elementos repetidos." en caso contrario.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;

public class ContainsDuplicate_Optimo {
    int n;
    int[] nums;
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
    }

    public void resuelve() {
        HashSet<Integer> vistos = new HashSet<>();
        boolean repetido = false;

        for (int i = 0; i < nums.length; i++) {
            if (vistos.contains(nums[i])) {
                repetido = true;
                break;
            }

            vistos.add(nums[i]);
        }

        if (repetido) {
            System.out.println("Hay elementos repetidos.");
        } else {
            System.out.println("No hay elementos repetidos.");
        }
    }

    public static void main(String[] args) {
        ContainsDuplicate_Optimo id = new ContainsDuplicate_Optimo();

        id.leerDatos();
        id.resuelve();
    }
}
