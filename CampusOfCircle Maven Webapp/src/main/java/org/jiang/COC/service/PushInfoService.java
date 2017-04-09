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
	
	public List<PushInfo> findByuserIds(List<Long> userIds);
	
	public void deleteBywbId(long wbId);
	public PushInfo getPushIfoBywbId(long wbId);

}
