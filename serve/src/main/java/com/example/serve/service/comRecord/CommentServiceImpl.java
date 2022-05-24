package com.example.serve.service.comRecord;

import com.example.serve.Dao.CompanyDao;
import com.example.serve.bean.company.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CompanyDao companyDao;

    @Override
    public List<Comment> getCommentByUserIdNoComId(Integer userid, Integer comid) {
        List<Comment> commentArrayList = new ArrayList<>();
        commentArrayList = companyDao.getCommentByUserIdNoComId(userid,comid);
        Collections.sort(commentArrayList, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                return o1.comid - o2.comid;
            }
        });
        return commentArrayList;
    }
    @Override
    public List<Comment> getCommentByUserId(Integer userid) {
        List<Comment> commentArrayList = new ArrayList<>();
        commentArrayList = companyDao.getCommentByUserId(userid);
        Collections.sort(commentArrayList, new Comparator<Comment>() {
            @Override
            public int compare(Comment o1, Comment o2) {
                return o1.comid - o2.comid;
            }
        });
        return commentArrayList;
    }

    @Override
    public Comment getCommentByUserIdAndComId(Integer userid, Integer comid) {
        return companyDao.getCommentByUserIdAndComId(userid,comid);
    }
}
