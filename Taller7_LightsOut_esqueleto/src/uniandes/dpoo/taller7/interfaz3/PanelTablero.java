package uniandes.dpoo.taller7.interfaz3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PanelTablero extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int n;
	
	public PanelTablero (int tamano) {
		this.n = tamano;
	}
			
	protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        Graphics2D tablero = (Graphics2D) g;
	        int r;
	        if (n == 5) {
	        	r = 65;
	        }
	        else if (n == 10) {
	        	r = 33;
	        }
	        else {
	        	r = 22;
	        }

	        for (int fila = 0; fila < n; fila++) {
	            for (int col = 0; col < n; col++) {
	                int x = col * r;
	                int y = fila * r;
	                tablero.setColor(Color.YELLOW);
	                tablero.fillRect(x, y, r, r);
	                tablero.setColor(Color.BLACK);
	                tablero.drawRect(x, y, r, r);
	            }
	        }
	    }
	}
	


