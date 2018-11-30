package com.tfx0one.common.constant;

/**
 * Created by 2fx0one on 28/5/2018.
 */
public class APIConstant {
    //非法 token
    public static int TOKEN_ILLEGAL = 50001;

    //URL Access Denied 无权访问该链接！
    public static int TOKEN_ACCESS_DENIED = 50002;

    public static final String API_VERSION = "/api/v1";
    public static final String API_VERSION_ADMIN = API_VERSION + "/admin";
    public static final String API_VERSION_VENDOR = API_VERSION + "/shop";
    public static final String API_VERSION_WECHAT = API_VERSION + "/wechat";

    //=============== 用户授权相关 ============================================
    //临时的注册
    //    public static final String authRegister = "/auth/register";
    //后台网页登录
    public static final String authSysUserLogin = API_VERSION + "/auth/user/login";
    //后台网页
    public static final String authSysUserInfo = API_VERSION + "/auth/user/info";




    //微信登录
    public static final String authWeChatLogin = "/auth/wxlogin";


    //=============================================================================
    //============================= 超级管理员 接口 =================================
    //=============================================================================

    //=============== 超级用户  商家咨询相关   ==========================================
    //获取咨询列表
    public static final String vendorAdvisoryFind = API_VERSION_ADMIN + "/advisory/find";
    //商家设置备注
    public static final String vendorAdvisorysRemark = API_VERSION_ADMIN + "/advisory/remark";

    //=============== 超级用户 菜单管理相关 ============================================
    //获取用户的菜单列表
    public static final String adminVendorRoleMenuList = API_VERSION_ADMIN + "/manager/admin/role/menu/list";
    //添加菜单
    public static final String adminVendorRoleMenuAdd = API_VERSION_ADMIN + "/manager/admin/role/menu/add";
    //删除菜单
    public static final String adminVendorRoleMenuDelete = API_VERSION_ADMIN + "/manager/admin/role/menu/delete";
    //修改菜单
    public static final String adminVendorRoleMenuModify = API_VERSION_ADMIN + "/manager/admin/role/menu/modify";


    //=============== 超级用户 角色管理相关 ============================================
    //获取角色列表
    public static final String adminVendorRoleList = API_VERSION_ADMIN + "/manager/admin/role/list";
    //添加角色
    public static final String adminVendorRoleAdd = API_VERSION_ADMIN + "/manager/admin/role/add";
    //删除角色
    public static final String adminVendorRoleDelete = API_VERSION_ADMIN + "/manager/admin/role/delete";
    //修改角色
    public static final String adminVendorRoleModify = API_VERSION_ADMIN + "/manager/admin/role/modify";


    //=============== 超级用户 用户管理相关 ============================================
    //获取用户列表
    public static final String adminVendorUserList = API_VERSION_ADMIN + "/manager/admin/user/list";
    //添加用户
    public static final String adminVendorUserAdd = API_VERSION_ADMIN + "/manager/admin/user/add";
    //删除用户
    public static final String adminVendorUserDelete = API_VERSION_ADMIN + "/manager/admin/user/delete";
    //修改用户
    public static final String adminVendorUserModify = API_VERSION_ADMIN + "/manager/admin/user/modify";


    //=============== 支付相关 ============================================
    //微信发来的 异步支付结果通知.    //支付通知成功后的回调地址 必须配置是哪个域名的!!!
    public static final String paymentNotifyFromWeChat = API_VERSION_VENDOR + "/payment/notify/from/wechat/pay/web";




    //=============================================================================
    //============================= 商户前台vue接口 =================================
    //=============================================================================
    //======================商户套餐相关==============================================
    //创建服务项目
    public static final String shopVendorPackageCreate = API_VERSION_VENDOR + "/package/create";
    //查询单个套餐,修改前的数据
    public static final String shopVendorPackageDetail = API_VERSION_VENDOR + "/package/detail";
    //修改后的保存接口
    public static final String shopVendorPackageUpdate = API_VERSION_VENDOR + "/package/modify";



