package com.codeup;

import org.hibernate.Session;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jessedavila on 1/5/17.
 */
public interface Posts extends CrudRepository<Post, Long> {

//    public List<Post> all();
//    public Post save(Post post);
//    public Post find(long id);
//    public void update(Post existingPost);
//    public void delete(Post post);

}
