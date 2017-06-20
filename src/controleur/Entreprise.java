package controleur;

public class Entreprise extends Client 
{

	private int NUMSIRET_Entreprise; 
	private String ACTIVITE_Entreprise; 
	
	public Entreprise(int ID_Client, String NOM_Client,String MDP_Client, String ADR_Client, int CP_Client, String VILLE_Client, String MAIL_Client,
			String TEL_Client,  int ETAT_Client, int NUMSIRET_Entreprise, String ACTIVITE_Entreprise) {
		super(ID_Client, NOM_Client,MDP_Client, ADR_Client, CP_Client, VILLE_Client, MAIL_Client, TEL_Client, ETAT_Client);
		
		this.ACTIVITE_Entreprise = ACTIVITE_Entreprise; 
		this.NUMSIRET_Entreprise = NUMSIRET_Entreprise; 
	}
	
	public Entreprise(String NOM_Client,String MDP_Client, String ADR_Client, int CP_Client, String VILLE_Client, String MAIL_Client,
			String TEL_Client,  int NUMSIRET_Entreprise, String ACTIVITE_Entreprise) {
		super(NOM_Client,MDP_Client, ADR_Client, CP_Client, VILLE_Client, MAIL_Client, TEL_Client);
		
		this.ACTIVITE_Entreprise = ACTIVITE_Entreprise; 
		this.NUMSIRET_Entreprise = NUMSIRET_Entreprise; 
	}

	public int getNUMSIRET_Entreprise() {
		return NUMSIRET_Entreprise;
	}

	public void setNUMSIRET_Entreprise(int nUMSIRET_Entreprise) {
		NUMSIRET_Entreprise = nUMSIRET_Entreprise;
	}

	public String getACTIVITE_Entreprise() {
		return ACTIVITE_Entreprise;
	}

	public void setACTIVITE_Entreprise(String aCTIVITE_Entreprise) {
		ACTIVITE_Entreprise = aCTIVITE_Entreprise;
	}
	
	
	

}
