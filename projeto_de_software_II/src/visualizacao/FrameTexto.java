package visualizacao;

import pacote.PainelTexto;


@SuppressWarnings("serial")
public class FrameTexto extends javax.swing.JFrame {

	private javax.swing.JScrollPane jScrollPane1;
	private PainelTexto panelJtextArea;

	/**
	 * Creates new form FrameTexto
	 */
	public FrameTexto(PainelTexto pTexto) {
		super("Visualização - TEXTO");
		panelJtextArea = pTexto;

		initComponents();
	}

	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();

//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		panelJtextArea.setColumns(20);
		panelJtextArea.setRows(5);
		jScrollPane1.setViewportView(panelJtextArea);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE));

		pack();
	}
}
