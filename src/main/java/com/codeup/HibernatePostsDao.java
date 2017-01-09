package com.codeup;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jessedavila on 1/6/17.
 */
public class HibernatePostsDao implements Posts {
    private Session session;

    public HibernatePostsDao(Session session) {
        this.session = session;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Post> all() {
        return session.createQuery("from Post").list();
    }

    @Override
    public Post save(Post post) {
        Transaction tx = session.beginTransaction();
        session.save(post);
        tx.commit();
        return post;
    }

    public Post find(long id) {
        //Post post = (Post) session.get(Post.class, id);
        //return post;
        Query query = session.createQuery("");
    }

    public void update(Post exisitingPost) {

    }

    public void delete(long id) {

    }
}
