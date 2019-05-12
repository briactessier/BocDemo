package com.fdorval.bocdemo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.fdorval.bocdemo.business.BocBusiness;
import com.fdorval.bocdemo.dao.FireBaseDao;
import com.fdorval.bocdemo.dao.mock.FireBaseDaoMock;
import com.fdorval.bocdemo.model.Student;



@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = {BocBusiness.class, FireBaseDaoMock.class})
public class BocdemoUnitTestsMock {


	@Autowired
    private FireBaseDao fireBaseDao;
	
	Logger LOG = LoggerFactory.getLogger(BocdemoUnitTests.class);

	@Autowired
	BocBusiness bocBusiness;
	
	

	@Test
	public void testGetSudents() {
		List<Student> result = new ArrayList<Student>();
		result.add(new Student("Harry", 12));
		result.add(new Student("Hermione", 18));
		result.add(new Student("Voldemort", 8));
        try {
        	FireBaseDaoMock fireBaseDaoMock = (FireBaseDaoMock) fireBaseDao;

			Mockito.when(fireBaseDaoMock.getMockDelegate(). getStudents()).thenReturn(result);
	
		
			List<Student> students = bocBusiness.getStudents();
			for (Student student : students) {
				LOG.info("-> " + student);
			}
			Assert.assertEquals(students.get(2).getName(), "Voldemort");

		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAverage() {
		List<Student> result = new ArrayList<Student>();
		result.add(new Student("Riri", 12));
		result.add(new Student("fifi", 10));
		result.add(new Student("LouLou", 8));
        try {
        	FireBaseDaoMock fireBaseDaoMock = (FireBaseDaoMock) fireBaseDao;

			Mockito.when(fireBaseDaoMock.getMockDelegate(). getStudents()).thenReturn(result);
			Integer averageGrade = bocBusiness.getAverageGrade();
			LOG.info("averageGrade -> " + averageGrade);
			
			Assert.assertTrue(averageGrade == 10);

		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
	
	

}