    //======================用户套餐管理相关==============================================
    //商户套餐管理接口
    //查询用户对应套餐的修改和服务记录
    public static final String shopUserPackageList= API_VERSION_VENDOR + "/user/package/list";
    //查询详情和服务记录
    public static final String shopUserPackageDetail = API_VERSION_VENDOR + "/user/package/detail";
    //商户修改项目服务
    public static final String shopUserPackageModify = API_VERSION_VENDOR + "/user/package/modify";


    //=============== 商家产品相关   ==========================================

    //获取商家可用的商品类目
    public static final String vendorProductCategory = API_VERSION_VENDOR + "/product/category";
    //创建商品
    public static final String vendorProductCreate = API_VERSION_VENDOR + "/product/productCreate";
    //获取商家的商品列表
    public static final String vendorProductList = API_VERSION_VENDOR + "/product/productList";
    //加载一个商品的详情数据，提供给修改用！
    public static final String vendorProductLoad = API_VERSION_VENDOR + "/product/productLoad";
    //修改商品基本信息
    public static final String vendorProductModifySPU = API_VERSION_VENDOR + "/product/productModifyBasic";
    // 修改单品信息
    public static final String vendorProductModifySKU = API_VERSION_VENDOR + "/product/productModifySku";

    //=============== 商家产品分组相关   ==========================================
    //商家添加商品分组
    public static final String vendorProductGroupCreate = API_VERSION_VENDOR + "/product/group/add";
    //商家获取商品子分组接口 通过父级ID 获取 二级分类
    public static final String vendorProductGroupChildren = API_VERSION_VENDOR + "/product/group/children";
    //商家删除商品分组
    public static final String vendorProductGroupDelete = API_VERSION_VENDOR + "/product/group/delete";
    //商家修改商品分组
    public static final String vendorProductGroupModify = API_VERSION_VENDOR + "/product/group/modify";
    //商家获取商品分组接口 树状
    public static final String vendorProductGroupTree = API_VERSION_VENDOR + "/product/group/tree";


    //=============== 商家产品属性相关   ==========================================
    //获取商家可用分类中的可选属性
    public static final String vendorSkuAttrOption = API_VERSION_VENDOR + "/product/getSkuAttrOption";
    //增加商家可选分类中的可选属性（规格）
    public static final String vendorSkuAttrCreate = API_VERSION_VENDOR + "/product/productSkuAttrCreate";


    //=============== 商家图库相关   ==========================================
    //查看商家图库列表
    public static final String vendorImageList = API_VERSION_VENDOR + "/image/list";
    //上传图片
    public static final String vendorImageUpload = API_VERSION_VENDOR + "/image/upload";
    //获取腾讯云的临时密钥
    public static final String vendorImageQCloudSts = API_VERSION_VENDOR + "/image/qcloud/sts";
    //获取腾讯云的授权
    public static final String vendorImageQCloudAuth = API_VERSION_VENDOR + "/image/qcloud/auth";
    //上传腾讯云
    public static final String vendorImageQCloudUploadUrl = API_VERSION_VENDOR + "/image/qcloud/upload/url";

    //=============== 商家视频库相关   ==========================================
    //查看商家视频库列表
    public static final String vendorVideoList = API_VERSION_VENDOR + "/video/list";
    //添加商家视频库
    public static final String vendorAddVideo = API_VERSION_VENDOR + "/video/add";
    //更新商家视频库
    public static final String vendorUpdateVideo = API_VERSION_VENDOR + "/video/update";
    //删除商家视频库
    public static final String vendorDeleteVideo = API_VERSION_VENDOR + "/video/delete";

