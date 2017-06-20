package controleur;

import vue.Connexion;
import vue.Generale;

@SuppressWarnings("unused")
public class Main {
	
	private static Connexion uneConnexion ;
	public Main()
	{
		uneConnexion = new Connexion(); 
		//new Generale(new Technicien()); // Pas besoin de taper les logs pour se connecter
	}
	public static void rendreVisible(boolean valeur){
		uneConnexion.setVisible(valeur); 
	}
	public static void main(String[] args) {
		new Main();  
	}
}
