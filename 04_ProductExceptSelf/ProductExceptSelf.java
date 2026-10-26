import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProductExceptSelf {
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
    int[] nums;

    public void leerDatos() {
        n = reader.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = reader.nextInt();
    }

    public void resuelve() {
        long[] resultado = new long[n];
        long producto = 1;
        for (int i = 0; i < n; i++) {
            resultado[i] = producto;
            producto *= nums[i];
        }
        producto = 1;
        for (int i = n - 1; i >= 0; i--) {
            resultado[i] *= producto;
            producto *= nums[i];
        }
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(resultado[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ProductExceptSelf id = new ProductExceptSelf();
        id.leerDatos();
        id.resuelve();
    }
}
