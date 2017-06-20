package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import controleur.Main;
import controleur.Technicien;

@SuppressWarnings("serial")
public class Generale extends JFrame implements ActionListener{

	private JMenuBar uneBarre = new JMenuBar(); 
	private JMenu mnMenu = new JMenu("Menu");
	private JMenu mnEspaceClient = new JMenu("Espace Client");
	//private JMenu mnSpeedy = new JMenu("Speedy");
	private JMenu mnRDV = new JMenu("RDV");  
	//private JMenu mnAide = new JMenu("Aide");
	private JMenuItem mnAjouter = new JMenu("Ajouter");
	

	private JMenuItem itemQuitter = new JMenuItem("Déconnexion");
	private JMenuItem itemLister = new JMenuItem("Lister");
	private JMenuItem itemParticulier= new JMenuItem("Particulier");
	private JMenuItem itemEntreprise= new JMenuItem("Entreprise");
	//private JMenuItem itemApropos= new JMenuItem("A Propos");
	private JMenuItem itemMonProfil = new JMenuItem("Mon Profil"); 
	@SuppressWarnings("unused")
	private JMenuItem itemDeconnexion = new JMenuItem("Deconnexion");
	private JMenuItem itemMonRDV = new JMenuItem("Rendez-vous"); 
	//@SuppressWarnings("unused")
	//private JMenuItem itemAide = new JMenuItem("Nous contacter"); 
	
	private VueAccueil uneVueAcceuil; 
	private VueParticulier uneVueParticulier;
	private VueInsertParticulier uneVueParticulierInsert; 
	private VueInsertEntreprise uneVueEntrepriseInsert; 
	private VueEditionClient uneVueEditionClient; 
	
public Generale(Technicien unTechnicien)
{
	this.setTitle(" Menu Administration ");
	this.setLayout(null);
	this.setBounds(350, 200, 1170, 650);
	this.setResizable(false);
	
	this.uneVueAcceuil = new VueAccueil(unTechnicien);
	this.add(uneVueAcceuil);
	
	this.uneVueParticulier = new VueParticulier();
	this.add(uneVueParticulier);
	
	this.uneVueParticulierInsert = new VueInsertParticulier();
	this.add(uneVueParticulierInsert);
	
	this.uneVueEntrepriseInsert = new VueInsertEntreprise();
	this.add(uneVueEntrepriseInsert);
	
	this.uneVueEditionClient = new VueEditionClient();
	this.add(uneVueEditionClient);
	
	// construction du menu 
		this.uneBarre.add(mnMenu); 
		this.mnMenu.add(itemMonProfil);
		this.mnMenu.add(itemQuitter); 
		this.mnAjouter.add(itemParticulier);
		this.mnAjouter.add(itemEntreprise);
		this.uneBarre.add(mnEspaceClient);
		this.mnEspaceClient.add(itemLister);
		this.mnEspaceClient.add(mnAjouter);
		
		this.uneBarre.add(mnRDV);
		this.mnRDV.add(itemMonRDV); 
		
		
		/*this.uneBarre.add(mnSpeedy);
		this.mnSpeedy.add(itemApropos);
		
		this.uneBarre.add(mnAide); 
		this.mnAide.add("Nous Contacter");*/ 
		
		
		
		this.setJMenuBar(uneBarre);	
		
		this.itemLister.addActionListener(this);
		this.itemQuitter.addActionListener(this);
		this.itemMonProfil.addActionListener(this);
		this.itemParticulier.addActionListener(this);
		this.itemEntreprise.addActionListener(this);
		
		this.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.itemQuitter)
		{
			int retour = JOptionPane.showConfirmDialog(this, "Voulez-vous quitter ? ", "Quitter", JOptionPane.ERROR_MESSAGE); 
			
			if (retour == 0)
			{
				this.dispose();
				Main.rendreVisible(true);
			}
		}
		else if  (e.getSource()==this.itemLister)
		{
			this.uneVueParticulier.setVisible(true);
			this.uneVueAcceuil.setVisible(false);
			this.uneVueParticulierInsert.setVisible(false);
			this.uneVueEntrepriseInsert.setVisible(false);
			this.uneVueEditionClient.setVisible(true);
		}
		else if (e.getSource()==this.itemMonProfil)
		{
			this.uneVueAcceuil.setVisible(true);
			this.uneVueParticulier.setVisible(false);
			this.uneVueParticulierInsert.setVisible(false);
			this.uneVueEntrepriseInsert.setVisible(false);
		}
		else if (e.getSource()==this.itemParticulier)
		{
			this.uneVueParticulierInsert.setVisible(true);
			this.uneVueAcceuil.setVisible(false);
			this.uneVueParticulier.setVisible(false);
			this.uneVueEntrepriseInsert.setVisible(false);
			this.uneVueEditionClient.setVisible(false);
		}
		else if (e.getSource()==this.itemEntreprise)
		{
			this.uneVueAcceuil.setVisible(false);
			this.uneVueParticulier.setVisible(false);
			this.uneVueParticulierInsert.setVisible(false);
			this.uneVueEntrepriseInsert.setVisible(true);
			this.uneVueEditionClient.setVisible(false);
		}
	}
}		

