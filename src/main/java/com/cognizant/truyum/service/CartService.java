package com.cognizant.truyum.service;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {
	
	CartDao cartDao;
	
	@Autowired
	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	public void addCartItem(long userId, long menuItemId) throws ClassNotFoundException, IOException, SQLException {
		cartDao.addCartItem(userId, menuItemId);
	}
	public List<MenuItem> getAllCartItems(long userId) throws ClassNotFoundException, CartEmptyException, SQLException {
		return cartDao.getAllCartItems(userId);
	}
	public void removeCartItem(long userId, long menuItemId) throws ClassNotFoundException, CartEmptyException, IOException, SQLException {
		cartDao.removeCartItem(userId, menuItemId);
	}



}
