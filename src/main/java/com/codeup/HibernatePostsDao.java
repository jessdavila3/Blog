//package com.codeup;
//
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
//import javax.persistence.Query;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by jessedavila on 1/6/17.
// */
//public class HibernatePostsDao implements Posts {
//    private Session session;
//
//    public HibernatePostsDao(Session session) {
//        this.session = session;
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public List<Post> all() {
//        return session.createQuery("from Post").list();
//    }
//
//    @Override
//    public Post save(Post post) {
//        Transaction tx = session.beginTransaction();
//        session.save(post);
//        tx.commit();
//        return post;
//    }
//
//    public Post find(long id) {
//        Transaction tx = session.beginTransaction();
//        Post post;
//        post = session.get(Post.class, id);
//        session.save(post);
//        tx.commit();
//        return post;
//    }
//
//    public void update(Post existingPost) {
//        Transaction tx = session.beginTransaction();
//        session.update(existingPost);
//        tx.commit();
//    }
//
//    public void delete(Post post) {
//        Transaction tx = session.beginTransaction();
//        session.delete(post);
//        tx.commit();
//    }
//}
