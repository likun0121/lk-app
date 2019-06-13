package com.lk.app.base;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * shiro授权测试
 *
 * @author LK
 * @date 2019/6/12
 */
public class AuthorizerTest {

    private SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void before() {
        simpleAccountRealm.addAccount("Jack", "123", "admin", "normal");
    }

    @Test
    public void testAuthorize() {
        // 1.构建SecurityManager环境
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(simpleAccountRealm);

        // 2.主体提交认证请求
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Jack", "123");
        subject.login(token);

        Assert.assertTrue(subject.isAuthenticated());

        subject.checkRoles("admin", "normal");

    }
}
