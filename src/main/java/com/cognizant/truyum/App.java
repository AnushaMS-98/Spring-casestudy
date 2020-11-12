package com.cognizant.truyum;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        MenuItemDaoCollectionImpl menuItems = (MenuItemDaoCollectionImpl) ctx.getBean("menuItems");
        List<MenuItem> lst = menuItems.getMenuItemList();
        for(MenuItem item:lst) {
        	System.out.println(item);
        }
    }
}
