package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(long itemId);
	EUDataGridResult getItemList(int page, int rows);
	TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception;
	TaotaoResult updateItem(TbItem item,String desc, String itemParam) throws Exception;
	TaotaoResult deleteItem(Long id);
	TaotaoResult instockItem(Long id);
	TaotaoResult reshelfItem(Long id);
}
