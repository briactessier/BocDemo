package com.fdorval.bocdemo.dao.stub;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.fdorval.bocdemo.dao.FireBaseDao;
import com.fdorval.bocdemo.model.Student;
import com.fdorval.bocdemo.util.exception.TechnicalException;

@Profile("test")
@Repository
public class FireBaseDaoStub implements FireBaseDao {

	Logger LOG = LoggerFactory.getLogger(FireBaseDaoStub.class);


	@Override
	public List<Student> getStudents() throws TechnicalException {
		List<Student> result = new ArrayList<Student>();
		result.add(new Student("Dark", "Vador", 8));
		result.add(new Student("Luke", "Skywalker", 18));
		result.add(new Student("R2", "D2", 8));
		return result;


	}

}
