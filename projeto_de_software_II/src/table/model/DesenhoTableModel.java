package table.model;


import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entidades.Desenho;


public class DesenhoTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;


    private List<Desenho> lista;

    public DesenhoTableModel() {
        // no construtor, instanciamos o List
        lista = new ArrayList<>();
    }

    public DesenhoTableModel(List<Desenho> lista) {
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
        Desenho p = lista.get(linha);
        // façamos um switch
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
        // aqui devemos atualizar o valor de nossos Clientes
        // vemos em qual linha ele está
        Desenho c = lista.get(linha);
        // e vemos o que será atualizado
        switch (coluna) {
            case 0:
                c.equals(valor);
                break;
        }

        // é importante notificar os listeners a cada alteração
        fireTableDataChanged();
    }

    // ==============================================================
    // Até aqui seria o mínimo necessário para um TableModel funcional, mas
    // ainda não há métodos para adicionar, remover ou resgatar objetos. Vamos
    // criá-los.
    // ==============================================================


    public void adiciona(Desenho l) {
        lista.add(l);
        // informamos os listeners que a linha (size - 1) foi adicionada
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
