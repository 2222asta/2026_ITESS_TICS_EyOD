import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ContainerWithMostWater{
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
    int[] alturas;

    public void leerDatos() {
        n = reader.nextInt();
        alturas = new int[n];
        for (int i = 0; i < n; i++) alturas[i] = reader.nextInt();
    }

    public void resuelve() {
        int izquierda = 0, derecha = n - 1;
        long mayorArea = 0;
        while (izquierda < derecha) {
            long altura = Math.min(alturas[izquierda], alturas[derecha]);
            long area = altura * (derecha - izquierda);
            mayorArea = Math.max(mayorArea, area);
            if (alturas[izquierda] < alturas[derecha]) izquierda++;
            else derecha--;
        }
        System.out.println(mayorArea);
    }

    public static void main(String[] args) {
        ContainerWithMostWater id = new ContainerWithMostWater();
        id.leerDatos();
        id.resuelve();
    }
}
