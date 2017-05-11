package org.jiang.COC.service;

import java.util.List;

import org.jiang.COC.model.PushInfo;





/**
 * PushInfo类的service层
 * @author cherry
 *
 */
public interface PushInfoService {

	public void savePushInfo(PushInfo pushInfo);
	public void updatePushInfo(PushInfo pushInfo);
	public List<PushInfo> findByuserIds(List<Long> userIds,long uid);
	public List<PushInfo> findByuserId(long userId);
	public void deleteBywbId(long wbId);
	public PushInfo getPushIfoBywbId(long uid,long wbId);
	public List<PushInfo> getPushIfosBywbIds(long uid,List<Long> wbIds);

}
