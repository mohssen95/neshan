package com.example.foodi.repo;

import com.example.foodi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepoitory extends JpaRepository<User,Long> {
    User findUserByUserId(Long userId);
    List<User>getAllByName(String name);

}
