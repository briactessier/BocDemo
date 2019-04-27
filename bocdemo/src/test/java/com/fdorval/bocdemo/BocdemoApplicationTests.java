package com.fdorval.bocdemo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fdorval.bocdemo.api.BocService;
import com.fdorval.bocdemo.util.exception.TechnicalException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BocdemoApplicationTests {

	@Autowired 
	BocService bocService;
	@Test
	public void contextLoads() {
		try {
			bocService.getStudents();
		} catch (TechnicalException e) {
			Assert.fail();
			e.printStackTrace();
		}	
	}

}
