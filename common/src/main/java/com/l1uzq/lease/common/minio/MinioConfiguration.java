package com.l1uzq.lease.common.minio;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: MinioConfiguration
 * Package: com.l1uzq.lease.common.minio
 * Description:
 *
 * @Author L1uZQ
 * @Create 2025/2/21 15:32
 * @Version 1.0
 */
@Configuration
@EnableConfigurationProperties(MinioProperties.class)
//@ConfigurationPropertiesScan("com.l1uzq.lease.common.minio")
public class MinioConfiguration {
    @Autowired
    private MinioProperties properties;

    @Bean
    public MinioClient minioClient(){
        return MinioClient.builder().endpoint(properties.getEndpoint()).credentials(properties.getAccessKey(), properties.getSecretKey()).build();
    }
}
