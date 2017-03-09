package org.jiang.COC.service;

import org.jiang.COC.common.Page;
import org.jiang.COC.model.Student;



public interface StudentService {

	/**
	 * 根据查询条件，查询学生分页信�?
	 * 
	 * @param searchModel
	 *            封装查询条件
	 * @param pageNum
	 *            查询第几页数�?
	 * @param pageSize
	 *            每页显示多少条记�?
	 * @return 查询结果
	 */
	public Page<Student> findStudent(Student searchModel, int pageNum,int pageSize);
}
