package com.yh.cms;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.yh.cms.support.fastjson.HcJsonReturnHandler;

/**
 * liuyt 2017年10月11日 上午10:51:18
 */
@SpringBootApplication
@MapperScan( basePackages = "com.yh.cms.dao" )
public class Application extends WebMvcConfigurerAdapter {

	public static void main( String[] args ) {
		SpringApplication.run( Application.class, args );
	}

	/**
	 * 配置 fastjson 解析器 @ResponseBody 注解使用
	 */
	@Override
	public void configureMessageConverters( List<HttpMessageConverter<?>> converters ) {
		super.configureMessageConverters( converters );
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures( SerializerFeature.WriteMapNullValue );
		fastConverter.setFastJsonConfig( fastJsonConfig );

		converters.add( fastConverter );
	}

	/**
	 * 添加自定义消息返回处理 @JSON 注解使用
	 */
	@Override
	public void addReturnValueHandlers( List<HandlerMethodReturnValueHandler> returnValueHandlers ) {
		returnValueHandlers.add( new HcJsonReturnHandler() );
		super.addReturnValueHandlers( returnValueHandlers );
	}
}
