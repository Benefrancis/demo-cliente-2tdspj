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

    @GetMapping(value = "/{id}")
    public Cliente findAll(@PathVariable("id") Long id) {
        var ret = repo.findById(id);
        return ret.get();
    }

    @Transactional
    @PostMapping
    public Cliente persist(@RequestBody Cliente cliente) {
        return repo.save(cliente);
    }

    @Transactional
    @PostMapping(value = "/{idCliente}/enderecos")
    public Endereco persistEndereco(@PathVariable("idCliente") Long idCliente, @RequestBody Endereco endereco) {
        Cliente cliente = repo.findById(idCliente).orElseThrow();
        endereco.setCliente(cliente);
        return enderecoRepository.save(endereco);
    }

    @GetMapping(value = "/{idCliente}/enderecos")
    public List<Endereco> getEndereco(@PathVariable("idCliente") Long idCliente) {
        return enderecoRepository.findByClienteId(idCliente);
    }

    @GetMapping(value = "/{idCliente}/telefones")
    public List<Telefone> findByClienteId(@PathVariable("idCliente") Long idCliente) {
        return telefoneRepository.findByClienteId(idCliente);
    }

    @Transactional
    @PostMapping(value = "/{idCliente}/telefones")
    public Telefone persistTelefone(@PathVariable("idCliente") Long idCliente, @RequestBody Telefone telefone) {
        Cliente cliente = repo.findById(idCliente).orElseThrow();
        telefone.setCliente(cliente);
        return telefoneRepository.save(telefone);
    }

}
