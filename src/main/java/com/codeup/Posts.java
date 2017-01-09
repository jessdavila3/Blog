package com.codeup;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jessedavila on 1/5/17.
 */
public interface Posts {

    public List<Post> all();
    public Post save(Post post);
}
