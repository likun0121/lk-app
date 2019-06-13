package com.lk.app.realm;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;

/**
 * JDBCRealm测试
 *
 * @author LK
 * @date 2019/6/13
 */
public class JdbcRealmTest {

    private DruidDataSource dataSource = new DruidDataSource();

    {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/shiro");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
    }

    @Test
    public void testJdbcRealmDefaultSql() {
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        // 如果校验权限，需要开启权限可用
        jdbcRealm.setPermissionsLookupEnabled(true);

        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(jdbcRealm);

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Jack", "123");
        subject.login(token);

        Assert.assertTrue(subject.isAuthenticated());

        subject.checkRoles("admin", "user");

        subject.checkPermissions("user:update", "user:add");
    }

    @Test
    public void testJdbcRealmCustomSql() {
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);

        String sql = "select password from t_users where username = ?";
        jdbcRealm.setAuthenticationQuery(sql);

        String roleSql = "select role_name from t_user_roles where username = ?";
        jdbcRealm.setUserRolesQuery(roleSql);

        String permissionSql = "select permission from t_roles_permissions where role_name = ?";
        jdbcRealm.setPermissionsQuery(permissionSql);

        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(jdbcRealm);

        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("Tom", "123");
        subject.login(token);

        Assert.assertTrue(subject.isAuthenticated());

        subject.checkRoles("admin", "user");

        subject.checkPermissions("user:add", "user:select");
    }
}
