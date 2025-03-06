package com.l1uzq.lease.web.app.service.impl;

import com.l1uzq.lease.web.app.service.SmsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: SmsServiceImplTest
 * Package: com.l1uzq.lease.web.app.service.impl
 * Description:
 *
 * @Author L1uZQ
 * @Create 2025/3/6 16:05
 * @Version 1.0
 */
@SpringBootTest
class SmsServiceImplTest {
    @Autowired
    private SmsService service;

    @Test
    void sendCode() {
        service.sendCode("13643738648","1234");
    }
}