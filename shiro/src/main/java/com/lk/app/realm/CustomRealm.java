package com.lk.app.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 自定义Realm
 *
 * @author LK
 * @date 2019/6/13
 */
public class CustomRealm extends AuthorizingRealm {

    private Map<String, String> userMap = new HashMap<>(1);

    {
        userMap.put("Jack", "ea2dfb9ca92706e1c03b2c7baaf69f91");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        // 模拟从数据库中获取用户的角色
        Set<String> roles = getRolesByUsername(username);
        // 模拟从数据库重获取用户的权限
        Set<String> permissions = getPermissionByRoles(roles);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);

        return authorizationInfo;
    }

    /**
     * 模拟从数据库中获取角色的权限
     *
     * @param roles
     * @return
     */
    private Set<String> getPermissionByRoles(Set<String> roles) {
        Set<String> set = new HashSet<>();
        set.add("user:select");
        set.add("user:add");
        set.add("user:update");
        set.add("user:delete");
        return set;
    }

    /**
     * 模拟从数据库中获取用户的角色
     *
     * @param username
     * @return
     */
    private Set<String> getRolesByUsername(String username) {
        Set<String> set = new HashSet<>();
        set.add("admin");
        set.add("user");
        return set;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 从请求的主体信息中获取用户名和密码
        String username = (String) authenticationToken.getPrincipal();

        // 模拟根据用户名从数据库查询密码
        String password = getPasswordByUsername(username);
        if (password == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, this.getName());
        // 加盐
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(username));
        return authenticationInfo;
    }

    /**
     * 模拟根据用户名查询用户密码
     *
     * @param username
     * @return
     */
    private String getPasswordByUsername(String username) {
        return userMap.get(username);
    }
}
