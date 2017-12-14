package com.yh.cms.service.base;

import java.io.Serializable;
import java.util.List;

import com.yh.cms.domain.base.BaseEntity;
import com.yh.cms.support.pagehelper.base.BaseDao;

/**
 * 抽象父类 处理公共方法 liuyt 2017年10月11日 下午2:27:22
 * 
 * @param <T>
 * @param <ID>
 */
public abstract class BaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable> implements IBaseService<T, ID> {

	@Override
	public List<T> findAll() {
		return getBaseDao().selectAll();
	}

	@Override
	public T findById( ID id ) {
		return getBaseDao().selectByPrimaryKey( id );
	}

	@Override
	public ID insertSelective( T t ) {
		int suc = getBaseDao().insertSelective( t );
		return suc == 0 ? null : t.getId();
	}

	@Override
	public ID insert( T t ) {
		int suc = getBaseDao().insert( t );
		return suc == 0 ? null : t.getId();
	}

	@Override
	public void deleteById( ID id ) {
		getBaseDao().deleteByPrimaryKey( id );
	}

	@Override
	public ID updateSelective( T t ) {
		int suc = getBaseDao().updateByPrimaryKeySelective( t );
		return suc == 0 ? null : t.getId();
	}

	protected abstract BaseDao<T, ID> getBaseDao();

}
