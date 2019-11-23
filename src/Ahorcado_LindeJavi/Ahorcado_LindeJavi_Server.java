package Ahorcado_LindeJavi;

import java.rmi.registry.Registry;

public class Ahorcado_LindeJavi_Server {
	public static void main(String args[]) {
		try {
			Registry r = java.rmi.registry.LocateRegistry.createRegistry(1159);
			r.rebind("Ahorcado_LindeJavi", new Ahorcado_LindeJavi_Imp());
			System.out.println("Server connected");
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}

	}
}
