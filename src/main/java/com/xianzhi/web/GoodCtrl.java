package com.xianzhi.web;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.xianzhi.bean.GoodTypeBean;
import com.xianzhi.bean.GoodUnitBean;
import com.xianzhi.bean.GoodsBean;
import com.xianzhi.service.GoodsService;


@RestController
@RequestMapping("/good")
public class GoodCtrl {

	@Autowired
	private GoodsService goodsService;

	/*
	 * 增加商品
	 */

	@RequestMapping(value = "/addGood", method = RequestMethod.POST)
	public void addGood(GoodsBean goods) throws JsonParseException, JsonMappingException, IOException {

		System.out.println(goods.getGoodOtherName());
		goodsService.insertGoods(goods);
	}

	/*
	 * 分页查询商品
	 */
	@RequestMapping(value = "/getGoodSByPage", method = RequestMethod.GET)
	@ResponseBody
	public List<GoodsBean> addGoodType(Integer page, Integer offset) {
		return goodsService.getGoodSByPage(page, offset);
	}
	
	/*
	 * 按id查询商品
	 */
	@RequestMapping(value = "/getGoodsById", method = RequestMethod.GET)
	@ResponseBody
	public GoodsBean getGoodsById(Integer goodsId) {
		return goodsService.getGoodsById(goodsId);
	}
	
	/*
	 * 增加商品类型
	 */

	@RequestMapping(value = "/addGoodType", method = RequestMethod.POST)
	public void addGoodType(String goodTypeName) {
		GoodTypeBean goodTypeBean = new GoodTypeBean();
		goodTypeBean.setGoodsTypeName(goodTypeName);
		goodsService.insertGoodType(goodTypeBean);
	}

	/*
	 * 增加商品单位
	 * 
	 */

	@RequestMapping(value = "/addGoodUtil", method = RequestMethod.POST)
	public void addGoodUtil(String goodUnitName) {
		GoodUnitBean goodUnitBean = new GoodUnitBean();
		goodUnitBean.setGoodUnitName(goodUnitName);
		goodsService.insertGoodUnit(goodUnitBean);
	}

	/*
	 * 获取商品总数
	 * 
	 */

	@RequestMapping(value = "/getTotalGoodSize", method = RequestMethod.GET)
	@ResponseBody
	public int getTotalGoodSize(GoodUnitBean goodUnitBean) {
		return goodsService.getTotalGoodSize();
	}

	/*
	 * 获取总商品分类
	 * 
	 */

	@RequestMapping(value = "/getAllGoodType", method = RequestMethod.GET)
	@ResponseBody
	public List<GoodTypeBean> getAllGoodType() {
		return goodsService.getAllGoodType();
	}

	/*
	 * 获取总商品单位
	 * 
	 */

	@RequestMapping(value = "/getAllGoodUnit", method = RequestMethod.GET)
	@ResponseBody
	public List<GoodUnitBean> getAllGoodUnit() {
		return goodsService.getAllGoodUnit();
	}

	/*
	 * 更新商品分类
	 * 
	 */

	@RequestMapping(value = "/updateGoodType", method = RequestMethod.POST)
	@ResponseBody
	public int updateGoodType(int id, String goodTypeName) {
		GoodTypeBean goodTypeBean = new GoodTypeBean();
		goodTypeBean.setGoodsTypeName(goodTypeName);
		goodTypeBean.setGoodsTypeId(id);
		return goodsService.updateGoodType(goodTypeBean);
	}
	
	/*
	 * 按ID删除商品分类
	 * 
	 * */
	
	@RequestMapping(value = "/deleteGoodTypeById", method = RequestMethod.POST)
	@ResponseBody
	public int deleteGoodTypeById(int id) {
		return goodsService.deleteGoodType(id);
	}
	
	/*
	 * 按ID更新商品单位
	 * 
	 * */
	
	@RequestMapping(value = "/updateGoodUnitById", method = RequestMethod.POST)
	@ResponseBody
	public int updateGoodUnitById(int id,String goodUnitName) {
		GoodUnitBean goodUnitBean =new GoodUnitBean();
		goodUnitBean.setGoodUnitId(id);
		goodUnitBean.setGoodUnitName(goodUnitName);
		return goodsService.updateGoodUnit(goodUnitBean);
	}
	
	
}
