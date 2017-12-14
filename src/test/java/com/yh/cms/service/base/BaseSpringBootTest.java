package com.yh.cms.service.base;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.yh.cms.Application;

/**
 * 单元测试基类 liuyt 2017年10月30日 上午11:44:12
 */
@RunWith( SpringJUnit4ClassRunner.class )
@WebAppConfiguration
@SpringBootTest( classes = Application.class )
public class BaseSpringBootTest {

}
