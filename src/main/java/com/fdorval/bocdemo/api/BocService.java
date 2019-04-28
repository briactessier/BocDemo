package com.fdorval.bocdemo.api;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fdorval.bocdemo.dao.FireBaseDao;
import com.fdorval.bocdemo.model.Student;
import com.fdorval.bocdemo.util.exception.TechnicalException;

@RestController
public class BocService {

	@Autowired 
	FireBaseDao fireBaseDao;
	
    @RequestMapping("/students")
    public List<Student> getStudents() throws TechnicalException {
		return fireBaseDao.getStudents();
    }
}