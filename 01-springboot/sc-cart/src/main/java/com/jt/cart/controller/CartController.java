package com.jt.cart.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jt.cart.pojo.Cart;
import com.jt.cart.service.CartService;
import com.jt.common.vo.SysResult;

@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/save")
	public SysResult save(Cart cart){
		return cartService.save(cart);
	}

	@RequestMapping("/query/{userId}")
	public SysResult query(@PathVariable Long userId, 
			@RequestParam(value="page",defaultValue="1") Integer page, 
			@RequestParam(value="rows",defaultValue="20") Integer rows){
		return cartService.query(userId, page, rows);
	}
	
	@RequestMapping("/update/num/{userId}/{itemId}/{num}")
	public SysResult update(@PathVariable Long userId, @PathVariable Long itemId, @PathVariable Integer num){
		Cart param = new Cart();
		param.setUserId(userId);
		param.setItemId(itemId);
		param.setNum(num);
		param.setUpdated(new Date());
		
		return cartService.updateNum(param);
	}
	
	@RequestMapping("/delete/{userId}/{itemId}")
	public SysResult deleteItem(@PathVariable Long userId, @PathVariable Long itemId){
		Cart param = new Cart();
		param.setUserId(userId);
		param.setItemId(itemId);
		
		return cartService.deleteItem(param);
	}
}
