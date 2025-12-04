package io.github.johann0301.webserviceproject.services;

import io.github.johann0301.webserviceproject.dto.OrderDTO;
import io.github.johann0301.webserviceproject.entities.Order;
import io.github.johann0301.webserviceproject.entities.OrderItem;
import io.github.johann0301.webserviceproject.entities.Product;
import io.github.johann0301.webserviceproject.entities.User;
import io.github.johann0301.webserviceproject.entities.enums.OrderStatus;
import io.github.johann0301.webserviceproject.repositories.OrderItemRepository;
import io.github.johann0301.webserviceproject.repositories.OrderRepository;
import io.github.johann0301.webserviceproject.repositories.ProductRepository;
import io.github.johann0301.webserviceproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<Order> findAll(){
        return repository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }

    @Transactional
    public Order createOrder(OrderDTO orderDTO) {
        // Find client
        User client = userRepository.findById(orderDTO.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + orderDTO.getClientId()));

        // Create order
        Order order = new Order();
        order.setMoment(Instant.now());
        order.setOrderStatus(OrderStatus.WAITING_PAYMENT);
        order.setClient(client);

        // Save order first to get ID
        order = repository.save(order);

        // Create order items
        Double total = 0.0;
        for (OrderDTO.OrderItemDTO itemDTO : orderDTO.getItems()) {
            Product product = productRepository.findById(itemDTO.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + itemDTO.getProductId()));

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setQuantity(itemDTO.getQuantity());
            orderItem.setPrice(product.getPrice());

            orderItemRepository.save(orderItem);

            // Calculate total
            total += product.getPrice() * itemDTO.getQuantity();
        }

        // Update order total (if you have a total field)
        // order.setTotal(total);
        // repository.save(order);

        return order;
    }
}

