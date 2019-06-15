package com.transaction;


import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {


     void save(User user) throws Exception;
}
