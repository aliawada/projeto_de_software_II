/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizacao;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import lista.encadeada.Iterador;
import pacote.Documento;
import pacote.FormaGeometrica;
import pacote.OuvintePaineis;

/**
 *
 * @author suga
 */
public class FrameTabela extends javax.swing.JFrame implements OuvintePaineis {

    private Documento doc;

    /**
     * Creates new form FrameTabela
     */
    public FrameTabela(Documento doc) {
        super("Visualização - TABELA");
        this.doc = doc;
        initComponents();
    }

    @Override
    public void atualizar() {
        StringBuffer buf = new StringBuffer();
        Iterador<FormaGeometrica> i = doc.getIterador();
        FormaGeometrica forma;

        //PREENCHENDO A TABELA
        DefaultTableModel model = new DefaultTableModel();
        jTableFormas.setModel(model);
        jTableFormas.setAutoCreateRowSorter(true);
//        sorter = new TableRowSorter<TableModel>(model);
//        jTableFormas.setRowSorter(sorter);

        //colunas
        model.addColumn("Forma");
        model.addColumn("Pontos");
        //dados (linhas)
        while((forma = i.proximo()) != null) {
            model.insertRow( model.getRowCount() ,
                    new Object[]{
                        forma.toString(),
                        forma.getStrPosition().replace( forma.toString()+" ", "" ),
                    }
            );
        }

        TableColumnModel tcm = jTableFormas.getColumnModel();
        tcm.getColumn(0).setMinWidth(50);
        tcm.getColumn(1).setMinWidth(500);

//        jTableFormas.sizeColumnsToFit(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
    }

    @Override
    public void novaFormaGeometrica(FormaGeometrica forma) {

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFormas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTableFormas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableFormas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFormas;
    // End of variables declaration//GEN-END:variables
}
