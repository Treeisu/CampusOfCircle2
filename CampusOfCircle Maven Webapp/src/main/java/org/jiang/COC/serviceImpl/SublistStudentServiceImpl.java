package org.jiang.COC.serviceImpl;

import javax.annotation.Resource;




import org.jiang.COC.common.Page;
import org.jiang.COC.dao.StudentDao;
import org.jiang.COC.model.Student;
import org.jiang.COC.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("sublistStudentServiceImpl")
public class SublistStudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;
	private Page<Student> result;
	public Page<Student> findStudent(Student searchModel, int pageNum,int pageSize) {
		result = studentDao.findStudent(searchModel, pageNum,pageSize);
		return result;
	}
}
