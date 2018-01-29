package controller;

import java.util.ArrayList;

import data.IRepositorioTextoArrayList;
import data.RepositorioTextoArrayList;
import exceptions.TextoNaoEncontrarException;
import model.Texto;

public class CadastroTexto implements ICadastroTexto {
	private IRepositorioTextoArrayList repositorioTextoArrayList;

	public CadastroTexto() {
		super();
		this.repositorioTextoArrayList = new RepositorioTextoArrayList();
	}

	@Override
	public void cadastrarTexto(Texto texto) {
		repositorioTextoArrayList.adicionarTexto(texto);
	}

	@Override
	public void descadastrarTexto(Texto texto) {
		repositorioTextoArrayList.removerTexto(texto);

	}

	@Override
	public Texto procurarTexti(int data) throws TextoNaoEncontrarException {
		return repositorioTextoArrayList.procurarTexto(data);
		
	}

	@Override
	public void getMaxCURTIDAS() throws TextoNaoEncontrarException {
		repositorioTextoArrayList.getMaxCURTIDAS();
		
	}

	@Override
	public void getMaxTxTLENGTH() throws TextoNaoEncontrarException {
		repositorioTextoArrayList.getMaxTxTLENGTH();
		
	}

	@Override
	public void getTxtWtritedByOldestPerson() throws TextoNaoEncontrarException {
		repositorioTextoArrayList.getTxtWtritedByOldestPerson();
		
	}

	@Override
	public void getLessTxTLENGTH() throws TextoNaoEncontrarException {
		repositorioTextoArrayList.getLessTxTLENGTH();
		
	}

	@Override
	public void receivelistTEXTO(ArrayList<Texto> listasalva) {
		repositorioTextoArrayList.receistlistTEXTO(listasalva);
		
	}

	@Override
	public void savelistTEXTO() {
		repositorioTextoArrayList.savelistTEXTO();
		
	}

	@Override
	public ArrayList<Texto> getListaTexto() {
		
		return repositorioTextoArrayList.getListaTexto();
	}

}
