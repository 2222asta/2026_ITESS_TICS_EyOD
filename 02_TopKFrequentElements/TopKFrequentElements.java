import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TopKFrequentElements {
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
        nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = reader.nextInt();
        k = reader.nextInt();
    }

    public void resuelve() {
        java.util.Map<Integer, Integer> frecuencia = new java.util.HashMap<>();
        for (int x : nums) frecuencia.put(x, frecuencia.getOrDefault(x, 0) + 1);
        java.util.List<Integer> lista = new java.util.ArrayList<>(frecuencia.keySet());
        lista.sort((a, b) -> {
            int cmp = Integer.compare(frecuencia.get(b), frecuencia.get(a));
            return cmp != 0 ? cmp : Integer.compare(a, b);
        });
        int limite = Math.min(k, lista.size());
        for (int i = 0; i < limite; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(lista.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TopKFrequentElements id = new TopKFrequentElements();
        id.leerDatos();
        id.resuelve();
    }
}
