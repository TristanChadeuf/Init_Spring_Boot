package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserDao extends JpaRepository<User, Long>{

}



