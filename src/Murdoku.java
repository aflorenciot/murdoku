import java.util.Scanner;

public class Murdoku {

    static final int TAM = 7;

    // Identificadores de las zonas
    static final int PICNIC = 1;
    static final int JARDIN = 2;
    static final int ESTANQUE = 3;
    static final int CENADOR = 4;

    // Identificadores de los elementos
    static final int VACIO = 0;
    static final int SILLA = 1;
    static final int ALFOMBRA = 2;
    static final int ARBOL = 3;
    static final int FLORES = 4;
    static final int PIEDRA = 5;
    static final int MESA = 6;

    static Scanner teclado = new Scanner(System.in);

    // Tablero donde se colocan los personajes
    static char[][] tablero = new char[TAM][TAM];

    // Elementos fijos del escenario
    static int[][] elementos = {
        {0, 1, 1, 0, 4, 0, 4},
        {3, 2, 2, 0, 0, 0, 4},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 5, 0, 0, 3},
        {1, 0, 0, 0, 0, 0, 1},
        {0, 0, 0, 0, 0, 0, 1},
        {2, 2, 1, 0, 1, 6, 0}
    };

    // Zona a la que pertenece cada casilla
    static int[][] zonas = {
        {1, 1, 1, 1, 2, 2, 2},
        {1, 1, 1, 1, 2, 2, 2},
        {1, 1, 3, 3, 2, 2, 2},
        {1, 1, 3, 3, 3, 2, 2},
        {1, 1, 3, 3, 4, 4, 4},
        {1, 1, 1, 3, 4, 4, 4},
        {1, 1, 1, 1, 4, 4, 4}
    };

    // Datos de los personajes
    static String[] nombres = {
        "Avery", "Bruno", "Christian",
        "Daphne", "Ethan", "Fabian", "Vicky"
    };

    static char[] letras = {
        'A', 'B', 'C', 'D', 'E', 'F', 'V'
    };

    // Indica qué personajes ya están colocados
    static boolean[] colocados = new boolean[7];


    public static void main(String[] args) {

    }

    // Devuelve el símbolo correspondiente a un elemento
    public static char simboloElemento(int elemento) {

        switch (elemento) {

            case SILLA:
                return 'S';

            case ALFOMBRA:
                return '=';

            case ARBOL:
                return 'T';

            case FLORES:
                return '*';

            case PIEDRA:
                return 'P';

            case MESA:
                return 'M';

            default:
                return '.';

        }

    }

    // Comprueba si una casilla puede ser ocupada
    public static boolean esTransitable(int fila, int columna) {

        int elemento = elementos[fila][columna];

        return elemento == VACIO
            || elemento == SILLA
            || elemento == ALFOMBRA;

    }

    // Muestra el tablero. Las X se calculan al mostrarlo y no se guardan.
public static void mostrarTablero() {

    System.out.println("\nTABLERO");
    System.out.print("    ");

    for (int columna = 0; columna < TAM; columna++) {
        System.out.print((columna + 1) + "   ");
    }

    System.out.println();

    for (int fila = 0; fila < TAM; fila++) {
        System.out.print((fila + 1) + " | ");

        for (int columna = 0; columna < TAM; columna++) {
            System.out.print(simboloCasilla(fila, columna) + "   ");
        }

        System.out.println();
    }

    System.out.println("\nLeyenda: S = silla | = = alfombra | T = arbol | * = flores");
    System.out.println("         P = piedra | M = mesa | . = libre | X = descartada");
}

// Decide que simbolo debe verse en una casilla
public static char simboloCasilla(int fila, int columna) {

    // Si hay un personaje, se muestra antes que el elemento
    if (tablero[fila][columna] != '.') {
        return tablero[fila][columna];
    }

    // Los elementos fijos siempre se muestran
    if (elementos[fila][columna] != VACIO) {
        return simboloElemento(elementos[fila][columna]);
    }

    // Las X solo se calculan para casillas vacias sin elemento
    if (filaOcupada(fila) || columnaOcupada(columna)) {
        return 'X';
    }

    return '.';
}

// Muestra los personajes que todavia no se han colocado
public static void mostrarPersonajesDisponibles() {

    System.out.println("\nPersonajes pendientes:");
    boolean quedanPersonajes = false;

    for (int i = 0; i < nombres.length; i++) {
        if (!colocados[i]) {
            System.out.println(letras[i] + " - " + nombres[i]);
            quedanPersonajes = true;
        }
    }

    if (!quedanPersonajes) {
        System.out.println("Todos los personajes estan colocados.");
    }
}

}