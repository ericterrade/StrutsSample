package fr.treeptik.strutssample.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ActionSupport;

import fr.treeptik.strutssample.model.Contact;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private Contact contact;

	@SkipValidation
	// ignorer la validation c'est juste de la redirection de page
	@Action(value = "/hello", results = @Result(name = "success", location = "/pages/hello.jsp"))
	public String getHelloWorldPage() {
		return SUCCESS;

	}

	@SkipValidation
	// ignorer la validation c'est juste de la redirection de page
	@Action(value = "/register", results = @Result(name = "success", location = "/pages/register.jsp"))
	public String register() {
		return SUCCESS;

	}

	@Action(value = "registration", results = {
			@Result(name = "success", location = "/pages/registration-ok.jsp"),
			@Result(name = "input", location = "/pages/register.jsp"),
			@Result(name = "error", location = "/pages/registration-error.jsp") })
	public String registration() {

		addActionMessage("enregistrement de " + contact.getUsername()
				+ " correctement effectué");
		if (contact.getUsername().equals("admin")) {
			addActionError("Erreur le USERNAME et déjà pris!");
			return ERROR;

		}
		return SUCCESS;

	}

	// @Override
	// public String execute() throws Exception {
	// addActionMessage("enregistrement de " + contact.getUsername()
	// + " correctement effectué");
	// if(contact.getUsername().equals("admin")){
	// addActionError("Erreur le USERNAME et déjà pris!");
	// return Action.ERROR;
	//
	// }
	//
	// return Action.SUCCESS;
	// }

	// @Override
	// public void validate() {
	// if(contact.getUsername()==null ||
	// contact.getUsername().equalsIgnoreCase("")){
	// addFieldError("username", "Username manquant");
	// }
	//
	// if(contact.getPassword()==null ||
	// contact.getPassword().equalsIgnoreCase("")){
	// addFieldError("password", "Password manquant");
	// }
	// }
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
