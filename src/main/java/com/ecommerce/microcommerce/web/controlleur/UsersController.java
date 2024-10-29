package com.ecommerce.microcommerce.web.controlleur;

import com.ecommerce.microcommerce.dao.UserDao;
import com.ecommerce.microcommerce.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UsersController {



   //CONSTRUCTOR*******************************************************************************************************
    private final UserDao userDao;
    @Autowired

    public UsersController(UserDao userDao) {
        this.userDao = userDao;

    }

    //ROUTE ALL USERS***************************************************************************************************
    @GetMapping("/user")
    public List<User> AllUsers() {
        return userDao.findAll();
    }

    //ROUTE USERS ID****************************************************************************************************

    @GetMapping(value = "/user/{id}")
    public User afficherUnProduit(@PathVariable Long id) {
        return userDao.findById(id).orElse(null);
    }

    //ROUTE CREATE USER*************************************************************************************************
    @PostMapping(value="/user")
    public User ajouterUnClient(@RequestBody User user) {

        return userDao.save(user);

    }

    @PutMapping(value = "/user/{id}")
   public User modifierUnClient(@PathVariable Long id , @RequestBody User user) {
        user.setId(id);
        return userDao.save(user);
    }

    @DeleteMapping(value = "/user/{id}")
    public void supprimerUnClient(@PathVariable Long id) {
         userDao.deleteById(id);
    }

}