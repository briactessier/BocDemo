package com.fdorval.bocdemo.dao;

import java.util.List;

import com.fdorval.bocdemo.model.Student;
import com.fdorval.bocdemo.util.exception.TechnicalException;

public interface FireBaseDao {

	List<Student> getStudents() throws TechnicalException;

}
