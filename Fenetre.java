package com.fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class Fenetre extends JFrame {
	
	private JMenuBar menuBar = new JMenuBar();
	
	//Menu Fichier
	private JMenu menuFichier = new JMenu("Fichier");
	private JMenuItem itemEffacer = new JMenuItem("Effacer");
	private JMenuItem itemQuitter = new JMenuItem("Quitter");
	
	//Menu Edition
	private JMenu menuEdition = new JMenu("Edition");
	private JMenu menuFormePointeur= new JMenu("Forme du Pointeur");
	private JMenuItem itemRond = new JMenuItem("Rond");
	private JMenuItem itemCarre = new JMenuItem("Carre");
	private JMenu menuCouleurPointeur= new JMenu("Couleur du Pointeur");
	private JMenuItem itemRouge = new JMenuItem("Rouge");
	private JMenuItem itemVert = new JMenuItem("Vert");
	private JMenuItem itemBleu = new JMenuItem("Bleu");
	
	//les panneaux
	private JPanel container = new JPanel();
	private Panneau panneau = new Panneau();
	
	//la barre d'outils
	private JToolBar barreOutils = new JToolBar();
	private JButton carreNoir = new JButton(new ImageIcon("images/carre.png"));
	private JButton rondNoir = new JButton(new ImageIcon("images/rond.png"));
	private JButton carreBleu = new JButton(new ImageIcon("images/bleu.png"));
	private JButton carreVert = new JButton(new ImageIcon("images/vert.png"));
	private JButton carreRouge = new JButton(new ImageIcon("images/rouge.png"));
	
	public Fenetre (){
		
		this.setSize(600,300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    container.setLayout(new BorderLayout());
	    //Lance le menu et barre outils
	    this.initMenu();
	    this.initBarreOutils();
	    
	    //ajoute le panneau contenant les dessins
	    //panneau.setBackground(Color.red);
	    container.add(panneau, BorderLayout.CENTER);
	    container.add(barreOutils, BorderLayout.NORTH); 
	    this.setContentPane(container);
	    this.setVisible(true);
	}
	
	private void initBarreOutils()
	{
		this.carreNoir.setBackground(Color.white);
		this.carreNoir.addActionListener(new itemCarreListener());
	    this.barreOutils.add(carreNoir);

		this.rondNoir.setBackground(Color.white);
		this.rondNoir.addActionListener(new itemRondListener());
	    this.barreOutils.add(rondNoir);
		
	    this.barreOutils.add(Box.createRigidArea(new Dimension(25,0)));//add space between shapes & colors
	    
		this.carreBleu.setBackground(Color.white);
		this.barreOutils.add(carreBleu);
		this.carreBleu.addActionListener(new itemBleuListener());
		
	    this.carreVert.setBackground(Color.white);
	    this.barreOutils.add(carreVert);
	    this.carreVert.addActionListener(new itemVertListener());
	    
	    this.carreRouge.setBackground(Color.white);
	    this.barreOutils.add(carreRouge);
	    this.carreRouge.addActionListener(new itemRougeListener());
	}
	
	private void initMenu()
	{
		//Menu Fichier
		menuBar.add(menuFichier);
		menuFichier.setMnemonic('F');
		menuFichier.add(itemEffacer);
		itemEffacer.addActionListener(new itemEffacerListener());
		itemEffacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
		menuFichier.add(itemQuitter);
		itemQuitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK));
		itemQuitter.addActionListener(new itemQuitterListener());
		
		//Menu Edition
		menuBar.add(menuEdition);
		menuEdition.setMnemonic('E');
		menuEdition.add(menuFormePointeur);
		//Sous menu Forme
		menuFormePointeur.add(itemCarre);
		itemCarre.addActionListener(new itemCarreListener());
		menuFormePointeur.add(itemRond);
		itemRond.addActionListener(new itemRondListener());
		//Sous menu couleur
		menuEdition.add(menuCouleurPointeur);
		menuCouleurPointeur.add(itemRouge);
		itemRouge.addActionListener(new itemRougeListener());
		menuCouleurPointeur.add(itemVert);
		itemVert.addActionListener(new itemVertListener());
		menuCouleurPointeur.add(itemBleu);
		itemBleu.addActionListener(new itemBleuListener());
		
		this.setJMenuBar(menuBar);
	}
	
	public class itemEffacerListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			panneau.effacer();
		}
	}
	
	public class itemQuitterListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			System.exit(0);
		}
		
	}
	
	public class itemRougeListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			panneau.setColor("Rouge");
		}
	}
	
	public class itemVertListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			panneau.setColor("Vert");
		}
	}
	
	public class itemBleuListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			panneau.setColor("Bleu");
		}
	}
	
	public class itemCarreListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			panneau.setForme("Carre");
		}
	}
	
	public class itemRondListener implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			panneau.setForme("Rond");
		}
	}
	
}
