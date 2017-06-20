package controleur;


public class Particulier extends Client 
{
	private String CIVILITE_Particulier; 
	private String PRENOM_Particulier; 
	private String DATENAISS_Particulier; 
	
	public Particulier(int ID_Client, String NOM_Client, String ADR_Client, int CP_Client, 
			String VILLE_Client, String MAIL_Client,
			String TEL_Client, String MDP_Client, 
			int ETAT_Client, String CIVILITE_Particulier,
			String PRENOM_Particulier, String DATENAISS_Particulier) {
		super(ID_Client, NOM_Client, MDP_Client, ADR_Client, CP_Client, VILLE_Client, MAIL_Client, TEL_Client, ETAT_Client);
		
		this.CIVILITE_Particulier = CIVILITE_Particulier;
		this.PRENOM_Particulier = PRENOM_Particulier; 
		this.DATENAISS_Particulier = DATENAISS_Particulier; 
		
	}
	
	public Particulier(String NOM_Client, String ADR_Client, int CP_Client, 
			String VILLE_Client, String MAIL_Client,
			String TEL_Client, String MDP_Client, 
			String CIVILITE_Particulier,
			String PRENOM_Particulier, String DATENAISS_Particulier) {
		super(NOM_Client, MDP_Client, ADR_Client, CP_Client, VILLE_Client, MAIL_Client, TEL_Client);
		
		this.CIVILITE_Particulier = CIVILITE_Particulier;
		this.PRENOM_Particulier = PRENOM_Particulier; 
		this.DATENAISS_Particulier = DATENAISS_Particulier; 
		
	}

	public String getCIVILITE_Particulier() {
		return CIVILITE_Particulier;
	}

	public void setCIVILITE_Particulier(String cIVILITE_Particulier) {
		CIVILITE_Particulier = cIVILITE_Particulier;
	}

	public String getPRENOM_Particulier() {
		return PRENOM_Particulier;
	}

	public void setPRENOM_Particulier(String pRENOM_Particulier) {
		PRENOM_Particulier = pRENOM_Particulier;
	}

	public String getDATENAISS_Particulier() {
		return DATENAISS_Particulier;
	}

	public void setDATENAISS_Particulier(String dATENAISS_Particulier) {
		DATENAISS_Particulier = dATENAISS_Particulier;
	}
	
	
}
