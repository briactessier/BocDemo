package com.fdorval.bocdemo.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdorval.bocdemo.dao.FireBaseDao;
import com.fdorval.bocdemo.model.Student;
import com.fdorval.bocdemo.util.exception.TechnicalException;

@Service
public class BocBusiness {

	@Autowired 
	FireBaseDao fireBaseDao;
	
	
	/**
	 * la liste des étudiants
	 * @return
	 * @throws TechnicalException
	 */
    public List<Student> getStudents() throws TechnicalException {
		return fireBaseDao.getStudents();
    }
    
    /**
     * la note moyenne
     * @return
     * @throws TechnicalException
     */
    public Integer  getAverageGrade() throws TechnicalException {
		 List<Student> students = fireBaseDao.getStudents();
		 Integer totalGrades = 0;
	
		 for(Student student:students) {
			 totalGrades+=student.getGrade();
		 }
		 return totalGrades/students.size();
    }
}