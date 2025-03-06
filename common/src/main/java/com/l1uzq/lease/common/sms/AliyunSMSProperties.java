package com.l1uzq.lease.common.sms;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName: AliyunSMSProperties
 * Package: com.l1uzq.lease.common.sms
 * Description:
 *
 * @Author L1uZQ
 * @Create 2025/3/6 15:52
 * @Version 1.0
 */
@Data
@ConfigurationProperties(prefix = "aliyun.sms")
public class AliyunSMSProperties {

    private String accessKeyId;

    private String accessKeySecret;

    private String endpoint;
}