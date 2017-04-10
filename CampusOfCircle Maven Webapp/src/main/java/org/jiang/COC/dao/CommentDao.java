package org.jiang.COC.dao;

import java.util.List;

import org.jiang.COC.model.Comment;

/**
 * 
 * @author cherry
 *
 */
public interface CommentDao {
	
	public void saveComment(Comment comment);//保存实体
	public List<Comment> findBywbId(long wbId);//根据weiboId查多条数据
	public Comment getById(long commentId);//根据评论ID查一条数据
	public void deleteComment(Comment comment);//删除实体
}
