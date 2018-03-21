package com.xianzhi.web;



import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xianzhi.bean.GoodTypeBean;
import com.xianzhi.bean.GoodUnitBean;
import com.xianzhi.bean.GoodsBean;
import com.xianzhi.service.GoodsService;
import com.xianzhi.utils.HttpServletRequestUtil;

@RestController
@RequestMapping("/good")
public class GoodCtrl {
	
	
	@Autowired
	private GoodsService goodsService;
	
	
	/*
	 * 增加商品
	 * */
	
	@RequestMapping(value="/addGood", method = RequestMethod.POST)
	public void addGood(GoodsBean goods) throws JsonParseException, JsonMappingException, IOException
	{
		
		System.out.println(goods.getGoodOtherName());
		goodsService.insertGoods(goods);
	}
	
	
	/*
	 * 分页查询商品
	 * */
	@RequestMapping(value="/getGoodSByPage", method = RequestMethod.GET)
	public void addGoodType(Integer page, Integer offset)
	{
		goodsService.getGoodSByPage(page, offset);
	}
	
	/*
	 * 增加商品类型
	 * */
	
	@RequestMapping(value="/addGoodType", method = RequestMethod.POST)
	public void addGoodType(GoodTypeBean goodTypeBean)
	{
		goodsService.insertGoodType(goodTypeBean);
	}
	
	/*
	 * 增加商品单位
	 * 
	 * */
	
	@RequestMapping(value="/addGoodUtil", method = RequestMethod.POST)
	public void addGoodUtil(GoodUnitBean goodUnitBean)
	{
		goodsService.insertGoodUnit(goodUnitBean);
	}
	
	
	/*
	 * 获取商品总数
	 * 
	 * */
	
	@RequestMapping(value="/getTotalGoodSize", method = RequestMethod.POST)
	public void getTotalGoodSize(GoodUnitBean goodUnitBean)
	{
		goodsService.getTotalGoodSize();
	}
	
	
}
