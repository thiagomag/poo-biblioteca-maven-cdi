package br.com.letscode.java.services.impl;

import br.com.letscode.java.dominio.Aluno;
import br.com.letscode.java.dominio.Pessoa;
import br.com.letscode.java.services.PessoaService;

import javax.inject.Named;

@Named
public class AlunoImpl extends PessoaImpl{

    @Override
    public int getPrazoDevolucaoDias(Pessoa pessoa) {
        Aluno alunor = (Aluno) pessoa;
        return alunor.getPRAZO_DEVOLUCAO_DIAS();
    }
}