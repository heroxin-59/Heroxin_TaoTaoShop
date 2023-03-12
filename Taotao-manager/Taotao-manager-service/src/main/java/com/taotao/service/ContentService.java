package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.EasyUIResult;
import com.taotao.pojo.TbContent;

public interface ContentService {

	EasyUIResult getContentList(Long catId, Integer page, Integer rows)throws Exception;

	TaotaoResult insertContent(TbContent tbContent);

	TaotaoResult updateContent(TbContent tbContent);

	TaotaoResult deleteContent(Long id);
}
