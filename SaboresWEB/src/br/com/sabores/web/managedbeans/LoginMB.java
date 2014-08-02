package br.com.sabores.web.managedbeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@SessionScoped
@Named("loginMB")
public class LoginMB implements Serializable
{
	private String email_header;
	private String senha_header;
	private boolean logged = false;
	
	public void logar()
	{
		this.logged = true;
	}
	
	public void logoff()
	{
		this.logged = false;
	}
	
	
	public boolean isLogged()
	{
		return logged;
	}
	
	public void setLogged(boolean logged)
	{
		this.logged = logged;
	}
	
	public String getEmail_header()
	{
		return email_header;
	}
	
	public void setEmail_header(String email_header)
	{
		this.email_header = email_header;
	}
	
	public String getSenha_header()
	{
		return senha_header;
	}
	
	public void setSenha_header(String senha_header)
	{
		this.senha_header = senha_header;
	}
	
	
}
