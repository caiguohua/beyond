package com.mongodb.cgh.dao;

import com.mongodb.cgh.bean.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao extends MongoRepository<Comment,String> {
}
