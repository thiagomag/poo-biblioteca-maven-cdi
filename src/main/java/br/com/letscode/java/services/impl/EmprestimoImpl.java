package br.com.letscode.java.services.impl;

import br.com.letscode.java.dominio.Emprestimo;
import br.com.letscode.java.services.EmprestimoService;

import javax.inject.Named;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Named
public class EmprestimoImpl implements EmprestimoService {

    /**
     * Regra "dataInicio + prazo (Aluno/Professor)"
     * @return a data estimada para devolução
     */
    public LocalDate calcularDataPrevistaDevolucao(Emprestimo emprestimo, PessoaImpl pessoa) {
        var date = emprestimo.getDataInicio();
        var prazoEmDias = pessoa.getPrazoDevolucaoDias(emprestimo.getPessoa());
        int contDiasUteis = 0;

        while (contDiasUteis < prazoEmDias) {
            date = date.plusDays(1);
            boolean fimDeSemana = date.getDayOfWeek().equals(DayOfWeek.SATURDAY)
                    || date.getDayOfWeek().equals(DayOfWeek.SUNDAY);

            if (!fimDeSemana && !emprestimo.getFeriados().contains(date)) {
                contDiasUteis++;//dia útil
            }
        }
        return date;
    }


}
