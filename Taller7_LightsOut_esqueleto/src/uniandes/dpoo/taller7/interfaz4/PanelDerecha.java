package uniandes.dpoo.taller7.interfaz4;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class PanelDerecha extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PanelDerecha (Ventana ventana) {
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
		nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.nuevoTablero();
            }
        });

        reiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.reiniciarTablero();
            }
        });

        top10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.mostrarTop10();;
            }
        });

        cambiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String nombre = JOptionPane.showInputDialog( ventana, "Ingrese su usuario (máximo 3 letras): ", null);
            	ventana.setJugador(nombre);
            }
        });
    }

	
}
