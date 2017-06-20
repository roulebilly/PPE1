package controleur;


public class Technicien {
	private String login_technicien, mdp_technicien, nom_technicien, prenom_technicien, dateembauche_technicien;
	
	
	
	public Technicien (String nom_technicien, String prenom_technicien, String dateembauche_technicien, String login_technicien, String mdp_technicien){
		this.login_technicien = login_technicien; 
		this.mdp_technicien = mdp_technicien; 
		this.nom_technicien = nom_technicien; 
		this.prenom_technicien = prenom_technicien; 
		this.dateembauche_technicien = dateembauche_technicien; 
		
	}
	
	public String dateJJMMAAAA(String date) {
		String[] split = date.split("-");
		StringBuilder sb = new StringBuilder();
		
		for (int i = 2; i >= 0; i--) {
		    sb.append(split[i]);
		    if (i != 0) {
		        sb.append(" / ");
		    }
		}
		String newDate = sb.toString();
		
		return newDate;
	}
	
	public Technicien ()
	{
		
	}

	public String getLogin_technicien() {
		return login_technicien;
	}


	public void setLogin_technicien(String login_technicien) {
		this.login_technicien = login_technicien;
	}


	public String getMdp_technicien() {
		return mdp_technicien;
	}


	public void setMdp_technicien(String mdp_technicien) {
		this.mdp_technicien = mdp_technicien;
	}


	public String getNom_technicien() {
		return nom_technicien;
	}


	public void setNom_technicien(String nom_technicien) {
		this.nom_technicien = nom_technicien;
	}


	public String getPrenom_technicien() {
		return prenom_technicien;
	}


	public void setPrenom_technicien(String prenom_technicien) {
		this.prenom_technicien = prenom_technicien;
	}


	public String getDateembauche_technicien() {
		return dateJJMMAAAA(dateembauche_technicien);
	}


	public void setDateembauche_technicien(String dateembauche_technicien) {
		this.dateembauche_technicien = dateembauche_technicien;
	}


	
}


