package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.Main;
import controleur.Technicien;
import modele.Modele;

@SuppressWarnings("serial")
public class VueConnex extends JPanel implements ActionListener, KeyListener
{
	private JLabel txtLog = new JLabel("\t Login :");
	private JLabel txtMdp = new JLabel("\t Mot de passe :");
	
	private JTextField fLog = new JTextField(); 
	private JPasswordField fMpd= new JPasswordField(); 
	
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btSeConnnecter = new JButton("Se Connecter"); 
	
	
	public VueConnex ()
	{
		this.setBounds(80, 150, 460, 100);

		this.setBackground(new Color(0, 102, 186));
		
		Font bold15 = new Font("Arial", Font.BOLD, 15);
		
		this.setLayout(new GridLayout(3, 3));
		this.add(this.txtLog);
		this.txtLog.setFont(bold15);
		this.txtLog.setForeground(Color.white);
		this.add(this.fLog);
		this.add(this.txtMdp);
		this.txtMdp.setFont(bold15);
		this.txtMdp.setForeground(Color.white);
		this.add(this.fMpd);
		
		this.add(this.btAnnuler);
		this.add(this.btSeConnnecter);

		
		// INSERER UNE IMAGE SUR LES BOUTONS CLIQUABLES // 
		
		ImageIcon icon = new ImageIcon("src/images/speedy.png"); 
		Image image = icon.getImage(); 
		image = image.getScaledInstance(this.getWidth()/2, this.getHeight()/6, Image.SCALE_AREA_AVERAGING); 
		icon.setImage(image);
		
		
		
		this.btSeConnnecter.setIcon(icon);
		
		this.btSeConnnecter.setIcon(new ImageIcon ("src/desktop/connexion.png")); 
		this.btAnnuler.setIcon(new ImageIcon ("src/desktop/annuler.jpg"));
		
		//RENDRE LES BOUTONS CLIQUABLES // 
		
		this.btAnnuler.addActionListener(this);
		this.btSeConnnecter.addActionListener(this);
		this.fMpd.addKeyListener(this);
		this.fLog.addKeyListener(this);
		this.setVisible(true);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btAnnuler)
		{
			this.fLog.setText("");
			this.fMpd.setText("");
		}
		else if (e.getSource()==this.btSeConnnecter)
		{
			this.actionConnexion();
		}
		
	}

	public void actionConnexion()
	{
		String login_technicien = this.fLog.getText(); 
		String mdp_technicien = new String(this.fMpd.getPassword()); 
		
		
		Technicien unTechnicien = Modele.selectWhere(login_technicien, mdp_technicien);
		if(unTechnicien == null){
			JOptionPane.showMessageDialog(this, "Echec de le connexion ");
		}else 
		{
			JOptionPane.showMessageDialog(this, "Connexion à votre programme réussie  "+unTechnicien.getNom_technicien()+
					" "+unTechnicien.getPrenom_technicien());
			new Generale(unTechnicien); 
			Main.rendreVisible(false);
			this.fLog.setText("");
			this.fMpd.setText("");
		}
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			this.actionConnexion();
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}

