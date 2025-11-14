package io.github.johann0301.webserviceproject.repositories;

import io.github.johann0301.webserviceproject.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
