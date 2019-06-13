package pacote;

import java.util.ArrayList;
import java.util.List;

import entidades.Desenho;
import entidades.Forma;
import formas.Circulo;
import formas.Linha;
import formas.Ponto;
import formas.PontoRepeticao;
import formas.Quadrado;
import formas.Retangulo;
import lista.encadeada.Iterador;
import lista.encadeada.ListaEncadeada;

public class Fabrica {


    public static Desenho criarDesenhoDao (Documento doc, String nomeDesenho){
        Forma forma;
        List<Forma> listaFormas = new ArrayList<>();
        Iterador<FormaGeometrica> i = doc.getIterador();
        FormaGeometrica formaGeometrica;

        while((formaGeometrica = i.proximo()) != null) {
            forma = new Forma();
            forma.setNome( formaGeometrica.toString() );
            forma.setPontos( formaGeometrica.toTextLineBD() );
            listaFormas.add(forma);
        }

        Desenho desenho = new Desenho(nomeDesenho);
        desenho.setListaFormas(listaFormas);

        return desenho;
    }

    public static ListaEncadeada<FormaGeometrica> gerarFormasGeometricas(Desenho desenho) {
        ListaEncadeada<FormaGeometrica> lista = new ListaEncadeada<FormaGeometrica>();

        for (Forma formaDao : desenho.getListaFormas())
        {
            switch ( formaDao.getNome() ){
                case (Ponto.NOME):{
                    String[] str_xy = formaDao.getPontos().split(",");

                    lista.inserirFim( new Ponto(new Integer(str_xy[0]), new Integer(str_xy[1])) );
                }break;

                case (Linha.NOME):{
                    String[] str_pontos = formaDao.getPontos().split("\\|");
                    String[] str_xy = str_pontos[0].trim().split(",");
                    Ponto p = new Ponto( new Integer(str_xy[0]), new Integer(str_xy[1]) );
                    str_xy = str_pontos[1].trim().split(",");
                    Ponto p2 = new Ponto( new Integer(str_xy[0]), new Integer(str_xy[1]) );

                    lista.inserirFim(new Linha( p, p2 ));
                }break;

                case (PontoRepeticao.NOME):{
                    String[] str_pontos = formaDao.getPontos().split("\\|");
                    List<Ponto> lp = new ArrayList<>();

                    for (String str_ponto : str_pontos) {
                        if (! str_ponto.trim().isEmpty()){
                            String[] str_xy = str_ponto.split(",");
                            lp.add(new Ponto(new Integer(str_xy[0].trim()), new Integer(str_xy[1].trim())));
                        }
                    }

                    lista.inserirFim( new PontoRepeticao( lp ) );
                }break;

                case (Quadrado.NOME):{
                    String[] str_pontos = formaDao.getPontos().split("\\|");
                    String[] str_xy = str_pontos[0].trim().split(",");
                    Ponto p = new Ponto( new Integer(str_xy[0]), new Integer(str_xy[1]) );
                    str_xy = str_pontos[1].trim().split(",");
                    Ponto p2 = new Ponto( new Integer(str_xy[0]), new Integer(str_xy[1]) );

                    lista.inserirFim(new Quadrado( p, p2 ));
                }break;

                case (Retangulo.NOME):{
                    String[] str_pontos = formaDao.getPontos().split("\\|");
                    String[] str_xy = str_pontos[0].trim().split(",");
                    Ponto p = new Ponto( new Integer(str_xy[0]), new Integer(str_xy[1]) );
                    str_xy = str_pontos[1].trim().split(",");
                    Ponto p2 = new Ponto( new Integer(str_xy[0]), new Integer(str_xy[1]) );

                    lista.inserirFim(new Retangulo( p, p2 ));
                }break;

                case (Circulo.NOME):{
                    String[] str_pontos = formaDao.getPontos().split("\\|");
                    String[] str_xy = str_pontos[0].trim().split(",");
                    Ponto p = new Ponto( new Integer(str_xy[0]), new Integer(str_xy[1]) );
                    str_xy = str_pontos[1].trim().split(",");
                    Ponto p2 = new Ponto( new Integer(str_xy[0]), new Integer(str_xy[1]) );

                    lista.inserirFim(new Circulo( p, p2 ));
                }break;

                default: break;
            }
        }

        return lista;
    }

}
