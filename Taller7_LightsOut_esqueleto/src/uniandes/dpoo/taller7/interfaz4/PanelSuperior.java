package uniandes.dpoo.taller7.interfaz4;

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
	private JComboBox<String> matriz;
	private JRadioButton facil;
	private JRadioButton medio;
	private JRadioButton dificil;
	public static final String fac = "5x5";
	public static final String med = "10x10";
	public static final String dif = "15x15";
	
	public PanelSuperior() {
		JPanel panelsuperior = new JPanel();
		panelsuperior.setLayout( new GridLayout());
		JLabel tamano = new JLabel("Tamaño");
		add(tamano);
		String[] matrices= { fac, med, dif };
		matriz = new JComboBox<String>(matrices);
		add(matriz);
		matriz.setSelectedIndex(0);
		JLabel dificultad = new JLabel("Dificultad");
		add(dificultad);
		ButtonGroup dificultades = new ButtonGroup();
        facil = new JRadioButton("Fácil");
		dificultades.add(facil);
		facil.setSelected(true);
		add(facil);
        medio = new JRadioButton("Medio");
		dificultades.add(medio);
		add(medio);
		dificil = new JRadioButton("Difícil");
		dificultades.add(dificil);
		add(dificil);
		this.setVisible(true);
	}
	
	public int getDificultad()
	{
		if ( facil.isSelected() )
		{
			return 5;
		}
		else if ( medio.isSelected() )
		{
			return 10;
		}
		else 
		{
			return 15;
		}
		
	}
	
	public int getN()
	{
		String n = (String) matriz.getSelectedItem();
		if (n == "5x5") {
			return 5;
		}
		else if (n == "10x10") {
			return 10;
		}
		else {
			return 15;
		}
	}
}
