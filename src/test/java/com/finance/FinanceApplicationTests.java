package com.finance;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.finance.routes.HelloController;

@SpringBootTest
@ActiveProfiles("test")
class FinanceApplicationTests {
	@Autowired
	private HelloController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
