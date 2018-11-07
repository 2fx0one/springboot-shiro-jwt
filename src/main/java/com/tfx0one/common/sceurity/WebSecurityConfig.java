package com.tfx0one.common.sceurity;

import com.tfx0one.common.constant.APIConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * Created by 2fx0one on 2018/6/4.
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //springboot安全配置 配合 JWT Token 使用

    @Override
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Resource
    private com.tfx0one.common.sceurity.impl.UserDetailsServiceImpl UserDetailsServiceImpl;

    @Resource
    private com.tfx0one.common.sceurity.filter.AuthenticationFilter AuthenticationFilter;

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                // 设置UserDetailsService
                .userDetailsService(UserDetailsServiceImpl)
                // 使用BCrypt进行密码的hash
                .passwordEncoder(passwordEncoder());
    }

    // 装载BCrypt密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public JwtAuthenticationTokenFilter authenticationTokenFilter() throws Exception {
//        return new JwtAuthenticationTokenFilter();
//    }

    private static String[] antPatternsPermitAllMethodGet = {
            // 允许对于网站静态资源的无授权访问
            "/",
            "/v2/api-docs",
            "/swagger-resources/**",
            "/*.html",
            "*.ico",
            "/**/*.html",
            "/**/*.png",
            "/**/*.css",
            "/**/*.js",
            //微信主页
            APIConstant.weChatPageMain,
            APIConstant.weChatPageInfo,

            //微信主页 分类信息 树状
            APIConstant.weChatProductGroupTree,

            //微信主页 分类中的商品列表
            APIConstant.weChatProductGroupProducts,

            //商品详情页需要的数据，整合多个单品数据
            APIConstant.weChatProductDetail,

            //商品详情页选择规格时需要的价格规格和库存
            APIConstant.weChatProductSkuDetailList,

            //获取动态二维码
            APIConstant.weChatQrCodeGenerate,

            APIConstant.wechatVideoGetUrl
    };

    private static String[] antPatternsPermitAllMethodPost = {
            APIConstant.paymentNotifyFromWeChat, //微信需要的支付通知
            APIConstant.weChatQrCodeGenerate,     //获取动态二维码
            APIConstant.weChatAdvisoryAdd,    //获取用户的反馈信息
            APIConstant.authSysUserLogin, //后台网页登录
            APIConstant.authWeChatLogin //微信登录
    };


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors()
                .and()
                // 由于使用的是JWT，我们这里不需要csrf
                .csrf().disable()

                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()

                .authorizeRequests()
                //.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                .antMatchers(
                        HttpMethod.GET,
                        antPatternsPermitAllMethodGet
                ).permitAll()

                .antMatchers(
                        HttpMethod.POST,
                        antPatternsPermitAllMethodPost
                ).permitAll()

                // 除上面外的所有请求全部需要鉴权认证
                .anyRequest().authenticated();


        // 禁用缓存
        httpSecurity.headers().cacheControl();

        httpSecurity.addFilterBefore(AuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
