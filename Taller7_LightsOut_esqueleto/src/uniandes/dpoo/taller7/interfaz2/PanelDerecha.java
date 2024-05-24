package uniandes.dpoo.taller7.interfaz2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelDerecha extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PanelDerecha () {
        setLayout( new GridBagLayout() );
		GridBagConstraints coord = new GridBagConstraints();
		coord.fill = GridBagConstraints.HORIZONTAL; 
		coord.gridx = 0;
		coord.gridy = 0;
		JButton nuevo = new JButton("NUEVO");
		add( nuevo , coord );
		coord.gridx = 0;
		coord.gridy = 2;
		JButton reiniciar = new JButton("REINICIAR");
	    add( reiniciar, coord );
		coord.gridx = 0;
		coord.gridy = 4;
		JButton top10 = new JButton("TOP-10");
		add( top10, coord );
		coord.gridx = 0;
		coord.gridy = 6;
		JButton cambiar = new JButton("CAMBIAR JUGADOR");
		add( cambiar, coord);
		setVisible(true);
	}
}
