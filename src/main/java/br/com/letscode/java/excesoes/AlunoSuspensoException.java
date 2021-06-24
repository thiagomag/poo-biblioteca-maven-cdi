package br.com.letscode.java.excesoes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AlunoSuspensoException extends RuntimeException {

    public AlunoSuspensoException(String matricula, LocalDate suspensoAte) {
        super(
            String.format("O Aluno matrícula %s está suspenso de novos empréstimos até %s.",
                matricula, suspensoAte.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
        );
    }
}
