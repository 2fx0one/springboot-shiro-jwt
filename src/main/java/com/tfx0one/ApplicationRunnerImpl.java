package com.tfx0one;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


/*
 * @Auth 2fx0one
 * 25/1/2019 23:03
 */
@Component
public class ApplicationRunnerImpl implements ApplicationRunner {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("======= !!!!!!!!!! 程序启动成功! !!!!!!!!!! [ ApplicationRunnerImpl ]  class will be execute ONLY ONCE when the project was started! !!!!!!!!!!!! ======= ");
    }

}
