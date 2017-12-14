package com.yh.cms.support.fastjson;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 自定义消息响应处理 liuyt 2017年11月9日 下午1:46:10
 */
public class HcJsonReturnHandler implements HandlerMethodReturnValueHandler {

	@Override
	public boolean supportsReturnType( MethodParameter returnType ) {
		return returnType.getMethodAnnotation( JSON.class ) != null || returnType.getMethodAnnotation( JSONS.class ) != null;
	}

	@Override
	public void handleReturnValue( Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
	        NativeWebRequest webRequest ) throws Exception {
		// 设置这个就是最终的处理类了，处理完不再去找下一个类进行处理
		mavContainer.setRequestHandled( true );

		// 获得注解并执行filter方法 最后返回
		HttpServletResponse response = webRequest.getNativeResponse( HttpServletResponse.class );
		Annotation[] annos = returnType.getMethodAnnotations();
		CustomerJsonSerializer[] customerJsonFilters = null;
		for( Annotation anno : annos ) {
			if( anno instanceof JSON ) {
				customerJsonFilters = new CustomerJsonSerializer[1];
				CustomerJsonSerializer filter = new CustomerJsonSerializer();
				filter.filter( (JSON)anno );
				customerJsonFilters[0] = filter;
			}
			else if( anno instanceof JSONS ) {
				JSONS jsons = (JSONS)anno;
				List<JSON> jsonList = Arrays.asList( jsons.value() );
				customerJsonFilters = new CustomerJsonSerializer[jsonList.size()];
				for( int i = 0; i < jsonList.size(); i++ ) {
					CustomerJsonSerializer filter = new CustomerJsonSerializer();
					filter.filter( jsonList.get( i ) );
					customerJsonFilters[i] = filter;
				}
			}
		}

		// 处理 json
		response.setContentType( MediaType.APPLICATION_JSON_UTF8_VALUE );
		response.getWriter().write(
		    JSONObject.toJSONString( returnValue, customerJsonFilters, SerializerFeature.WriteMapNullValue,
		        SerializerFeature.DisableCircularReferenceDetect ) );

	}

}
