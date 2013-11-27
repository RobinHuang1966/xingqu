package com.hwadee.xingqu.filter;


import java.util.Map;

import com.hwadee.xingqu.model.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class LoginInterceptor extends AbstractInterceptor {

	/**
	 * @author 张勇
	 * 用于检查用户是否登录
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {


		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		User user = (User) session.get("user");

		if (user!= null) {

			return invocation.invoke();
		}
		ctx.put("tip", "您还没有登录！");
		return Action.LOGIN;

	}
}
