/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Canvas;
import model.Handler;

/**
 *
 * @author Andres
 */
public class Display extends Canvas {

	private Handler h;
	
	public Display(Handler h) {
		this.h = h;
	}
	
}
