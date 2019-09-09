package bd.dbos;

public class Nutricionista {
	private int codigo;
	private String cpf, telefone, nome;
	
	public Nutricionista() {
		
	}
	
	public Nutricionista(int codigo, String cpf, String telefone, String nome) throws Exception {
		this.setCodigo(codigo);
		this.setCpf(cpf);
		this.setTelefone(telefone);
		this.setNome(nome);
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setCodigo(int codigo) throws Exception {
		if(codigo <= 0 || codigo > 5000) {
			throw new Exception("Código inválido");
		}
		
		this.codigo = codigo;
	}
	
	public void setCpf(String cpf) throws Exception {
		this.cpf = cpf;
	}
	
	public void setTelefone(String telefone) throws Exception {
		this.telefone = telefone;
	}
	
	public void setNome(String nome) throws Exception {
		this.nome = nome;
	}
}
