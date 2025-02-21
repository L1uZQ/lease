package com.l1uzq.lease.common.minio;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ClassName: MinioProperties
 * Package: com.l1uzq.lease.common.minio
 * Description:
 *
 * @Author L1uZQ
 * @Create 2025/2/21 15:44
 * @Version 1.0
 */
@Data
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

    private String endpoint;

    private String accessKey;

    private String secretKey;

    private String bucketName;
}
