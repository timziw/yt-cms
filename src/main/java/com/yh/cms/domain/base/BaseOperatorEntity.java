package com.yh.cms.domain.base;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 基本操作实体 liuyt 2017年10月25日 上午10:34:47
 */
@Data
@EqualsAndHashCode( callSuper = true )
@ToString( callSuper = true )
public class BaseOperatorEntity<T> extends BaseEntity<T> {
	private static final long serialVersionUID = -407450117650824412L;

	private String createBy; // 创建人

	@JSONField( format = "yyyy-MM-dd HH:mm:ss" )
	private Date createTime; // 创建时间

	private String updateBy; // 更新人

	@JSONField( format = "YYYY-MM-DD HH:mm:ss" )
	private Date updateTime; // 更新时间
}
