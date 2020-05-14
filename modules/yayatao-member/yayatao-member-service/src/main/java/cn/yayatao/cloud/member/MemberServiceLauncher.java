package cn.yayatao.cloud.member;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MemberServiceLauncher {
    public static void main(String[] args) {
        SpringApplication.run(MemberServiceLauncher.class,args);
    }
}
