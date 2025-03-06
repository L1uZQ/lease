package com.l1uzq.lease.web.admin.schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: ScheduleTasksTest
 * Package: com.l1uzq.lease.web.admin.schedule
 * Description:
 *
 * @Author L1uZQ
 * @Create 2025/2/23 16:29
 * @Version 1.0
 */
@SpringBootTest
class ScheduleTasksTest {
    @Autowired
    private ScheduleTasks scheduleTasks;

    @Test
    public void test(){
        scheduleTasks.checkLeaseStatus();
    }
}