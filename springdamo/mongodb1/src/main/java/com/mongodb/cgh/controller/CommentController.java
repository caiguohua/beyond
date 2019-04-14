package com.mongodb.cgh.controller;

import com.mongodb.cgh.bean.Comment;
import com.mongodb.cgh.dao.CommentDal;
import com.mongodb.cgh.dao.CommentDao;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")  //根域名
public class CommentController {

    private final CommentDao commentDao;

    private final CommentDal commentDal;

    public CommentController(CommentDao commentDao, CommentDal commentDal) {
        this.commentDao = commentDao;
        this.commentDal = commentDal;
    }

    /**
     * JPA
     * @return
     */
    @GetMapping
    public List<Comment> getAllComments(){
        return commentDao.findAll();
    }

    @GetMapping("/{commentId}")
    public Comment getComment(@PathVariable String commentId){
        return commentDao.findById(commentId).orElse(null);
    }

    @GetMapping("/{commentId}/tags")
    public Object getAllTags(@PathVariable String commentId){
        Comment comment = commentDao.findById(commentId).orElse(null);
        if(comment != null){
            return comment.getTags();
        }else{
            return "Comment not found";
        }
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment){    //通过封装数据体传给后端
        return commentDao.save(comment);
    }


    /**
     * MongoTemplate 写 query
     * @return
     */

    @GetMapping("/all")
    public List<Comment> getAll(){
        return commentDal.getAll();
    }

    @GetMapping("/get/{commentId}")
    public Comment getById(@PathVariable String commentId){
        return commentDal.getById(commentId);
    }

    @GetMapping("/get/{commentId}/tags")
    public Object getTagsById(@PathVariable String commentId){
        return commentDal.getAllTags(commentId);
    }

    @PostMapping("/add")
    public Comment addComment(@RequestBody Comment comment){
        return commentDal.addComment(comment);
    }

    @PostMapping("/{commentId}/tag/{key}/{value}")
    public String addTag(@PathVariable String commentId,@PathVariable String key,@PathVariable String value){
        return commentDal.addTag(commentId,key,value);
    }

    @GetMapping("/stats/star")
    public String countStar(){
        return commentDal.starAnalysis();
    }
}
