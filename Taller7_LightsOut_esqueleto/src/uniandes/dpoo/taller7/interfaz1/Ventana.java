package uniandes.dpoo.taller7.interfaz1;

import java.awt.*;
import javax.swing.JFrame;

public class Ventana extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ventana () {
		setTitle("Juego LigthsOut");
		setSize(700,600);
		setResizable(false);
		setLayout( new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main (String[] args) {
		Ventana ventana = new Ventana();
		ventana.setVisible(true);
	}

}
	