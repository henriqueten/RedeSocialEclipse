package data;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import exceptions.UsuarioNaoEncontrarException;
import model.Pessoa;

public class RepositorioPessoaArrayList implements IRepositorioPessoaArrayList {
	private ArrayList<Pessoa> pessoas;

	public RepositorioPessoaArrayList() {
		this.pessoas = new ArrayList<Pessoa>();
	}

	@Override
	public Pessoa procurarPessoa(String cpf) throws UsuarioNaoEncontrarException {
		Pessoa aux = null;
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf().equals(cpf)) {
				aux = pessoa;
				break;
			}

		}
		if (aux == null) {
			throw new UsuarioNaoEncontrarException();
		}
		return aux;
	}

	@Override
	public void adicionarPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
		

	}

	@Override
	public void removerPessoa(Pessoa pessoa) {
		pessoas.remove(pessoa);

	}

	@Override
	public boolean existePessoa(Pessoa p) {

		boolean result = false;
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCpf().equals(p.getCpf())) {
				result = true;
				break;
			}

		}
		return result;

	}

	// relater 2
	@Override
	public void getPersonWithMoreFriends() throws UsuarioNaoEncontrarException {
		int max = Integer.MIN_VALUE;
		
		ArrayList<Pessoa> pessoinhas = new ArrayList<Pessoa>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getAmigos().size() > max) {
				max = pessoa.getAmigos().size();
			}
			

		}

		for (Pessoa pessoa : pessoas) {
			if (pessoa.getAmigos().size() == max) {
				pessoinhas.add(pessoa);
			}

		}
		for (Pessoa pessoa : pessoinhas) {
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println("NOME: " + pessoa.getNome() + "\nCPF: " + pessoa.getCpf() + "\nQUANTIDADE DE AMIGOS: "
					+ pessoa.getAmigos().size());
			System.out.println("-----------------------------------------------------");
		}
	}

	// relater 3
	@Override
	public void getPersonWithMoreTxT() throws UsuarioNaoEncontrarException {
		int max = Integer.MIN_VALUE;
		
		ArrayList<Pessoa> pessoinhas = new ArrayList<Pessoa>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getTextosParaTimeline().size() > max) {
				max = pessoa.getTextosParaTimeline().size();
			}
		
		}

		for (Pessoa pessoa : pessoas) {
			if (pessoa.getTextosParaTimeline().size() == max) {
				pessoinhas.add(pessoa);
			}

		}
		for (Pessoa pessoa : pessoinhas) {
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println("NOME: " + pessoa.getNome() + "\nCPF: " + pessoa.getCpf() + "\nTAMANHO: "
					+ pessoa.getTextosParaTimeline().size());
			System.out.println("-----------------------------------------------------");
		}
	}

	// relater 5
	@Override
	public void getOldestPerson() throws UsuarioNaoEncontrarException {
		
		int max = Integer.MIN_VALUE;
		
		ArrayList<Pessoa> pessoinhas = new ArrayList<Pessoa>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getIdade() > max) {
				max = pessoa.getIdade();
			}
			
		}

		for (Pessoa pessoa : pessoas) {
			if (pessoa.getIdade() == max) {
				pessoinhas.add(pessoa);
			}

		}
		for (Pessoa pessoa : pessoinhas) {
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println(
					
					"NOME: " + pessoa.getNome() + "\nCPF: " + pessoa.getCpf() + "\nIDADE: " + pessoa.getIdade());
			System.out.println("-----------------------------------------------------");
		}

	}

	// relater 6
	@Override
	public void getPersonWithLOngestName() throws UsuarioNaoEncontrarException {
		System.out.println("LongestName");
		int max = Integer.MIN_VALUE;
		
		ArrayList<Pessoa> pessoinhas = new ArrayList<Pessoa>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getNome().length() > max) {
				max = pessoa.getNome().length();
			}

		}

		for (Pessoa pessoa : pessoas) {
			if (pessoa.getNome().length() == max) {
				pessoinhas.add(pessoa);
			}

		}
		for (Pessoa pessoa : pessoinhas) {
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println("NOME: " + pessoa.getNome() + "\nCPF: " + pessoa.getCpf() + "\nTAMANHO: "
					+ pessoa.getNome().length());
			System.out.println();
			System.out.println("-----------------------------------------------------");
		}

	}

	// relater 8
	@Override
	public void getPersonWithLessFriends() throws UsuarioNaoEncontrarException {
		int less = Integer.MAX_VALUE;
	
		ArrayList<Pessoa> pessoinhas = new ArrayList<Pessoa>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getAmigos().size() < less) {
				less = pessoa.getAmigos().size();
			}

		}

		for (Pessoa pessoa : pessoas) {
			if (pessoa.getAmigos().size() == less) {
				pessoinhas.add(pessoa);
			}

		}
		for (Pessoa pessoa : pessoinhas) {
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println("NOME: " + pessoa.getNome() + "CPF: " + pessoa.getCpf() + "QUANTIDADE DE AMIGOS: "
					+ pessoa.getAmigos().size());
			System.out.println("-----------------------------------------------------");
		}
	}

	// relater 9
	@Override
	public void getYoungerPerson() throws UsuarioNaoEncontrarException {

		int less = Integer.MAX_VALUE;
		ArrayList<Pessoa> pessoinhas = new ArrayList<Pessoa>();
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getIdade() < less) {
				less = pessoa.getIdade();
			}
			
		}

		for (Pessoa pessoa : pessoas) {
			if (pessoa.getIdade() == less) {
				pessoinhas.add(pessoa);
			}

		}
		for (Pessoa pessoa : pessoinhas) {
			System.out.println();
			System.out.println("-----------------------------------------------------");
			System.out.println(
					"NOME: " + pessoa.getNome() + "\nCPF: " + pessoa.getCpf() + "\nIDADE: " + pessoa.getIdade());
			System.out.println("-----------------------------------------------------");
		}

	}

	@Override
	public ArrayList<Pessoa> getListaPessoa() {
		
		return pessoas;
	}
	// salvar lista
	@Override
	public void savelist() {
		FileOutputStream out;
		try {
			out = new FileOutputStream("testepessoa");
			ObjectOutputStream objout = new ObjectOutputStream(out);
			
			objout.writeObject(pessoas);
			objout.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	@Override
	public void receivelist(ArrayList<Pessoa> listasalva) {
		pessoas = listasalva;
	}

}
