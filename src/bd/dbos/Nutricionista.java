package bd.dbos;

public class Nutricionista implements Cloneable {
	private int codigo;
	private String email, cpf, telefone, nome, senha;
	
	/**
	 * Construtor vazio.
	 */
	public Nutricionista() {
		
	}
	
	/**
	 * Construtor da classe Nutricionista.
	 * Recebe os respectivos parâmetros e chama os métodos que setam os valores.
	 * @param codigo Código do nutricionista
	 * @param nome	Nome do nutricionista
	 * @param cpf	Cpf do nutricionista
	 * @param email email do nutricionista
	 * @param telefone telefone do nutricionista
	 * @param senha senha já criptografada do nutricionista
	 * @throws Exception caso algum valor seja inválido
	 */
	public Nutricionista(int codigo,  String nome, String cpf, String email, String telefone, String senha) throws Exception {
		this.setCodigo(codigo);
		this.setNome(nome);
		this.setCpf(cpf);
		this.setEmail(email);
		this.setTelefone(telefone);
		this.setSenha(senha);
	}
	
	/**
	 * Pega o valor do atributo Código
	 * @return o código do respectivo nutricionista
	 */
	public int getCodigo() {
		return this.codigo;
	}
	
	/**
	 * Pega o valor do atributo Nome
	 * @return o nome do respectivo nutricionista
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Pega o valor do atributo Cpf
	 * @return o cpf do respectivo nutricionista
	 */
	public String getCpf() {
		return this.cpf;
	}
	
	/**
	 * Pega o valor do atributo Email
	 * @return o email do respectivo nutricionista
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Pega o valor do atributo Telefone
	 * @return o telefone do respectivo nutricionista
	 */
	public String getTelefone() {
		return this.telefone;
	}
	
	/**
	 * Pega o valor do atributo Senha 
	 * @return a senha do respectivo nutricionista
	 */
	public String getSenha() {
		return this.senha;
	}
	
	/**
	 * Seta o valor do atributo código
	 * @param codigo o código do nutricionista desejado
	 * @throws Exception caso o código negativo, ou maior que 5000
	 */
	public void setCodigo(int codigo) throws Exception {
		if(codigo <= 0 || codigo > 5000) {
			throw new Exception("Código deve estar entre 0 e 5000");
		}
		
		this.codigo = codigo;
	}
	
	/**
	 * Seta o valor do atributo cpf
	 * @param cpf o cpf do nutricionista de sejado
	 * @throws Exception caso a string cpf seja nula
	 */
	public void setCpf(String cpf) throws Exception {
		if(cpf == null)
			throw new Exception("CPF inválido!");
		this.cpf = cpf;
	}
	
	/**
	 * Seta o valor do atributo email
	 * @param email o email do nutricionista de sejado
	 * @throws Exception caso a string email seja nula
	 */
	public void setEmail(String email) throws Exception{
		if(email == null)
			throw new Exception("Email inválido!");
			this.email = email;
	}
	
	/**
	 * Seta o valor do atributo telefone
	 * @param telefone o telefone do nutricionista de sejado
	 * @throws Exception caso a string telefone seja nula
	 */
	public void setTelefone(String telefone) throws Exception {
		if(telefone == null)
			throw new Exception("Telefone inválido!");
		this.telefone = telefone;
	}
	
	/**
	 * Seta o valor do atributo nome
	 * @param nome o nome do nutricionista desejado
	 * @throws Exception caso a string nome seja nula
	 */
	public void setNome(String nome) throws Exception {
		if(nome == null)
				throw new Exception("Nome inválido!");
		this.nome = nome;
	}
	
	/**
	 * Seta o valor do atributo senha
	 * @param senha a senha do nutricionista desejado
	 * @throws Exception caso a string senha seja nula
	 */
	public void setSenha(String senha) throws Exception{
		if(senha == null)
			throw new Exception("Senha inválida!");
		this.senha = senha;
	}
	
	/**
	 * Retorna o código hash da classe
	 */
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
	
	/**
	 * Retorna os valores da classe em formato de string
	 */
	public String toString() {
		String ret = "";
		ret+= "Código:" + this.codigo+"/n";
		ret+= "Nome:" + this.nome+"/n";
		ret+= "Cpf:" + this.cpf+"/n";
		ret+= "Telefone:" + this.telefone+"/n";
		ret += "Senha:" + this.senha+"/n";
		
		return ret;
	}
	
	/**
	 * Verifica se a instância é igual a outra passada como parâmetro 
	 */
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
	
	/**
	 * Construtor de cópia da classe.
	 * @param modelo a instância que será copiada.
	 */
	public Nutricionista(Nutricionista modelo) {
		this.codigo = modelo.codigo;
		this.nome = modelo.nome;
		this.cpf = modelo.cpf;
		this.telefone = modelo.telefone;
		this.senha = modelo.senha;
	}
	
	/**
	 * Clona a instância.
	 */
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
