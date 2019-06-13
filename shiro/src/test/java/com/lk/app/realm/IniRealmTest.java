package com.lk.app.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;

/**
 * IniRealm测试
 * ini文件中的配置有严格语法要求
 *
 * @author LK
 * @date 2019/6/12
 */
public class IniRealmTest {

    @Test
    public void testIniRealm() {
        IniRealm iniRealm = new IniRealm("classpath:user.ini");

        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(iniRealm);

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Jack", "123");
        subject.login(token);

        Assert.assertTrue(subject.isAuthenticated());

        subject.checkRoles("admin");

        subject.checkPermissions("user:update", "user:delete");
    }
}
