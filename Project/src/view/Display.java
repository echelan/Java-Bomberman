/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.KeyHandler;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import model.Handler;

/**
 *
 * @author Andres
 */
public class Display extends Canvas implements Runnable {

	private Handler h;
	private BufferedImage lastFrame;
			
	public Display(Handler h) {
		this.h = h;
		lastFrame = new BufferedImage(Handler.SCREEN_SIZE,Handler.SCREEN_SIZE,BufferedImage.TYPE_INT_ARGB);
		addKeyListener(new KeyHandler());
	}

	@Override
	public void paint(Graphics g) {
		try{
			lastFrame = Handler.currentScene.getDisplay();
			g.drawImage (lastFrame,0,0,getWidth(),getHeight(),null);
		} catch (Exception e) {
			System.err.println("ERROR! "+e.toString());
			g.drawImage (lastFrame,0,0,getWidth(),getHeight(),null);
		}
	}

	@Override
	public void run() {
		createBufferStrategy(2);
		while (true){
			repaint();
			try {
				Thread.sleep(75);
			} catch (Exception e) {
				
			}
		}
	}
	
	
	
}
