package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.Client;
import modele.ModeleClient;

@SuppressWarnings("serial")
public class VueEditionClient  extends JPanel implements ActionListener
{
	
	private static JTextField txtId = new JTextField(); 
	private static JTextField txtNom = new JTextField(); 
	private static JTextField txtMail = new JTextField(); 
	private static JTextField txtAdr = new JTextField(); 
	private static JTextField txtCp = new JTextField(); 
	private static JTextField txtVille = new JTextField(); 
	private static JTextField txtEtat = new JTextField(); 
	private static JTextField txtTel = new JTextField(); 
	
	
	private JButton btModifier = new JButton("Modifier"); 
	private JButton btSupprimer = new JButton("Supprimer"); 
	private JButton btAjouter = new JButton("Ajouter");
	
	private JLabel lbId = new JLabel("ID Client : "); 
	private JLabel lbNom = new JLabel("NOM Client : "); 
	private JLabel lbMail = new JLabel("MAIL Client : "); 
	private JLabel lbAdr = new JLabel("ADR Client : "); 
	private JLabel lbCp = new JLabel("CP Client : "); 
	private JLabel lbVille = new JLabel("VILLE Client : "); 
	private JLabel lbEtat = new JLabel("ETAT Client : "); 
	private JLabel lbTel = new JLabel("TEL Client : "); 
	
	
	public VueEditionClient()
	{
		this.setBounds(0, 300, 1150, 350);
		this.setLayout(null);
		this.setBackground(new Color(0, 102, 186));
		
		lbId.setBounds(60, 40, 100, 20);
		this.add(lbId); 
		txtId.setBounds(180, 40, 100, 20);
		this.add(txtId);
		
		lbNom.setBounds(300, 40, 100, 20);
		this.add(lbNom); 
		txtNom.setBounds(420, 40, 100, 20);
		this.add(txtNom);
		
		lbMail.setBounds(540, 40, 100, 20);
		this.add(lbMail); 
		txtMail.setBounds(660, 40, 100, 20);
		this.add(txtMail);
		
		lbAdr.setBounds(780, 40, 100, 20);
		this.add(lbAdr); 
		txtAdr.setBounds(900, 40, 100, 20);
		this.add(txtAdr);
		
		lbCp.setBounds(60, 80, 100, 20);
		this.add(lbCp); 
		txtCp.setBounds(180, 80, 100, 20);
		this.add(txtCp);
		
		lbVille.setBounds(300, 80, 100, 20);
		this.add(lbVille); 
		txtVille.setBounds(420, 80, 100, 20);
		this.add(txtVille);
		lbEtat.setBounds(540, 80, 100, 20);
		this.add(lbEtat); 
		txtEtat.setBounds(660, 80, 100, 20);
		this.add(txtEtat);
		
		lbTel.setBounds(780, 80, 100, 20);
		this.add(lbTel); 
		txtTel.setBounds(900, 80, 100, 20);
		this.add(txtTel);
		
		btAjouter.setBounds(400, 150, 100, 20);
		this.add(btAjouter);
		btModifier.setBounds(550, 150, 100, 20);
		this.add(btModifier);
		btSupprimer.setBounds(700, 150, 100, 20);
		this.add(btSupprimer);
		
		this.btAjouter.addActionListener(this);
		this.btModifier.addActionListener(this);
		this.btSupprimer.addActionListener(this);
		


		this.setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()== this.btSupprimer)
		{
			String email = txtMail.getText().toString(); 
			String nom = txtNom.getText().toString(); 
			ModeleClient.delete(email, nom); 
			JOptionPane.showMessageDialog(this, "Suppression effectuée");	
			VueClient.supprimerTable(txtId.getText().toString());
		}
		else if (e.getSource()==this.btAjouter){
			String email = txtMail.getText().toString();
			String nom = txtNom.getText().toString();
			String ville = txtVille.getText().toString();
			int cp = Integer.parseInt(txtCp.getText().toString());
			String tel = txtTel.getText().toString();
			int etat = Integer.parseInt(txtEtat.getText().toString());
			String adresse= txtAdr.getText().toString();
			String mdp ="e";
			
			Client unClient = new Client(0, nom, mdp, adresse, cp, ville, email, tel, etat);
			ModeleClient.insert(unClient); 
			
			JOptionPane.showMessageDialog(this, "Insertion effectuée");
			VueClient.ajouterTable(unClient);
		}
	}
	
	public static void remplir(Client unClient){
		
		txtId.setText(unClient.getID_Client()+"");
		txtNom.setText(unClient.getNOM_Client());
		txtMail.setText(unClient.getMAIL_Client());
		txtAdr.setText(unClient.getADR_Client());
		txtCp.setText(unClient.getCP_Client()+"");
		txtVille.setText(unClient.getVILLE_Client());
		txtEtat.setText(unClient.getETAT_Client()+"");
		txtTel.setText(unClient.getTEL_Client());
		
	}
}
