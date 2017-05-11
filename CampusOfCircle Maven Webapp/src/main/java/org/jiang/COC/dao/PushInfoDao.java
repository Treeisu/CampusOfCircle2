package org.jiang.COC.dao;

import java.util.List;

import org.jiang.COC.model.PushInfo;


/**
 * 
 * @author cherry
 *
 */
public interface PushInfoDao {
	/***
	 * 用户发布动态
	 * @param user
	 */
	public void savePushInfo(PushInfo pushInfo);
	public void updatePushInfo(PushInfo pushInfo);
	public List<PushInfo> findByuserIds(List<Long> list);
	public List<PushInfo> findByuserId(long userId);
	public PushInfo getPushIfoBywbId(long wbId);
	public List<PushInfo> getPushIfoBywbIds(List<Long> list);
	public void deletePushInfo(PushInfo pushInfo);
}
