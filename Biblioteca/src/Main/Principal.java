package Main;


import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
			System.out.println("0 - Encerrar Sistema");
			Integer s = scanner.nextInt();
			if (s == 1) {
				telaAdicionar();
			}else if (s == 2) {
				telaImprimir();
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
			System.out.println("0 - Voltar ao menu inicial");
			Integer s = scanner.nextInt();
			if (s == 1) {
				adicionarCliente();
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
		
	}
	
	
	public static void telaImprimir() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("-----------PESQUISA BIBLIOTECA----------");
			System.out.println("1 - Lista de Inquilinos");
			System.out.println("0 - Voltar ao menu inicial");
			Integer s = scanner.nextInt();
			if (s == 1) {
				imprimirListaInquilinos();	
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
		
	}
	
	private static void imprimirListaInquilinos() {
		Utils u = new Utils();
		List<Inquilino> lstCliente = (List<Inquilino>) u.lerLista(Inquilino.ARQUIVOSERIAL);
		for (Inquilino c: lstCliente) {
			System.out.println(c.getNome());
		}
	}

	private static void adicionarCliente() {
		Scanner scanner = new Scanner(System.in);
		Inquilino cliente = new Inquilino();
		System.out.println("Insira o nome do inquilino");
		cliente.setNome(scanner.nextLine());
		System.out.println("Insira o CPF do inquilino");
		cliente.setCpf(scanner.nextLine());
		System.out.println("Insira o RG do inquilino");
		cliente.setRg(scanner.nextLine());
		System.out.println("Insira o telefone do inquilino");
		cliente.setTelefone(scanner.nextLine());
		
//		Produto p = new Produto();
//		p.setCodigoBarra(2342342344453L);
//		p.setDataFabricacao ( new Date());
//		p.setDataValidade (new Date());
//
//		ArrayList<Produto> lstProdutos = new ArrayList<Produto>();
//		lstProdutos.add(p);
//		cliente.setLstProdutos(lstProdutos);
		
		
		
		
		cliente.salvar();
	}
}

