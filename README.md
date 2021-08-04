## Bem-vindo(a) ao Sistema Biblioteca! 👋🏼

A linguagem utilizada nesse projeto foi `Java`. 

## O que me motivou a realizar esse projeto?

Esse sistema foi desenvolvido para finalização da disciplina de **LP(Linguagem de Programação)**, na Universidade Federal da Paraíba.<br>Nesse projeto adquirir diversos conhecimentos como:

- `POO`
- `Herança`
- `Polimorfismo`
- `Persistência de Dados`
- `Interfaces`

## Principal ideia do projeto:

Para realização do sistema, foi pensado o que seria possivel fazer para facilitar o gerenciamento de uma biblioteca.<br>Então, foi desenvolvido um sistema no qual o usuário tem a possibilidade de:

- `Adicionar um novo livro`
- `Pesquisar livros por categorias`
- `Ver a lista de todos os livros`
- `Remover um livro`
- `Salvar da dados`

## Alguns trechos do sistema:

```java
public class SistemaBiblioteca implements InterfaceBiblioteca{

    private List<Livro> livros;
    BancoDeDados gravador;

    public SistemaBiblioteca(){
        this.livros = new ArrayList<>();
        this.gravador = new BancoDeDados();
        this.recuperarDados();
    }

    @Override
    public boolean verificarLivro(String nome, String editora, String autor) {
        for (Livro c: this.livros){
            if (c.getNome().equals(nome) && c.getEditora().equals(editora) && c.getAutor().equals(autor)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void cadastrarLivro(Livro livro) throws LivroJaExisteException {
        boolean jaExiste = false;
        for (Livro c: this.livros){
            if(c.equals(livro)){
                jaExiste = true;
                break;
            }
        }
        if (jaExiste){
            throw new LivroJaExisteException("Já existe um livro cadastrado com nome " + livro.getNome());
        } else {
            this.livros.add(livro);
        }
    }

    @Override
    public ArrayList<Livro> pesquisarLivrosPorCategorias(String categoria) {
        ArrayList<Livro> categorias = new ArrayList<Livro>();
        for (final Livro l : this.livros) {
            if (l.getCategoria().equals(categoria)) {
                categorias.add(l);
            }
        }
        return categorias;
    }

    @Override
	public String listaDosLivros(String paginas) {
		String ListaDeLivros = "";
		for (Livro l: this.livros) {
			ListaDeLivros += l + "\n";
		}
		return ListaDeLivros;
	}
   

    @Override
    public boolean removerLivro(String nome, String editora) {
        for (Livro l: this.livros){
            if (l.getNome().equals(nome) && l.getEditora().equals(editora)){
                this.livros.remove(l);
                return true;
            }
        }
        return false;
    }

    @Override
    public void recuperarDados() {
        try {
            this.livros = gravador.recuperaLivrosDeArquivo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void salvarDados() {
        try {
            this.gravador.gravaLivrosEmArquivo(this.livros);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
```

Espero que tenho gostado desse projeto.<br>
Agradeço o interesse! 😁
