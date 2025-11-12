package io.github.johann0301.webserviceproject.resources;

import io.github.johann0301.webserviceproject.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "maria", "maria@gmail", "83993333333", "maria123");
        return ResponseEntity.ok().body(u);
    }
}
