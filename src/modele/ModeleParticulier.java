package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Particulier;

public class ModeleParticulier {
	public static ArrayList<Particulier> selectAll() /*
												 * Cette méthode va extraire
												 * tous les produits de la table
												 * produit
												 */
	{
		ArrayList<Particulier> lesParticuliers = new ArrayList<Particulier>();
		String requete = "SELECT * FROM PARTICULIERS; ";
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
				String PRENOM_Particulier = unRes.getString("PRENOM_Particulier");
				String CIVILITE_Particulier = unRes.getString("CIVILITE_Particulier");
				String DATENAISS_Particulier = unRes.getString("DATENAISS_Particulier");

				// Instantiation de la classe Client
				Particulier unParticulier = new Particulier(ID_Client, NOM_Client, MDP_Client, CP_Client, ADR_Client, VILLE_Client,
						MAIL_Client, TEL_Client, ETAT_Client, CIVILITE_Particulier, PRENOM_Particulier, DATENAISS_Particulier);

				// Insertion du produit
				lesParticuliers.add(unParticulier);

			}

			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();

		} catch (SQLException exp) {
			System.out.println("Erreur d'éxécution de la requête : " + requete);
		}

		return lesParticuliers;
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

	public static void insertParticulier(Particulier unParticulier) {
		String requete = "INSERT INTO PARTICULIERS (NOM_CLIENT, MDP_CLIENT, ADR_CLIENT, CP_CLIENT, VILLE_CLIENT, MAIL_CLIENT, TEL_CLIENT, ETAT_CLIENT, CIVILITE_PARTICULIER, PRENOM_PARTICULIER, DATENAISS_PARTICULIER)"
				+ " VALUES ('" + unParticulier.getNOM_Client() + "',sha1(sha1('"
				+ unParticulier.getMDP_Client() + "')),'" + unParticulier.getADR_Client() + "','" + unParticulier.getCP_Client() + "','"
				+ unParticulier.getVILLE_Client() + "','" + unParticulier.getMAIL_Client() + "','" + unParticulier.getTEL_Client()
				+ "','1','" + unParticulier.getCIVILITE_Particulier() + "','" + unParticulier.getPRENOM_Particulier() + "','" + unParticulier.getDATENAISS_Particulier() + "');";

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
