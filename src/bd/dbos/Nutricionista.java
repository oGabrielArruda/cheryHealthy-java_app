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
		if(cpf == null)
			throw new Exception("CPF inválido!");
		this.cpf = cpf;
	}
	
	public void setEmail(String email) throws Exception{
		if(email == null)
			throw new Exception("Email inválido!");
			this.email = email;
	}
	
	public void setTelefone(String telefone) throws Exception {
		if(telefone == null)
			throw new Exception("Telefone inválido!");
		this.telefone = telefone;
	}
	
	public void setNome(String nome) throws Exception {
		if(nome == null)
				throw new Exception("Nome inválido!");
		this.nome = nome;
	}
	
	public void setSenha(String senha) throws Exception{
		if(senha == null)
			throw new Exception("Senha inválida!");
		this.senha = senha;
	}
	
	public int hashCode() {
		int ret = 666;
		ret = ret * 7 + new Integer(this.codigo).hashCode();
		ret = ret * 7 + new String(this.nome).hashCode();
		ret = ret * 7 + new String(this.cpf).hashCode();
		ret = ret * 7 + new String(this.email).hashCode();
		ret = ret * 7 + new String(this.telefone).hashCode();
		ret = ret * 7 + new String(this.senha).hashCode();
		
		if(ret < 0)
			ret = -ret;
		return ret;
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
