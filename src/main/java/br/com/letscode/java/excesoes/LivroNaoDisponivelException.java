package br.com.letscode.java.excesoes;

import br.com.letscode.java.dominio.Livro;

public class LivroNaoDisponivelException extends RuntimeException {

    public LivroNaoDisponivelException(Livro livro) {
        super("O livro " + livro.getTitulo() + " não está disponível.");
    }
}
