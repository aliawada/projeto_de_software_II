package table.model;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Desenho;


public class DesenhoTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;


    private List<Desenho> lista;

    public DesenhoTableModel() {
        lista = new ArrayList<>();
    }

    public DesenhoTableModel(List<Desenho> lista) {
        this.lista = lista;
    }
    
    @Override
    public Class<?> getColumnClass(int coluna) {
        return String.class;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int coluna) {
        switch (coluna) {
            case 0:
                return "ID";
            case 1:
                return "Nome";
            default:
                return "";
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Desenho p = lista.get(linha);
        switch (coluna) {
            case 0:
                return p.getId();
            case 1:
                return p.getNome();
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        Desenho c = lista.get(linha);
        
        switch (coluna) {
            case 0:
                c.equals(valor);
                break;
        }

        fireTableDataChanged();
    }

    public void adiciona(Desenho l) {
        lista.add(l);
        
        fireTableRowsInserted(lista.size() - 1, lista.size() - 1);
    }


    public void remove(int indice) {
        lista.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }


    public int getIndice(Desenho c) {
        return lista.indexOf(c);
    }

    public Desenho getIndice(int i) {
        return lista.get(i);
    }



}
