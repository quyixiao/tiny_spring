package com.jdbc;

import java.util.List;

public interface UserSerivce {

    public void save(User user);

    public List<User> getUsers();
}
