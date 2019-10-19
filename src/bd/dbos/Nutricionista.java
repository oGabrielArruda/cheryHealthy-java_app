package bd.dbos;

public class Nutricionista {
	private int codigo;
	private String email, cpf, telefone, nome, senha;
	
	public Nutricionista() {
		
	}
	
	public Nutricionista(int codigo,  String nome, String cpf, String email, String telefone, String senha) throws Exception {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setTelefone(telefone);
		this.setSenha(senha);
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	
	public void setCodigo(int codigo) throws Exception {
		if(codigo <= 0 || codigo > 5000) {
			throw new Exception("Código deve estar entre 0 e 5000");
		}
		
		this.codigo = codigo;
	}
	
	public void setCpf(String cpf) throws Exception {
		this.cpf = cpf;
	}
	
	public void setEmail(String email) throws Exception{
		this.email = email;
	}
	
	public void setTelefone(String telefone) throws Exception {
		this.telefone = telefone;
	}
	
	public void setNome(String nome) throws Exception {
		this.nome = nome;
	}
	
	public void setSenha(String senha) throws Exception{
		this.senha = senha;
	}
	
	public String toString() {
		String ret = "";
		ret+= "Código:" + this.codigo+"/n";
		ret+= "Nome:" + this.nome+"/n";
		ret+= "Cpf:" + this.cpf+"/n";
		ret+= "Telefone:" + this.telefone+"/n";
		ret += "Senha:" + this.senha+"/n";
		
		return ret;
	}
	
	public boolean equals (Object obj) {
		if(this==obj)
			return true;
		if(obj == null)
			return false;
		if(!(obj instanceof Nutricionista))
			return false;
		
		Nutricionista nutri = (Nutricionista) obj;
		if(this.codigo != nutri.codigo)
			return false;
		if(!(this.nome.equals(nutri.nome)))
			return false;
		if(!(this.cpf.equals(nutri.cpf)))
			return false;
		if(!(this.telefone.equals(nutri.telefone)))
			return false;
		if(!(this.senha.equals(nutri.senha)))
			return false;
		return true;		
	}
	
	public Nutricionista(Nutricionista modelo) {
		this.codigo = modelo.codigo;
		this.nome = modelo.nome;
		this.cpf = modelo.cpf;
		this.telefone = modelo.telefone;
		this.senha = modelo.senha;
	}
	
	public Object clone() {
		Nutricionista ret = null;
		try {
			ret = new Nutricionista(this);
		}
		catch(Exception ex) 
		{}
		
		return ret;
	}
}
