package com.l1uzq.lease.common.utils;

import java.util.Random;

/**
 * ClassName: CodeUtil
 * Package: com.l1uzq.lease.common.utils
 * Description:
 *
 * @Author L1uZQ
 * @Create 2025/3/6 16:16
 * @Version 1.0
 */
public class CodeUtil {
    public static String getRandomCode(Integer length){
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for(int i=0; i<length; i++){
            int num = random.nextInt(10);
            builder.append(num);
        }
        return builder.toString();
    }
}
