package cn.yayatao.cloud.member.api.controller;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.DiscoveryManager;
import com.netflix.discovery.EurekaClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaClientConfigBean;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("/eureka")
public class EurekaInstanceOutOfServiceController {


    @Autowired
    private EurekaInstanceConfigBean eurekaInstanceConfigBean;
    @Autowired
    private EurekaClientConfigBean eurekaClientConfigBean;

    @PutMapping("/out_of_service")
    public void outOfService(){
        EurekaClientConfig config = eurekaClientConfigBean;

        List<String> serverUrls = config.getEurekaServerServiceUrls(EurekaClientConfigBean.DEFAULT_ZONE);

        for (String serverUrl : serverUrls) {
            System.out.println(serverUrl);
            String getAppsUrl =  serverUrl +  "apps/"+eurekaInstanceConfigBean.getAppname();
            String outOfServiceUrl = getAppsUrl + "/" + eurekaInstanceConfigBean.getInstanceId() + "/" + "status?value=OUT_OF_SERVICE";
           // String auth  =  serverUrl.substring(serverUrl.indexOf("//")).substring(0,serverUrl.indexOf("@"));
            String authorization = ""; //"Basic " + Base64.getEncoder().encodeToString(auth.getBytes());
            put(outOfServiceUrl,"",authorization);
        }

       // DiscoveryManager.getInstance().shutdownComponent();
    }

    public String put(String urlStr, String data,String authorization){
        PrintWriter out = null;
        BufferedReader in = null;
        String result = null;
        URL url = null;
        try {
            url = new URL(urlStr);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(url);
        if (url != null) {
            try {
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("PUT");
                conn.setRequestProperty("Content-Type", " application/json");// 设定
                // 请求格式
                // 设置通用的请求属性
                conn.setRequestProperty("accept", "*/*");
                conn.setRequestProperty("connection", "Keep-Alive");
                conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
               // conn.setRequestProperty("Authorization", authorization); //  TOKEN 如果没有token可以删除
                // 发送POST请求必须设置如下两行
                conn.setDoOutput(true);
                conn.setDoInput(true);
                // 获取URLConnection对象对应的输出流
                out = new PrintWriter(conn.getOutputStream());
                // 发送请求参数
                out.print(data);
                // flush输出流的缓冲
                out.flush();
                if (conn.getResponseCode() == 200) {
                    // 定义BufferedReader输入流来读取URL的响应
                    in = new BufferedReader(new InputStreamReader(
                            conn.getInputStream()));
                    String line;
                    while ((line = in.readLine()) != null) {
                        result += line;
                    }
                } else {
                    System.out.println("请求失败----Code:" + conn.getResponseCode()+ "Message:" + conn.getResponseMessage());
                }
                conn.disconnect();// 断开连接
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
