package com.tfx0one;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by 2fx0one on 2018/7/27.
 */
@Component
public class ApplicationRunnerImpl implements ApplicationRunner {


    private final Logger logger = LoggerFactory.getLogger(ApplicationRunnerImpl.class);


//    @Value("${is_clear_all_cache_at_startup}")
//    private boolean isClearAllCache;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("======= !!!!!!!!!! 程序启动后, 该函数只会执行一次 !!!!!!!!!! [ ApplicationRunnerImpl ]  class will be execute when the project was started! !!!!!!!!!!!! ======= ");
    }

}
