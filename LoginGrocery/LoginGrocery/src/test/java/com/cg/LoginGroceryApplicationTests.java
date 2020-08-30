package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.model.Login;
import com.cg.repository.LoginRepository;
import com.cg.service.LoginService;



@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginGroceryApplicationTests {



@Autowired
private LoginService service;

@MockBean
private LoginRepository repository ;

@Test
public void addCredentialtest() {
	Login Login = new Login(1, "satyamkumarsharma498@gmail.com", "Satyam123");
	when(repository.save(Login)).thenReturn(Login);
	assertEquals(Login, service.addCredential(Login));
}


@Test
public void getAllTest() {
	when(repository.findAll()).thenReturn(Stream.of(new Login(1, "satyamkumarsharma498@gmail.com", "Satyam123"),
			new Login(2,"mayank07@gmail.com","Mayank123")).collect(Collectors.toList()));
			assertEquals(2, service.getAll().size());
}

}
