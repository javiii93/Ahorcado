package Ahorcado_LindeJavi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Ahorcado_LindeJavi_Cliente {
	public static void main(String[] args) {
		String palabraOculta = "";
		int intentos = 0;
		char letra = 0;
		Scanner sc = new Scanner(System.in);
		Registry r;
		try {
			r = LocateRegistry.getRegistry("192.168.1.119", 1159);
			Ahorcado_LindeJavi a = (Ahorcado_LindeJavi) r.lookup("Ahorcado_LindeJavi");
			// palabra= a.seleccionarPalabraRandom();
			intentos = a.palabralength();
			// Ahorcado_LindeJavi p = (Ahorcado_LindeJavi)
			// Naming.lookup("//localhost/Ahorcado_LindeJavi");

			System.out.println("Empezamos el ahorcadoRMI");
			System.out.println("La palabra random seleccionada consta de " + intentos + " letras");
			intentos = intentos * 2;
			System.out.println("Por lo que tendras el doble de intentos, " + intentos);
			System.out.println("Para hacerlo mas facil todas las palabras estan en minusculas y sin accentos");
			System.out.println("Suerte colegon");

			while (intentos > 0) {
				System.out.println("Introduce una letra");
				letra = sc.next().charAt(0);
				palabraOculta = a.comprobarLetra(letra);
				System.out.println(palabraOculta);
				intentos--;
				if (palabraOculta.contains("_")) {
					System.out.println("Numero de intentos = " + intentos);
					sc.nextLine();
				} else {
					System.out.println("Felicidades maquinon ¡has acertado!");
					intentos = -10;
				}

			}
			if (intentos <= 0 && intentos != -10) {
				System.out.println("Has perdido, reinicia el server y vuelve a empezar");
			}

			sc.close();

		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
