package com.fdorval.bocdemo.dao.mock;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.fdorval.bocdemo.business.BocBusiness;
import com.fdorval.bocdemo.dao.FireBaseDao;
import com.fdorval.bocdemo.model.Student;
import com.fdorval.bocdemo.util.exception.TechnicalException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import lombok.Getter;

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
