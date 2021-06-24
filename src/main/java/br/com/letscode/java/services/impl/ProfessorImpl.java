package br.com.letscode.java.services.impl;

import br.com.letscode.java.dominio.Pessoa;
import br.com.letscode.java.dominio.Professor;
import br.com.letscode.java.services.PessoaService;

import javax.inject.Named;

@Named
public class ProfessorImpl implements PessoaService {

    @Override
    public int getPrazoDevolucaoDias(Pessoa pessoa) {
        if(pessoa instanceof Professor) {
            Professor professor = (Professor) pessoa;
            return professor.getPRAZO_DEVOLUCAO_DIAS();
        }
        return 0;
    }
}
