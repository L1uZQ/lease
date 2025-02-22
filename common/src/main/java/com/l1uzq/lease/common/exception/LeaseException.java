package com.l1uzq.lease.common.exception;

import com.l1uzq.lease.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * ClassName: LeaseException
 * Package: com.l1uzq.lease.common.exception
 * Description:
 *
 * @Author L1uZQ
 * @Create 2025/2/22 19:00
 * @Version 1.0
 */
@Data
public class LeaseException extends RuntimeException{

    private Integer code;

    public LeaseException(Integer code, String message){
        super(message);
        this.code=code;
    }

    public LeaseException(ResultCodeEnum resultCodeEnum){
        super(resultCodeEnum.getMessage());
        this.code=resultCodeEnum.getCode();
    }
}
