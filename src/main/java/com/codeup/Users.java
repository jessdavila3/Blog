package com.codeup;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by jessedavila on 1/10/17.
 */
public interface Users extends CrudRepository<User, Long> {
    public User findByUsername(String username);
    // does something go here to save users?
}
