package entidades;

import java.util.List;

public class Desenho {
    private int id;
    private String nome;

    private List<Forma> listaFormas;

    public Desenho() {
    }

    public Desenho(String nome ) {
        this.nome = nome;
    }

    public List<Forma> getListaFormas() {
        return listaFormas;
    }

    public void setListaFormas(List<Forma> listaFormas) {
        this.listaFormas = listaFormas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
