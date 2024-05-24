package uniandes.dpoo.taller7.interfaz4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class PanelTablero extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int n;

	private boolean[][] boardState;
	private int blockH;
	private int blockW;
	
	
	public PanelTablero (int tamano , boolean[][] boardState) {
		this.n = tamano;
		this.boardState = boardState;
		blockH = ( (501 - 1 ) / n) - 1;
		blockW = ( (501 - 1) / n) - 1;
		setPreferredSize( new Dimension(500, 500) );
		addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int col = e.getX();
                int fila = e.getY();
                int[] casilla = convertirCoordenadasACasilla(col, fila);
                Ventana.jugar(casilla[0], casilla[1]);

            }
        });
	}

	@Override
	public void paint( Graphics g ) 
	{
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.setPaint( Color.black );
		Rectangle2D rectangulo = new Rectangle2D.Double(1, 1, 501, 501 );
		g2D.fill( rectangulo );
		g2D.setPaint( Color.gray );
		boolean state;
		int i = 0;
		int currentHeight = 2;
		while ( i < n & n != 1 )
		{
			int j = 0;
			int currentWidth = 2;
			while ( j < n )
			{
				rectangulo = new Rectangle2D.Double(currentHeight, currentWidth, blockW, blockH );
				
				state = boardState[i][j];
				
				if ( state )
				{
					g2D.setPaint( Color.yellow );
					g2D.fill( rectangulo );
					g2D.setPaint( Color.gray );
				}
				else
				{
					g2D.fill( rectangulo );
				}
				
				j += 1;
				currentWidth += blockW + 1;
			}
			
			i += 1;
			currentHeight += blockH + 1;
		}
	}

	public void actualizar( boolean[][] boardState) {
		this.boardState = boardState;
		this.repaint();
		
	}
	private int[] convertirCoordenadasACasilla(int x, int y)
	{
		int fila = (int) (y / blockH);
		int columna = (int) (x / blockW);
		return new int[] { fila , columna };
	}
	
	}
	


