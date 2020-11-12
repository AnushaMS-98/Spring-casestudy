package com.cognizant.truyum.service;

import static org.junit.Assert.*;

import java.util.List;
import java.io.IOException;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public class CartServiceTest {
	CartService cartService;
	//public ExpectedException exceptionRule = ExpectedException.none();

	@Before
	public void initializeService()  {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.cognizant.truyum");
		context.refresh();
		cartService = context.getBean(CartService.class);

		
	}
	@Test(expected = CartEmptyException.class)
	 public void testGetAllCartItems() throws ClassNotFoundException, CartEmptyException, SQLException {
		cartService.getAllCartItems(1);
		
	 }
	
	@Test(expected = CartEmptyException.class)
    public void testAddCartItem() throws CartEmptyException, ClassNotFoundException, SQLException, IOException {
		boolean result = false;
        for(MenuItem item : cartService.getAllCartItems(1)) {
            if(item.getName().equalsIgnoreCase("Sandwich")) {
                result = true;
            }
        }
        assertFalse(result);
       result = false;
        cartService.addCartItem(1, 1);
        for(MenuItem item : cartService.getAllCartItems(1)) {
            if(item.getName().equalsIgnoreCase("Sandwich")) {
                result = true;
            }
        }
        assertTrue(result);

    }
    @Test(expected = CartEmptyException.class)
    public void testRemoveCartItem() throws CartEmptyException, ClassNotFoundException, SQLException, IOException {
    	cartService.removeCartItem(1, 1);
        boolean expected =false;
        List <MenuItem>cartList = cartService.getAllCartItems(1);
        for(MenuItem menuItem:cartList) {
        	if(menuItem.getName().equals("Sandwich")) {
        		expected = true;
        	}
        }
        assertTrue(expected);
    }

    }

	



