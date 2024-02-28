package br.com.fiap.demo.repository;

import br.com.fiap.demo.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {

    public List<Telefone> findByClienteId(Long idCliente);
}
