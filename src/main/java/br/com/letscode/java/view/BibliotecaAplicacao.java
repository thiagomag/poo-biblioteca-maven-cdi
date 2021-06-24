package br.com.letscode.java.view;

import br.com.letscode.java.dominio.Biblioteca;
import br.com.letscode.java.dominio.Emprestimo;
import br.com.letscode.java.dominio.Logger;
import br.com.letscode.java.services.BibliotecaService;
import br.com.letscode.java.services.impl.EmprestimoImpl;
import br.com.letscode.java.services.impl.PessoaImpl;
import lombok.NoArgsConstructor;

import javax.inject.Inject;

@NoArgsConstructor
public class BibliotecaAplicacao {


    private BibliotecaService bibliotecaService;
    private Logger logger;


    @Inject
    public BibliotecaAplicacao(BibliotecaService bibliotecaService, Logger logger) {
        this.bibliotecaService = bibliotecaService;
        this.logger = logger;
    }

    public void realizarEmprestimo(Emprestimo emprestimo, Biblioteca biblioteca) {
        System.out.println(this.logger.getTempoFormatado());
        this.bibliotecaService.realizarEmprestimo(emprestimo, biblioteca);
    }
    public void realizarDevolucao(Emprestimo emprestimo, Biblioteca biblioteca, EmprestimoImpl emprestimoImpl, PessoaImpl pessoaImpl) {
        this.bibliotecaService.realizarDevolucao(emprestimo, biblioteca, emprestimoImpl, pessoaImpl);
    }

}