    //=============== 商家订单相关   ==========================================
    //关闭订单
    public static final String vendorOrderClose = API_VERSION_VENDOR + "/order/close";
    //获取订单详情
    public static final String vendorOrderDetail = API_VERSION_VENDOR + "/order/detail";
    //查询订单列表
    public static final String vendorOrderList = API_VERSION_VENDOR + "/order/list";
    //修改订单价格
    public static final String vendorOrderModifyPrice = API_VERSION_VENDOR + "/order/modify/price";
    //更新售后状态
    public static final String vendorOrderModifyRefund = API_VERSION_VENDOR + "/order/modify/refund";
    //更新商家备注信息
    public static final String vendorOrderModifyRemark = API_VERSION_VENDOR + "/order/modify/remark";
    //设置订单加星状态
    public static final String vendorOrderModifyStar = API_VERSION_VENDOR + "/order/modify/star";
    //设置发货状态信息
    public static final String vendorOrderSendGoods = API_VERSION_VENDOR + "/order/send/goods";
    //付款但未发货的订单
    public static final String vendorOrderNotSend = API_VERSION_VENDOR + "/order/not/send";
    //付款但未发货的订单，前十条
    public static final String vendorOrderTopTen = API_VERSION_VENDOR + "/order/top/ten";


    //=============== 商户配置主页相关   ==========================================
    //微信主页配置 列表
    public static final String vendorMainPageConfigList = API_VERSION_VENDOR + "/page/main/config/list";
    //微信主页配置 单元格显示
    public static final String vendorMainPageConfigGroupName = API_VERSION_VENDOR + "/page/main/config/group/name";
    //微信主页配置 跳转路径树
    public static final String vendorMainPageConfigNavigateTree = API_VERSION_VENDOR + "/page/main/config/navigate/tree";
    //微信主页配置 获取商品简要信息
    public static final String vendorMainPageConfigProductBrief = API_VERSION_VENDOR + "/page/main/config/product/brief";
    //微信主页配置 保存单元格
    public static final String vendorMainPageConfigSave = API_VERSION_VENDOR + "/page/main/config/save";
    //微信主页配置 单元格显示
    public static final String vendorMainPageConfigVisable = API_VERSION_VENDOR + "/page/main/config/visable";
    //微信主页配置 删除单元格
    public static final String vendorMainPageConfigDelete = API_VERSION_VENDOR + "/page/main/config/delete";

    //=============== 商户配置主页相关   ==========================================
    //获取订单列表
    public static final String vendorReservationList = API_VERSION_VENDOR + "/reservation/list";
    //服务项目次数: 增加1次
    public static final String vendorReservationItemIncrease = API_VERSION_VENDOR + "/reservation/item/increase";
    //服务项目次数: 减少1次
    public static final String vendorReservationItemDecrease = API_VERSION_VENDOR + "/reservation/item/decrease";
    //删除项目, 次数为0!
    public static final String vendorReservationItemDelete = API_VERSION_VENDOR + "/reservation/item/delete";
    //修改备注和时间
    public static final String vendorReservationModifyRemark = API_VERSION_VENDOR + "/reservation/modify/remark";
    //修改状态
    public static final String vendorReservationModifyStatus = API_VERSION_VENDOR + "/reservation/modify/status";

    //=============== 商户配置页面相关   ==========================================
    //获取页面列表
    public static final String vendorPageList = API_VERSION + "/shop/page/pagelist";
    //添加一个新的页面
    public static final String vendorAddPage = API_VERSION + "/shop/page/addpage";
    //获得指定页面数据
    public static final String vendorPageInfo = API_VERSION + "/shop/page/pageinfo";
    //修改指定页面
    public static final String vendorUpdatePage = API_VERSION + "/shop/page/updatepage";
    //删除指定页面
    public static final String vendorDeletePage = API_VERSION + "/shop/page/deletepage";


    //=============== 商家指标统计   ==========================================
    //主页指标数据
    public static final String vendorMainIndicators = API_VERSION + "/shop/main/indicators";

    //主页统计数据
    public static final String vendorMainTopIndicators = API_VERSION + "/shop/main/topIndicators";

    //=============== 商家优惠券属性相关   ==========================================
    //创建优惠券
    public static final String vendorCouponCreate = API_VERSION_VENDOR + "/coupon/create";

