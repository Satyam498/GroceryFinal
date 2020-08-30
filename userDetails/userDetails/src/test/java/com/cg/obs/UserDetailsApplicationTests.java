package com.cg.obs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.model.User;
import com.cg.repository.UserRepository;
import com.cg.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDetailsApplicationTests {

@Autowired
private UserService service;

@MockBean
private UserRepository repository ;

@Test
public void retrieveAllUserstest() {
when(repository.findAll()).thenReturn(Stream.of(new User(1, "Sonali", "Deshmukh", "7277793998","Mumbai","sonalideshmukh1998@gmail.com"),
new User(2,"Satyam","Kumar", "09168008610","Ambegaon","satyamkumarsharma498@gmail.com")).collect(Collectors.toList()));
assertEquals(2, service.findAll().size());
}


@Test
public void addUserTest() {
User User = new User(1, "Sonali", "Deshmukh", "7277793998","Mumbai","sonalideshmukh1998@gmail.com");
when(repository.save(User)).thenReturn(User);
assertEquals(User, service.addUser(User));
}



@Test
public void deleteUserTest() {
User User = new User(2,"Satyam","Kumar", "09168008610","Ambegaon","satyamkumarsharma498@gmail.com");
service.deleteUser(2);
verify(repository, times(1)).deleteById(User.getUserId());
}



}
