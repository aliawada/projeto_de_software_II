package visualizacao;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import connection.ConexaoMySQL;
import dao.DesenhoDAO;
import entidades.Desenho;
import entidades.Forma;
import pacote.MeuFrame;
import table.model.DesenhoTableModel;
import table.model.FormaTableModel;

@SuppressWarnings("serial")
public class FrameBancoDeDados extends javax.swing.JFrame {
	
    private  MeuFrame pai;
    private List<Desenho> listaDesenhos;
    private ConexaoMySQL mySQL;

    private boolean detailsVisible = false;

    public FrameBancoDeDados( MeuFrame pai, ConexaoMySQL mySQL) {
        this.mySQL = mySQL;
        this.pai = pai;
        initComponents();

        mySQL.conectar();
        listaDesenhos = new DesenhoDAO(mySQL.getConexao()).consultaTodos();
        mySQL.desconectar();

        this.preencheTabela();
    }

    private void preencheTabela() {
        jTableFormas.setModel( new DesenhoTableModel(listaDesenhos) );
//        jTableFormas.setModel( new FormaDaoTableModel( listaDesenhos.get(0).getListaFormas() ));


        //double click na tabela p/ trocar info
        jTableFormas.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                //s'o funga quando tem linha
                //                int row = jTableFormas.getSelectedRow();

                //funciona mesmo quando nao tem linha
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);

                if (mouseEvent.getClickCount() == 2) {

                    if (detailsVisible){
                        jTableFormas.setModel( new DesenhoTableModel(listaDesenhos) );
                        detailsVisible = false;

                    }else{
                        List<Forma> lista = listaDesenhos.get( row ).getListaFormas();
                        jTableFormas.setModel( new FormaTableModel( lista ));
                        detailsVisible = true;
                    }
                }
            }
        });

    }

    private void btnAbrirActionPerformed(java.awt.event.ActionEvent evt) {
        if (jTableFormas.getSelectedRow() < 0 && !detailsVisible){
        	JOptionPane.showMessageDialog(null,"Selecione algum desenho");
            return;
        }

        pai.abreDesenho( listaDesenhos.get( jTableFormas.getSelectedRow() ) );
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFormas = new javax.swing.JTable();
        btnAbrir = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTableFormas);

        btnAbrir.setText("Abrir");
        btnAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnAbrir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFormas;
    // End of variables declaration//GEN-END:variables
}
