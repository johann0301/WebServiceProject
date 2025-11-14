package io.github.johann0301.webserviceproject.config;

import io.github.johann0301.webserviceproject.entities.Order;
import io.github.johann0301.webserviceproject.entities.User;
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

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria", "maria@gmail", "999999999", "12345");
        User u2 = new User(null, "João", "joão@gmail", "988888888", "54321");


        Order o1 = new Order(u1, null, Instant.parse("2025-06-20T19:53:07Z"));
        Order o2 = new Order(u1, null, Instant.parse("2025-07-23T16:52:45Z"));
        Order o3 = new Order(u2, null, Instant.parse("2025-01-12T11:23:14Z"));

        userRepository.saveAll(Arrays.asList(u1,u2));

        orderRepository.saveAll(Arrays.asList(o1,o2,o3));


    }
}
