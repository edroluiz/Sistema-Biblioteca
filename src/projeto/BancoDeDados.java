package projeto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    public static final String ARQUIVO_LIVROS = "biblioteca.txt";

    public List<Livro> recuperaLivrosDeArquivo() throws IOException {
        List<Livro> listaLivros = new ArrayList<>();
        List<String> textoLivros = this.recuperaTextoDeArquivo(ARQUIVO_LIVROS);
        for (String linha: textoLivros){
            String[] dadosLinha = linha.split("#");
            Livro l = new Livro(dadosLinha[0], dadosLinha[1], dadosLinha[2], dadosLinha[3], dadosLinha[4]);
            listaLivros.add(l);
        }
        return listaLivros;
    }

    public void gravaLivrosEmArquivo(List<Livro> livros) throws IOException {
        List<String> livrosTxt = new ArrayList<>();
        for (Livro c: livros) {
            String linha = c.getNome() + "#" +
            c.getEditora() + "#" +
            c.getAutor() + "#" +
            c.getCategoria() + "#" +
            c.getPaginas();
            livrosTxt.add(linha);
        }
        this.gravaTextoEmArquivo(livrosTxt, ARQUIVO_LIVROS);
    }

    public List<String> recuperaTextoDeArquivo(String nomeArquivo) throws IOException {

        BufferedReader leitor = null;
        List<String> textoLido = new ArrayList<>();
        try {
            leitor = new BufferedReader(new FileReader(nomeArquivo));
            String texto = null;

            do {
                texto = leitor.readLine();

                if (texto != null){
                    textoLido.add(texto);
                }

            } while (texto != null);

        } finally {

            if(leitor != null) {
                leitor.close();
            }

        }
        return textoLido;

    }

    public void gravaTextoEmArquivo(List<String> texto, String nomeArquivo) throws IOException{

        BufferedWriter gravador = null;
        try {
            gravador = new BufferedWriter((new FileWriter(nomeArquivo)));
            for (String c: texto){
                gravador.write(c + "\n");
            }
        } finally {
            if (gravador != null){
                gravador.close();
            }
        }

    }
    
}
