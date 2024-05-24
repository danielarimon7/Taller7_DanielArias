package uniandes.dpoo.taller7.interfaz4;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.*;
import javax.swing.JFrame;
import uniandes.dpoo.taller7.modelo.*;

public class Ventana extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelSuperior panelsuperior;
	private PanelDerecha panelderecha;
	private static PanelInferior panelinferior;
	private static PanelTablero paneltablero;
	private static Tablero tablero;
	private static Top10 top10;
	private Dialogo dialogo;

	public Ventana () {
		setTitle("Juego LigthsOut");
		setSize(700,570);
		setResizable(false);
		setLayout( new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tablero = new Tablero(5);
		top10 = new Top10();
		File top = new File( "./data/Top10.csv" );
		top10.cargarRecords( top );
		
		JPanel norte = new JPanel();
		norte.setLayout(new GridLayout());
		add(norte, BorderLayout.NORTH);
		panelsuperior = new PanelSuperior();
		norte.add(panelsuperior, 0);
		
		JPanel centro = new JPanel();
		centro.setLayout( new BorderLayout() );
		add( centro, BorderLayout.CENTER );
		paneltablero = new PanelTablero(5, tablero.darTablero());
		centro.add( paneltablero, BorderLayout.CENTER );
		
		JPanel derecha = new JPanel();
		derecha.setLayout(new BorderLayout());
		add(derecha, BorderLayout.EAST);
		panelderecha = new PanelDerecha(this);
		derecha.add(panelderecha, BorderLayout.CENTER);
		
		JPanel inferior = new JPanel();
		inferior.setLayout( new GridLayout());
		add(inferior, BorderLayout.SOUTH);
		panelinferior = new PanelInferior();
		inferior.add(panelinferior);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing( WindowEvent e )
				{
					salvarTop10();
				}
		});
	}
	
	public static void main (String[] args) {
		Ventana ventana = new Ventana();
		ventana.setVisible(true);
	}

	public static void jugar(int i, int j) {
		boolean terminado = tablero.tableroIluminado();
		if (terminado != true) {
			tablero.jugar(i, j);
			paneltablero.actualizar( tablero.darTablero() );
			panelinferior.incJugadas();
			int puntaje = tablero.calcularPuntaje();
			if (tablero.tableroIluminado() == true && top10.esTop10(puntaje) == true) {
				String jugador = panelinferior.getJugador();
				top10.agregarRegistro(jugador, puntaje);
			}
		}
		
	}
	
	public void salvarTop10()
	{
		File top = new File( "./data/Top10.csv" );
		try
		{
			top10.salvarRecords( top );
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
	}

	public void mostrarTop10()
	{
		dialogo = new Dialogo( top10 );
		dialogo.setVisible( true );
	}
	
	public void setJugador( String nombre )
	{
		panelinferior.cambiarJugador( nombre );
	}
	
	public void nuevoTablero()
	{
		int n = panelsuperior.getN();
		int dificultad = panelsuperior.getDificultad();
		tablero = new Tablero( n );
		tablero.desordenar( dificultad );
		panelinferior.resetJugadas();
	}
	public void reiniciarTablero()
	{
			tablero.reiniciar();
			panelinferior.resetJugadas();

		
	}
}
	