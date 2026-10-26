import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GroupAnagrams {
    static class FastReader {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s;

        String next() {
            while (s == null || !s.hasMoreTokens()) {
                try {
                    String linea = b.readLine();
                    if (linea == null) return null;
                    s = new StringTokenizer(linea);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return s.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        char nextChar() { return next().charAt(0); }
    }

    FastReader reader = new FastReader();
    int n;
    String[] palabras;

    public void leerDatos() {
        n = reader.nextInt();
        palabras = new String[n];
        for (int i = 0; i < n; i++) palabras[i] = reader.next();
    }

    public void resuelve() {
        java.util.Map<String, java.util.List<String>> grupos = new java.util.LinkedHashMap<>();
        for (String palabra : palabras) {
            char[] letras = palabra.toCharArray();
            java.util.Arrays.sort(letras);
            String clave = new String(letras);
            grupos.computeIfAbsent(clave, k -> new java.util.ArrayList<>()).add(palabra);
        }
        for (java.util.List<String> grupo : grupos.values()) {
            System.out.println(String.join(" ", grupo));
        }
    }

    public static void main(String[] args) {
        GroupAnagrams id = new GroupAnagrams();
        id.leerDatos();
        id.resuelve();
    }
}
