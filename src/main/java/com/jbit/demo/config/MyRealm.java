package com.jbit.demo.config;
import	java.util.stream.Collectors;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.jbit.demo.dao.PermissionDao;
import com.jbit.demo.dao.RoleDao;
import com.jbit.demo.dao.UserDao;
import com.jbit.demo.entity.Permission;
import com.jbit.demo.entity.Role;
import com.jbit.demo.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;


public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String userName=(String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Set<String> roles=new HashSet<String>();
        List<Role> rolesByUserName = roleDao.getRolesByUserName(userName);
        for(Role role:rolesByUserName) {
            roles.add(role.getRoleName());
        }
        List<Permission> permissionsByUserName = permissionDao.getPermissionsByUserName(userName);
        info.addStringPermissions(permissionsByUserName.stream().map(p->p.getPermissionName()).collect(Collectors.toList()));
//        for(Permission permission:permissionsByUserName) {
//            info.addStringPermission(permission.getPermissionName());
//        }
        info.setRoles(roles);
        return info;
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("token.getPrincipal:" + token.getPrincipal());
        System.out.println("token.getCredentials:" + token.getCredentials());
        String userName = token.getPrincipal().toString();
        User user = userDao.getUserByUserName(userName);
        if (user != null) {
            // Object principal, Object credentials, String realmName
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());
            this.setSession("user",user);
            return authcInfo;
        } else {
            return null;
        }
    }
    private void setSession(Object key, Object value) {
        Subject currentUser = SecurityUtils.getSubject();
        if (null != currentUser) {
            Session session = currentUser.getSession();
            if (null != session) {
                session.setAttribute(key, value);
            }
        }
    }

}