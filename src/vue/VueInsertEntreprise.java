package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.Entreprise;
import modele.ModeleEntreprise;

@SuppressWarnings("serial")
public class VueInsertEntreprise extends JPanel implements ActionListener {
	private JLabel lbTitre = new JLabel("Ajout d'une Entreprise : "); 
	private JTextField txtNumSiret = new JTextField();  
	private JTextField txtActivite = new JTextField();  
	private JTextField txtNom = new JTextField(); 
	private JTextField	txtAdr = new JTextField();
	private JTextField	txtCp = new JTextField();
	private JTextField	txtVille = new JTextField(); 
	private JTextField	txtMail = new JTextField(); 
	private JTextField	txtMdp = new JTextField();
	private JTextField	txtTel = new JTextField();
	
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btAjouter = new JButton("Ajouter");  
	
	public VueInsertEntreprise ()
	{
		this.setBounds(0, 0, 1170, 600);
		this.setLayout(new GridLayout(11, 2));
		this.setBackground(new Color(0, 102, 186));
		
		this.add(this.lbTitre); 
		this.add(new JLabel(""));
		// Construction de la JTable 
		this.add(new JLabel("Nom :"));
		this.add(txtNom);
		this.add(new JLabel("NumSiret :"));
		this.add(txtNumSiret);
		this.add(new JLabel("Activité : "));
		this.add(txtActivite);
		this.add(new JLabel("Adresse :"));
		this.add(txtAdr);
		this.add(new JLabel("Code Postal:"));
		this.add(txtCp);
		this.add(new JLabel("Ville :"));
		this.add(txtVille);
		this.add(new JLabel("Mail :"));
		this.add(txtMail);
		this.add(new JLabel("Mot de passe:"));
		this.add(txtMdp);
		this.add(new JLabel("Téléphone:"));
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
		// TODO Auto-generated method stub
		
		if(e.getSource()== this.btAjouter)
		{
			String nom = txtNom.getText().toString();
			int numsiret = Integer.parseInt(txtNumSiret.getText().toString());
			String activite = txtActivite.getText().toString();
			String adresse= txtAdr.getText().toString();
			int cp = Integer.parseInt(txtCp.getText().toString());
			String ville = txtVille.getText().toString();
			String mail = txtMail.getText().toString(); 
			String mdp = txtMdp.getText().toString();
			String tel = txtTel.getText().toString(); 
			
			Entreprise uneEntreprise = new Entreprise(nom, mdp, adresse, cp, ville, mail, tel, numsiret, activite);
			ModeleEntreprise.insertEntreprise(uneEntreprise); 
			
			JOptionPane.showMessageDialog(this, "Insertion effectuée");
	
		}
		else if (e.getSource()== this.btAnnuler){
			this.txtNom.setText("");
			this.txtAdr.setText("");
			this.txtCp.setText("");
			this.txtVille.setText("");
			this.txtMail.setText("");
			this.txtMdp.setText("");
			this.txtTel.setText("");
			this.txtNumSiret.setText("");
			this.txtActivite.setText("");
		}
	}
}
