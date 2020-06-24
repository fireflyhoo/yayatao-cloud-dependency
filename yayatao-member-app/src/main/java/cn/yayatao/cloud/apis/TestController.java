package cn.yayatao.cloud.apis;

import cn.yayatao.cloud.member.api.MemberServiceClient;
import cn.yayatao.cloud.model.GetUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/user")
    public  String getUser(@Validated @RequestBody GetUserRequest getUser){
        return "测试成功";
    }

}
