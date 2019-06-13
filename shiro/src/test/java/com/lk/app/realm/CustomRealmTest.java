package com.lk.app.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

/**
 * 自定义Realm测试
 *
 * @author LK
 * @date 2019/6/13
 */
public class CustomRealmTest {

    @Test
    public void testCustomRealm() {
        CustomRealm customRealm = new CustomRealm();

        // 加密
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1);
        customRealm.setCredentialsMatcher(matcher);

        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(customRealm);

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Jack", "123");
        subject.login(token);

        Assert.assertTrue(subject.isAuthenticated());

        subject.checkRoles("admin", "user");

        subject.checkPermissions("user:select", "user:delete");
    }
}
