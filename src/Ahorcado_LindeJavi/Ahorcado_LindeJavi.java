package Ahorcado_LindeJavi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Ahorcado_LindeJavi extends Remote {

	public String comprobarLetra(char letra) throws RemoteException;

	public String seleccionarPalabraRandom() throws RemoteException;

	public int palabralength() throws RemoteException;

}
