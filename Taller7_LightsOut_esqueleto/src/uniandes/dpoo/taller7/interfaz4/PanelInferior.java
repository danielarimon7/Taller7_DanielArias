package uniandes.dpoo.taller7.interfaz4;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelInferior extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JTextField numjug;
	private static JTextField nomjug;
	
	public PanelInferior () {
		JPanel panelinferior = new JPanel();
		panelinferior.setLayout( new GridLayout());
		JLabel jugadas = new JLabel("Jugadas:");
		add(jugadas);
		numjug = new JTextField("0");
		numjug.setEditable(false);
		add(numjug);
		JLabel jugador = new JLabel("Jugador:");
		add(jugador);
		nomjug = new JTextField("    ");
		nomjug.setEditable(false);
		add(nomjug);
	}

	public static void incJugadas() {
		Integer jugadas = Integer.parseInt( numjug.getText() ) + 1;
		numjug.setText( jugadas.toString() );
		
	}
	public void resetJugadas()
	{
		numjug.setText( "0" );
	}

	public String getJugador() {
		return nomjug.getText();
	}

	public void cambiarJugador( String name )
	{
		nomjug.setText( name );
	}


}
