package com.sudha;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class StudentAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String status = "";
		StudentActionForm saf = (StudentActionForm) form;
		String sid = saf.getSid();
		String sname = saf.getSname();
		String saddr = saf.getSaddr();
		StudentService stdService = new StudentService();
		status = stdService.registration(sid, sname, saddr);
		return mapping.findForward(status);
	}
}
