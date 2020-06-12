package cn.yayatao.cloud.apis;

import cn.yayatao.cloud.member.api.MemberServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class TestController   {
    @Autowired
    private MemberServiceClient client;

    @GetMapping
    @ResponseBody
    public String index(){
        return client.sayHi("xxx");
    }

}
