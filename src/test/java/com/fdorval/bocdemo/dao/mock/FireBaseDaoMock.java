package com.fdorval.bocdemo.dao.mock;


import java.util.List;

import org.mockito.Mockito;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.fdorval.bocdemo.dao.FireBaseDao;
import com.fdorval.bocdemo.model.Student;
import com.fdorval.bocdemo.util.exception.TechnicalException;

@Profile("test")
@Repository
public class FireBaseDaoMock implements FireBaseDao {

	
    private FireBaseDao mockDelegate = Mockito.mock(FireBaseDao.class);

	@Override
	public List<Student> getStudents() throws TechnicalException {
		return mockDelegate.getStudents();


	}

	public FireBaseDao getMockDelegate() {
		return mockDelegate;
	}

}
