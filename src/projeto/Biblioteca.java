package projeto;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Biblioteca {
    public static void main(String[] args){
      
        JOptionPane.showMessageDialog(null, "BEM-VINDO(A) A BIBLIOTECA\nAPERTE NO BOTÃO ABAIXO PARA ACESSAR O SISTEMA...");
        SistemaBiblioteca sistema;
        sistema = new SistemaBiblioteca();

        boolean continuar = true;
        while(continuar){
            String escolha = JOptionPane.showInputDialog(
                "Escolha uma das opções:\n"+
                "1.Ver lista de todos os livros da biblioteca\n"+
                "2.Cadastrar um novo livro\n"+
                "3.Pesquisar livro por categoria\n"+
                "4.Remover livro\n"+
                "5.Salvar dados\n"+
                "6.Sair\n");

            if(escolha.equals("1")){

                String lista = sistema.listaDosLivros("");
			    JOptionPane.showMessageDialog(null, lista.toString());

            } else if(escolha.equals("2")){

                String nome = JOptionPane.showInputDialog("Qual nome do livro?");
                String editora = JOptionPane.showInputDialog("Qual editora do livro " + nome + "?");
                String autor = JOptionPane.showInputDialog("Qual do(a) autor(a) do livro " + nome + "?");
                String categoria = JOptionPane.showInputDialog("Qual a categoria do livro " + nome + "?");
                String paginas = JOptionPane.showInputDialog(null, "Quantas páginas tem o livro " + nome + "?");

                Livro livro = new Livro(nome, editora, autor, categoria, paginas);

                try {
                    sistema.cadastrarLivro(livro);
                    JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!\nAntes de sair não esqueça de salvar na opção 5.");
                } catch (LivroJaExisteException e) {
                    JOptionPane.showMessageDialog(null, "Problema no cadastro. " + e.getMessage());
                    e.printStackTrace();
                }
        
            } else if(escolha.equals("3")){

                String categoria = JOptionPane.showInputDialog(null, "Por qual categoria deseja pesquisar?");

                ArrayList<Livro> lista = sistema.pesquisarLivrosPorCategorias(categoria);

                if (lista.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Infelizmente não encontrado nenhuma categoria com esse nome. Tente novamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "Esses são os livros cadastrados na categoria " + categoria + ":\n" + sistema.pesquisarLivrosPorCategorias(categoria));
                }

            } else if(escolha.equals("4")){

                String nome = JOptionPane.showInputDialog(null, "Qual nome do livro que deseja remover?");
                String editora = JOptionPane.showInputDialog(null, "Informe o nome da editora do livro que deseja remover");

                boolean remover = sistema.removerLivro(nome, editora);

                if (remover){
                    JOptionPane.showMessageDialog(null, "Livro removido com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Infelizmente houve um problema na remoção do livro " + nome + ". Verifique se o livro realmente existe e tente novamente.");
                }

            } else if(escolha.equals("5")){
                sistema.salvarDados();
            } else if(escolha.equals("6")){
                continuar = false;
                sistema.salvarDados();
                JOptionPane.showMessageDialog(null, "FIM DO PROGRAMA!");
            } else {
                JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA!");
            }
        }
    }
}
