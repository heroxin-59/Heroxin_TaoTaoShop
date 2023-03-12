package com.taotao.controller;

import com.taotao.common.utils.EasyUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;


@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;

	@RequestMapping("/query/list")
	@ResponseBody
	public EasyUIResult getContentList(Long categoryId, Integer page, Integer rows) throws Exception {
		return contentService.getContentList(categoryId, page, rows);
	}

	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult insertContent(TbContent content) {
		return contentService.insertContent(content);
	}

	@RequestMapping("/edit")
	@ResponseBody
	public TaotaoResult updateContent(TbContent tbContent){
		return contentService.updateContent(tbContent);
	}

	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult deleteContent(Long id){
		return contentService.deleteContent(id);
	}
}
