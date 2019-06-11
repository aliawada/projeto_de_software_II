package pacote;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entidades.Desenho;
import entidades.Forma;
import formas.Circulo;
import formas.Lapis;
import formas.Linha;
import formas.Ponto;
import formas.Retangulo;
import formas.Triangulo;
import lista.encadeada.Iterador;

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

    public static List<FormaGeometrica> gerarFormasGeometricas(byte[] fileContent) {
        List<FormaGeometrica> lista = new ArrayList<>();

        for (int i=0; i< fileContent.length; ){
            switch ( fileContent[i] ){
                case (Ponto.ID):{
                    byte[] formaArray = Arrays.copyOfRange(fileContent, i, i+5);

                    lista.add( new Ponto( formaArray ));

                    i+= 5;
                }break;

                case (Lapis.ID):{
                    //pega tamanho
                    byte[] tam = Arrays.copyOfRange(fileContent, i+1, i+3);

                    ByteBuffer bb_aux = ByteBuffer.allocate( 2 );
                    bb_aux.put(tam[0]);//tamanho vet pontos
                    bb_aux.put(tam[1]);//tamanho vet pontos
                    int tamanho = bb_aux.getShort(0);//tamanho vet pontos

                    //aloca 1 p/ ID, 2 P/ tamanho, 4*tamanho p/ cada ponto
                    int num_alloc = 1 + 2 + 4 * tamanho;

                    byte[] formaArray = Arrays.copyOfRange(fileContent, i, i + num_alloc);
                    lista.add( new Lapis( formaArray ));

                    i+= num_alloc;
                }break;

                case (Linha.ID):{
                    byte[] formaArray = Arrays.copyOfRange(fileContent, i, i + 9);
                    lista.add( new Linha( formaArray ));

                    i+= 9;
                }break;

                case (Triangulo.ID):{
                    byte[] formaArray = Arrays.copyOfRange(fileContent, i, i + 9);
                    lista.add( new Triangulo( formaArray ));

                    i+= 9;
                }break;

                case (Retangulo.ID):{
                    byte[] formaArray = Arrays.copyOfRange(fileContent, i, i + 9);
                    lista.add( new Retangulo( formaArray ));

                    i+= 9;
                }break;

                case (Circulo.ID):{
                    byte[] formaArray = Arrays.copyOfRange(fileContent, i, i + 9);
                    lista.add( new Circulo( formaArray ));

                    i+= 9;
                }break;

                default: break;
            }
        }

        return lista;
    }

    public static List<FormaGeometrica> gerarFormasGeometricas(Desenho desenho) {
        List<FormaGeometrica> lista = new ArrayList<>();

        for (Forma formaDao : desenho.getListaFormas())
        {
            switch ( formaDao.getNome() ){
                case (Ponto.NOME):{
                    String[] str_xy = formaDao.getPontos().split(",");

                    lista.add( new Ponto(new Integer(str_xy[0]), new Integer(str_xy[1])) );
                }break;

                case (Linha.NOME):{
                    String[] str_pontos = formaDao.getPontos().split("\\|");
                    String[] str_xy = str_pontos[0].trim().split(",");
                    Ponto p = new Ponto( new Integer(str_xy[0]), new Integer(str_xy[1]) );
                    str_xy = str_pontos[1].trim().split(",");
                    Ponto p2 = new Ponto( new Integer(str_xy[0]), new Integer(str_xy[1]) );

                    lista.add(new Linha( p, p2 ));
                }break;

                case (Lapis.NOME):{
                    String[] str_pontos = formaDao.getPontos().split("\\|");
                    List<Ponto> lp = new ArrayList<>();

                    for (String str_ponto : str_pontos) {
                        if (! str_ponto.trim().isEmpty()){
                            String[] str_xy = str_ponto.split(",");
                            lp.add(new Ponto(new Integer(str_xy[0].trim()), new Integer(str_xy[1].trim())));
                        }
                    }

                    lista.add( new Lapis( lp ) );
                }break;

                case (Triangulo.NOME):{
                    String[] str_pontos = formaDao.getPontos().split("\\|");
                    String[] str_xy = str_pontos[0].trim().split(",");
                    Ponto p = new Ponto( new Integer(str_xy[0]), new Integer(str_xy[1]) );
                    str_xy = str_pontos[1].trim().split(",");
                    Ponto p2 = new Ponto( new Integer(str_xy[0]), new Integer(str_xy[1]) );
                    str_xy = str_pontos[2].trim().split(",");
                    Ponto p3 = new Ponto( new Integer(str_xy[0]), new Integer(str_xy[1]) );

                    lista.add(new Triangulo( p, p2, p3 ));
                }break;

                case (Retangulo.NOME):{
                    String[] str_pontos = formaDao.getPontos().split("\\|");
                    String[] str_xy = str_pontos[0].trim().split(",");
                    Ponto p = new Ponto( new Integer(str_xy[0]), new Integer(str_xy[1]) );
                    str_xy = str_pontos[1].trim().split(",");
                    Ponto p2 = new Ponto( new Integer(str_xy[0]), new Integer(str_xy[1]) );

                    lista.add(new Retangulo( p, p2 ));
                }break;

                case (Circulo.NOME):{
                    String[] str_pontos = formaDao.getPontos().split("\\|");
                    String[] str_xy = str_pontos[0].trim().split(",");
                    Ponto p = new Ponto( new Integer(str_xy[0]), new Integer(str_xy[1]) );
                    str_xy = str_pontos[1].trim().split(",");
                    Ponto p2 = new Ponto( new Integer(str_xy[0]), new Integer(str_xy[1]) );

                    lista.add(new Circulo( p, p2 ));
                }break;

                default: break;
            }
        }

        return lista;
    }

    public static FormaGeometrica criarFormaGeom_porTexto(String linha) {

        //se linha eh lixo (ou apenas tem o nome sem pontos, ou eh lixo mesmo)
        if (linha.length() < 3)
            return null;

        switch ( linha.split(" ")[0] ){

            case (Ponto.NOME):{
                String px, py;
                px = linha.split(" ")[1];
                py = linha.split(" ")[2];
                int x = Integer.valueOf(px);
                int y = Integer.valueOf(py);

                return new Ponto(x, y);
            }

            case (Linha.NOME):{
                int x = Integer.valueOf(linha.split(" ")[1]);
                int y = Integer.valueOf(linha.split(" ")[2]);
                int x2 = Integer.valueOf(linha.split(" ")[3]);
                int y2 = Integer.valueOf(linha.split(" ")[4]);

                Ponto p = new Ponto( x, y );
                Ponto p2 = new Ponto( x2, y2 );
                return new Linha( p, p2 );
            }

            case (Lapis.NOME):{
                String[] str_pontos = linha.split(" ");
                List<Ponto> lp = new ArrayList<>();

                for (int i=1; i<str_pontos.length; i+=2){
                    if (! str_pontos[i].isEmpty()){
                        int x = Integer.valueOf( str_pontos[i] );
                        int y = Integer.valueOf( str_pontos[i+1] );
                        lp.add(new Ponto(x, y));
                    }
                }
                return new Lapis( lp );
            }

            case (Triangulo.NOME):{
                int x = Integer.valueOf(linha.split(" ")[1]);
                int y = Integer.valueOf(linha.split(" ")[2]);
                int x2 = Integer.valueOf(linha.split(" ")[3]);
                int y2 = Integer.valueOf(linha.split(" ")[4]);
                int x3 = Integer.valueOf(linha.split(" ")[5]);
                int y3 = Integer.valueOf(linha.split(" ")[6]);
                
                Ponto p = new Ponto( x, y );
                Ponto p2 = new Ponto( x2, y2 );
                Ponto p3 = new Ponto( x3, y3 );
                return new Triangulo( p, p2, p3 );
            }

            case (Retangulo.NOME):{
                int x = Integer.valueOf(linha.split(" ")[1]);
                int y = Integer.valueOf(linha.split(" ")[2]);
                int x2 = Integer.valueOf(linha.split(" ")[3]);
                int y2 = Integer.valueOf(linha.split(" ")[4]);

                Ponto p = new Ponto( x, y );
                Ponto p2 = new Ponto( x2, y2 );
                return new Retangulo( p, p2 );
            }

            case (Circulo.NOME):{
                int x = Integer.valueOf(linha.split(" ")[1]);
                int y = Integer.valueOf(linha.split(" ")[2]);
                int x2 = Integer.valueOf(linha.split(" ")[3]);
                int y2 = Integer.valueOf(linha.split(" ")[4]);

                Ponto p = new Ponto( x, y );
                Ponto p2 = new Ponto( x2, y2 );
                return new Circulo( p, p2 );
            }

            default: return null;
        }
    }


}
