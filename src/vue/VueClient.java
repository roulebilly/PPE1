package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controleur.Client;
import controleur.Tableau;
import modele.ModeleClient;

@SuppressWarnings({ "unused", "serial" })
public class VueClient extends JPanel implements ActionListener, MouseListener
{
	private JLabel lbTitre = new JLabel("Liste des clients"); 
	private static JTable tableClients;
	private static Tableau contenu ;
	
	
	public VueClient ()
	{
		this.setBounds(0, 0, 1150, 300);	
		this.setLayout(null);
		this.setBackground(new Color(0, 102, 186));
		this.lbTitre.setBounds(50, 10, 100, 10);
		this.lbTitre.setForeground(Color.white);
		
		Font bold30 = new Font("Courier", Font.BOLD, 30);
		this.lbTitre.setBounds(450, 10, 500, 50);
		this.lbTitre.setFont(bold30);
		this.add(this.lbTitre); 
		// Construction de la JTable 
		String entete[] = {"ID_Client", "NOM_Client", "ADR_Client", "CP_Client", "VILLE_Client", "MAIL_Client", "TEL_Client", "Etat_Client"}; 
		contenu = new Tableau(this.extraireClients(), entete);
		
		tableClients = new JTable (contenu); 
		JScrollPane uneScroll = new JScrollPane(tableClients); 
		uneScroll.setBounds(100, 50, 900, 230);
		this.add(uneScroll);
		tableClients.addMouseListener(this);
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	public Object [][] extraireClients()
	{
		ArrayList<Client> lesClients = ModeleClient.selectAll(); 
		Object[][]donnees = new Object[lesClients.size()][8]; 
		int i=0; 
		for(Client unClient : lesClients)
		{
			donnees[i][0] = unClient.getID_Client();
			donnees[i][1] = unClient.getNOM_Client();
			donnees[i][2] = unClient.getADR_Client();
			donnees[i][3] = unClient.getCP_Client();
			donnees[i][4] = unClient.getVILLE_Client();
			donnees[i][5] = unClient.getMAIL_Client();
			donnees[i][6] = unClient.getTEL_Client();
			donnees[i][7] = unClient.getETAT_Client();
			i++;
		}
		return donnees; 
	}
	@Override
	public void mouseClicked(MouseEvent e)
	{
		int lg = tableClients.getSelectedRow(); 
		int ht = tableClients.getSelectedColumn(); 
		int id = Integer.parseInt(tableClients.getValueAt(lg, 0).toString());
		String nom = tableClients.getValueAt(lg, 1).toString();
		String adr = tableClients.getValueAt(lg, 2).toString(); 
		int cp = Integer.parseInt(tableClients.getValueAt(lg, 3).toString()); 
		String ville = tableClients.getValueAt(lg, 4).toString(); 
		String mail = tableClients.getValueAt(lg, 5).toString(); 
		String tel = tableClients.getValueAt(lg, 6).toString(); 
		int etat = Integer.parseInt(tableClients.getValueAt(lg, 7).toString());
		
		Client unClient = new Client(id, nom,"",  adr, cp, ville, mail, tel, etat); 
		VueEditionClient.remplir(unClient);
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	 public static void supprimerTable (String id)
	 {
		 for(int i =0; i<contenu.getRowCount(); i++)
		 {
			 System.out.println(contenu.getValueAt(i, 0));
			 if (id.equals(contenu.getValueAt(i, 0).toString())){
				 contenu.removeRow(i);
				 break;
			 }
		 }
		
	 }
	 public static void ajouterTable (Client unClient)
	 {
		 Object [] data = {unClient.getID_Client(), unClient.getNOM_Client(),unClient.getADR_Client(),unClient.getCP_Client(),unClient.getVILLE_Client(),
				 unClient.getMAIL_Client(), unClient.getTEL_Client(), unClient.getETAT_Client()};
		 
		 contenu.addRow(data);
	 }
}
