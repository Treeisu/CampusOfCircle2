package org.jiang.COC.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jiang.COC.common.Constant;
import org.jiang.COC.common.Page;
import org.jiang.COC.dao.StudentDao;
import org.jiang.COC.model.Student;
import org.springframework.stereotype.Repository;




@Repository
public class SublistStudentDaoImpl implements StudentDao {
	private SessionFactory sessionFactory;
	private Session session;
	@Resource
	private Page<Student> pager;
	
	

	public Page<Student> findStudent(Student searchModel, int pageNum,int pageSize) {
		List<Student> allStudenList = getAllStudent(searchModel);
		pager.setCurrentPage(pageNum);
		pager.setPageSize(pageSize);
		pager.setListShow(allStudenList);
		return pager;
	}

	/**
	 * 妯′豢鑾峰彇鎵?湁鏁版嵁
	 * 
	 * @param searchModel
	 *            鏌ヨ鍙傛暟
	 * @return 鏌ヨ缁撴灉
	 */
	@SuppressWarnings("unchecked")
	private  List<Student> getAllStudent(Student searchModel) {
		 session=sessionFactory.openSession();
		List<Student> result = new ArrayList<Student>();
		String hql1 = "from Student and stuName";
		String hql2 = "from Student and stuName like :myname";
		String hql3 = "from Student and gender like :mygender";
		String hql4 = "from Student and stuName like :myname and gender=:mygender";
		
		String stuName = searchModel.getStuName();
		int gender = searchModel.getGender();
		
		if((stuName != null && !stuName.equals(""))&&(gender == Constant.GENDER_FEMALE || gender == Constant.GENDER_MALE)){
			Query query= session.createQuery(hql4);
			query.setString("myname", stuName);
			query.setParameter("mygender", gender);
			result=query.list();
			session.close();
		}
		else if (!(stuName != null && !stuName.equals(""))&&(gender == Constant.GENDER_FEMALE || gender == Constant.GENDER_MALE)) {
			Query query= session.createQuery(hql3);
			query.setParameter("mygender", gender);
			result=query.list();
			session.close();
		}
		else if (!(stuName != null && !stuName.equals(""))&&!(gender == Constant.GENDER_FEMALE || gender == Constant.GENDER_MALE)) {
			Query query= session.createQuery(hql2);
			query.setString("myname", stuName);
			result=query.list();
			session.close();
		}
		else{
			Query query= session.createQuery(hql1);
			result=query.list();
			session.close();
		}
		return result;
	}
}
