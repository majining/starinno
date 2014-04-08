package com.starinno.portal.common.tags;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.starinno.portal.common.util.Page;

public class PageTags extends TagSupport {
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int doStartTag() throws JspException {
		try {
			ServletRequest request= pageContext.getRequest();
			Page mypage=(Page)request.getAttribute(name);
			pageContext.getOut().write(mypage.writeTags());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}
}
