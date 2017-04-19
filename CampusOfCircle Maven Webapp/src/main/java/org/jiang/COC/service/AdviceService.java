package org.jiang.COC.service;








import org.jiang.COC.model.UserAdviceNum;





/**
 * 
 * @author cherry
 *
 */
public interface AdviceService {

	public void saveAdvice(UserAdviceNum userAdviceNum);//保存实体
	public void deleteAdvice(UserAdviceNum userAdviceNum);//删除实体
	public UserAdviceNum getAdvice(long Id);
	public void update(UserAdviceNum userAdviceNum);
	public UserAdviceNum findByUserId(long userId);
	

}
