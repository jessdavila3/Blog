//package com.codeup;
//
//import java.util.ArrayList;
//
///**
// * Created by jessedavila on 1/5/17.
// */
//public class ListPosts implements Posts {
//    private ArrayList<Post> posts;
//    //store Post objects in an array
//
//    public ListPosts() {
//        posts = new ArrayList<>();
//    }
//
//    public ArrayList<Post> all() {
//        return posts;
//    }
//
//    @Override
//    public Post save(Post post) {
//        post.setId(posts.size() + 1);
//        posts.add(post);
//        return null;
//    }
//
//    public Post find(long id) {
//        return null;
//    }
//
//    public void update(Post existingPost) {
//
//    }
//
//    @Override
//    public void delete(Post post) {
//
//    }
//}
