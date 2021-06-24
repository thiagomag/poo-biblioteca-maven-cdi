package br.com.letscode.java.excesoes;

public class AlunoJaTemEmprestrimoEmAndamentoException extends RuntimeException {

    public AlunoJaTemEmprestrimoEmAndamentoException(String matricula) {
        super("O Aluno de matrícula " + matricula + " já possui um empréstimo em andamento");
    }
}
