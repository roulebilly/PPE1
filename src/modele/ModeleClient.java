package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Client;

public class ModeleClient {
	public static ArrayList<Client> selectAll() /*
												 * Cette méthode va extraire
												 * tous les produits de la table
												 * produit
												 */
	{
		ArrayList<Client> lesClients = new ArrayList<Client>();
		String requete = "SELECT * FROM CLIENTS; ";
		try {
			Bdd uneBdd = new Bdd("localhost", "garage", "root", "");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete);
			while (unRes.next()) {
				int ID_Client = unRes.getInt("ID_Client");
				String NOM_Client = unRes.getString("NOM_Client");
				String ADR_Client = unRes.getString("ADR_Client");
				int CP_Client = unRes.getInt("CP_Client");
				String VILLE_Client = unRes.getString("VILLE_Client");
				String MAIL_Client = unRes.getString("MAIL_Client");
				String TEL_Client = unRes.getString("TEL_Client");
				String MDP_Client = unRes.getString("MDP_Client");
				int ETAT_Client = unRes.getInt("ETAT_Client");

				// Instantiation de la classe Client
				Client unClient = new Client(ID_Client, NOM_Client, MDP_Client, ADR_Client, CP_Client, VILLE_Client,
						MAIL_Client, TEL_Client, ETAT_Client);

				// Insertion du produit
				lesClients.add(unClient);

			}

			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();

		} catch (SQLException exp) {
			System.out.println("Erreur d'éxécution de la requête : " + requete);
		}

		return lesClients;
	}

	public static void delete(String email, String nom) {
		String requete = "DELETE FROM CLIENTS WHERE MAIL_CLIENT = '" + email + "' and NOM_CLIENT ='" + nom + "';";
		try {
			Bdd uneBdd = new Bdd("localhost", "garage", "root", "");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();
		} catch (SQLException e) {
			System.out.println("Erreur d'éxecution de la requête" + requete);
		}

	}

	public static void insert(Client unClient) {
		String requete = "INSERT INTO CLIENTS (ID_CLIENT, NOM_CLIENT, MDP_CLIENT, ADR_CLIENT, CP_CLIENT, VILLE_CLIENT, MAIL_CLIENT, TEL_CLIENT, ETAT_CLIENT)"
				+ " VALUES (" + unClient.getID_Client() + ",'" + unClient.getNOM_Client() + "','"
				+ unClient.getMDP_Client() + "','" + unClient.getADR_Client() + "','" + unClient.getCP_Client() + "','"
				+ unClient.getVILLE_Client() + "','" + unClient.getMAIL_Client() + "','" + unClient.getTEL_Client()
				+ "','" + unClient.getETAT_Client() + "');";

		try {
			Bdd uneBdd = new Bdd("localhost", "garage", "root", "");
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeConnecter();

		} catch (SQLException exp) {
			System.out.println("Erreur d'execution de la requete : " + requete);
			exp.printStackTrace();
		}
	}
}
