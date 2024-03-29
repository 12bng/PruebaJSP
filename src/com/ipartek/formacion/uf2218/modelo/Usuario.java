package com.ipartek.formacion.uf2218.modelo;

public class Usuario {
	private String nick;
	private String password;
	private Boolean admin;
	private String errorNick;
	private String errorPassword;
	private String errorUsuario;
	private String errorNewNick;
	private String errorNewPassword;
	private boolean valido = true;
	
	public String getErrorNewNick() {
		return errorNewNick;
	}

	public void setErrorNewNick(String errorNewNick) {
		this.errorNewNick = errorNewNick;
	}

	public String getErrorNewPassword() {
		return errorNewPassword;
	}

	public void setErrorNewPassword(String errorNewPassword) {
		this.errorNewPassword = errorNewPassword;
	}

	

	public Usuario(String nick, String password) {
		super();
		setNick(nick);
		setPassword(password);
		setAdmin(false);
	}

	public Usuario(String nick, Boolean isAdmin) {
		super();
		setNick(nick);
		setAdmin(isAdmin);
	}

	public Usuario(String nick, String password, Boolean isAdmin) {
		super();
		setNick(nick);
		setPassword(password);
		setAdmin(isAdmin);
	}

	public void setAdmin(Boolean isAdmin) {
		admin = isAdmin;
	}

	public Boolean isAdmin() {
		return admin;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		if (nick == null) {
			throw new ModeloException("No se admiten nicks nulos");
		}

		if (nick.trim().length() == 0) {
			setErrorNick("No se admiten nicks vacíos");
		}
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorNick() {
		return errorNick;
	}

	public void setErrorNick(String errorNick) {
		this.errorNick = errorNick;
		setValido(false);
	}

	public String getErrorPassword() {
		return errorPassword;
	}

	public void setErrorPassword(String errorPassword) {
		this.errorPassword = errorPassword;
		setValido(false);
	}

	public String getErrorUsuario() {
		return errorUsuario;
	}

	public void setErrorUsuario(String errorUsuario) {
		this.errorUsuario = errorUsuario;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean hayErrores) {
		this.valido = hayErrores;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nick == null) ? 0 : nick.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nick == null) {
			if (other.nick != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [nick=" + nick + ", password=" + password + "]";
	}

}
