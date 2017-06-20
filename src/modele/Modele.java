package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controleur.Technicien;


public class Modele 
{
	public static ArrayList<Technicien> selectAll() /* Cette méthode va extraire tous les produits de la table produit */ 		
	{
		ArrayList<Technicien> lesTechniciens = new ArrayList<Technicien>(); 
		String requete = "SELECT * FROM TECHNICIENS; "; 
		try 
		{
			Bdd uneBdd = new Bdd("localhost", "garage", "root", ""); 
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete); 
			while (unRes.next())
			{
				String login_technicien = unRes.getString("Login"); 
				String mdp_technicien = unRes.getString("Mdp"); 
				String nom_technicien = unRes.getString("Nom"); 
				String prenom_technicien = unRes.getString("Prenom"); 
				String dateembauche_technicien = unRes.getString("Dateembauche"); 
				
				
				// instanciation de la classe Produit 
				Technicien unTechnicien = new Technicien(nom_technicien,prenom_technicien, dateembauche_technicien, login_technicien, mdp_technicien); 
				
				// Insertion du produit 
				lesTechniciens.add(unTechnicien); 
				
			}
			
			unStat.close();
			unRes.close();
			uneBdd.seDeConnecter();
			
			
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'éxécution de la requête : " + requete);
		}
		
		
		
		return lesTechniciens;
	}
	
	public static Technicien selectWhere (String login_technicien, String mdp_technicien){
		String requete = "SELECT * FROM TECHNICIENS WHERE LOGIN_TECHNICIEN = '"+login_technicien+"' AND MDP_TECHNICIEN = '"+mdp_technicien+"'; ";
		Technicien unTechnicien = null; 
		
		try 
		{
			Bdd uneBdd = new Bdd("localhost", "garage", "root", ""); 
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unRes = unStat.executeQuery(requete); 
			
			if(unRes.next())
			{
				String nom_technicien = unRes.getString("NOM_TECHNICIEN"); 
				String prenom_technicien = unRes.getString("PRENOM_TECHNICIEN"); 
				String dateembauche_technicien = unRes.getString("DATEEMBAUCHE_TECHNICIEN"); 
			
				unTechnicien = new Technicien(nom_technicien, prenom_technicien, dateembauche_technicien, login_technicien, mdp_technicien);
			}
			
			uneBdd.seDeConnecter();
			unStat.close();
			unRes.close(); 
			
			
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur d'éxecution de la requete : " + requete);
		}
		return unTechnicien; 
	}
	
}
