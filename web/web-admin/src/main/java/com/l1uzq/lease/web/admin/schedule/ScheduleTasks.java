package com.l1uzq.lease.web.admin.schedule;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.l1uzq.lease.model.entity.LeaseAgreement;
import com.l1uzq.lease.model.enums.LeaseStatus;
import com.l1uzq.lease.web.admin.service.LeaseAgreementService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ClassName: ScheduleTasks
 * Package: com.l1uzq.lease.web.admin.schedule
 * Description:
 *
 * @Author L1uZQ
 * @Create 2025/2/23 16:10
 * @Version 1.0
 */
@Component
public class ScheduleTasks {

    @Autowired
    private LeaseAgreementService service;

    @Scheduled(cron = "0 0 0 * * *")
    public void checkLeaseStatus(){
        LambdaUpdateWrapper<LeaseAgreement> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.le(LeaseAgreement::getLeaseEndDate,new Date());
        updateWrapper.in(LeaseAgreement::getStatus,LeaseStatus.SIGNED,LeaseStatus.WITHDRAWING);
        updateWrapper.set(LeaseAgreement::getStatus, LeaseStatus.EXPIRED);
        service.update(updateWrapper);
    }
}
