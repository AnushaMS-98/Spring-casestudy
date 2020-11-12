package com.cognizant.truyum.service;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemServiceTest {
	private MenuItemService menuItemService;

	@Before
	public void initializeService() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.cognizant.truyum");
		context.refresh();
		menuItemService = (MenuItemService) context.getBean("menuItemService");
	}
	
	@Test
	public void testGetMenuItemListAdminSize() throws ClassNotFoundException, IOException, SQLException {
		int size = menuItemService.getMenuItemListAdmin().size();
		assertEquals(5, size);
	}
	
	@Test
	public void testGetMenuItemListAdminContainsSandwich() throws ClassNotFoundException, IOException, SQLException {
		List<MenuItem> menuItemList = menuItemService.getMenuItemListAdmin();
		boolean actual= false;
		for(MenuItem item: menuItemList) {
			if(item.getName().equals("Sandwich")) {
				actual =true;
			}
		}
		assertTrue(actual);
	}
	
	@Test
	public void testGetMenuItemListCustomerSize() throws ClassNotFoundException, IOException, SQLException {
		int size = menuItemService.getMenuItemListCustomer().size();
		assertEquals(3, size);
	}
	
	@Test
	public void testGetMenuItemListCustomerNotContainsFrenchFries() throws ClassNotFoundException, IOException, SQLException {
		List<MenuItem> menuItemList = menuItemService.getMenuItemListCustomer();
		boolean actual= false;
		for(MenuItem item: menuItemList) {
			if(item.getName().equals("French Fries")) {
				actual =true;
			}
		}
		assertFalse(actual);
	}
	
	@Test
	public void testGetMenuItem() throws ClassNotFoundException, IOException, SQLException {
		String actual = menuItemService.getMenuItem(5).getName();
		assertEquals("Choclate Brownie", actual);
	}
	
	@Test
	public void testModifyMenuItem() {
		
	}

}
