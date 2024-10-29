package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

@Repository
public class UserDaoImpl {

    public static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1L, "Tristan", "Chadeuf", 31032000, 1));
        users.add(new User(2L, "Antoine", "Donnat", 31032000, 2));
        users.add(new User(3L, "Moumen", "buffala", 31032000, 3));
    }

    public List<User> findAll() {
        return users;
    }


    public User findById(Long id) {
        for (User user : users) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }


    public User save(User user) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Boolean> isValid = restTemplate.getForEntity("http://127.0.0.1:8081/licenses/" + user.getNumeroPermis(),
                    Boolean.class, user.getNumeroPermis());


            if (Boolean.TRUE.equals(isValid.getBody())) {
                users.add(user);
                return user;
            } else {
                throw new Exception("permis not valid");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public User update(Long id, User user) {
        for (User updateUser : users) {
            if (Objects.equals(updateUser.getId(), id)) {
                updateUser.setId(user.getId());
                updateUser.setPrenom(user.getPrenom());
                updateUser.setNom(user.getNom());
                updateUser.setDateNaissance(user.getDateNaissance());
                updateUser.setNumeroPermis(user.getNumeroPermis());
            }
        }
        return user;
    }



    public User delete(@PathVariable Long id) {
        users.removeIf(user -> Objects.equals(user.getId(), id));
        return null;
    }
}