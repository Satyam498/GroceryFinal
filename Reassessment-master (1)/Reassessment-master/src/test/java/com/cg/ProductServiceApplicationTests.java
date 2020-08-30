package com.cg;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.models.Product;
import com.cg.repository.ProductRepository;
import com.cg.service.ProductInterface;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceApplicationTests {
	

@Autowired
private ProductInterface service;

@MockBean
private ProductRepository repository ;


@Test
public void retriveAllProductstest() {
when(repository.findAll()).thenReturn(Stream.of(new Product(1, "Maza", "Candy", 85.00,"maja.jpg","Yes",25),
new Product(2,"Amul", "Dairy", 85,"amul","Yes",50)).collect(Collectors.toList()));
assertEquals(2, service.retriveAllProducts().size());
}



@Test
public void deleteUserTest() {
Product Product = new Product(2,"Amul", "Dairy", 85,"amul","Yes",50);
service.delete(2);
verify(repository, times(1)).deleteById(Product.getProductId());
}


}
