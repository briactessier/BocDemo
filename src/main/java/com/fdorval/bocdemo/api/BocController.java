package com.fdorval.bocdemo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fdorval.bocdemo.business.BocBusiness;
import com.fdorval.bocdemo.model.Student;
import com.fdorval.bocdemo.util.exception.TechnicalException;

@RestController
public class BocController {

	@Autowired
	BocBusiness bocBusiness;
	
	 @RequestMapping(value ="/students",  method = RequestMethod.GET)
	    public List<Student> getStudents() throws TechnicalException {
			return bocBusiness.getStudents();
	    }
	 
	 @RequestMapping(value ="/average",  method =  RequestMethod.GET)
	    public Integer getAverage() throws TechnicalException {
			return bocBusiness.getAverageGrade();
	    }
}
