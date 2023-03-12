package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;



@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		return itemService.getItemById(itemId);
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		return itemService.getItemList(page, rows);
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	@ResponseBody
	private TaotaoResult createItem(TbItem item, String desc, String itemParams) throws Exception {
		return itemService.createItem(item, desc, itemParams);
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	@ResponseBody
	private TaotaoResult updateItem(TbItem item, String desc, String itemParams) throws Exception {
		return itemService.updateItem(item,desc,itemParams);
	}
	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteItem(Long id){
		return itemService.deleteItem(id);
	}

	@RequestMapping("/instock")
	@ResponseBody
	public TaotaoResult instockItem(Long id){
		return itemService.instockItem(id);
	}

	@RequestMapping("/reshelf")
	@ResponseBody
	public TaotaoResult reshelfItem(Long id){
		return itemService.reshelfItem(id);
	}
}
