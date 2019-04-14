package com.mongodb.cgh.dao;

import com.mongodb.cgh.bean.Comment;
import com.mongodb.cgh.bean.KeyValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.MapReduceOptions;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDalImpl implements CommentDal{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Comment> getAll() {
        return mongoTemplate.findAll(Comment.class);
    }

    @Override
    public Comment getById(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query,Comment.class);
    }

    @Override
    public Comment addComment(Comment comment) {
        mongoTemplate.save(comment);
        return comment;
    }

    @Override
    public Object getAllTags(String id) {
        Comment comment = getById(id);
        return comment != null ? comment.getTags() : "Comment not found";
    }

    @Override
    public String addTag(String id, String key, String values) {
        Comment comment = getById(id);
        if(comment != null){
            comment.getTags().put(key,values);
            mongoTemplate.save(comment);
            return "Key Added";
        }else{
            return "Comment not  found";
        }
    }

    @Override
    public String starAnalysis() {
        final String map = "function() {emit(this.star, 1);}";
        final String reduce = "function(name, count) {return Array.sum(count);}";
        final String COLLECTION_NAME = "comment";

        MapReduceOptions options = MapReduceOptions.options();
        options.outputCollection("countStar");
        options.outputTypeReduce();

        MapReduceResults<KeyValuePair> results = mongoTemplate.mapReduce(COLLECTION_NAME,map,reduce,KeyValuePair.class);

        StringBuilder stats = new StringBuilder();
        for(KeyValuePair result : results){
            stats.append(result.toString());
        }

        return stats.toString();
    }
}
