package com.fdorval.bocdemo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdorval.bocdemo.business.BocBusiness;
import com.fdorval.bocdemo.model.Student;
import com.fdorval.bocdemo.util.exception.TechnicalException;

@RestController
public class BocController {

	@Autowired
	BocBusiness bocBusiness;
	
	 @RequestMapping("/students")
	    public List<Student> getStudents() throws TechnicalException {
			return bocBusiness.getStudents();
	    }
	 
	 @RequestMapping("/average")
	    public Integer getAverage() throws TechnicalException {
			return bocBusiness.getAverageGrade();
	    }
}
