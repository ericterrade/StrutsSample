package fr.treeptik.strutssample.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

import fr.treeptik.strutssample.model.Contact;

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Contact contact;

	private SessionMap<String, Object> session;

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>) session;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@SkipValidation
	@Action(value = "/loginForm", results = @Result(name = "success", location = "/pages/login.jsp"))
	public String getLoginForm() {
		return SUCCESS;

	}

	@SkipValidation
	@Action(value = "/logout", results = @Result(name = "success", location = "/pages/login.jsp"))
	public String logout() {
		session.invalidate();
		return SUCCESS;

	}

	@SkipValidation
	@Action(value = "/login", results = @Result(name = "success", location = "/pages/login-success.jsp"))
	public String getLoginSuccess() {
		session.put("USER", contact);
		addActionMessage("Vous avez bien été identifié ! "
				+ contact.getUsername());
		return SUCCESS;

	}

	// @Override
	// public String execute() throws Exception {
	// session.put("USER", contact);
	// addActionMessage("Vous avez bien été identifié ! "+contact.getUsername());
	// //on peut aller verifier en base de donné sur l'utilisateur existe.
	// return Action.SUCCESS;
	// }

}
