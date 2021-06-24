package br.com.letscode.java.dominio;

import br.com.letscode.java.excesoes.ExcedeuQuantidadeMaximaLivrosException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Emprestimo {
    private static final int QTD_MAXIMA_LIVROS = 3;
    private final List<LocalDate> feriados = getListFeriados();

    private Pessoa pessoa;
    private Livro[] livros;
    private final LocalDate dataInicio = LocalDate.now();
    private LocalDate dataDevolucao;//data efetiva de devolução

    public Emprestimo(Pessoa pessoa, Livro[] livros) throws ExcedeuQuantidadeMaximaLivrosException { //duvida
        this.pessoa = pessoa;
        this.livros = livros;

        if (livros.length > QTD_MAXIMA_LIVROS) {
            throw new ExcedeuQuantidadeMaximaLivrosException(livros.length, QTD_MAXIMA_LIVROS);
        }
    }

    private static List<LocalDate> getListFeriados() {
        List<LocalDate> datas = new ArrayList<>();
        datas.add(LocalDate.of(2021, 1, 1));
        datas.add(LocalDate.of(2021, 5, 1));
        datas.add(LocalDate.of(2021, 4, 21));
        datas.add(LocalDate.of(2021, 10, 12));
        datas.add(LocalDate.of(2021, 11, 15));
        datas.add(LocalDate.of(2021, 11, 2));
        datas.add(LocalDate.of(2021, 12, 25));
        datas.add(LocalDate.of(2021, 9, 7));
        datas.add(LocalDate.of(2021, 6, 3));
        return datas;
    }



}
