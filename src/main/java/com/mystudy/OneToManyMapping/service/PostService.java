/**
 * 
 */
package com.mystudy.OneToManyMapping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.OneToManyMapping.dao.PostDao;
import com.mystudy.OneToManyMapping.model.Post;

/**
 * @author om
 *
 */
@Service
public class PostService {
	@Autowired
	PostDao postDao;
	
	public Post save(Post post) {
		//return postDao.save(post);
		return postDao.saveCascadePersist(post);
	}

	public Post find(long postId) {
		return postDao.find(postId);
	}

}
