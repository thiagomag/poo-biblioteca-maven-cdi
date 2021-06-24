package br.com.letscode.java.view;

import br.com.letscode.java.dominio.Emprestimo;
import br.com.letscode.java.services.EmprestimoService;
import br.com.letscode.java.services.impl.PessoaImpl;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import java.time.LocalDate;

@NoArgsConstructor
public class EmprestimoAplicacao {

    @Inject
    private EmprestimoService emprestimoService;

    public EmprestimoAplicacao(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    LocalDate calcularDataPrevistaDevolucao(Emprestimo emprestimo, PessoaImpl pessoa) {
        return this.emprestimoService.calcularDataPrevistaDevolucao(emprestimo, pessoa);
    }
}
