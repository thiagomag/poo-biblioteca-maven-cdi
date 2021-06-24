package br.com.letscode.java.dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Professor extends Pessoa {

    public static final int QTD_LIVROS = 5;
    protected final int PRAZO_DEVOLUCAO_DIAS = 20;

    public Professor(String email, String matricula, String nome) {
        this.email = email;
        this.matricula = matricula;
        this.nome = nome;
    }
}
