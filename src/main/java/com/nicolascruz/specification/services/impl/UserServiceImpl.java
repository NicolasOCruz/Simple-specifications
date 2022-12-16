package com.nicolascruz.specification.services.impl;

import com.nicolascruz.specification.models.User;
import com.nicolascruz.specification.repositories.UserRepository;
import com.nicolascruz.specification.repositories.specification.Filter;
import com.nicolascruz.specification.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.nicolascruz.specification.repositories.specification.Filter.createSpecification;
import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> find(List<Filter> filters) {
        //call the query with the specifications
        return userRepository.findAll(getSpecificationFromFilters(filters));
    }

    private Specification<User> getSpecificationFromFilters(List<Filter> filter) {
        //receive a list of filters and mount the specifications
        //can
        Specification<User> specification = where(createSpecification(filter.remove(0)));
        for (Filter input : filter) {
            specification = specification.and(createSpecification(input));
        }
        return specification;
    }
}
