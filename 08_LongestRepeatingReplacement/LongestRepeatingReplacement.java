import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestRepeatingReplacement {
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
    String s;
    int k;

    public void leerDatos() {
        s = reader.next().toUpperCase(java.util.Locale.ROOT);
        k = reader.nextInt();
    }

    public void resuelve() {
        int[] frecuencia = new int[26];
        int izquierda = 0, frecuenciaMaxima = 0, mayorLongitud = 0;
        for (int derecha = 0; derecha < s.length(); derecha++) {
            int indice = s.charAt(derecha) - 'A';
            frecuencia[indice]++;
            frecuenciaMaxima = Math.max(frecuenciaMaxima, frecuencia[indice]);
            while ((derecha - izquierda + 1) - frecuenciaMaxima > k) {
                frecuencia[s.charAt(izquierda) - 'A']--;
                izquierda++;
            }
            mayorLongitud = Math.max(mayorLongitud, derecha - izquierda + 1);
        }
        System.out.println(mayorLongitud);
    }

    public static void main(String[] args) {
        LongestRepeatingReplacement id = new LongestRepeatingReplacement();
        id.leerDatos();
        id.resuelve();
    }
}
