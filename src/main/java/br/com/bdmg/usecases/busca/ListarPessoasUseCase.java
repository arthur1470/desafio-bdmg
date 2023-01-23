package br.com.bdmg.usecases.busca;

import br.com.bdmg.model.Pessoa;
import br.com.bdmg.repository.PessoaRepository;

import java.util.Set;
import java.util.stream.Collectors;

public class ListarPessoasUseCase {
    private final PessoaRepository repository = PessoaRepository.getInstance();

    public Set<Pessoa> execute() {
        return repository.findAll().stream()
                .filter(p -> p.getDocumento().length() == 11)
                .collect(Collectors.toSet());
    }
}
