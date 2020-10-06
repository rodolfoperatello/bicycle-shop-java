package br.com.exactalabs.bicycleshop.repository;

import br.com.exactalabs.bicycleshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
