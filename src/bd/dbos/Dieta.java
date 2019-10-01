package bd.dbos;

public class Dieta {
	private int codDieta, codNutricionista, codUsuario;
	private String seg, ter, qua, qui, sex, sab, dom;
	
	
	public Dieta(int codNutri, int codUser, String seg, String ter, String qua, String qui,
			String sex, String sab, String dom) throws Exception 
	{
		this.codNutricionista = codNutri;
		this.codUsuario = codUser;
		this.setSeg(seg);
		this.setTer(ter);
		this.setQua(qua);
		this.setQui(qui);
		this.setSex(sex);
		this.setSab(sab);
		this.setDom(dom);
	}
	
	public void setCodNutricionista(int cod) {
		this.codNutricionista = cod;
	}
	
	public void setCodUsuario(int cod) {
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
}
