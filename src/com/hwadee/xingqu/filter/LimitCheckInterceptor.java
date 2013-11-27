package com.hwadee.xingqu.filter;


import java.util.Map;

import com.hwadee.xingqu.model.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;


public class LimitCheckInterceptor extends AbstractInterceptor {

	/**
	 * @author 张勇
	 * @since 2013-07-01
	 * 用于权限检查
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

	
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		User user = (User) session.get("user");
		if ("3".equals(user.getUtype())) {
			return invocation.invoke();
		}
		ctx.put("tip", "您没有空间！");
		return "error";

	}
}
