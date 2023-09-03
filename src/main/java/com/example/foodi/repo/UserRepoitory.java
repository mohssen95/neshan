package com.example.foodi.repo;

import com.example.foodi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepoitory extends JpaRepository<User,Long> {
    User findUserByUserId(Long userId);
    List<User>getAllByName(String name);


    @Query(value = "select w from  User w where w.username =?1")
    public User findUserByUserName(String username);
    @Modifying
    @Query(value = "update User u set u.username=:uname where u.userId=:id")
    void editUsername(@Param("id") long id, @Param("uname") String uname);



}
