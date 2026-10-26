import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestConsecutiveSequence {
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
        java.util.Set<Integer> conjunto = new java.util.HashSet<>();
        for (int x : nums) conjunto.add(x);
        int mayor = 0;
        for (int x : conjunto) {
            if (x != Integer.MIN_VALUE && conjunto.contains(x - 1)) continue;
            int actual = x, longitud = 1;
            while (actual != Integer.MAX_VALUE && conjunto.contains(actual + 1)) {
                actual++;
                longitud++;
            }
            mayor = Math.max(mayor, longitud);
        }
        System.out.println(mayor);
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence id = new LongestConsecutiveSequence();
        id.leerDatos();
        id.resuelve();
    }
}
