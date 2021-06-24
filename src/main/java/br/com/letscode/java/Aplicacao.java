package br.com.letscode.java;

import br.com.letscode.java.dominio.Aluno;
import br.com.letscode.java.dominio.Biblioteca;
import br.com.letscode.java.dominio.Emprestimo;
import br.com.letscode.java.dominio.Livro;
import br.com.letscode.java.dominio.Pessoa;
import br.com.letscode.java.dominio.Professor;
import br.com.letscode.java.excesoes.ExcedeuQuantidadeMaximaLivrosException;
import br.com.letscode.java.excesoes.ProfessorEstourouLimiteLivrosException;
import br.com.letscode.java.view.BibliotecaAplicacao;
import br.com.letscode.java.view.EmprestimoAplicacao;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import java.time.LocalDate;

public class Aplicacao {

    public static void main(String[] args) {

        Aplicacao aplicacao = new Aplicacao();
        //1 - quantidade máxima de livros por empréstimo
//        aplicacao.emprestimoAcimaDoMaximo();
        //2 - o prazo de devolução para empréstimo de aluno é de 10 dias úteis
//        aplicacao.prazoDevolucaoAluno();
        //3 - Aluno não pode realizar mais de um empréstimo
//        aplicacao.variosEmprestimosAluno();
        //4 - Aluno suspenso tentando pegar livro
//        aplicacao.alunoSuspenso();
        //5 - Professor tentando pegar mais livros que o permitido
//        aplicacao.professorLivrosDemais();

        final WeldContainer container = new Weld().initialize();
        final BibliotecaAplicacao bibliotecaAplicacao = container.select(BibliotecaAplicacao.class).get();
//        final EmprestimoAplicacao emprestimoAplicacao = container.select(EmprestimoAplicacao.class).get();
//        aplicacao.prazoDevolucaoAluno(emprestimoAplicacao);
        //5 - Professor tentando pegar mais livros que o permitido com CDU
        aplicacao.professorLivrosDemais(bibliotecaAplicacao);
    }

    /**
     * Tenta instanciar um Empréstimo com a quantidade de Livros acima do máximo permitido
     */
    private void emprestimoAcimaDoMaximo() {
        Professor professor = new Professor();
        Livro[] livros = new Livro[5];
        try {
            Emprestimo emprestimo = new Emprestimo(professor, livros);
            System.out.println(emprestimo);
        } catch (ExcedeuQuantidadeMaximaLivrosException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * O prazo de devolução para empréstimo de aluno é de 10 dias úteis
     *
     */
    private void prazoDevolucaoAluno(EmprestimoAplicacao emprestimoAplicacao) {
        Pessoa aluno = new Aluno();
        Livro[] livros = { new Livro() };
        try {
            final var emprestimo = new Emprestimo(aluno, livros);
//            final LocalDate dataPrevistaDevolucao = emprestimoAplicacao.calcularDataPrevistaDevolucao();
//            System.out.println(dataPrevistaDevolucao);
        } catch (ExcedeuQuantidadeMaximaLivrosException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void variosEmprestimosAluno() {
        Pessoa aluno = new Aluno("Jessé", "123", "jesse@letscode.com.br");
        try {
            var emprestimo = new Emprestimo(aluno, new Livro[]{new Livro()});
            Biblioteca biblioteca = new Biblioteca();
//            biblioteca.adicionarLivro();
//            biblioteca.realizarEmprestimo(emprestimo, biblioteca);
//            biblioteca.realizarEmprestimo(emprestimo, biblioteca);
        } catch (ExcedeuQuantidadeMaximaLivrosException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void alunoSuspenso() {
        Pessoa aluno = new Aluno("Jessé", "123", "jesse@letscode.com.br");
        Biblioteca biblioteca = new Biblioteca();
        try {
            var emprestimo = new Emprestimo(aluno, new Livro[]{new Livro()});
//            biblioteca.realizarEmprestimo(emprestimo);
//            biblioteca.realizarDevolucao(emprestimo);
        } catch (ExcedeuQuantidadeMaximaLivrosException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            var emprestimo = new Emprestimo(aluno, new Livro[]{new Livro()});
//            biblioteca.realizarEmprestimo(emprestimo);
        } catch (ExcedeuQuantidadeMaximaLivrosException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void professorLivrosDemais() {
        Pessoa professor = new Professor("Jessé", "123", "jesse@letscode.com.br");
        try {
            var emprestimo = new Emprestimo(professor, new Livro[]{new Livro(), new Livro(), new Livro()});
            Biblioteca biblioteca = new Biblioteca();
//            biblioteca.realizarEmprestimo(emprestimo);
//            biblioteca.realizarEmprestimo(emprestimo);
        } catch (ExcedeuQuantidadeMaximaLivrosException | ProfessorEstourouLimiteLivrosException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void professorLivrosDemais(BibliotecaAplicacao bibliotecaAplicacao) {
        Pessoa professor = new Professor("Jessé", "123", "jesse@letscode.com.br");
        try {
            var emprestimo = new Emprestimo(professor, new Livro[]{new Livro(), new Livro(), new Livro()});
            Biblioteca biblioteca = new Biblioteca();
            bibliotecaAplicacao.realizarEmprestimo(emprestimo, biblioteca);
//            biblioteca.realizarEmprestimo(emprestimo);
            bibliotecaAplicacao.realizarEmprestimo(emprestimo, biblioteca);
//            biblioteca.realizarEmprestimo(emprestimo);
        } catch (ExcedeuQuantidadeMaximaLivrosException | ProfessorEstourouLimiteLivrosException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
