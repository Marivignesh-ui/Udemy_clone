package com.ps.repository;

import java.util.List;

import com.ps.domain.User;

public interface UserRepository {
    public User create(User user);
    public List<User> getUsers();
}
