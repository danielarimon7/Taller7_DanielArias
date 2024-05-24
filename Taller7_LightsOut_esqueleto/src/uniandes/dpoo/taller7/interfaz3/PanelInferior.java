package uniandes.dpoo.taller7.interfaz3;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInferior extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PanelInferior () {
		JPanel panelinferior = new JPanel();
		panelinferior.setLayout( new GridLayout());
		JLabel jugadas = new JLabel("Jugadas:");
		add(jugadas);
		JTextField numjug = new JTextField("0           ");
		numjug.setEditable(false);
		add(numjug);
		JLabel jugador = new JLabel("Jugador:");
		add(jugador);
		JTextField nomjug = new JTextField("            ");
		nomjug.setEditable(false);
		add(nomjug);
	}

}
