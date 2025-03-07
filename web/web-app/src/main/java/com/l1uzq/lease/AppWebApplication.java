package com.l1uzq.lease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * ClassName: AppWebApplication
 * Package: com.l1uzq.lease
 * Description:
 *
 * @Author L1uZQ
 * @Create 2025/3/6 13:43
 * @Version 1.0
 */
@SpringBootApplication
@EnableAsync
public class AppWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppWebApplication.class);
    }
}