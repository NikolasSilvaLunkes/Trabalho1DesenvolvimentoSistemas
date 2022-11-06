package Main;


import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Livro implements Serializable{
	
	
	private static final long serialVersionUID = 2L;
	
	public static String ARQUIVO = "./livro.csv";
	public final static String ARQUIVOSERIAL = "./livro_serialv1.obj";
	
	
	private Long codigo;
	private Date dataLevado;
	private Date dataEntrega;
	private String titulo;
	private String autor;
	private String publicadora;
	private String cpfInquilino;
	
	@Override
	public String toString() {
		return String.format("\n%s;%s;%s;%s;%s;%s;%s ",codigo,dataLevado,dataEntrega,titulo,autor,publicadora,cpfInquilino);
	}
	
	public void salvar() {
		Utils utils = new Utils();
		utils.salvar(this, ARQUIVOSERIAL);
	}
	
	public void setCodigo(Long codigoBarra) {
		if (false) {
			System.out.println("codigo invalido");
		}else {			
			this.codigo = codigoBarra;
		}
	}
	
	public Long getCodigo() {
		return this.codigo;
	}

	public Date getDataLevado() {
		return dataLevado;
	}

	public void setDataLevado(Date dataLevado) {
		this.dataLevado = dataLevado;
	}
	
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getPublicadora() {
		return publicadora;
	}
	
	public void setPublicadora(String publicadora) {
		this.publicadora = publicadora;
	}
	
	public String getCpfInquilino() {
		return cpfInquilino;
	}
	
	public void setCpfInquilino(String cpfInquilino) {
		this.cpfInquilino = cpfInquilino;
	}
	
	public static boolean updateLivro(Long CodLivro, Livro novoLivro) {
		Utils u = new Utils();
		List<Livro> lstLivro = (List<Livro>) u.lerLista(Livro.ARQUIVOSERIAL);	
//		List<E> lstEntidadesGenerica = new ArrayList<>();
		Object[] livros = new Livro[lstLivro.size()];
		livros = lstLivro.toArray();
		
		int i = 0;
		for (Livro c: lstLivro) {
			Long cod1 = novoLivro.codigo;
			Long cod2 = c.getCodigo();
			if (cod1.equals(cod2)) {
				break;
			}
			i++;
		}
		
		livros[i] = novoLivro;
		lstLivro.clear();
		for(Object s : livros){
			lstLivro.add((Livro) s);
		}

		File f = new File(ARQUIVOSERIAL);
		try {
			FileOutputStream fos = new FileOutputStream(f,false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			// List<E> lst = new ArrayList<E>();
			oos.writeObject(lstLivro);
			System.out.println("o arquivo: " + ARQUIVOSERIAL + " foi gravado com sucesso!");
			fos.flush();
			fos.close();
			return true;
		} catch (Exception excessao) {
			System.out.println("opa, nao foi possivel criar o arquivo: " + ARQUIVOSERIAL);
			System.out.println(excessao.getMessage());
			return false;
		}
	}
	
	
	
	
	
	
	
}
