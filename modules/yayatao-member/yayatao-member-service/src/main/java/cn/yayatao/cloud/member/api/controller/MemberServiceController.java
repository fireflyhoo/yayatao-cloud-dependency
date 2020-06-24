package cn.yayatao.cloud.member.api.controller;

import cn.yayatao.cloud.member.api.MemberServiceClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberServiceController implements MemberServiceClient {

    @Value("${spring.profiles.active}")
    private  String env;

    @Override
    public String sayHi(String name) {
        return "hi,"+env;
    }
}
