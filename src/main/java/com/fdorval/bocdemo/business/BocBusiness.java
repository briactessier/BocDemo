package com.fdorval.bocdemo.business;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fdorval.bocdemo.dao.FireBaseDao;
import com.fdorval.bocdemo.model.Student;
import com.fdorval.bocdemo.util.exception.TechnicalException;

/**
 * la couche du milieu de votre appli : faites votre métier ici
 * @author franc
 *
 */
@Service
public class BocBusiness {

	Logger LOG = LoggerFactory.getLogger(BocBusiness.class);

	
	@Autowired 
	FireBaseDao fireBaseDao;
	
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
	 * la liste des étudiants avec filtre
	 * @param filterLimitGrad! :on filtre les élèves sous la note passé
	 * @return
	 * @throws TechnicalException
	 */
    public List<Student> getStudents(String filterLimitGradeStr) throws TechnicalException {
    	List<Student> students = null;
    	
    	//si pas de filtre on retourne toute la liste
    	if (StringUtils.isEmpty(filterLimitGradeStr)) {
	    	LOG.info("getStudents sans filtre");
			students = fireBaseDao.getStudents();
		//si il y a un paramètre on enlève de la liste tous les élèves dont la note est en dessous de celle passée en paramètre
    	}else {
			int filterLimitGrade = Integer.parseInt(filterLimitGradeStr);
	    	LOG.info("getStudents avec filtre : "+filterLimitGrade);
	    	students = filterStudentsUnder(fireBaseDao.getStudents(), filterLimitGrade);
		}
    	
    	for (Student student:students) {
	    	LOG.info("---> student "+student);
    		
    	}
		return students;
    }


    /**
     * fonction de filtre
     * @param students
     * @param filterLimitGrade
     * @return
     * @throws TechnicalException
     */
    public List<Student> filterStudentsUnder(List<Student> students, int filterLimitGrade) throws TechnicalException {
    	List<Student> result = new ArrayList<Student>();
    
    	//TODO
    	//ici filter les students dont la note est <10
		throw new TechnicalException("Erreur : filtre non implémenté!");
    	
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