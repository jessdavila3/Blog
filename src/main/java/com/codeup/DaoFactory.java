//package com.codeup;
//
///**
// * Created by jessedavila on 1/5/17.
// */
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//public class DaoFactory {
//    private static HibernatePostsDao postsDao;
//
//    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//    private static Session session = sessionFactory.openSession();
//
//
//    public static HibernatePostsDao getPostsDao() {
//        if (postsDao == null) {
//            postsDao = new HibernatePostsDao(session); // I think i'm supposed to pass the session object I just made into this ListPosts instance
//            //except it should be a HibernatePostsDAO instead of ListPosts.
//        }
//        return postsDao;
//    }
//}
