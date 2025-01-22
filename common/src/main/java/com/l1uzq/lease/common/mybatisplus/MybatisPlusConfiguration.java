package com.l1uzq.lease.common.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: MybatisPlusConfiguration
 * Package: com.l1uzq.lease.common.mybatisplus
 * Description:
 *
 * @Author L1uZQ
 * @Create 2025/1/18 16:30
 * @Version 1.0
 */
@Configuration
@MapperScan("com.l1uzq.lease.web.*.mapper")
public class MybatisPlusConfiguration {

}
