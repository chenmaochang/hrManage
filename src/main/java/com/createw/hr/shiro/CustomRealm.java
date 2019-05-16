package com.createw.hr.shiro;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.createw.hr.bean.Role;
import com.createw.hr.bean.User;
import com.createw.hr.bean.UserExample;
import com.createw.hr.bean.UserExample.Criteria;
import com.createw.hr.bean.UserRoleRelationExample;
import com.createw.hr.mapper.RoleMapper;
import com.createw.hr.mapper.UserMapper;
import com.createw.hr.mapper.UserRoleRelationMapper;
import com.createw.hr.utils.MD5Utils;

public class CustomRealm extends AuthorizingRealm {
	@Resource
	private UserMapper userMapper;
	@Resource
	private RoleMapper roleMapper;
	/*
	 * private UserMapper userMapper;
	 * 
	 * @Autowired private void setUserMapper(UserMapper userMapper) {
	 * this.userMapper = userMapper; }
	 */

	/**
	 * 获取身份验证信息 Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
	 *
	 * @param authenticationToken 用户身份信息 token
	 * @return 返回封装了用户信息的 AuthenticationInfo 实例
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andAccountEqualTo(token.getUsername());
		List<User> users = userMapper.selectByExample(userExample);
		User user=null;
		if (users.size() > 0) {
			user = users.get(0);// 从数据库获取对应用户名密码的用户
			String password = user.getPassword();
			if (!password.equals(new String((char[])token.getCredentials()))) {
				throw new AccountException("密码不正确");
			}
		} else {
			throw new AccountException("用户名不正确");
		}
		SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user, new String((char[])token.getCredentials()), getName());
		return authenticationInfo;
	}

	/**
	 * 获取授权信息
	 *
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		String account = (String) SecurityUtils.getSubject().getPrincipal();
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 获得该用户角色
		Set<String> set = new HashSet<>();
		UserExample userExample=new UserExample();
		Criteria criteria=userExample.createCriteria();
		criteria.andAccountEqualTo(account);
		List<Role> roles=roleMapper.getByUserId(userMapper.selectByExample(userExample).get(0).getId());
		for (Role role : roles) {
			set.add(role.getRoleName());
		}
		// 设置该用户拥有的角色
		info.setRoles(set);
		return info;
	}
}