    //查询优惠券列表
    public static final String vendorCouponSelectByParams = API_VERSION_VENDOR + "/coupon/list/parmas";
    //编辑
    public static final String vendorCouponEditResponse = API_VERSION_VENDOR + "/coupon/edit/response";
    //编辑存入数据库
    public static final String vendorCouponEditRequest = API_VERSION_VENDOR + "/coupon/edit/request";
    //停止发放
    public static final String vendorCouponStopSend = API_VERSION_VENDOR + "/coupon/stop/send";
//    //发送模板消息
//    public static final String vendorSendTemplateMsg = API_VERSION_VENDOR + "/send/template/msg";

    //=============== 商家促销活动相关   ==========================================
    //list
    public static final String vendorPromtionList = API_VERSION_VENDOR + "/promotion/list";

    public static final String vendorPromtionProductList = API_VERSION_VENDOR + "/promotion/product/list";
    //选中商品时的简要信息 包含是否可以被选中
    public static final String vendorPromtionProductBrief = API_VERSION_VENDOR + "/promotion/product/brief";
    //创建促销活动
    public static final String vendorPromtionCreate = API_VERSION_VENDOR + "/promotion/create";
    public static final String vendorPromtionModify = API_VERSION_VENDOR + "/promotion/modify";
    public static final String vendorPromtionStatus = API_VERSION_VENDOR + "/promotion/status";
    public static final String vendorPromtionDelete = API_VERSION_VENDOR + "/promotion/delete";







    //=============================================================================
    //============================= 微信前端接口 ====================================
    //=============================================================================

    //=============== 微信用户首页   ==========================================
    public static final String weChatPageMain = API_VERSION_WECHAT + "/page/main";
    public static final String weChatPageInfo = API_VERSION_WECHAT + "/pageinfo";


    //=============== 微信用户地址相关   ==========================================
    //获取地址列表
    public static final String weChatAddressList = API_VERSION_WECHAT + "/address/list";
    //添加用户地址
    public static final String weChatAddressAdd = API_VERSION_WECHAT + "/address/add";
    //获取用户默认地址
    public static final String weChatAddressDefault = API_VERSION_WECHAT + "/address/default";
    //删除用户地址
    public static final String weChatAddressDelete = API_VERSION_WECHAT + "/address/delete";
    //通过ID获取用户地址
    public static final String weChatAddressDetail = API_VERSION_WECHAT + "/address/detail";
    //修改用户地址
    public static final String weChatAddressModify = API_VERSION_WECHAT + "/address/modify";


    //=============== 微信用户购物车相关   ==========================================
    //获取用户购物车中物品列表
    public static final String weChatCartList = API_VERSION_WECHAT + "/cart/list";
    //添加物品至用户购物车
    public static final String weChatCartAdd = API_VERSION_WECHAT + "/cart/add";
    //删除用户购物车的物品
    public static final String weChatCartDelete = API_VERSION_WECHAT + "/cart/delete";
    //修改用户购物车的物品数量
    public static final String weChatCartModify = API_VERSION_WECHAT + "/cart/modify";
    //验证单品是否有效
    public static final String weChatCartVerify = API_VERSION_WECHAT + "/cart/verify";


    //=============== 微信用户订单相关   ==========================================
    //获取支付的预支付订单信息，微信发起预支付
    public static final String weChatPaymentPrePay = API_VERSION_WECHAT + "/pay/prepay";

    //获取订单列表
    public static final String weChatOrderList = API_VERSION_WECHAT + "/order/list";
    //取消订单
    public static final String weChatOrderCancel = API_VERSION_WECHAT + "/order/cancel";
    //确认订单 确认完成状态变成已完成！
    public static final String weChatOrderConfirm = API_VERSION_WECHAT + "/order/confirm";
    //创建订单，返回orderID， 可以开始发起支付了！
    public static final String weChatOrderCreate = API_VERSION_WECHAT + "/order/create";
    //微信获取订单详情
    public static final String weChatOrderDetail = API_VERSION_WECHAT + "/order/detail";
    //确认订单界面中 的 最终价格计算
    public static final String weChatOrderPriceTotal = API_VERSION_WECHAT + "/order/price/total";


