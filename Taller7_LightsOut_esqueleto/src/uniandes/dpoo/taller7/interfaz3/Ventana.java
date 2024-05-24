package uniandes.dpoo.taller7.interfaz3;

import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

public class Ventana extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelSuperior panelsuperior;
	private PanelDerecha panelderecha;
	private PanelInferior panelinferior;
	private PanelTablero tablero;

	public Ventana () {
		setTitle("Juego LigthsOut");
		setSize(500,450);
		setResizable(false);
		setLayout( new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel norte = new JPanel();
		norte.setLayout(new GridLayout());
		add(norte, BorderLayout.NORTH);
		panelsuperior = new PanelSuperior();
		norte.add(panelsuperior, 0);
		
		JPanel centro = new JPanel();
		centro.setLayout( new BorderLayout() );
		add( centro, BorderLayout.CENTER );
		tablero = new PanelTablero(5);
		centro.add( tablero, BorderLayout.CENTER );
		
		JPanel derecha = new JPanel();
		derecha.setLayout(new BorderLayout());
		add(derecha, BorderLayout.EAST);
		panelderecha = new PanelDerecha();
		derecha.add(panelderecha, BorderLayout.CENTER);
		
		JPanel inferior = new JPanel();
		inferior.setLayout( new GridLayout());
		add(inferior, BorderLayout.SOUTH);
		panelinferior = new PanelInferior();
		inferior.add(panelinferior);
	}
	
	public static void main (String[] args) {
		Ventana ventana = new Ventana();
		ventana.setVisible(true);
	}

}
	