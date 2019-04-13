package com.mongodb.cgh.dao;

import com.mongodb.cgh.bean.Comment;

import java.util.List;

public interface CommentDal {
    List<Comment> getAll();

    Comment getById(String id);

    Comment addComment(Comment comment);

    Object getAllTags(String id);

    String addTag(String id,String key,String values);

    String starAnalysis();
}
