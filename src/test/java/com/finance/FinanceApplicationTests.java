package com.finance;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.finance.routes.AccountController;
import com.finance.routes.AuthenticationController;
import com.finance.routes.ForecastController;
import com.finance.routes.HelloController;
import com.finance.routes.TagController;
import com.finance.routes.TransactionController;
import com.finance.routes.UserController;

@SpringBootTest
@ActiveProfiles("test")
class FinanceApplicationTests {
	@Autowired
	private HelloController controller;
	@Autowired
	private AccountController accountController;
	@Autowired
	private TagController tagController;
	@Autowired
	private ForecastController forecastController;
	@Autowired
	private AuthenticationController authenticationController;
	@Autowired
	private UserController userController;
	@Autowired
	private TransactionController transactionController;
	

	@Test
	void helloControllerLoads() {
		assertThat(controller).isNotNull();
	}

	@Test
	void accountControllerLoads() {
		assertThat(accountController).isNotNull();
	}

	@Test
	void tagControllerLoads() {
		assertThat(tagController).isNotNull();
	}

	@Test
	void forecastControllerLoads() {
		assertThat(forecastController).isNotNull();
	}

	@Test
	void authenticationControllerLoads() {
		assertThat(authenticationController).isNotNull();
	}

	@Test
	void userControllerLoads() {
		assertThat(userController).isNotNull();
	}

	@Test
	void transactionControllerLoads() {
		assertThat(transactionController).isNotNull();
	}


}
