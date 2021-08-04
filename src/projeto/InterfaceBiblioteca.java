package projeto;
import java.util.ArrayList;

// INTERFACE
public interface InterfaceBiblioteca {

    public abstract boolean verificarLivro(String nome, String editora, String autor);

    public abstract void cadastrarLivro(Livro livro) throws LivroJaExisteException;

    public ArrayList<Livro> pesquisarLivrosPorCategorias(String categoria);

    public String listaDosLivros(String paginas);

    public boolean removerLivro(String nome, String editora);

    public void recuperarDados();

    public void salvarDados();
    
}
