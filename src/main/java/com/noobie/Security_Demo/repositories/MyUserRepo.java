package com.noobie.Security_Demo.repositories;

import com.noobie.Security_Demo.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}
