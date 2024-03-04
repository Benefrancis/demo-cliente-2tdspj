package br.com.fiap.demo.repository;

import br.com.fiap.demo.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByClienteId(Long idCliente);

    List<Endereco> findByCep(String cep);

}
