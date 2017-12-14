package com.yh.cms.domain.base;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseEntity<T> implements Serializable {
	private static final long serialVersionUID = -4117839526813738067L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY, generator = "select replace(uuid(),'-','') from dual" )
	private T id; // 主键

	@Transient
	private String appId; // 应用id.用于标识唯一的请求方
}
