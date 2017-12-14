package com.yh.cms.service.base;

import com.github.pagehelper.Page;

/**
 * 分页服务基类 liuyt 2017年10月12日 上午11:42:34
 * 
 * @param <T>
 * @param <ID>
 */
public interface IBasePageService<T, ID> extends IBaseService<T, ID> {

	/**
	 * 全部数据分页
	 */
	Page<T> findAllPage();
}
