package br.com.bdmg.repository;

import br.com.bdmg.model.Pessoa;
import br.com.bdmg.model.PessoaJuridica;

import java.util.*;

public final class PessoaRepository {

    private static PessoaRepository instance;
    private final Map<String, Pessoa> pessoas;

    private PessoaRepository() {
        this.pessoas = new HashMap<>();
    }

    public static PessoaRepository getInstance() {
        if (instance == null) instance = new PessoaRepository();

        return instance;
    }

    public Pessoa save(final Pessoa pessoa) {
        this.pessoas.put(pessoa.getDocumento(), pessoa);
        return pessoa;
    }

    public void saveAll(final Set<Pessoa> pessoa) {
        pessoa.forEach(this::save);
    }

    public boolean existsByDocument(final String document) {
        return this.pessoas.containsKey(document);
    }

    public Optional<Pessoa> findByDocument(final String document) {
        return Optional.ofNullable(this.pessoas.get(document));
    }

    public void deleteByDocument(final String document) {
        findByDocument(document).ifPresent(pessoa -> {
            pessoas.values().stream()
                    .filter(PessoaJuridica.class::isInstance)
                    .forEach(p -> ((PessoaJuridica) p).removerSocio(pessoa));

            this.pessoas.remove(document);
        });
    }

    public Set<Pessoa> findAll() {
        return new HashSet<>(this.pessoas.values());
    }
}
