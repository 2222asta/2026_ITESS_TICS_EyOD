import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ThreeSum {
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
        java.util.Arrays.sort(nums);
        boolean encontro = false;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int izq = i + 1, der = n - 1;
            while (izq < der) {
                long suma = (long) nums[i] + nums[izq] + nums[der];
                if (suma == 0) {
                    System.out.println(nums[i] + " " + nums[izq] + " " + nums[der]);
                    encontro = true;
                    int a = nums[izq], b = nums[der];
                    while (izq < der && nums[izq] == a) izq++;
                    while (izq < der && nums[der] == b) der--;
                } else if (suma < 0) izq++;
                else der--;
            }
        }
        if (!encontro) System.out.println("Sin soluciones");
    }

    public static void main(String[] args) {
        ThreeSum id = new ThreeSum();
        id.leerDatos();
        id.resuelve();
    }
}
