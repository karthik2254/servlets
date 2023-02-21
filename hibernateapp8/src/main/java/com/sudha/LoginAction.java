package com.sudha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		LoginActionForm laf = (LoginActionForm) form;
		String uname = laf.getUname();
		String upwd = laf.getUpwd();
		String status = "";
		if (uname.equals("sudha") && upwd.equals("sudha")) {
			status = "success";
		} else {
			status = "failure";
		}
		return mapping.findForward(status);
	}
}
