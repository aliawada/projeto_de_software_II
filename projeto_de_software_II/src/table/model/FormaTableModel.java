package table.model;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Forma;


public class FormaTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    private List<Forma> lista;
    

    public FormaTableModel() {
        // no construtor, instanciamos o List
        lista = new ArrayList<>();
    }

    public FormaTableModel(List<Forma> lista) {
//        this();
//        this.lista.addAll(lista);

        this.lista = lista;
    }

    // ==============================================================
    // Métodos implementados.
    // ==============================================================

    @Override
    public Class<?> getColumnClass(int coluna) {
        // todas as colunas representam uma String
        return String.class;
    }

    @Override
    public int getColumnCount() {
        // esse método deve retornar o número de colunas. No caso, 3 (uma para o
        // nome, uma para o sobrenome e uma para o apelido).
        return 4;
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
            case 3:
                return "Criação";
            default:
                return ""; // isso jamais deve ocorrer
        }
    }

    @Override
    public int getRowCount() {
        // retorna o número de linhas, ou seja, a quantidade de entradas na
        // nossa lista.
        return lista.size();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        // vai retornar o valor de determinada célula. A linha representa a
        // posição do Cliente na nossa lista e a coluna vai ser: 1 - nome, 2 -
        // sobrenome e 3 - apelido
        // primeiro vamos pegar o Cliente da linha
        Forma p = lista.get(linha);
        // façamos um switch
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
        // aqui devemos atualizar o valor de nossos Clientes
        // vemos em qual linha ele está
        Forma c = lista.get(linha);
        // e vemos o que será atualizado
        switch (coluna) {
            case 0:
                c.equals(valor);
                break;
        }

        // é importante notificar os listeners a cada alteração
        fireTableDataChanged();
    }





}
