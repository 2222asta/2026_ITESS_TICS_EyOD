import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumAverageSubarrayFuerzaBruta {
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
    int n, k;
    int[] nums;

    public void leerDatos() {
        n = reader.nextInt();
        k = reader.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = reader.nextInt();
    }

    public void resuelve() {
        if (k < 1 || k > n) {
            System.out.println("Valor de k invalido");
            return;
        }
        long mayorSuma = Long.MIN_VALUE;
        // Fuerza bruta: vuelve a sumar los k elementos para cada ventana.
        for (int inicio = 0; inicio <= n - k; inicio++) {
            long suma = 0;
            for (int j = inicio; j < inicio + k; j++) {
                suma += nums[j];
            }
            if (suma > mayorSuma) mayorSuma = suma;
        }
        System.out.printf(java.util.Locale.US, "%.5f%n", (double) mayorSuma / k);
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayFuerzaBruta id = new MaximumAverageSubarrayFuerzaBruta();
        id.leerDatos();
        id.resuelve();
    }
}
