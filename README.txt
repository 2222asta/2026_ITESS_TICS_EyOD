# Unidad 2 - Estructuras lineales (Plantilla ICPC)

Cada carpeta contiene:
- Un archivo Java con la estructura `leerDatos()`, `resuelve()` y `main()`.
- `caso1.txt`: entrada de prueba.
- `salida_esperada.txt`: resultado esperado.

## Cómo ejecutar
Abre la carpeta del ejercicio en VS Code, compila y ejecuta la clase correspondiente:

```bash
javac GroupAnagrams.java
java GroupAnagrams < caso1.txt
```

En Windows PowerShell también puedes pegar el contenido de `caso1.txt` en la terminal si la redirección no te funciona.

## Fuerza bruta
La carpeta `09_FuerzaBruta_MaximumAverageSubarray` contiene una segunda solución al problema 7:
- `MaximumAverageSubarray.java` (en la carpeta 07): optimizada con ventana deslizante, O(n).
- `MaximumAverageSubarrayFuerzaBruta.java` (en la carpeta 09): prueba cada ventana y vuelve a sumar sus elementos, O(n*k).

Ambas usan la misma entrada y producen la misma salida para el caso de prueba.
