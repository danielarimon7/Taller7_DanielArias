package uniandes.dpoo.taller7.interfaz4;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Top10;

public class Dialogo extends JDialog{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Top10 top10;
    private Container contentPanel;
	public Dialogo( Top10 top10 ) 
    {
	this.top10 = top10;
    setLayout( new BorderLayout() );
	setTitle( "Top 10" );
	JPanel mensaje = new JPanel();
	mensaje.setLayout( new BorderLayout() );
    add( mensaje, BorderLayout.CENTER );
	setResizable( false );
	Collection<RegistroTop10> registros = top10.darRegistros();
	Iterator<RegistroTop10> registrosIt = registros.iterator();
	DefaultListModel<JLabel> lista = new DefaultListModel<JLabel>();
	JLabel headerLabel = new JLabel( "#      Nombre     Puntaje", SwingConstants.CENTER );
	lista.addElement( headerLabel );
	int i = 1;
	while ( registrosIt.hasNext() )
	{
		RegistroTop10 next = registrosIt.next();
		String name = next.darNombre();
		int puntos = next.darPuntos();
		String regString = formatReg( i, name, puntos);
		JLabel regLabel = new JLabel( regString, SwingConstants.CENTER );
		lista.addElement( regLabel );
		i += 1;
	}
	
	JList<JLabel> toop = new JList<JLabel>( lista );
	
	
	
	
	// Use a custom cell renderer to display JLabels properly in the JList
    toop.setCellRenderer(new ListCellRenderer<JLabel>() 
    {
        @Override
        public Component getListCellRendererComponent(JList<? extends JLabel> list, JLabel value, int index, boolean isSelected, boolean cellHasFocus) 
        {
            value.setOpaque(true);
            if (isSelected) 
            {
                value.setBackground(list.getSelectionBackground());
                value.setForeground(list.getSelectionForeground());
            } 
            else 
            {
                value.setBackground(list.getBackground());
                value.setForeground(list.getForeground());
            }
            
            return value;
        }
        
    });
	
	JScrollPane scroll = new JScrollPane( toop );
	mensaje.add( scroll, BorderLayout.CENTER );
	
	setVisible( true );
	
}


    private String formatReg(int i, String name, int puntos)
    {
	String reg;
	
	String lenBase = "......";
	String len3 = ".......";
	String len2 = ".........";
	String len1 = "..........";
	String len0 = "...........";
	
	if ( name.length() == 3 )
	{
		if ( i != 10)
			reg = i + len3 + name + len3 + puntos;
		else
			reg = i + lenBase + name + len3 + puntos;
	}
	else if ( name.length() == 2 )
	{
		if ( i != 10)
			reg = i + len2 + name + len2 + puntos;
		else
			reg = i + len3 + name + len2 + puntos;
	}
	else if ( name.length() == 1 )
	{
		if ( i != 10)
			reg = i + len1 + name + len1 + puntos;
		else
			reg = i + len2 + name + len1 + puntos;
	}
	else
	{
		if ( i != 10)
			reg = i + len0 + name + len0 + puntos;
		else
			reg = i + len1 + name + len0 + puntos;
	}
	
	return reg;
}
}
