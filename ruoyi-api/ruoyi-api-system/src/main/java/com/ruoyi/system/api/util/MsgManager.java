package com.ruoyi.system.api.util;

import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;

import java.util.HashMap;
import java.util.Random;

public class MsgManager {
    public static String getMsg(String phone) {
        //生产环境请求地址：app.cloopen.com
        String serverIp = "app.cloopen.com";
        //请求端口
        String serverPort = "8883";
        //主账号,登陆云通讯网站后,可在控制台首页看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN
        String accountSId = "2c94811c85c27659018610eaff980a03";
        String accountToken = "72c94f54cbd0454cb43fb82e63128c26";
        //请使用管理控制台中已创建应用的APPID
        String appId = "2c94811c8a27cf2d018a73fba177176a";
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(serverIp, serverPort);
        sdk.setAccount(accountSId, accountToken);
        sdk.setAppId(appId);
        sdk.setBodyType(BodyType.Type_JSON);
        //设置测试模板为:1
        String templateId = "1";
        //6位    463726   100000    999999
        Random ran = new Random();
        int verify = ran.nextInt(9999);
        if (verify < 1000)
            verify += 1000;
        //设置数据的数组: verify:发送的数据    ,  10:分钟
        String[] datas = {verify + "", "10"};
        //String subAppend="1234";  //可选 扩展码，四位数字 0~9999
        //String reqId="fadfafas";  //可选 第三方自定义消息id，最大支持32位英文数字，同账号下同一自然天内不允许重复
        HashMap<String, Object> result = sdk.sendTemplateSMS(phone, templateId, datas);
        //HashMap<String, Object> result = sdk.sendTemplateSMS(phone,templateId,datas,subAppend,reqId);
        if ("000000".equals(result.get("statusCode"))) {
            //正常返回输出data包体信息（map）
            return verify + "";
        } else {
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
        }
        return "0";
    }
}