    //=============== 微信用户商品信息相关   ==========================================
    //商品详情页需要的数据，整合多个单品数据
    public static final String weChatProductDetail = API_VERSION_WECHAT + "/product/detail";
    //商品详情页选择规格时需要的价格规格和库存
    public static final String weChatProductSkuDetailList = API_VERSION_WECHAT + "/product/sku/detail/list";
    //微信通过分组ID获取商家分类中的商品列表
    public static final String weChatProductGroupProducts = API_VERSION_WECHAT + "/product/group/products";
    //微信获取商家分类信息
    public static final String weChatProductGroupTree = API_VERSION_WECHAT + "/product/group/tree";


    //=============== 微信用户信息相关   ==========================================
    //加密数据解码
    public static final String wechatUserDataDecode = API_VERSION_WECHAT + "/user/data/decode";
    //查询个人信息
    public static final String wechatUserInfo = API_VERSION_WECHAT + "/user/info";
    //获取用户短信验证码
    public static final String wechatSmsVeriicationCode = API_VERSION_WECHAT + "/user/sms/verification/code";

    //获取动态二维码
    public static final String weChatQrCodeGenerate = API_VERSION_WECHAT + "/qrcode/generate";

    //咨询服务增加接口
    public static final String weChatAdvisoryAdd = API_VERSION_WECHAT + "/advisory/add";


    //=============== 微信用户会员相关   ==========================================
    //用户会员卡
    public static final String wechatUserMemberList = API_VERSION_WECHAT + "/user/member/list";

    public static final String wechatUserMemberDetail = API_VERSION_WECHAT + "/user/member/detail";


    //=============== 微信用户会员服务预约相关   ==========================================
    //预约服务记录
    public static final String wechatUserReservationList = API_VERSION_WECHAT + "/reservation/list";

    //预约
    public static final String wechatUserReservationSubmit = API_VERSION_WECHAT + "/reservation/submit";

    //取消预约
    public static final String wechatUserReservationCancel = API_VERSION_WECHAT + "/reservation/cancel";

    //确认完成
    public static final String wechatUserReservationConfirm = API_VERSION_WECHAT + "/reservation/confirm";

    //=============== 微信用户优惠券相关   ==========================================
    //领取优惠券
    public static final String wechatUserCreateCoupon = API_VERSION_WECHAT + "/coupon/create";
    //动态查询所有的券
    public static final String wechatUserSelectCuopons = API_VERSION_WECHAT + "/coupons/list";
    //使用优惠券
    public static final String wechatUserUseCoupon = API_VERSION_WECHAT + "/coupons/use";
    //获取用户最优的优惠券
    public static final String wechatGetBestCoupon = API_VERSION_WECHAT + "/get/best/coupon";
    //获取符合规则的优惠券
    public static final String wechatGetCanUseCoupon = API_VERSION_WECHAT + "/get/can/use/coupon";
    //=============== 微信用户视频相关   ==========================================
    //转换video接口
    public static final String wechatVideoGetUrl = API_VERSION_WECHAT + "/video/geturl";


    //=============== 微信用户内容管理相关   ==========================================
    //创建收藏接口
    public static final String wechatUserStarCreate = API_VERSION_WECHAT + "/star/create";
    //创建收藏接口
    public static final String wechatUserStarSelect = API_VERSION_WECHAT + "/star/list";
    //创建收藏接口
    public static final String wechatUserStarDelete = API_VERSION_WECHAT + "/star/delete";
    //判断商品或者图文是否收藏接口
    public static final String wechatUserJudgeProductIsStar = API_VERSION_WECHAT + "/judge/is/star";


    //=============== 微信用户 获取商品的优惠活动列表   ==========================================
    public static final String wechatUserProductPromtionList = API_VERSION_WECHAT + "/product/promotion/list";

}



