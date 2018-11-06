package com.tfx0one.common.constant;

/*
 * Create by 2fx0one on 2/6/18
 */

public class WeChatApiConstant {
    //小程序 登录凭证校验
    public static final String URL_JSCODE2SESSION = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";


    // 统一下单接口
    public static final String UNIFIEDORDER_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";

    // 订单查询
    public static final String ORDERQUERY_URL = "https://api.mch.weixin.qq.com/pay/orderquery";



    //base access token 7200s expired
    public static final String BASE_ACCESSS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    public static final String BASE_ACCESSS_TOKEN_URL_CENTRAL_SERVER = "/wechat/access/token?appId=APPID&appSecret=APPSECRET";

    //mini app qrcode and code
    public static final String WECHAT_MINI_APP_QRCODE = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=ACCESS_TOKEN";

    //获取模板list
    public static final String WECHAT_GET_TEMPLATE_LIST = "https://api.weixin.qq.com/cgi-bin/wxopen/template/list?access_token=ACCESS_TOKEN";

    //发送模板消息
    public static final String WECHAT_SEND_TEMPLATE ="https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=ACCESS_TOKEN";



}