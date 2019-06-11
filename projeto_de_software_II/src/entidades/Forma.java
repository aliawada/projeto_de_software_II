package entidades;

public class Forma {
    private int id;
    private int desenho_id;

    private String nome;
    private String pontos;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDesenho_id() {
        return desenho_id;
    }

    public void setDesenho_id(int desenho_id) {
        this.desenho_id = desenho_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPontos() {
        return pontos;
    }

    public void setPontos(String pontos) {
        this.pontos = pontos;
    }
}
