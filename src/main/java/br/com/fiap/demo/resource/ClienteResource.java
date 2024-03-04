package br.com.fiap.demo.resource;


import br.com.fiap.demo.entity.Cliente;
import br.com.fiap.demo.repository.ClienteRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteRepository repo;

    @GetMapping
    public List<Cliente> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Cliente findAll(@PathVariable("id") Long id) {
        var ret = repo.findById(id);
        return ret.get();
    }
}
