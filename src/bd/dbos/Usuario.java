package bd.dbos;

public class Usuario {
	private int codUsuario, codNutricionista, pontuacao;
	private float altura, peso;
	private String nome,cpf,email,telefone, senha;
	
	public Usuario(int codUsuario, String nome, String cpf, String email, String telefone, 
			String senha, float peso, float altura, int codNutricionista, int pontuacao) throws Exception 
	{
		this.setCodUsuario(codUsuario);
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setTelefone(telefone);
		this.setSenha(senha);
		this.setPeso(peso);
		this.setAltura(altura);
		this.setCodNutricionista(codNutricionista);
		this.setPontuacao(pontuacao);
	}
	
	
	public void setCodUsuario(int cod) throws Exception
	{
		if(cod < 0)
			throw new Exception("C�digo inv�lido");
		this.codUsuario = cod;
	}
	
	public void setNome(String nome) throws Exception
	{
		if(nome.isEmpty() || nome.trim().equals(""))
			throw new Exception("Nome inv�ilido");
		this.nome = nome;
	}
	
	public void setCpf(String cpf) throws Exception
	{
		if(cpf.isEmpty() || cpf.trim().equals(""))
			throw new Exception("Nome inv�ilido");
		this.cpf = cpf;
	}
	
	public void setEmail(String email) throws Exception
	{
		if(email.isEmpty() || email.trim().equals(""))
			throw new Exception("Nome inv�ilido");
		this.email = email;
	}
	
	public void setTelefone(String telefone) throws Exception
	{
		if(telefone.isEmpty() || telefone.trim().equals(""))
			throw new Exception("Nome inv�ilido");
		this.telefone = telefone;
	}
	
	public void setSenha(String senha) throws Exception
	{
		if(senha.isEmpty() || senha.trim().equals(""))
			throw new Exception("Nome inv�ilido");
		this.senha = senha;
	}
	
	public void setCodNutricionista(int cod) throws Exception
	{
		if(cod < 0)
			throw new Exception("C�digo inv�lido");
		this.codNutricionista = cod;
	}
	public void setPeso(float peso) throws Exception
	{
		if(peso < 0)
			throw new Exception("Peso inv�lido");
		this.peso = peso;
	}
	public void setAltura(float altura) throws Exception
	{
		if(altura < 0)
			throw new Exception("Altura inv�lida");
		this.altura = altura;
	}
	public void setPontuacao(int pontuacao) throws Exception
	{
		this.pontuacao = pontuacao;
	}
	
	public int getCodUsuario() 
	{
		return this.codUsuario;
	}
	
	public String getNome() 
	{
		return this.nome;
	}
	
	public String getCpf() 
	{
		return this.cpf;
	}
	
	public String getEmail() 
	{
		return this.email;
	}
	
	public String getTelefone() 
	{
		return this.telefone;
	}
	
	public String getSenha() 
	{
		return this.senha;
	}
	
	public int getCodNutricionista() 
	{
		return this.codNutricionista;
	}
	
	public float getPeso() 
	{
		return this.peso;
	}
	
	public float getAltura() 
	{
		return this.altura;
	}
	
	public int getPontuacao() 
	{
		return this.pontuacao;
	}
	
	public boolean equals(Object obj) 
	{
		if(obj == null)
			return false;
		if(this == obj)
			return true;
		if(this.getClass() != obj.getClass())
			return false;
		
		Usuario user = (Usuario)obj;
		
		if(this.codUsuario != user.codUsuario || this.nome != user.nome || this.cpf != user.cpf
		|| this.email != user.email || this.telefone != user.telefone || this.senha != user.senha
		|| this.codNutricionista != user.codNutricionista || this.altura != user.altura
		|| this.peso != user.peso || this.pontuacao != user.pontuacao)
			return false;
		return true;
	}
	
	
	public String toString() 
	{
		String ret = "";
		ret += "Codigo: " + this.codUsuario;
		ret += "Nome: " + this.nome;
		ret += "Cpf: " + this.cpf;
		ret += "Email: " + this.email;
		ret += "Telefone: " + this.telefone;
		ret += "Senha: " + this.senha;
		ret += "Codigo Nutricionista: " + this.codNutricionista;
		ret += "Altura: " + this.altura;
		ret += "Peso: " + this.peso;
		ret += "Pontuacao: " + this.pontuacao;
		
		return ret;
	}
	
	public int hashCode() 
	{
		int ret = 356;
		ret = ret*7 + new Integer(this.codUsuario).hashCode();
		ret = ret*7 + this.nome.hashCode();
		ret = ret*7 + this.cpf.hashCode();
		ret = ret*7 + this.email.hashCode();
		ret = ret*7 + this.telefone.hashCode();
		ret = ret*7 + this.senha.hashCode();
		ret = ret*7 + new Float(this.peso).hashCode();
		ret = ret*7 + new Float(this.altura).hashCode();
		ret = ret*7 + this.email.hashCode();
		ret = ret*7 + new Integer(this.codNutricionista).hashCode();
		ret = ret*7 + new Integer(this.pontuacao).hashCode();
		
		if(ret<0)
			ret = -ret;
			
		return ret;
	}
}
