package com.example.serve.service.comRecord;

import com.example.serve.bean.company.Comment;

import java.util.List;

public interface CommentService {
    Comment getCommentByUserIdAndComId(Integer userid, Integer comid);
    List<Comment> getCommentByUserIdNoComId(Integer userid, Integer comid);
    List<Comment> getCommentByUserId(Integer userid);
}
