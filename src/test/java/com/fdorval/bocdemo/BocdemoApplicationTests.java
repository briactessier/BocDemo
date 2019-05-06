package com.fdorval.bocdemo;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fdorval.bocdemo.api.BocService;
import com.fdorval.bocdemo.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BocdemoApplicationTests {

	Logger LOG = LoggerFactory.getLogger(BocdemoApplicationTests.class);

	@Autowired
	BocService bocService;

	@Test
	public void testGetSudents() {
		try {
			List<Student> students = bocService.getStudents();
			for (Student student : students) {
				LOG.info("-> " + student);
			}
			Assert.assertEquals(4, students.size());

		} catch (Exception e) {
			Assert.fail();
			e.printStackTrace();
		}
	}

}
