package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Entreprise;

public class ModeleEntreprise {
	public static ArrayList<Entreprise> selectAll() /*
												 * Cette méthode va extraire
												 * tous les produits de la table
												 * produit
												 */
	{
		ArrayList<Entreprise> lesEntreprises = new ArrayList<Entreprise>();
		String requete = "SELECT * FROM ENTREPRISES; ";
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
				String ACTIVITE_Entreprise = unRes.getString("ACTIVITE_Entreprise");
				int NUMSIRET_Entreprise = unRes.getInt("NUMSIRET_Entreprise");

				// Instantiation de la classe Client
				Entreprise uneEntreprise = new Entreprise(ID_Client, NOM_Client, MDP_Client, ADR_Client, CP_Client, VILLE_Client,
						MAIL_Client, TEL_Client, ETAT_Client, NUMSIRET_Entreprise, ACTIVITE_Entreprise);

				// Insertion du produit
				lesEntreprises.add(uneEntreprise);

			}

			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();

		} catch (SQLException exp) {
			System.out.println("Erreur d'éxécution de la requête : " + requete);
		}

		return lesEntreprises;
	}

	public static void delete(String email, String nom) {
		String requete = "DELETE FROM ENTREPRISES WHERE MAIL_CLIENT = '" + email + "' and NOM_CLIENT ='" + nom + "';";
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

	public static void insertEntreprise(Entreprise uneEntreprise) {
		String requete = "INSERT INTO ENTREPRISES (NOM_CLIENT, MDP_CLIENT, ADR_CLIENT, CP_CLIENT, VILLE_CLIENT, MAIL_CLIENT, TEL_CLIENT, ETAT_CLIENT, NUMSIRET_ENTREPRISE, ACTIVITE_ENTREPRISE)"
				+ " VALUES ('" + uneEntreprise.getNOM_Client() + "',sha1(sha1('"
				+ uneEntreprise.getMDP_Client() + "')),'" + uneEntreprise.getADR_Client() + "','" + uneEntreprise.getCP_Client() + "','"
				+ uneEntreprise.getVILLE_Client() + "','" + uneEntreprise.getMAIL_Client() + "','" + uneEntreprise.getTEL_Client()
				+ "','1','" + uneEntreprise.getNUMSIRET_Entreprise() + "','" + uneEntreprise.getACTIVITE_Entreprise() + "');";

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
