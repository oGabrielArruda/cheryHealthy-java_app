package bd.dbos;

public class Dieta {
	private int codNutricionista, codUsuario;
	private String seg, ter, qua, qui, sex, sab, dom;
	
	/**
	 * Construtor da classe dieta.
	 * Seta 
	 * Chama os m�todos que setam os respectivos atributos
	 * @param codNutri c�digo do nutricionista respons�vel pela dieta
	 * @param codUser c�digo do usu�rio pertencente a essa dieta
	 * @param seg dieta da segunda-feira
	 * @param ter dieta da terca-feira
	 * @param qua dieta da quarta-feira
	 * @param qui dieta da quinta-feira
	 * @param sex dieta da sexta-feira
	 * @param sab dieta do s�bado
	 * @param dom dieta do domingo
	 * @throws Exception caso algum par�metro seja inv�lido
	 */
	public Dieta(int codNutri, int codUser, String seg, String ter, String qua, String qui,
			String sex, String sab, String dom) throws Exception 
	{
		this.setCodNutricionista(codNutri);
		this.setCodUsuario(codUser);
		this.setSeg(seg);
		this.setTer(ter);
		this.setQua(qua);
		this.setQui(qui);
		this.setSex(sex);
		this.setSab(sab);
		this.setDom(dom);
	}
	
	/**
	 * Seta o valor do atributo codNutricionista
	 * @param cod o c�digo do nutricionista respons�vel pela dieta
	 * @throws Exception caso o c�digo negativo, ou maior que 5000
	 */
	public void setCodNutricionista(int cod) throws Exception {
		if(cod < 0 || cod > 5000)
			throw new Exception("C�digo inv�lido");
		this.codNutricionista = cod;
	}
	
	/**
	 * Seta o valor do atributo codUsuario
	 * @param cod o c�digo do usu�rio pertencente � dieta
	 * @throws Exception caso o c�digo negativo
	 */
	public void setCodUsuario(int cod) throws Exception {
		if(cod < 0)
			throw new Exception("C�digo inv�lido");
		this.codUsuario = cod;
	}
	
	/**
	 * Seta o valor do atributo seg
	 * @param dieta a string da dieta para segunda feira
	 * @throws Exception caso o texto da dieta seja maior que 500 car�cteres
	 */
	public void setSeg(String dieta) throws Exception {
		if(dieta.length() > 500)
			throw new Exception("Digite menos que 500 caracteres");
		this.seg = dieta;
	}
	
	/**
	 * Seta o valor do atributo ter
	 * @param dieta a string da dieta para terca feira
	 * @throws Exception caso o texto da dieta seja maior que 500 car�cteres
	 */
	public void setTer(String dieta) throws Exception {
		if(dieta.length() > 500)
			throw new Exception("Digite menos que 500 caracteres");
		this.ter = dieta;
	}
	
	/**
	 * Seta o valor do atributo qua
	 * @param dieta a string da dieta para quarta feira
	 * @throws Exception caso o texto da dieta seja maior que 500 car�cteres
	 */
	public void setQua(String dieta) throws Exception {
		if(dieta.length() > 500)
			throw new Exception("Digite menos que 500 caracteres");
		this.qua = dieta;
	}
	
	/**
	 * Seta o valor do atributo qui
	 * @param dieta a string da dieta para quinta feira
	 * @throws Exception caso o texto da dieta seja maior que 500 car�cteres
	 */
	public void setQui(String dieta) throws Exception {
		if(dieta.length() > 500)
			throw new Exception("Digite menos que 500 caracteres");
		this.qui = dieta;
	}
	
	/**
	 * Seta o valor do atributo sex
	 * @param dieta a string da dieta para sexta feira
	 * @throws Exception caso o texto da dieta seja maior que 500 car�cteres
	 */
	public void setSex(String dieta) throws Exception {
		if(dieta.length() > 500)
			throw new Exception("Digite menos que 500 caracteres");
		this.sex= dieta;
	}
	
	/**
	 * Seta o valor do atributo sab
	 * @param dieta a string da dieta para o s�bado
	 * @throws Exception caso o texto da dieta seja maior que 500 car�cteres
	 */
	public void setSab(String dieta) throws Exception {
		if(dieta.length() > 500)
			throw new Exception("Digite menos que 500 caracteres");
		this.sab = dieta;
	}
	
	/**
	 * Seta o valor do atributo dom
	 * @param dieta a string da dieta para o domingo
	 * @throws Exception caso o texto da dieta seja maior que 500 car�cteres
	 */
	public void setDom(String dieta) throws Exception {
		if(dieta.length() > 500)
			throw new Exception("Digite menos que 500 caracteres");
		this.dom = dieta;
	}
	
	/**
	 * Verifica se a inst�ncia � igual a outra passada como par�metro 
	 */
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(this == obj)
			return true;
		if(this.getClass() != obj.getClass())
			return false;
		Dieta diet = (Dieta)obj;
		
		if(this.codUsuario != diet.codUsuario || this.codNutricionista != diet.codNutricionista)
			return false;
		
		if(!this.seg.equals(diet.seg) || !this.ter.equals(diet.ter) || !this.qua.equals(diet.qua) ||
		this.qui.equals(diet.qui) ||!this.sex.equals(diet.sex) ||!this.sab.equals(diet.sab) || !this.dom.equals(diet.dom))
			return false;
		return true;
	}
	
	/**
	 * Retorna os valores da classe em formato de string
	 */
	public String toString() {
		String ret = "";
		ret += "Codigo Nutricionista: " + this.codNutricionista +"/n";
		ret+= "Codigo Usuario: " + this.codUsuario +"/n";
		ret+= "Segunda-Feira: " + this.seg +"/n";
		ret += "Ter�a-Feira: " + this.ter+"/n";
		ret += "Quarta-Feira: " + this.qua+"/n";
		ret += "Quinta-Feira: " + this.qui+"/n";
		ret += "Sexta-Feira: " + this.sex+"/n";
		ret += "Sabado: " + this.sab+"/n";
		ret += "Domingo: " + this.dom;
		
		return ret;
	}
	
	/**
	 * Retorna o c�digo hash da inst�ncia
	 */
	public int hashCode() {
		int ret = 356;
		ret = ret*7 + new Integer(this.codNutricionista).hashCode();
		ret = ret*7 + new Integer(this.codUsuario).hashCode();
		ret = ret*7 + this.seg.hashCode();
		ret = ret*7 + this.ter.hashCode();
		ret = ret*7 + this.qua.hashCode();
		ret = ret*7 + this.qui.hashCode();
		ret = ret*7 + this.sex.hashCode();
		ret = ret*7 + this.sab.hashCode();
		ret = ret*7 + this.dom.hashCode();
		
		return ret;
	}
}
