package data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import exceptions.TextoNaoEncontrarException;
import exceptions.UsuarioNaoEncontrarException;
import model.Pessoa;
import model.Texto;

public class RepositorioTextoArrayList implements IRepositorioTextoArrayList {
	private ArrayList<Texto> textos;

	public RepositorioTextoArrayList() {
		super();
		this.textos = new ArrayList<Texto>();
	}

	@Override
	public ArrayList<Texto> getListaTexto() {
		return textos;
	}

	@Override
	public void adicionarTexto(Texto texto) {
		textos.add(texto);

	}

	@Override
	public void removerTexto(Texto texto) {
		textos.remove(texto);

	}

	@Override
	public Texto procurarTexto(int data) throws TextoNaoEncontrarException {
		Texto aux = null;

		for (Texto txt2 : this.textos) {

			if (txt2.getData() == data) {
				aux = txt2;
				break;
			}

		}
		if (aux == null) {
			throw new TextoNaoEncontrarException();
		}
		return aux;

	}

	// Relater 1
	@Override
	public void getMaxCURTIDAS() throws TextoNaoEncontrarException {
		int max = Integer.MIN_VALUE;

		ArrayList<Texto> maxTXTs = new ArrayList<Texto>();
		for (Texto txt : textos) {
			if (txt.getCurtidas().size() > max) {
				max = txt.getCurtidas().size();
				

			}
		}

			for (Texto txt2 : textos) {
				if (max == txt2.getCurtidas().size()) {
					
					maxTXTs.add(txt2);
				}
			}
		
		System.out.println("=====================================================");
		for (Texto txt3 : maxTXTs) {
			
			System.out.println("-----------------------------------------------------");
			System.out.println("NOME: " + txt3.getPessoa().getNome() + "\nTexto: " + txt3.getTexto() + "\nCurtidas: "
					+ txt3.getCurtidas().size());
			System.out.println("-----------------------------------------------------");
		}
		System.out.println("=====================================================");
	}

	// relater 4
	@Override
	public void getMaxTxTLENGTH() throws TextoNaoEncontrarException {
		int max = Integer.MIN_VALUE;
		Texto aux = null;
		ArrayList<Texto> maxTXTs = new ArrayList<Texto>();
		for (Texto txt : textos) {
			if (txt.getTexto().length() > max) {
				max = txt.getTexto().length();
				aux = txt;
			}
			if (txt == null) {
				throw new TextoNaoEncontrarException();
			}

		}
		for (Texto txt2 : textos) {
			if (max == txt2.getTexto().length()) {
				maxTXTs.add(txt2);
			}
			System.out.println("=====================================================");
		}
		for (Texto txt3 : maxTXTs) {
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println("NOME: " + txt3.getPessoa().getNome() + "\nTexto: " + txt3.getTexto() + "\nTAMANHO: "
					+ txt3.getTexto().length());
			System.out.println("-----------------------------------------------------");

		}
		System.out.println("=====================================================");
	}

	// relater 7
	@Override
	public void getTxtWtritedByOldestPerson() throws TextoNaoEncontrarException {
		int max = Integer.MIN_VALUE;
		Texto aux = null;
		ArrayList<Texto> maxTXTs = new ArrayList<Texto>();
		for (Texto txt : textos) {
			if (txt.getPessoa().getIdade() > max) {
				max = txt.getPessoa().getIdade();
				aux = txt;
			}
			if (txt == null) {
				throw new TextoNaoEncontrarException();
			}
			for (Texto txt2 : textos) {
				if (max == txt2.getPessoa().getIdade()) {
					maxTXTs.add(txt2);
				}
			}
			
		}
		System.out.println("=====================================================");
		for (Texto txt3 : maxTXTs) {
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println("NOME: " + txt3.getPessoa().getNome() + "\nTexto: " + txt3.getTexto() + "\nIDADE: "
					+ txt3.getPessoa().getIdade());
			System.out.println("-----------------------------------------------------");

		}
		System.out.println("=====================================================");
	}

	// relater 10
	@Override
	public void getLessTxTLENGTH() throws TextoNaoEncontrarException {
		int less = Integer.MAX_VALUE;
		Texto aux = null;
		ArrayList<Texto> maxTXTs = new ArrayList<Texto>();
		for (Texto txt : textos) {
			if (txt.getTexto().length() < less) {
				less = txt.getTexto().length();
				aux = txt;
			}
			if (txt == null) {
				throw new TextoNaoEncontrarException();
			}

		}
		for (Texto txt2 : textos) {
			if (less == txt2.getTexto().length()) {
				maxTXTs.add(txt2);
			}
		}
		System.out.println("=====================================================");
		for (Texto txt3 : maxTXTs) {
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println("NOME: " + txt3.getPessoa().getNome() + "\nTexto: " + txt3.getTexto() + "\nTAMANHO: "
					+ txt3.getTexto().length());
			System.out.println("-----------------------------------------------------");

		}
		System.out.println("=====================================================");
	}

	@Override
	public void savelistTEXTO() {
		FileOutputStream out;
		try {
			out = new FileOutputStream("testetexto");
			ObjectOutputStream objout = new ObjectOutputStream(out);

			objout.writeObject(textos);
			objout.close();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void receistlistTEXTO(ArrayList<Texto> listasalva) {
		textos = listasalva;
	}

}
