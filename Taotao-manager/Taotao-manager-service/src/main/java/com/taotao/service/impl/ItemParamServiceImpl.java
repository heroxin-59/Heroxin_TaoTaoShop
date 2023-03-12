package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamExample.Criteria;
import com.taotao.service.ItemParamService;


@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper itemParamMapper;

	@Override
	public EUDataGridResult getItemParamList(int page, int rows) {
//		查询商品列表
		TbItemParamExample example = new TbItemParamExample();
//		分页处理
		PageHelper.startPage(page,rows);
		List<TbItemParam> tbItemParams = itemParamMapper.selectByExampleWithBLOBs(example);
//		创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(tbItemParams);
//		取记录总条数
		PageInfo<TbItemParam> pageInfo = new PageInfo<>(tbItemParams);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public TaotaoResult getItemParamByCid(long cid) {
		TbItemParamExample example = new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		//判断是否查询到结果
		if (list != null && list.size() > 0) {
			return TaotaoResult.ok(list.get(0));
		}
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult insertItemParam(TbItemParam itemParam) {
		//补全pojo
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		//插入到规格参数模板表
		itemParamMapper.insert(itemParam);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult deleteItemParam(long id) {
		itemParamMapper.deleteByPrimaryKey(id);
		return TaotaoResult.ok();
	}

}
