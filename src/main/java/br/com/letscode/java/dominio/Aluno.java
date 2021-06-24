package br.com.letscode.java.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Aluno extends Pessoa{

    public static final int QTD_LIVROS = 3;
    private final int PRAZO_DEVOLUCAO_DIAS = 10;

    private LocalDate suspensoAte;

    public Aluno(String email, String matricula, String nome) {
        this.email = email;
        this.matricula = matricula;
        this.nome = nome;
    }
}
