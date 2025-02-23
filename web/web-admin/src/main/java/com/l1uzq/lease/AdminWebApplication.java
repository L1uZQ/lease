package com.l1uzq.lease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * ClassName: AdminWebApplication
 * Package: com.l1uzq.lease
 * Description:
 *
 * @Author L1uZQ
 * @Create 2025/1/18 16:22
 * @Version 1.0
 */
@SpringBootApplication
@EnableScheduling
public class AdminWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminWebApplication.class, args);
    }
}
