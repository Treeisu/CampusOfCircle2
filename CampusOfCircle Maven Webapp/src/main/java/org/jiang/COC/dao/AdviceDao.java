package org.jiang.COC.dao;








import org.jiang.COC.model.UserAdviceNum;

/**
 * 
 * @author cherry
 *
 */
public interface AdviceDao {
	
	public void saveAdvice(UserAdviceNum userAdviceNum);//保存实体
	public void deleteAdvice(UserAdviceNum userAdviceNum);//删除实体
	public void updateAdvice(UserAdviceNum userAdviceNum);//删除实体
	public UserAdviceNum getAdvice(long Id);
	public UserAdviceNum findByUserId(long userId);
	
}
