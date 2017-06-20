package controleur;

public class Client 
{
	protected int ID_Client; 
	protected String NOM_CLIENT;
	protected String ADR_Client; 
	protected String MDP_Client; 
	protected int CP_Client; 
	protected String VILLE_Client; 
	protected String MAIL_Client;
	protected String TEL_Client; 
	protected int ETAT_Client; 
	
	public Client(int ID_Client, String NOM_Client, String MDP_Client,  String ADR_Client, int CP_Client, String VILLE_Client, String MAIL_Client, String TEL_Client, int ETAT_Client){
		
		this.ID_Client = ID_Client; 
		this.NOM_CLIENT = NOM_Client;
		this.MDP_Client = MDP_Client;
		this.ADR_Client = ADR_Client; 
		this.CP_Client = CP_Client; 
		this.VILLE_Client = VILLE_Client; 
		this.MAIL_Client = MAIL_Client; 
		this.TEL_Client = TEL_Client; 
		this.ETAT_Client = ETAT_Client; 
	}
	
	public Client(String NOM_Client, String MDP_Client,  String ADR_Client, int CP_Client, String VILLE_Client, String MAIL_Client, String TEL_Client){
		
		this.NOM_CLIENT = NOM_Client;
		this.MDP_Client = MDP_Client;
		this.ADR_Client = ADR_Client; 
		this.CP_Client = CP_Client; 
		this.VILLE_Client = VILLE_Client; 
		this.MAIL_Client = MAIL_Client; 
		this.TEL_Client = TEL_Client;  
	}

	public int getID_Client() {
		return ID_Client;
	}

	public String getNOM_CLIENT() {
		return NOM_CLIENT;
	}

	public void setNOM_CLIENT(String nOM_CLIENT) {
		NOM_CLIENT = nOM_CLIENT;
	}

	public String getMDP_Client() {
		return MDP_Client;
	}

	public void setMDP_Client(String mDP_Client) {
		MDP_Client = mDP_Client;
	}

	public void setID_Client(int iD_Client) {
		ID_Client = iD_Client;
	}

	public String getADR_Client() {
		return ADR_Client;
	}

	public void setADR_Client(String aDR_Client) {
		ADR_Client = aDR_Client;
	}

	public int getCP_Client() {
		return CP_Client;
	}

	public void setCP_Client(int cP_Client) {
		CP_Client = cP_Client;
	}

	public String getVILLE_Client() {
		return VILLE_Client;
	}

	public void setVILLE_Client(String vILLE_Client) {
		VILLE_Client = vILLE_Client;
	}

	public String getMAIL_Client() {
		return MAIL_Client;
	}

	public void setMAIL_Client(String mAIL_Client) {
		MAIL_Client = mAIL_Client;
	}

	public String getTEL_Client() {
		return TEL_Client;
	}

	public void setTEL_Client(String tEL_Client) {
		TEL_Client = tEL_Client;
	}

	public int getETAT_Client() {
		return ETAT_Client;
	}

	public void setETAT_Client(int eTAT_Client) {
		ETAT_Client = eTAT_Client;
	}

	public String getNOM_Client() {
		return NOM_CLIENT;
	}

	public void setNOM_Client(String nOM_CLIENT) {
		NOM_CLIENT = nOM_CLIENT;
	}
	
}
