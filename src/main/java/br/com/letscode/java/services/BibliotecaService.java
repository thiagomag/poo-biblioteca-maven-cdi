package br.com.letscode.java.services;

import br.com.letscode.java.dominio.Biblioteca;
import br.com.letscode.java.dominio.Emprestimo;
import br.com.letscode.java.services.impl.EmprestimoImpl;
import br.com.letscode.java.services.impl.PessoaImpl;


public interface BibliotecaService {

    void realizarEmprestimo(Emprestimo emprestimo, Biblioteca biblioteca);
    void realizarDevolucao(Emprestimo emprestimo, Biblioteca biblioteca, EmprestimoImpl emprestimoImpl, PessoaImpl pessoaImpl);
}
