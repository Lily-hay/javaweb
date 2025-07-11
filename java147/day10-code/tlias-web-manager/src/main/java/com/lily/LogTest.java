package com.lily;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j

public class LogTest {
    //private final Logger log= LoggerFactory.getLogger(LogTest.class);
    @Test
    public void testLog(){
        log.info("开始计算...");
        int sum = 0;
        try {
            int[] nums = {1, 5, 3, 2, 1, 4, 5, 4, 6, 7, 4, 34, 2, 23};
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
        } catch (Exception e) {
            log.error("程序运行出错...");
        }
        log.info("计算结果为: "+sum);
        log.info("结束计算...");
    }

}
