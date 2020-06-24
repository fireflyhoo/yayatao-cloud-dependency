package cn.yayatao.cloud.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/***
 *
 */
public class GetUserRequest {
    @NotNull(message = "用户Id不能为空")
    private Integer id;

    @NotBlank(message = "用户名称不能为空")
    private String name;

    private Integer age;

    @NotNull(message = "注册时间不能为空")
    private Long registeTime;


    private Double money;
}
