package com.jt.cart.service;

import com.jt.cart.pojo.Cart;
import com.jt.common.vo.SysResult;

public interface CartService {
	public SysResult save(Cart cart);
	public SysResult query(Long userId, Integer page, Integer rows);
	public SysResult updateNum(Cart cart);
	public SysResult deleteItem(Cart cart);
}