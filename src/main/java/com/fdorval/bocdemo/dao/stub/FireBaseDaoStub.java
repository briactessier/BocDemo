package com.fdorval.bocdemo.dao.stub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.fdorval.bocdemo.dao.FireBaseDao;
import com.fdorval.bocdemo.model.Student;
import com.fdorval.bocdemo.util.exception.TechnicalException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

@Profile("test")
@Repository
public class FireBaseDaoStub implements FireBaseDao {

	Logger LOG = LoggerFactory.getLogger(FireBaseDaoStub.class);


	@Override
	public List<Student> getStudents() throws TechnicalException {
		List<Student> result = new ArrayList<Student>();
		result.add(new Student("Dark Vador", 8));
		result.add(new Student("Chewbacca", 18));
		result.add(new Student("R2D2", 8));
		return result;


	}

}
