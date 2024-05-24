package uniandes.dpoo.taller7.interfaz2;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelSuperior extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PanelSuperior() {
		JPanel panelsuperior = new JPanel();
		panelsuperior.setLayout( new GridLayout());
		JLabel tamano = new JLabel("Tamaño");
		add(tamano);
		String[] matrices= { "5x5", "10x10", "15x15" };
		JComboBox<String> matriz = new JComboBox<String>(matrices);
		add(matriz);
		JLabel dificultad = new JLabel("Dificultad");
		add(dificultad);
		ButtonGroup dificultades = new ButtonGroup();
		JRadioButton facil = new JRadioButton("Fácil");
		dificultades.add(facil);
		add(facil);
		JRadioButton medio = new JRadioButton("Medio");
		dificultades.add(medio);
		add(medio);
		JRadioButton dificil = new JRadioButton("Difícil");
		dificultades.add(dificil);
		add(dificil);
	}
}
