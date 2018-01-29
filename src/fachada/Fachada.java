package fachada;

import java.util.ArrayList;

import controller.CadastroPessoa;
import controller.CadastroTexto;
import controller.ICadastroPessoa;
import controller.ICadastroTexto;
import exceptions.PessoaJaExisteException;
import exceptions.TextoNaoEncontrarException;
import exceptions.UsuarioNaoEncontrarException;
import model.Pessoa;
import model.Texto;

public class Fachada implements ICadastroPessoa, ICadastroTexto {
	private ICadastroPessoa cadastroPessoa;
	private ICadastroTexto cadastroTexto;
	private static Fachada instance = null;
	
	
	public Fachada() {
		super();
		this.cadastroPessoa = new CadastroPessoa();
		this.cadastroTexto = new CadastroTexto();
		
	}
	public static Fachada getInstance() {
		if (instance == null) {
			instance = new Fachada();
		}
		return instance;
	}

	@Override
	public void cadastrarTexto(Texto texto) {
		cadastroTexto.cadastrarTexto(texto);
		
	}

	@Override
	public void descadastrarTexto(Texto texto) {
		cadastroTexto.descadastrarTexto(texto);
		
	}

	@Override
	public Pessoa searchPessoa(String cpf) throws UsuarioNaoEncontrarException {
		
		return cadastroPessoa.searchPessoa(cpf);
	}

	@Override
	public void cadastrarPessoa(Pessoa pessoa) throws PessoaJaExisteException, UsuarioNaoEncontrarException {
		cadastroPessoa.cadastrarPessoa(pessoa);
		
	}

	@Override
	public void descadastrarPessoa(Pessoa pessoa) throws UsuarioNaoEncontrarException {
		cadastroPessoa.descadastrarPessoa(pessoa);
		
	}
	@Override
	public Texto procurarTexti(int data) throws TextoNaoEncontrarException {
		return cadastroTexto.procurarTexti(data);
		
	}
	@Override
	public void getMaxCURTIDAS() throws TextoNaoEncontrarException {
		cadastroTexto.getMaxCURTIDAS();
		
	}
	@Override
	public void getMaxTxTLENGTH() throws TextoNaoEncontrarException {
		cadastroTexto.getMaxTxTLENGTH();
		
	}
	@Override
	public void getTxtWtritedByOldestPerson() throws TextoNaoEncontrarException {
		cadastroTexto.getTxtWtritedByOldestPerson();
		
	}
	@Override
	public void getLessTxTLENGTH() throws TextoNaoEncontrarException {
		cadastroTexto.getLessTxTLENGTH();
		
	}
	@Override
	public void getPersonWithMoreFriends() throws UsuarioNaoEncontrarException {
		cadastroPessoa.getPersonWithMoreFriends();
		
	}
	@Override
	public void getPersonWithMoreTxT() throws UsuarioNaoEncontrarException {
		cadastroPessoa.getPersonWithMoreTxT();
		
	}
	@Override
	public void getOldestPerson() throws UsuarioNaoEncontrarException {
		cadastroPessoa.getOldestPerson();
		
	}
	@Override
	public void getPersonWithLOngestName() throws UsuarioNaoEncontrarException {
		cadastroPessoa.getPersonWithLOngestName();
		
	}
	@Override
	public void getPersonWithLessFriends() throws UsuarioNaoEncontrarException {
		cadastroPessoa.getPersonWithLessFriends();
		
	}
	@Override
	public void getYoungerPerson() throws UsuarioNaoEncontrarException {
		cadastroPessoa.getYoungerPerson();
		
	}
	@Override
	public void existePessoaCadastro(Pessoa p) {
		cadastroPessoa.existePessoaCadastro(p);
		
	}
	@Override
	public ArrayList<Pessoa> getListaPessoas() {
		
		return cadastroPessoa.getListaPessoas();
	}
	@Override
	public void savelist() {
		cadastroPessoa.savelist();
		
	}
	@Override
	public void receivelist(ArrayList<Pessoa> listasalva) {
		cadastroPessoa.receivelist(listasalva);
		
	}
	@Override
	public void receivelistTEXTO(ArrayList<Texto> listasalva) {
		cadastroTexto.receivelistTEXTO(listasalva);
		
	}
	@Override
	public void savelistTEXTO() {
		cadastroTexto.savelistTEXTO();
		
	}
	@Override
	public ArrayList<Texto> getListaTexto() {
		// TODO Auto-generated method stub
		return cadastroTexto.getListaTexto();
	}
	

}
