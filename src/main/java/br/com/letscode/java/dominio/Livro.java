package br.com.letscode.java.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Livro {

    private Long isbn;
    private String titulo;
    private String autor;
    private String editora;
    private boolean disponivel = true;

}
