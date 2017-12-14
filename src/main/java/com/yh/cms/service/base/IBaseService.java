package com.yh.cms.service.base;

import java.util.List;

/**
 * 公共服务接口 liuyt 2017年10月11日 下午2:11:38
 */
public interface IBaseService<T, ID> {

	/**
	 * 查询全部
	 * 
	 * @return 数据集合
	 */
	public List<T> findAll();

	/**
	 * 通过id查询实体
	 */
	public T findById( ID id );

	/**
	 * 保存实体 null属性不会插入 使用数据库默认值
	 * 
	 * @param t 实体信息
	 * @return 主键
	 */
	public ID insertSelective( T t );

	/**
	 * 保存实体 null也插入
	 */
	public ID insert( T T );

	/**
	 * 删除实体
	 * 
	 * @param id 主键
	 */
	public void deleteById( ID id );

	/**
	 * 更新实体信息 null属性不会更新
	 * 
	 * @param t 实体信息
	 * @return 主键
	 */
	public ID updateSelective( T t );

}
