package model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

public class Texto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Pessoa> curtidas;
	private String texto;
	private Pessoa pessoa;
	private int data;

	public Texto(String texto, Pessoa pessoa) {

		super();
		this.curtidas = new ArrayList<Pessoa>();

		this.texto = texto;
		this.pessoa = pessoa;
		this.data = Calendar.getInstance().get(Calendar.YEAR) + Calendar.getInstance().get(Calendar.MONTH)
				+ Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
				+ Calendar.getInstance().get(Calendar.MINUTE) + Calendar.getInstance().get(Calendar.SECOND);
	}

	public void addListaCurtida(Pessoa p) {
		curtidas.add(p);

	}

	public void removeListaCurtida(Pessoa p) {
		curtidas.remove(p);
	}

	public List<Pessoa> getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(List<Pessoa> curtidas) {
		this.curtidas = curtidas;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}
