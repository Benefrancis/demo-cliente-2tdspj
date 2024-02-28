package br.com.fiap.demo.resource;


import br.com.fiap.demo.entity.Cliente;
import br.com.fiap.demo.entity.Endereco;
import br.com.fiap.demo.entity.Telefone;
import br.com.fiap.demo.repository.ClienteRepository;
import br.com.fiap.demo.repository.EnderecoRepository;
import br.com.fiap.demo.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteRepository repo;

    @Autowired
    private EnderecoRepository enderecoRepository;


    @Autowired
    private TelefoneRepository telefoneRepository;

    @GetMapping
    public List<Cliente> findAll() {
        return repo.findAll();
    }

    @Transactional
    @PostMapping
    public Cliente persist(@RequestBody Cliente cliente) {
        Cliente save = repo.save(cliente);
        return save;
    }

    @GetMapping(value = "/{id}")
    public Cliente findAll(@PathVariable("id") Long id) {
        var ret = repo.findById(id);
        return ret.get();
    }

    @GetMapping(value = "/{id}/endereco")
    public List<Endereco> findEndereco(@PathVariable("id") Long id) {
        return enderecoRepository.findByClienteId(id);
    }

    @Transactional
    @PostMapping(value = "/{id}/endereco")
    public Endereco persistEndereco(@PathVariable("id") Long id, @RequestBody Endereco endereco) {
        var cliente = repo.findById(id).get();
        endereco.setCliente(cliente);
        var save = enderecoRepository.save(endereco);
        return save;
    }

    @GetMapping(value = "/{id}/telefone")
    public List<Telefone> findTelefone(@PathVariable("id") Long id) {
        return telefoneRepository.findByClienteId(id);
    }

    @Transactional
    @PostMapping(value = "/{id}/telefone")
    public Telefone persistTelefone(@PathVariable("id") Long id, @RequestBody Telefone telefone) {
        var cliente = repo.findById(id).get();
        telefone.setCliente(cliente);
        var save = telefoneRepository.save(telefone);
        return save;
    }

}
