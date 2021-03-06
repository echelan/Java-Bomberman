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

/**
 *
 * @author Andres
 */
public class Display extends Canvas implements Runnable {

	private BufferedImage lastFrame;
			
	public Display() {
		int size = bomberman.Bomberman.SCREEN_SIZE;
		lastFrame = new BufferedImage(size, size,BufferedImage.TYPE_INT_ARGB);
		addKeyListener(new KeyHandler());
	}
	
	/**
	 * Displays the current scene image;
	 */
	@Override
	public void run() {
		createBufferStrategy(2);
		while (true){
			
			try {
				Graphics g = getBufferStrategy().getDrawGraphics();
				lastFrame = model.Handler.getDisplay();
				g.drawImage (lastFrame,0,0,getWidth(),getHeight(),null);
				getBufferStrategy().show();
			}catch(Exception e) {
//				System.err.println("Error display.");
			}
			
			try {
				Thread.sleep(50);
			} catch (Exception e) { }
		}
	}
	
}
