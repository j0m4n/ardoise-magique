package com.fenetre;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
	
	private Panneau panneau = new Panneau();
	
	public Fenetre (){
		
		this.setSize(600,300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    
	    //Lance le menu
	    this.initMenu();
	    
	    this.setContentPane(panneau);
	    this.setVisible(true);
	    
	}
	
	private void initMenu()
	{
		//Menu Fichier
		menuBar.add(menuFichier);
		menuFichier.add(itemEffacer);
		menuFichier.add(itemQuitter);
		
		//Menu Edition
		menuBar.add(menuEdition);
		menuEdition.add(menuFormePointeur);
		menuFormePointeur.add(itemCarre);
		menuFormePointeur.add(itemRond);
		menuEdition.add(menuCouleurPointeur);
		menuCouleurPointeur.add(itemRouge);
		menuCouleurPointeur.add(itemVert);
		menuCouleurPointeur.add(itemBleu);
		
		this.setJMenuBar(menuBar);
	}
	
}
