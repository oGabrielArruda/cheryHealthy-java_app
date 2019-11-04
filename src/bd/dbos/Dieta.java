package bd.dbos;

public class Dieta {
	private int codNutricionista, codUsuario;
	private String seg, ter, qua, qui, sex, sab, dom;
	
	/**
	 * Construtor da classe dieta.
	 * Seta 
	 * Chama os métodos que setam os respectivos atributos
	 * @param codNutri código do nutricionista responsável pela dieta
	 * @param codUser código do usuário pertencente a essa dieta
	 * @param seg dieta da segunda-feira
	 * @param ter dieta da terca-feira
	 * @param qua dieta da quarta-feira
	 * @param qui dieta da quinta-feira
	 * @param sex dieta da sexta-feira
	 * @param sab dieta do sábado
	 * @param dom dieta do domingo
	 * @throws Exception caso algum parâmetro seja inválido
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
	
	public void setCodNutricionista(int cod) throws Exception {
		if(cod < 0 || cod > 5000)
			throw new Exception("Código inválido");
		this.codNutricionista = cod;
	}
	
	public void setCodUsuario(int cod) throws Exception {
		if(cod < 0)
			throw new Exception("Código inválido");
		this.codUsuario = cod;
	}
	
	public void setSeg(String dieta) throws Exception {
		if(dieta.length() > 500)
			throw new Exception("Digite menos que 500 caracteres");
		this.seg = dieta;
	}
	
	public void setTer(String dieta) throws Exception {
		if(dieta.length() > 500)
			throw new Exception("Digite menos que 500 caracteres");
		this.ter = dieta;
	}
	public void setQua(String dieta) throws Exception {
		if(dieta.length() > 500)
			throw new Exception("Digite menos que 500 caracteres");
		this.qua = dieta;
	}
	public void setQui(String dieta) throws Exception {
		if(dieta.length() > 500)
			throw new Exception("Digite menos que 500 caracteres");
		this.qui = dieta;
	}
	public void setSex(String dieta) throws Exception {
		if(dieta.length() > 500)
			throw new Exception("Digite menos que 500 caracteres");
		this.sex= dieta;
	}
	public void setSab(String dieta) throws Exception {
		if(dieta.length() > 500)
			throw new Exception("Digite menos que 500 caracteres");
		this.sab = dieta;
	}
	public void setDom(String dieta) throws Exception {
		if(dieta.length() > 500)
			throw new Exception("Digite menos que 500 caracteres");
		this.dom = dieta;
	}
	
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
	
	public String toString() {
		String ret = "";
		ret += "Codigo Nutricionista: " + this.codNutricionista +"/n";
		ret+= "Codigo Usuario: " + this.codUsuario +"/n";
		ret+= "Segunda-Feira: " + this.seg +"/n";
		ret += "Terça-Feira: " + this.ter+"/n";
		ret += "Quarta-Feira: " + this.qua+"/n";
		ret += "Quinta-Feira: " + this.qui+"/n";
		ret += "Sexta-Feira: " + this.sex+"/n";
		ret += "Sabado: " + this.sab+"/n";
		ret += "Domingo: " + this.dom;
		
		return ret;
	}
	
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
