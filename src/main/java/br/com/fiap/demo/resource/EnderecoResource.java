package br.com.fiap.demo.resource;

import br.com.fiap.demo.entity.Endereco;
import br.com.fiap.demo.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping(value = "/enderecos")
@RestController
public class EnderecoResource {

    @Autowired
    private EnderecoRepository repo;

    @GetMapping(value = "/{cep}")
    public List<Endereco> findByCep(@PathVariable String cep) {
        return repo.findByCep(cep);
    }

}
