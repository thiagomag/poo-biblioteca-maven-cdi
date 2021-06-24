package br.com.letscode.java.excesoes;

public class ExcedeuQuantidadeMaximaLivrosException extends Exception {

    public ExcedeuQuantidadeMaximaLivrosException(int qtdInformada, int qtdMaxima) {
        super(String.format("A quantidade máxima de livros por empréstimo foi excedida. "
                + "Quantidade %d onde limite é %d.", qtdInformada, qtdMaxima));
    }
}
