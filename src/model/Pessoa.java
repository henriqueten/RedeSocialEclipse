package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import exceptions.UsuarioJaAdicionadoException;
import exceptions.UsuarioNaoEncontrarException;

public class Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private int idade;
	private String cpf;
	private List<Pessoa> amigos;
	private List<Pessoa> amigosPendentes;
	private List<Texto> textosParaTimeline;

	public Pessoa(String nome, int idade, String cpf) {
		super();
		this.amigos = new ArrayList<Pessoa>();
		this.amigosPendentes = new ArrayList<Pessoa>();
		this.textosParaTimeline = new ArrayList<Texto>();
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
	}

	public void adicionarTextosParaTimeLine(Texto t) {
		textosParaTimeline.add(t);
		
	}

	public void aceitarConvite(String resposta, Pessoa pe) {
		if (resposta.equalsIgnoreCase("sim")) {
			amigos.add(pe);
		} else if (resposta.equalsIgnoreCase("não")) {
			System.out.println("Amigo Não Sera Adicionado");
		}
	}

	public void addPendenciaAmigos(Pessoa per) throws UsuarioJaAdicionadoException {
		for (Pessoa pessoa : amigosPendentes) {
			if (pessoa.getCpf() == per.getCpf()) {
				throw new UsuarioJaAdicionadoException();
			}
		}
		amigosPendentes.add(per);
		System.out.println("==========AMIZADE PENDENTE!==========");

	}

	public void removerPendenciaAmigos(Pessoa per) {
		amigosPendentes.remove(per);

	}

	public List<Texto> getTextosParaTimeline() {
		return textosParaTimeline;
	}

	public void setTextosParaTimeline(List<Texto> textosParaTimeline) {
		this.textosParaTimeline = textosParaTimeline;
	}

	public List<Pessoa> getAmigosPendentes() {
		return amigosPendentes;
	}

	public void setAmigosPendentes(List<Pessoa> amigosPendentes) {
		this.amigosPendentes = amigosPendentes;
	}

	public List<Pessoa> getAmigos() {
		return amigos;
	}

	public void setAmigos(ArrayList<Pessoa> amigos) {
		this.amigos = amigos;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void listaAmigos() {
		for (Pessoa pessoa : amigos) {
			System.out.println("NOME: " + pessoa.getNome());
		}
	}

	public void listaAmigosPendentes() {
		if (amigosPendentes.size() == 0) {
			System.out.println("==========NÃO HÁ AMIZADES PENDENTES==========");
		} else {
			for (Pessoa pessoa : amigosPendentes) {
				System.out.println("NOME: " + pessoa.getNome() + " CPF: " + pessoa.getCpf());

			}
		}
	}
	public int getListaAmigosPendetesSize() {
		return amigosPendentes.size();
	}
}
