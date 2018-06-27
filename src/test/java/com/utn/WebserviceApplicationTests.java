package com.utn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebserviceApplication.class)
public class WebserviceApplicationTests {

	@Test
	public void contextLoads() {
		WebserviceApplication.main(new String[]{});
	}

}
