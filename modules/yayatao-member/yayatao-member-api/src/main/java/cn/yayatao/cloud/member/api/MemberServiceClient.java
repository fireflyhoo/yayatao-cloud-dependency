package cn.yayatao.cloud.member.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value=Constants.YAYATAO_MEMBER_SERVICE,path = "/member")
public interface MemberServiceClient {
    @GetMapping("/say")
    @ResponseBody
    String sayHi(@RequestParam("name") String  name) ;

}
