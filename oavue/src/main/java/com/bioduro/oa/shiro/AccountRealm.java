package com.bioduro.oa.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.bioduro.oa.entity.User;
import com.bioduro.oa.service.UserService;
import com.bioduro.oa.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        JwtToken jwtToken = (JwtToken) token;
        String userid = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();
        System.out.println("userid----"+userid);
        User user = userService.getById(Long.valueOf(userid));
        if(user== null){
            throw new UnknownAccountException("账户不存在");
        }
        if(user.getStatus() == -1){
            throw new LockedAccountException("账户已被锁定");
        }
        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user,profile);
        System.out.println("----------------");

        return new SimpleAuthenticationInfo(profile, jwtToken.getCredentials(),getName());
    }
}
