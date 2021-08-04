package projeto;

public class Livro {
    private String nome;
    private String editora;
    private String autor;
    private String categoria;
    private String paginas;

    public Livro(){
        this("", "", "", "", "");
    }

    public Livro(String nome, String editora, String autor, String categoria, String paginas){
        this.nome = nome;
        this.editora = editora;
        this.autor = autor;
        this.categoria = categoria;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Livro other = (Livro) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString(){
        return "Nome: "+ this.nome + " | Editora: " + this.editora + " | Autor: " + this.autor + " | Categoria: "+ this.categoria + " | Número de páginas: " + this.paginas;
    }
   
}
