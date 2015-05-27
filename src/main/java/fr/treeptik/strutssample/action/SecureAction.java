package fr.treeptik.strutssample.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("secure")
public class SecureAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	@SkipValidation
	@Action(value = "/securepage", results = @Result(name = "success", location = "/pages/secure-page.jsp"))
	public String getSecurePage() {
		return SUCCESS;
	}

}
