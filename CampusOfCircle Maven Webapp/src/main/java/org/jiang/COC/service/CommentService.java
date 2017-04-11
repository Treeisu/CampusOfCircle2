package org.jiang.COC.service;

import java.util.List;

import org.jiang.COC.model.Comment;
import org.jiang.COC.model.PushInfo;






/**
 * Comment的service层
 * @author cherry
 *
 */
public interface CommentService {

	public void saveComment(Comment comment,PushInfo pushInfo);//保存实体
	public List<Comment> findCommentsBywbId(long wbId);//根据weiboId查多条数据
	public Comment getCommentBycommentId(long commentId);//根据评论ID查一条数据
	public void deleteComment(long commentId,PushInfo pushInfo);//删除实体

}
