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

import controleur.Particulier;
import controleur.Tableau;
import modele.ModeleParticulier;

@SuppressWarnings({ "unused", "serial" })
public class VueParticulier extends JPanel implements ActionListener, MouseListener
{
	private JLabel lbTitre = new JLabel("Liste des Particuliers"); 
	private static JTable tableParticuliers;
	private static Tableau contenu ;
	
	
	public VueParticulier ()
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
		contenu = new Tableau(this.extraireParticuliers(), entete);
		
		tableParticuliers = new JTable (contenu); 
		JScrollPane uneScroll = new JScrollPane(tableParticuliers); 
		uneScroll.setBounds(100, 50, 900, 230);
		this.add(uneScroll);
		tableParticuliers.addMouseListener(this);
		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	public Object [][] extraireParticuliers()
	{
		ArrayList<Particulier> lesParticuliers = ModeleParticulier.selectAll(); 
		Object[][]donnees = new Object[lesParticuliers.size()][8]; 
		int i=0; 
		for(Particulier unParticulier : lesParticuliers)
		{
			donnees[i][0] = unParticulier.getID_Client();
			donnees[i][1] = unParticulier.getNOM_Client();
			donnees[i][2] = unParticulier.getADR_Client();
			donnees[i][3] = unParticulier.getCP_Client();
			donnees[i][4] = unParticulier.getVILLE_Client();
			donnees[i][5] = unParticulier.getMAIL_Client();
			donnees[i][6] = unParticulier.getTEL_Client();
			donnees[i][7] = unParticulier.getETAT_Client();
			donnees[i][7] = unParticulier.getCIVILITE_Particulier();
			donnees[i][7] = unParticulier.getPRENOM_Particulier();
			donnees[i][7] = unParticulier.getDATENAISS_Particulier();
			i++;
		}
		return donnees; 
	}
	@Override
	public void mouseClicked(MouseEvent e)
	{
		int lg = tableParticuliers.getSelectedRow(); 
		int ht = tableParticuliers.getSelectedColumn(); 
		int id = Integer.parseInt(tableParticuliers.getValueAt(lg, 0).toString());
		String nom = tableParticuliers.getValueAt(lg, 1).toString();
		String adr = tableParticuliers.getValueAt(lg, 2).toString(); 
		int cp = Integer.parseInt(tableParticuliers.getValueAt(lg, 3).toString()); 
		String ville = tableParticuliers.getValueAt(lg, 4).toString(); 
		String mail = tableParticuliers.getValueAt(lg, 5).toString(); 
		String tel = tableParticuliers.getValueAt(lg, 6).toString(); 
		int etat = Integer.parseInt(tableParticuliers.getValueAt(lg, 7).toString());
		String civilite = tableParticuliers.getValueAt(lg, 8).toString(); 
		String prenom = tableParticuliers.getValueAt(lg, 9).toString(); 
		String datenaiss = tableParticuliers.getValueAt(lg, 10).toString();
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
	 public static void ajouterTable (Particulier unParticulier)
	 {
		 Object [] data = {unParticulier.getID_Client(), unParticulier.getNOM_Client(),unParticulier.getADR_Client(),unParticulier.getCP_Client(),unParticulier.getVILLE_Client(),
				 unParticulier.getMAIL_Client(), unParticulier.getTEL_Client(), unParticulier.getETAT_Client()};
		 
		 contenu.addRow(data);
	 }
}
