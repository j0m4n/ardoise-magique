package com.fenetre;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Panneau extends JPanel /*implements MouseMotionListener*/
{
	private int posX = 0;
	private int posY = 0;
	private String forme = "Carre";
	private String color = "Vert";
	private int drawSize = 20; 
	private Graphics g;
	private ArrayList<Point> listePoints = new ArrayList<Point>();
	private boolean start = false;
	
	public Panneau()
	{
		//Cas d'un seul click
		this.addMouseListener(new MouseAdapter() 
		{
			public void mousePressed(MouseEvent e)
			{
				 setPosX(e.getX());
				 setPosY(e.getY());
				 start = true;
				 repaint();	
			}
		});
		
		//Cas d'un click prolongé où l'on déplace la souris
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				 setPosX(e.getX());
				 setPosY(e.getY());
				 start = true;
				 repaint(); 
			}
		});
	}
	
	//Methode de JPanel appel� � chaque redimensionnement
	public void paintComponent(Graphics g)
	{
	    g.setColor(Color.white);
	    g.fillRect(0, 0, this.getWidth(), this.getHeight());
		this.draw(g);
	}
	 
	 public void effacer()
	 {
		 listePoints.clear();
		 start = false;
		 repaint();
	 }
	
	private void draw(Graphics g)
	{      
		if(start)
		{	
			Point newP = new Point(drawSize, this.getPosX(), this.getPosY(), this.getForme(), this.getColor());
			listePoints.add(newP);
		}
	
		for(Point p : listePoints)
		{
			if(p.color.equals("Vert"))
				g.setColor(Color.green);
			else if(p.color.equals("Bleu"))
				g.setColor(Color.blue);
			else if(p.color.equals("Rouge"))
				g.setColor(Color.red);
			
			if(p.forme.equals("Rond"))
				g.fillOval(p.posX, p.posY, p.size, p.size); 
			else if(p.forme.equals("Carre"))
				g.fillRect(p.posX, p.posY, p.size, p.size); 
		}
	 }
	
	//Accesseurs
	public int getPosX()
	{
		return this.posX;
	}
	
	public int getPosY()
	{
		return this.posY;
	}
	
	public String getForme()
	{
		return this.forme;
	}
	
	public String getColor()
	{
		return this.color;
	}
	
	//Mutateurs
	public void setPosX(int posX)
	{
		this.posX = posX;
	}
	
	public void setPosY(int posY)
	{
		this.posY = posY;
	}

	public void setForme(String forme)
	{
		this.forme = forme;
	}
	
	public void setColor (String color)
	{
		this.color = color;
	}
	
}
