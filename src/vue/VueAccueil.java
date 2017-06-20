package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import controleur.Technicien;

@SuppressWarnings({ "serial", "unused" })
public class VueAccueil extends JPanel implements ActionListener
{
	private JTextArea txtTitre = new JTextArea();
	private JTextArea txtInfos = new JTextArea();
	
	
	public VueAccueil(Technicien unTechnicien) {
		// TODO Auto-generated constructor stub
		this.setBounds(0, 0, 1150, 650);
		this.setLayout(null);

		this.setBackground(new Color(0, 102, 186));
		ImageIcon iconLogo = new ImageIcon("src/images/logo.png"); 
		JLabel logo = new JLabel(iconLogo);
		logo.setBounds(50, 10, 100, 100);
		this.add(logo);
		
		Font bold30 = new Font("Courier", Font.BOLD, 30);
		
		this.txtTitre.setBounds(530, 70, 180, 50);
		this.txtTitre.setEditable(false);
		this.txtTitre.setForeground(Color.white);
		this.txtTitre.setFont(bold30);
		this.txtTitre.setBackground(new Color(0, 102, 186));
		
		String titre = "Mon Profil";
		
		this.txtTitre.setText(titre);
		this.add(this.txtTitre);
		
		this.txtInfos.setBounds(400, 200, 450, 150);
		this.txtInfos.setEditable(false);
	
		String infos = "\n\tNom : \t\t"+unTechnicien.getNom_technicien(); 
		infos += "\n\n\tPrénom : \t\t"+unTechnicien.getPrenom_technicien(); 
		infos += "\n\n\tLogin : \t\t"+unTechnicien.getLogin_technicien(); 
		infos += "\n\n\tDate d'embauche : \t"+unTechnicien.getDateembauche_technicien();
		
		this.txtInfos.setText(infos);
		this.add(this.txtInfos);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
