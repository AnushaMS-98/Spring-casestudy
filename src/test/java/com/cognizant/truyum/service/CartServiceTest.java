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

		
	}
	@Test(expected = CartEmptyException.class)
	 public void testGetAllCartItems() throws ClassNotFoundException, CartEmptyException, SQLException {

	 }
	
	
    public void testAddCartItem() throws CartEmptyException, ClassNotFoundException, SQLException, IOException {

    }
    @Test(expected = CartEmptyException.class)
    public void testRemoveCartItem() throws CartEmptyException, ClassNotFoundException, SQLException, IOException {

    }

	
	}


