package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Plateau extends JFrame {
	static int
	posX = 150,
	posY = 0,
	imageX = 2816,
	imageY = 2112;
	
	
	public static void screenRender(JFrame main_frame) throws IOException  {
		JPanel fond = new DrawHexagon();
		main_frame.add(fond);
		main_frame.setVisible(true); 

	}
}


class DrawHexagon extends JPanel{
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int i,j;
		int ligne[] = {7,10,11,10,11,12,11,12,11,10,11,10,7};
		int positionCorrect[] = {10,12,12,12,13,13,13,13,12,12,12,10,12};
		int colonne = 13;
		int Xhexagon[] = {26,52,52,26,0,0}; 
		int Yhexagon[] = {0,14,44,58,44,14};
		BasicStroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);
		Polygon hexagon = new Polygon(Xhexagon,Yhexagon,6);
		Graphics2D g2d =(Graphics2D)g.create();
		BufferedImage bufferedImage = null;
		
		Plateau.imageX = (int)Plateau.imageX/(Plateau.imageY/g2d.getClipBounds().height); 
		Plateau.imageY = g2d.getClipBounds().height;

		try {
			bufferedImage = ImageIO.read(new File("map1.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image image = bufferedImage.getScaledInstance((Plateau.imageX),(Plateau.imageY), Image.SCALE_SMOOTH);
		
		g2d.drawImage(image,Plateau.posX,Plateau.posY,null);
		g2d.setColor(Color.BLACK);
		g2d.setStroke(stroke);
		hexagon.translate(Plateau.posX + 200,Plateau.posY + 60);
		for (j = 0; j < 13; j++) {
			for (i = 0; i <= ligne[j]; i++) {
				hexagon.translate(52,0);
				g2d.drawPolygon(hexagon);
			}
			hexagon.translate(-52*positionCorrect[j],0);
			hexagon.translate(26,44);
		}
		g2d.dispose();
		}
}
