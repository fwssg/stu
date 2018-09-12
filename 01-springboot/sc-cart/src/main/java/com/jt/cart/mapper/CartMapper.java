package com.jt.cart.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jt.cart.pojo.Cart;

@Repository
public interface CartMapper extends BaseMapper<Cart>{
	/**
	 * 按用户id和商品的id来查询商品是否存在
	 */	
	@Select("select count(1) from tb_cart where user_id=#{userId} and item_id=#{itemId}")
	public Integer queryByUserIdItemId(Map<String,Long> map);
	
	/**
	 * 根据用户id和商品id，更新数据
	 * 注意updateNum方法名称不能叫update，会和BaseMapper中重复，无法正确执行
	 */
	@Update("update tb_cart"
			+ " set num = #{num}"
			+ " where user_id=#{userId} and item_id=#{itemId}")
	public void updateNum(Cart cart);
	
	/**
	 * 删除某个人的商品
	 */
	@Delete("delete from tb_cart where user_id=#{userId} and item_id=#{itemId}")
	public void deleteItem(Cart cart);
}
