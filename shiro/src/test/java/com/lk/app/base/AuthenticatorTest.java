package com.lk.app.base;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * shiro认证测试
 *
 * @author LK
 * @date 2019/6/12
 */
public class AuthenticatorTest {

    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public void before() {
        simpleAccountRealm.addAccount("admin", "123");
    }

    @Test
    public void testAuthenticator() {

        // 1.构建SecurityManager环境
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(simpleAccountRealm);

        // 2.主体提交认证请求
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        // 3.生成token
        UsernamePasswordToken token = new UsernamePasswordToken("admin", "123");
        subject.login(token);

        boolean authenticated = subject.isAuthenticated();
        assertTrue(authenticated);
    }
}
