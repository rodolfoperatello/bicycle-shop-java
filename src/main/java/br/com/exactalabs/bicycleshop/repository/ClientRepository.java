package br.com.exactalabs.bicycleshop.repository;

import br.com.exactalabs.bicycleshop.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {


}
