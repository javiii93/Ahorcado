package Ahorcado_LindeJavi;

import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Ahorcado_LindeJavi_Imp extends UnicastRemoteObject implements Ahorcado_LindeJavi {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String palabra, palabraOculta = "";

	protected Ahorcado_LindeJavi_Imp() throws RemoteException {
		super();
		palabra = seleccionarPalabraRandom();
		for (int i = 0; i < palabra.length(); i++) {
			palabraOculta = palabraOculta + "_";
		}
	}

	@Override
	public String comprobarLetra(char letra) throws RemoteException {
		for (int i = 0; i < palabra.length(); i++) {
			if (palabra.charAt(i) == letra) {
				palabraOculta = palabraOculta.substring(0, i) + letra + palabraOculta.substring(i + 1, palabralength());

			}
		}

		return palabraOculta;
	}

	@Override
	public String seleccionarPalabraRandom() {
		String palabra = "";
		int random = (int) (Math.random() * 100) + 1;
		// TODO Auto-generated method stub
		File f = new File("palabras.txt");
		try {
			Scanner sc = new Scanner(f);
			for (int i = 0; i <= random; i++) {

				if (i == random) {
					palabra = sc.next().toLowerCase();
				} else {
					sc.nextLine();
				}

			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(palabra);
		return palabra;
	}

	@Override
	public int palabralength() throws RemoteException {
		// TODO Auto-generated method stub
		return palabra.length();
	}

}
