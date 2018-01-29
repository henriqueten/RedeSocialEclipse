package controller;

import java.util.ArrayList;

import data.IRepositorioPessoaArrayList;
import data.RepositorioPessoaArrayList;
import exceptions.PessoaJaExisteException;
import exceptions.UsuarioNaoEncontrarException;
import model.Pessoa;

public class CadastroPessoa implements ICadastroPessoa {
	private IRepositorioPessoaArrayList repositorioPessoaArrayList;

	public CadastroPessoa() {
		super();
		this.repositorioPessoaArrayList = new RepositorioPessoaArrayList();
	}

	@Override
	public Pessoa searchPessoa(String cpf) throws UsuarioNaoEncontrarException {
		 Pessoa pes = repositorioPessoaArrayList.procurarPessoa(cpf);
		return pes;
			
		
	}

	@Override
	public void cadastrarPessoa(Pessoa pessoa) throws PessoaJaExisteException {

		if (!repositorioPessoaArrayList.existePessoa(pessoa)) {
			repositorioPessoaArrayList.adicionarPessoa(pessoa);
		} else {
			throw new PessoaJaExisteException();
		}

	}

	@Override
	public void descadastrarPessoa(Pessoa pessoa) throws UsuarioNaoEncontrarException {
		
		if (repositorioPessoaArrayList.existePessoa(pessoa)) {

			repositorioPessoaArrayList.removerPessoa(pessoa);
		} else {
			throw new UsuarioNaoEncontrarException();
		}
	}

	@Override
	public void getPersonWithMoreFriends() throws UsuarioNaoEncontrarException {
		repositorioPessoaArrayList.getPersonWithMoreFriends();
		
	}

	@Override
	public void getPersonWithMoreTxT() throws UsuarioNaoEncontrarException {
		repositorioPessoaArrayList.getPersonWithMoreTxT();
		
	}

	@Override
	public void getOldestPerson() throws UsuarioNaoEncontrarException {
		repositorioPessoaArrayList.getOldestPerson();
		
	}

	@Override
	public void getPersonWithLOngestName() throws UsuarioNaoEncontrarException {
		repositorioPessoaArrayList.getPersonWithLOngestName();
		
	}

	@Override
	public void getPersonWithLessFriends() throws UsuarioNaoEncontrarException {
		repositorioPessoaArrayList.getPersonWithLessFriends();
		
	}

	@Override
	public void getYoungerPerson() throws UsuarioNaoEncontrarException {
		repositorioPessoaArrayList.getYoungerPerson();
		
	}

	@Override
	public void existePessoaCadastro(Pessoa p) {
		repositorioPessoaArrayList.existePessoa(p);
		
	}

	@Override
	public ArrayList<Pessoa> getListaPessoas() {
		
		return repositorioPessoaArrayList.getListaPessoa();
	}

	@Override
	public void savelist() {
		repositorioPessoaArrayList.savelist();
		
	}

	@Override
	public void receivelist(ArrayList<Pessoa> listasalva) {
		repositorioPessoaArrayList.receivelist(listasalva);
		
	}
	

}
