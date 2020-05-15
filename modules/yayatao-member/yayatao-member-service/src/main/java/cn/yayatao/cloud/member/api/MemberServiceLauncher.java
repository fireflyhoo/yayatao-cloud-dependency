package cn.yayatao.cloud.member.api;


import cn.yayatao.cloud.member.api.config.ClientAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = ClientAutoConfiguration.class)
@EnableEurekaClient
public class MemberServiceLauncher {
    public static void main(String[] args) {
        SpringApplication.run(MemberServiceLauncher.class, args);
    }
}
