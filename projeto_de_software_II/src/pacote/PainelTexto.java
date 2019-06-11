package pacote;

import java.awt.Color;

import javax.swing.JTextArea;

import lista.encadeada.Iterador;

@SuppressWarnings("serial")
public class PainelTexto extends JTextArea implements OuvintePaineis{
	
	protected Documento doc;

	public PainelTexto(Documento doc) {
		super(8,15);
		this.doc = doc;
		setBackground(new Color(255,255,255));
	}

	@Override
	public void novaFormaGeometrica(FormaGeometrica forma) {
		doc.inserirFim(forma);
	}

	@Override
	public void atualizar() {
		StringBuffer buf = new StringBuffer();
		Iterador<FormaGeometrica> i = doc.getIterador();
		FormaGeometrica forma;
		while((forma = i.proximo()) != null) {
			buf.append(forma.toTextLine());
			buf.append("\n");
		}
		setText(buf.toString());
	}	
	
}
