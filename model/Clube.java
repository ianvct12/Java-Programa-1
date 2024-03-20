package model;

import java.io.Serializable;

public class Clube implements Serializable {
	private String nome;
	private String cidade;
	private String uf;

	public Clube(String nome, String cidade, String uf) throws ModelException {
		this.setNome(nome);
		this.setCidade(cidade);
		this.setUf(uf);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ModelException{
		validarNome(nome);
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) throws ModelException {
		validarCidade(cidade);
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) throws ModelException{
		validarUf(uf);
		this.uf = uf;
	}

	public static void validarNome(String nome) throws ModelException {
		if (nome.length() == 0 || nome == null)
			throw new ModelException("O nome do Clube não pode ser nulo.");
		if (nome.length() > 40)
			throw new ModelException("O nome do Clube não pode conter mais do que 40 caracteres.");
		for (int i = 0; i < nome.length(); i++) {
			char c = nome.charAt(i);
			if(!Character.isAlphabetic(c)&&!Character.isSpaceChar(c))
				throw new ModelException("O nome do clube não pode conter caracteres numéricos.");
		}
	}
	
	public static void validarCidade(String cidade) throws ModelException{
		if(cidade.length()==0||cidade==null)
			throw new ModelException("A cidade não pode ser nula.");
		if(cidade.length()>20)
			throw new ModelException("A cidade não pode ser maior do que 20 caracteres.");
		for(int i=0;i<cidade.length();i++) {
			char c=cidade.charAt(i);
			if(!Character.isAlphabetic(c)&&!Character.isSpaceChar(c))
				throw new ModelException("A cidade deve conter apenas caracteres alfabéticos.");
		}
	}
	
	public static void validarUf(String uf) throws ModelException{
		if(uf.length()==0||uf==null)
			throw new ModelException("A UF não pode ser nula.");
		if(uf.length()!=2)
			throw new ModelException("A UF deve conter 2 caracteres.");
		for(int i=0;i<uf.length();i++){
			char c= uf.charAt(i);
			if(!Character.isUpperCase(c))
				throw new ModelException("A UF deve conter apenas letras maiúsculas.");
		}
	}


	public String toString() {
		return  this.nome;
	}
	
	
}
