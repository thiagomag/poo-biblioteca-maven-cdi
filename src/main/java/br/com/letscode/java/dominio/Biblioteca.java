package br.com.letscode.java.dominio;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Biblioteca {

    private final List<Livro> livros = new ArrayList<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();


    public Biblioteca() {
        this.livros.add(new Livro(
                8550804622L, "Java efetivo", "Joshua Bloch", "Alta Books", true));
        this.livros.add(new Livro(
                8576082675L, "Código limpo", "Robert C. Martin", "Alta Books", true));
        this.livros.add(new Livro(
                8573933755L, "Estruturas De Dados E Algoritmos Em Java",
                "Robert Lafore", "CIENCIA MODERNA", true));
        this.livros.add(new Livro(
                8573076100L, "Padrões de Projetos",
                "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "Bookman", true));
        this.livros.add(new Livro(
                8575227246L, "Refatoração", "Martin Fowler", "Novatec Editora", true));
        this.livros.add(new Livro(
                8575223305L, "Introdução às Expressões Regulares",
                "Michael Fitzgerald", "Novatec Editora", true));
    }
}
