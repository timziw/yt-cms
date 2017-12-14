package com.yh.cms.service.base;

import java.io.Serializable;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yh.cms.domain.base.BaseEntity;
import com.yh.cms.support.pagehelper.base.BaseDao;
import com.yh.cms.support.pagehelper.base.BasePageDao;

/**
 * 分页通用服务实现 liuyt 2017年10月12日 上午11:54:52
 */
public abstract class BasePageServiceImpl<T extends BaseEntity<ID>, ID extends Serializable> extends BaseServiceImpl<T, ID>
        implements IBasePageService<T, ID> {

	public Page<T> findAllPage() {
		Page<T> page = PageHelper.startPage( 1, 10 ).doSelectPage( ( ) -> getBasePageDao().selectAll() );
		return page;
	}

	@Override
	protected BaseDao<T, ID> getBaseDao() {
		return getBasePageDao();
	}

	protected abstract BasePageDao<T, ID> getBasePageDao();
}
