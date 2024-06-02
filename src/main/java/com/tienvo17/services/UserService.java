package com.tienvo17.services;

import com.tienvo17.models.User;



public interface UserService {
    User findByUserName(String username);
}
