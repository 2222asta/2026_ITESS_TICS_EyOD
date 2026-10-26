import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumAverageSubarray {
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
        long suma = 0;
        for (int i = 0; i < k; i++) suma += nums[i];
        long mayorSuma = suma;
        for (int i = k; i < n; i++) {
            suma += nums[i] - nums[i - k];
            mayorSuma = Math.max(mayorSuma, suma);
        }
        System.out.printf(java.util.Locale.US, "%.5f%n", (double) mayorSuma / k);
    }

    public static void main(String[] args) {
        MaximumAverageSubarray id = new MaximumAverageSubarray();
        id.leerDatos();
        id.resuelve();
    }
}
