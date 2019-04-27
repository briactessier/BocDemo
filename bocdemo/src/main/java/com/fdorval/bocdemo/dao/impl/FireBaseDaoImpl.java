package com.fdorval.bocdemo.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fdorval.bocdemo.dao.FireBaseDao;
import com.fdorval.bocdemo.model.Student;
import com.fdorval.bocdemo.util.exception.TechnicalException;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

@Repository
public class FireBaseDaoImpl implements FireBaseDao {

	Logger LOG = LoggerFactory.getLogger(FireBaseDaoImpl.class);

	@Autowired
	DatabaseReference firebaseDatabase;

	@Override
	public List<Student> getStudents() throws TechnicalException {
		FirebaseDatabase database = firebaseDatabase.getDatabase();
		List<Student> result = new ArrayList<Student>();

		//beurk
		DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
		final Semaphore semaphore = new Semaphore(0);

		ref.addValueEventListener(new ValueEventListener() {

			@Override
			public void onDataChange(DataSnapshot snapshot) {
				LOG.info("found {} students", snapshot.child("students").getChildrenCount());
				 String string = snapshot.toString();

				  for (DataSnapshot postSnapshot: snapshot.child("students").getChildren()) {
				    Student student = postSnapshot.getValue(Student.class);
					LOG.info("--> " + student.toString());

				    result.add(student);
				  }
				 LOG.debug(string);
		        semaphore.release();

			}

			@Override
			public void onCancelled(DatabaseError error) {
				LOG.error("appel firebase ko", error);
				semaphore.release();


			}
		});
		
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			LOG.error("aarg", e);
			TechnicalException.throwTechnicalException("aaaarg", e);
		}
		return result;

	}

}
