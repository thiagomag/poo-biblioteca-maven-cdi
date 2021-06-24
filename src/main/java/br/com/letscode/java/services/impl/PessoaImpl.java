package br.com.letscode.java.services.impl;

import br.com.letscode.java.dominio.Pessoa;
import br.com.letscode.java.services.PessoaService;

public abstract class PessoaImpl implements PessoaService {

    public abstract int getPrazoDevolucaoDias(Pessoa pessoa);
}
