/**
 * 
 */
package com.mystudy.OneToManyMapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mystudy.OneToManyMapping.dao.CommentDao;
import com.mystudy.OneToManyMapping.dao.PostDao;
import com.mystudy.OneToManyMapping.model.Comment;

/**
 * @author om
 *
 */
//@Service
@Transactional
@Component
public class CommentService {
	@Autowired
	CommentDao commentDao;
	@Autowired
	PostDao postDao;
	
	public Comment save(Comment comment) throws Exception {
		return commentDao.save(comment);
	}

	public Comment find(long commentId) {
		return commentDao.findById(commentId);
	}

	//@Transactional(rollbackFor = { Exception.class })
	//(propagation = Propagation.REQUIRES_NEW)
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<Comment> saveAll(List<Comment> comments, long postId){
			/*Post post = postDao.find(postId);
			comments.forEach(c -> {
				c.setPost(post);
			});*/
		try {
			return commentDao.saveAll(comments, postId);
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Comment> findCommentsByPostId(long postId) {
		return commentDao.findCommetsByPostId(postId);
	}

}
