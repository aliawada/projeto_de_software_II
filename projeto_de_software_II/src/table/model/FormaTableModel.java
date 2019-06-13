package table.model;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Forma;


public class FormaTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private List<Forma> lista;
    

    public FormaTableModel() {
        lista = new ArrayList<>();
    }

    public FormaTableModel(List<Forma> lista) {
        this.lista = lista;
    }

    @Override
    public Class<?> getColumnClass(int coluna) {
        return String.class;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int coluna) {
        // vamos retornar o nome de cada coluna
        switch (coluna) {
            case 0:
                return "ID";
            case 1:
                return "Nome";
            case 2:
                return "Pontos";
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
        Forma p = lista.get(linha);
        switch (coluna) {
            case 0:
                return p.getId();
            case 1:
                return p.getNome();
            case 2:
                return p.getPontos();
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
        Forma c = lista.get(linha);
        switch (coluna) {
            case 0:
                c.equals(valor);
                break;
        }

        fireTableDataChanged();
    }

}
