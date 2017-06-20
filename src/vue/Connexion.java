package vue;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Connexion extends JFrame
{
	
	public Connexion(){
		this.setTitle("Gestion de Garage");
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(0, 102, 186));
		this.setBounds(200, 200, 600, 350);
		this.setResizable(false);
		ImageIcon icon = new ImageIcon("src/images/speedy.png"); 
		JLabel logo = new JLabel(icon);
		logo.setBounds(100, 0, 400, 150);
		this.add(logo);
		
		ImageIcon iconLogo = new ImageIcon("src/images/logo.png"); 
		this.setIconImage(iconLogo.getImage());
		this.add(new VueConnex()); 
		this.setVisible(true);
	}
	
	
}
