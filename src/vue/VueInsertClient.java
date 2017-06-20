package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.Client;
import modele.ModeleClient;


@SuppressWarnings("serial")
public class VueInsertClient extends JPanel implements ActionListener {
	private JLabel lbTitre = new JLabel("Ajout d'un Client : "); 
	@SuppressWarnings("rawtypes")
	private JComboBox txtCivilite = new JComboBox();
	private JTextField txtNom = new JTextField();
	private JTextField txtPrenom = new JTextField();
	private JTextField txtDateNaiss = new JTextField(); 
	private JTextField	txtAdr = new JTextField();
	private JTextField	txtCp = new JTextField();
	private JTextField	txtVille = new JTextField(); 
	private JTextField	txtMail = new JTextField(); 
	private JTextField	txtMdp = new JTextField();
	private JTextField	txtTel = new JTextField(); 
	
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btAjouter = new JButton("Ajouter");
	
	@SuppressWarnings("unchecked")
	public VueInsertClient ()
	{
		this.setBounds(0, 0, 1170, 600);	
		this.setLayout(new GridLayout(12, 2));
		this.setBackground(new Color(0, 102, 186));
	 
		this.add(this.lbTitre); 
		this.add(new JLabel(""));
		txtCivilite.addItem("Monsieur");
		txtCivilite.addItem("Madame");
		// Construction de la JTable 
		this.add(new JLabel("Civilite :"));
		this.add(txtCivilite);
		this.add(new JLabel("Nom : "));
		this.add(txtNom); 
		this.add(new JLabel("Prénom : "));
		this.add(txtPrenom); 
		this.add(new JLabel("Date de naissance :"));
		this.add(txtDateNaiss);
		this.add(new JLabel("Adresse :"));
		this.add(txtAdr);
		this.add(new JLabel("Code postal :"));
		this.add(txtCp);
		this.add(new JLabel("Ville :"));
		this.add(txtVille);
		this.add(new JLabel("Email :"));
		this.add(txtMail);
		this.add(new JLabel("Mot de passe :"));
		this.add(txtMdp);
		this.add(new JLabel("Téléphone :"));
		this.add(txtTel);
		
		this.add(btAnnuler);
		this.add(btAjouter);
		
		this.setVisible(false);
		
		//RENDRE LES BOUTONS CLIQUABLES // 
		
		this.btAnnuler.addActionListener(this);
		this.btAjouter.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== this.btAjouter)
		{
			String nom = txtNom.getText().toString();
			String adresse= txtAdr.getText().toString();
			int cp = Integer.parseInt(txtCp.getText().toString());
			String ville = txtVille.getText().toString();
			String mail = txtMail.getText().toString(); 
			String mdp = txtMdp.getText().toString();
			String tel = txtTel.getText().toString(); 
			
			Client unClient = new Client(nom, mdp, adresse, cp, ville, mail, tel);
			ModeleClient.insert(unClient); 
			
			JOptionPane.showMessageDialog(this, "Insertion effectuée");
			VueClient.ajouterTable(unClient);
	
		}
		else if (e.getSource()== this.btAnnuler){
			this.txtNom.setText("");
			this.txtAdr.setText("");
			this.txtCp.setText("");
			this.txtVille.setText("");
			this.txtPrenom.setText("");
			this.txtMail.setText("");
			this.txtMdp.setText("");
			this.txtTel.setText("");
			this.txtDateNaiss.setText("");
		}
		
	}
}
