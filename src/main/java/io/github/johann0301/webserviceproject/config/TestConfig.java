package io.github.johann0301.webserviceproject.config;

import io.github.johann0301.webserviceproject.entities.Category;
import io.github.johann0301.webserviceproject.entities.Order;
import io.github.johann0301.webserviceproject.entities.User;
import io.github.johann0301.webserviceproject.entities.enums.OrderStatus;
import io.github.johann0301.webserviceproject.repositories.CategoryRepository;
import io.github.johann0301.webserviceproject.repositories.OrderRepository;
import io.github.johann0301.webserviceproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category c1 = new Category(null, "Eletronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        User u1 = new User(null, "Maria", "maria@gmail", "999999999", "12345");
        User u2 = new User(null, "João", "joão@gmail", "988888888", "54321");


        Order o1 = new Order(null, Instant.parse("2025-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u1);
        Order o2 = new Order( null, Instant.parse("2025-07-23T16:52:45Z"), OrderStatus.PAID, u1);
        Order o3 = new Order( null, Instant.parse("2025-01-12T11:23:14Z"), OrderStatus.CANCELLED, u2);


        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));

        userRepository.saveAll(Arrays.asList(u1,u2));

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));




    }
}
