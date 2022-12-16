package com.nicolascruz.specification.services;

import com.nicolascruz.specification.models.User;
import com.nicolascruz.specification.repositories.specification.Filter;

import java.util.List;

public interface UserService {

    List<User> find(List<Filter> filters);

    //List<User> find(String field, QueryOperator operator, List<String> values);
}
