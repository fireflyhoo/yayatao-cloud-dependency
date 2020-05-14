package cn.yayatao.cloud.member;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value=Constants.YAYATAO_MEMBER_SERVICE,path = "/member")
public interface MemberServiceClient {
    @GetMapping("/say")
    @ResponseBody
    String sayHi(String  name) ;

}
