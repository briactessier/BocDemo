package com.fdorval.bocdemo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.fdorval.bocdemo.business.BocBusiness;
import com.fdorval.bocdemo.dao.stub.FireBaseDaoStub;
import com.fdorval.bocdemo.model.Student;


/**
 * tests unitaires bouchonnés : les données viennent de 
 * com.fdorval.bocdemo.dao.stub.FireBaseDaoStub
 * 
 * Stub : données statiques
 * @author françois
 *
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = {BocBusiness.class, FireBaseDaoStub.class})
public class BocdemoUnitTests {

	
	
	
	Logger LOG = LoggerFactory.getLogger(BocdemoUnitTests.class);

	@Autowired
	BocBusiness bocBusiness;
	
	

	@Test
	public void testGetSudents() {
		try {
			List<Student> students = bocBusiness.getStudents();
			for (Student student : students) {
				LOG.info("-> " + student);
			}
			Assert.assertEquals(students.get(1).getName(), "Luke");

		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetAverage() {
		try {
			Integer averageGrade = bocBusiness.getAverageGrade();
			LOG.info("averageGrade -> " + averageGrade);
			
			Assert.assertTrue(averageGrade == 11);

		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

}
