package br.com.letscode.java.services;

import br.com.letscode.java.dominio.Emprestimo;
import br.com.letscode.java.services.impl.PessoaImpl;

import java.time.LocalDate;

public interface EmprestimoService {

    LocalDate calcularDataPrevistaDevolucao(Emprestimo emprestimo, PessoaImpl pessoa);
}