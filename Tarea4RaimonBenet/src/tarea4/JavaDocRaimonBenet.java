package tarea4;

import java.util.Scanner;

public class JavaDocRaimonBenet {

	public static void localizador(int dim, boolean[] esPrimo) {
		for (int i = 0; i < dim; i++)
			esPrimo[i] = true;

		esPrimo[0] = esPrimo[1] = false;

		for (int i = 2; i < Math.sqrt(dim) + 1; i++) {
			if (esPrimo[i]) {

				for (int j = 2 * i; j < dim; j += i)
					esPrimo[j] = false;
			}
		}
	}

	public static int contar(int dim, boolean[] esPrimo) {
		int cuenta = 0;
		for (int i = 0; i < dim; i++) {
			if (esPrimo[i])
				cuenta++;
		}
		return cuenta;
	}

	public static int[] generarPrimos(int max) {
		if (max >= 2) {

			int dim = max + 1;
			boolean[] esPrimo = new boolean[dim];

			localizador(dim, esPrimo);

			int cuenta = contar(dim, esPrimo);

			int[] primos = new int[cuenta];
			for (int i = 0, j = 0; i < dim; i++) {
				if (esPrimo[i])
					primos[j++] = i;
			}
			return primos;
		} else {
			return new int[0];

		}
	}

	public static void vecInicial(int[] vector) {
		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.print(i + 1 + "\t");
		}
	}

	public static void vecPrimos(int dato, int[] vector) {
		System.out.println("\nVector de primos hasta:" + dato);
		for (int i = 0; i < vector.length; i++) {
			if (i % 10 == 0)
				System.out.println();
			System.out.print(vector[i] + "\t");
		}
	}

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce el número para la criba de Erastótenes:");
		int dato = teclado.nextInt();
		int vector[] = new int[dato];
		System.out.println("\nVector inicial hasta :" + dato);
		vecInicial(vector);
		vector = generarPrimos(dato);
		vecPrimos(dato, vector);
		teclado.close();
	}
}