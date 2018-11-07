package com.tfx0one.common.sceurity.filter;

import com.alibaba.fastjson.JSONObject;
import com.tfx0one.common.constant.APIConstant;
import com.tfx0one.common.sceurity.JWTUtils;
import com.tfx0one.common.sceurity.impl.UserDetailsImpl;
import com.tfx0one.common.sceurity.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 2fx0one on 2018/6/4.
 */

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    //自动装配JwtUserDetailService 把jwt 集成到 security
    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;
//
//    @Resource
//    private RolePermissionService rolePermissionService;
//
//    @Resource
//    private RoleService roleService;

//    @Autowired
//    private JWTUtils jwtUtils;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain
    )
            throws ServletException, IOException {
//        response.setHeader("Access-Control-Allow-Origin",request.getHeader("Origin"));
//        response.setHeader("Access-Control-Allow-Credentials", "true");
//        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        String authHeader = request.getHeader(this.tokenHeader);
//        request.getRequestURL()
        logger.info(" 收到请求 request url = " + request.getRequestURL() + "  Authorization = \"" + authHeader + "\"");

        //对于所有的请求， 如果包含token 都需要嵌入数据到 进行验证 然后再走原来的请求链。filterChain.doFilter
        if (authHeader != null && authHeader.startsWith(tokenHead) && authHeader.length() > tokenHead.length() + 1) {
//            logger.info("authentication authHeader = [ " + authHeader + " ]");
            final String authToken = authHeader.substring(tokenHead.length() + 1); // The part after "Bearer " 用空格
            logger.info("checking authToken ===== " + authToken);
            String username = JWTUtils.getUsernameFromToken(authToken);

//            logger.info("authentication username = " + username);
//            //TODO 验证失败时。需要返回信息
            if (username == null) {
                errorStrWriteToResponse(response, APIConstant.TOKEN_ILLEGAL, "失效的 Token， username == null");
                return;
            }

            //需要验证 token，加入到授权上下文
            if (SecurityContextHolder.getContext().getAuthentication() == null) {

                //简单验证
                UserDetailsImpl userDetails = userDetailsServiceImpl.loadUserByUsername(username);

                //验证token 和 userDetail 是否一致
                if (JWTUtils.validateToken(authToken, userDetails)) {
                    logger.info(" ===== SecurityContextHolder.getContext().setAuthentication(authentication) username ===== " + username);

                    //把用户信息放到 SecurityContextHolder
                    UsernamePasswordAuthenticationToken authentication
                            = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    errorStrWriteToResponse(response, APIConstant.TOKEN_ILLEGAL, "validateToken 验证失败 Token");
                    return;
                }

                //权限已经注入 SecurityContextHolder。接下来需要验证非管理用户是否可以访问url的权限。
//                if (!userDetails.isAdmin()) {
//                    String uri = request.getRequestURI();
//                    String ctx = request.getContextPath();
//                    String path = uri.replace(ctx, ""); //请求路径

                //所有的权限数据
//                    Map<String, EShopRolePermission> all = rolePermissionService.selectAllActiveRolePermission();// .getVendorPackageItemListByVendorPackageId(new EShopRolePermission().withDelFlag((byte)0));

                //过滤出匹配的权限
//                    for (EShopRolePermission permission : all.values()) {
//                        if (!StringUtils.isEmpty(permission.getPath())) {
//                            AntPathRequestMatcher matcher = new AntPathRequestMatcher(permission.getPath());
//
//                            //判断如果url不在数据库中，则默认都有权限访问。
//                            if (matcher.matches(request)) {
//                                //匹配到权限，找到拥有该权限的角色
//                                List<EShopRole> roles = roleService.selectUserRoleByPermissionId(permission.getId());
//
//                                //获取当前访问用户的角色
//                                EShopRole role = roleService.selectById(userDetails.getRoleId());
//
//                                //检查该用户的角色， 不在列表中，表示无权限。
//                                if (roles.stream().noneMatch(e -> e.getId().equals(role.getId()))) {
//                                    errorStrWriteToResponse(response, APIConstant.TOKEN_ACCESS_DENIED, "URL Access Denied 无权访问该链接！ path = " + path);
//                                    return;
//                                }
//                            }
//                        }
//                    }
//                }
            }
        }
        filterChain.doFilter(request, response);
    }

    private void errorStrWriteToResponse(HttpServletResponse response, int code, String errorStr) throws IOException {
//        String errStr = "{\"code\":" + code + "" + new Date().toString() + ",\"msg\":\"" + errorCode + "\"}";

        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("timestamp", new Date().toString());
        map.put("msg", errorStr);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        response.getWriter().println(JSONObject.toJSONString(map));
//        throw new AccessDeniedException("Access Denied！");
    }

}
