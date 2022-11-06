package Main;


import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;


public class Principal {
	
	public static void main(String args[]) {
//		Farmaceutico farmaceutico = new Farmaceutico();
//		farmaceutico.nome = "Jose";
//		farmaceutico.cpf = "23456465";
//		farmaceutico.rg = "567567567";
//		farmaceutico.salvar();
//			

		
		
//		ArrayList<Pessoa> listaPessoas = Utils.lerPessoa(Pessoa.ARQUIVO);
//		listaPessoas.forEach( (p)->  System.out.println("Nome: "+p.nome + "  CPF :" +p.cpf)    );
		
		
		
//		Pessoa pessoa = new Pessoa("Maria", "234234", "234234234");
//		ArrayList<Pessoa> listaPessoas = new ArrayList<>();
//		listaPessoas.add(pessoa);
//		Utils u = new Utils();
//		u.serializarLista(listaPessoas, pessoa.ARQUIVO_SERIAL);
		
 
//		ArrayList<Pessoa> listaPessoas = new ArrayList<>();
//		Utils u = new Utils();
// 
//		 List<Pessoa> lst =  ( List<Pessoa> ) u.deserializarLista(Pessoa.ARQUIVO_SERIAL);
//		 System.out.println(lst.size());
		
//		adicionarCliente();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			
			System.out.println("-----------SISTEMA BIBLIOTECA-----------");
			System.out.println("1 - Adicionar");
			System.out.println("2 - Listar");
			System.out.println("3 - Registrar aluguel livro");
			System.out.println("0 - Encerrar Sistema");
			Integer s = scanner.nextInt();
			if (s == 1) {
				telaAdicionar();
			}else if (s == 2) {
				telaImprimir();
			}else if (s == 3) {
				alugarLivro();
			}else if (s == 0) {
				break;
			}else {
				System.out.println(s.getClass());
				System.out.println("1".getClass());
				System.out.println(s == 1);
				System.out.println("----------------------------------------");
				System.out.println("------------INSIRA UM NUMERO------------");
				System.out.println("----------------------------------------");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		
		
		scanner.close();
		System.out.println("Sistema Encerrado");
	}

	public static void telaAdicionar() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("-----------PESQUISA BIBLIOTECA----------");
			System.out.println("1 - Adicionar Inquilino");
			System.out.println("2 - Adicionar Livro");
			System.out.println("0 - Voltar ao menu inicial");
			Integer s = scanner.nextInt();
			if (s == 1) {
				adicionarInquilino();
			}else if (s == 2) {
				adicionarLivro();
			}else if (s == 0) {
				break;
			}else {
				onWrongInput();
			}
		}
		
	}
	
	
	public static void telaImprimir() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("-----------PESQUISA BIBLIOTECA----------");
			System.out.println("1 - Lista de Inquilinos");
			System.out.println("2 - Lista de Livros");
			System.out.println("0 - Voltar ao menu inicial");
			Integer s = scanner.nextInt();
			if (s == 1) {
				imprimirListaInquilinos();	
			}else if (s == 2) {
				imprimirListaLivros();
			}else if (s == 0) {
				break;
			}else {
				onWrongInput();
			}
		}
		
	}
	
	private static void onWrongInput() {
		System.out.println("----------------------------------------");
		System.out.println("------------INSIRA UM NUMERO------------");
		System.out.println("----------------------------------------");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void imprimirListaInquilinos() {
		Utils u = new Utils();
		List<Inquilino> lstInquilino  = (List<Inquilino>) u.lerLista(Inquilino.ARQUIVOSERIAL);
		for (Inquilino c: lstInquilino) {
			System.out.println(c.getNome());
		}
	}
	
	private static void imprimirListaLivros() {
		Utils u = new Utils();
		List<Livro> lstLivro = (List<Livro>) u.lerLista(Livro.ARQUIVOSERIAL);
		for (Livro c: lstLivro) {
			System.out.println("Codigo: "+ c.getCodigo());
			System.out.println("Titulo: "+ c.getTitulo());
			System.out.println("Cpf Inquilino: "+ c.getCpfInquilino());
		}
	}

	private static void adicionarInquilino() {
		Scanner scanner = new Scanner(System.in);
		Inquilino inquilino = new Inquilino();
		System.out.println("Insira o nome do inquilino");
		inquilino.setNome(scanner.nextLine());
		System.out.println("Insira o CPF do inquilino");
		inquilino.setCpf(scanner.nextLine());
		System.out.println("Insira o RG do inquilino");
		inquilino.setRg(scanner.nextLine());
		System.out.println("Insira o telefone do inquilino");
		inquilino.setTelefone(scanner.nextLine());
		
//		Produto p = new Produto();
//		p.setCodigoBarra(2342342344453L);
//		p.setDataFabricacao ( new Date());
//		p.setDataValidade (new Date());
//
//		ArrayList<Produto> lstProdutos = new ArrayList<Produto>();
//		lstProdutos.add(p);
//		cliente.setLstProdutos(lstProdutos);
		
		Utils u = new Utils();
		List<Inquilino> lstInquilino = (List<Inquilino>) u.lerLista(Inquilino.ARQUIVOSERIAL);
		
		Boolean found = false;
		
		for (Inquilino c: lstInquilino) {
			System.out.println(c.getCpf());
			System.out.println(inquilino.getCpf());
			String inq1 = inquilino.getCpf();
			String inq2 = c.getCpf();
			if (inq1.equals(inq2)) {
				found = true;
				break;
			}
		}
		if (!found) {
			inquilino.salvar();
			System.out.println("Salvo com sucesso!");
		}else {
			System.out.println("Outro inquilino ja tem o mesmo CPF!");
		}
	}
	
	private static void adicionarLivro() {
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		Livro livro = new Livro();
		System.out.println("Insira o codigo do livro");
		livro.setCodigo(scanner1.nextLong());
		System.out.println("Insira o titulo do livro");
		livro.setTitulo(scanner.nextLine());
		System.out.println("Insira o autor do livro");
		livro.setAutor(scanner.nextLine());
		System.out.println("Insira a publicadora do livro");
		livro.setPublicadora(scanner.nextLine());
		

		
		Utils u = new Utils();
		List<Livro> lstLivro = (List<Livro>) u.lerLista(Livro.ARQUIVOSERIAL);
		
		Boolean found = false;
		
		for (Livro c: lstLivro) {
			Long cod1 = livro.getCodigo();
			Long cod2 = c.getCodigo();
			if (cod1.equals(cod2)) {
				found = true;
				break;
			}
		}
		if (!found) {
			livro.salvar();
			System.out.println("Salvo com sucesso!");
		}else {
			System.out.println("Outro livro ja tem este codigo!");
		}
	}
	
	private static void alugarLivro() {
		Utils u = new Utils();
		Scanner scanner = new Scanner(System.in);
		Scanner scanner1 = new Scanner(System.in);
		Boolean found = false;
		Livro livro = new Livro();
		while (!found) {
			System.out.println("Insira o codigo do livro");
			long codigo = scanner1.nextLong();
			List<Livro> lstLivro = (List<Livro>) u.lerLista(Livro.ARQUIVOSERIAL);
			for (Livro c: lstLivro) {
				Long cod1 = codigo;
				Long cod2 = c.getCodigo();
				if (cod1.equals(cod2)) {
					found = true;
					livro = c;
					break;
				}
			}
			if (found) {
				System.out.println("Livro encontrado");
			} else {
				System.out.println("O livro nao foi encontrado");
			}
		}
		System.out.println("A data atual");
		livro.setDataLevado(java.sql.Date.valueOf(LocalDate.now()));
		System.out.println("Insira a data de entrega");
		livro.setDataEntrega(java.sql.Date.valueOf(LocalDate.now().plusDays(7)));
		System.out.println("Insira a publicadora do livro");
		
		found = false;
		Inquilino inquilino = new Inquilino();
		while (!found) {
			System.out.println("Insira o CPF do inquilino (o inquilino precisa de estar cadastrado)");
			String CPF = scanner.nextLine();
			List<Inquilino> lstInquilino = (List<Inquilino>) u.lerLista(Inquilino.ARQUIVOSERIAL);
			for (Inquilino c: lstInquilino) {
				String cod1 = CPF;
				String cod2 = c.getCpf();
				if (cod1.equals(cod2)) {
					found = true;
					inquilino = c;
					break;
				}
			}
			if (found) {
				System.out.println("Inquilino encontrado");
			} else {
				System.out.println("O inquilino nao foi encontrado");
			}
		}
		livro.setCpfInquilino(inquilino.getCpf());
		
		Livro.updateLivro(livro.getCodigo(), livro);
		
	}
}

