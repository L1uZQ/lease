package com.l1uzq.lease.common.exception;

import com.l1uzq.lease.common.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName: GlobalExceptionHandler
 * Package: com.l1uzq.lease.common.exception
 * Description:
 *
 * @Author L1uZQ
 * @Create 2025/2/21 17:04
 * @Version 1.0
 */
//处理全局异常
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        e.printStackTrace();
        return Result.fail();
    }

}
