package br.com.letscode.java.services.impl;

import br.com.letscode.java.dominio.Aluno;
import br.com.letscode.java.dominio.Biblioteca;
import br.com.letscode.java.dominio.Emprestimo;
import br.com.letscode.java.dominio.Livro;
import br.com.letscode.java.dominio.Pessoa;
import br.com.letscode.java.dominio.Professor;
import br.com.letscode.java.excesoes.AlunoJaTemEmprestrimoEmAndamentoException;
import br.com.letscode.java.excesoes.AlunoSuspensoException;
import br.com.letscode.java.excesoes.EmprestimoNaoEncontradoException;
import br.com.letscode.java.excesoes.LivroNaoDisponivelException;
import br.com.letscode.java.excesoes.ProfessorEstourouLimiteLivrosException;
import br.com.letscode.java.services.BibliotecaService;

import javax.inject.Named;
import java.time.LocalDate;
import java.time.Period;

@Named
public class BibliotecaServiceImpl implements BibliotecaService {


    public void realizarEmprestimo(Emprestimo emprestimo, Biblioteca biblioteca) {
        //1 - verificar se é Aluno ou Professor
        //2 - checar se o livro está disponível
        //3 - checar se é possível realizar o empréstimo
        this.livrosEstaoTodosDisponiveis(emprestimo.getLivros());
        String matricula = emprestimo.getPessoa().getMatricula();
        if (emprestimo.getPessoa() instanceof Aluno) {
            boolean existeEmprestimoEmAndamento = this.existeEmprestimoEmAndamento(matricula, biblioteca);
            if (existeEmprestimoEmAndamento) {
                throw new AlunoJaTemEmprestrimoEmAndamentoException(matricula);
            }
            var aluno = (Aluno) emprestimo.getPessoa();
            final var suspensoAte = aluno.getSuspensoAte();
            if (suspensoAte != null && suspensoAte.isAfter(LocalDate.now())) {
                throw new AlunoSuspensoException(matricula, suspensoAte);
            }
        } else if (emprestimo.getPessoa() instanceof Professor) {
            int totalLivrosEmprestados = 0;
            for (Emprestimo emp : biblioteca.getEmprestimos()) {
                if (emp.getPessoa().getMatricula().equals(emprestimo.getPessoa().getMatricula())
                        && emp.getDataDevolucao() == null) {
                    totalLivrosEmprestados += emp.getLivros().length;
                }
            }
            if (emprestimo.getLivros().length + totalLivrosEmprestados > Professor.QTD_LIVROS) {
                throw new ProfessorEstourouLimiteLivrosException(totalLivrosEmprestados);
            }
        }
        biblioteca.getEmprestimos().add(emprestimo);
        System.out.println("Empréstimo com sucesso.");
    }

    private void livrosEstaoTodosDisponiveis(Livro[] livros) {
        for (Livro livro : livros) {
            if (! livro.isDisponivel()) {
                throw new LivroNaoDisponivelException(livro);
            }
        }
    }

    private boolean existeEmprestimoEmAndamento(String matricula, Biblioteca biblioteca) {
        for (Emprestimo emprestimo : biblioteca.getEmprestimos()) {
            final Pessoa pessoaEmprestimo = emprestimo.getPessoa();
            final String pessoaEmprestimoMatricula = pessoaEmprestimo.getMatricula();
            if (emprestimo.getDataDevolucao() == null && pessoaEmprestimoMatricula.equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    public void realizarDevolucao(Emprestimo emprestimo, Biblioteca biblioteca, EmprestimoImpl emprestimoImpl, PessoaImpl pessoaImpl) {
        if (! biblioteca.getEmprestimos().contains(emprestimo)) {
            throw new EmprestimoNaoEncontradoException();
        }
        final var dataPrevistaDevolucao = emprestimoImpl.calcularDataPrevistaDevolucao(emprestimo, pessoaImpl);
        final LocalDate hoje = LocalDate.now().plusDays(20);
        if (hoje.isAfter(dataPrevistaDevolucao) && emprestimo.getPessoa() instanceof Aluno) {
            aplicarSuspensaoNoAluno(emprestimo, dataPrevistaDevolucao, hoje);
        }
        emprestimo.setDataDevolucao(hoje);
        for (Livro livro : emprestimo.getLivros()) {
            livro.setDisponivel(true);
        }
    }

    private void aplicarSuspensaoNoAluno(Emprestimo emprestimo, LocalDate dataPrevistaDevolucao, LocalDate dataEfetivaDevolucao) {
        //Realizando o cast de Pessoa para Aluno, para poder acessar o método "setSuspensoAte"
        Aluno aluno = (Aluno) emprestimo.getPessoa();
        //https://www.baeldung.com/java-date-difference
        final int diasAtraso = Period.between(dataPrevistaDevolucao, dataEfetivaDevolucao).getDays();
        LocalDate suspensoAte = dataEfetivaDevolucao.plusDays(diasAtraso);
        aluno.setSuspensoAte(suspensoAte);
    }
}
