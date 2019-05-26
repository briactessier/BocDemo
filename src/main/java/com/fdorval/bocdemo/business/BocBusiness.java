package com.fdorval.bocdemo.business;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fdorval.bocdemo.dao.FireBaseDao;
import com.fdorval.bocdemo.dao.impl.FireBaseDaoImpl;
import com.fdorval.bocdemo.model.Student;
import com.fdorval.bocdemo.util.exception.TechnicalException;

@Service
public class BocBusiness {

	Logger LOG = LoggerFactory.getLogger(BocBusiness.class);

	
	@Autowired 
	FireBaseDao fireBaseDao;
	
	
	/**
	 * la liste des étudiants
	 * @param filterLimitGrade! : si true on enlève les redoublants
	 * @return
	 * @throws TechnicalException
	 */
    public List<Student> getStudents(String filterLimitGradeStr) throws TechnicalException {
		if (StringUtils.isEmpty(filterLimitGradeStr)) {
	    	LOG.info("getStudents sans filtre");
			List<Student> students = fireBaseDao.getStudents();
			return students;
		}else {
			int filterLimitGrade = Integer.parseInt(filterLimitGradeStr);
	    	LOG.info("getStudents avec filtre : "+filterLimitGrade);
			//ici filter les students dont la note est <10
			throw new TechnicalException("Erreur : filtre non implémenté!");
		}
		
    }

	/**
	 * la liste des étudiants par défault
	 * @param filter : si true on enlève les redoublants
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
		 if (students == null||students.size()==0) {
			 return null;
		 }
		 for(Student student:students) {
			 totalGrades+=student.getGrade();
		 }
		 return totalGrades/students.size();
    }
}