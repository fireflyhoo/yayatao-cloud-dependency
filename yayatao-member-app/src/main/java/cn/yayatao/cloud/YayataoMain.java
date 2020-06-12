package cn.yayatao.cloud;

import cn.yayatao.cloud.member.api.config.ClientAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Hello world!
 */

@SpringBootApplication()
@EnableEurekaClient
public class YayataoMain {
    public static void main(String[] args) {
        SpringApplication.run(YayataoMain.class,args);
    }
}
