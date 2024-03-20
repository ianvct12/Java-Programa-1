package model;

import java.io.Serializable;

public class Jogador implements Serializable{
	private String nome;
	private String apelido;
	private String posicao;
	private Clube clube;
	
	public Jogador(String nome,String apelido, String posicao,Clube clube) throws ModelException{
		this.setNome(nome);
		this.setApelido(apelido);
		this.setPosicao(posicao);
		this.setClube(clube);
	}

	public Clube getClube() {
		return clube;
	}

	public void setClube(Clube clube) throws ModelException{
		validarClube(clube);
		this.clube = clube;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) throws ModelException{
		validarNome(nome);
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) throws ModelException{
		validarApelido(apelido);
		this.apelido = apelido;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) throws ModelException{
		validarPosicao(posicao);
		this.posicao = posicao;
	}
	
	public static void validarNome(String nome) throws ModelException{
		if(nome.length()==0||nome==null)
			throw new ModelException("O nome do Jogador não pode ser nulo.");
		if(nome.length()>40)
			throw new ModelException("O nome do Jogador não pode ter mais do que 40 caracteres.");
		for(int i=0;i<nome.length();i++) {
			char c=nome.charAt(i);
			if(!Character.isAlphabetic(c)&&!Character.isSpaceChar(c))
				throw new ModelException("O nome deve conter apenas caracteres alfabéticos.");
		}
	}
	
	public static void validarApelido(String apelido) throws ModelException{
		if(apelido.length()==0||apelido==null)
			throw new ModelException("O apelido do Jogador não pode ser nulo.");
		if(apelido.length()>15)
			throw new ModelException("O apelido do Jogador deve ter no máximo 15 caracteres.");
		for(int i=0;i<apelido.length();i++) {
			char c=apelido.charAt(i);
			if(!Character.isAlphabetic(c)&&!Character.isSpaceChar(c))
				throw new ModelException("O apelido do jogador deve conter apenas caracteres alfabéticos.");
		}
	}
	
	public static void validarPosicao(String posicao) throws ModelException{
		if(posicao.length()==0||posicao==null)
			throw new ModelException("A posição do Jogador não pode ser nula.");
		if(!posicao.equalsIgnoreCase("Goleiro")&&!posicao.equalsIgnoreCase("Defesa")&&!posicao.equalsIgnoreCase("Meio Campo")&&!posicao.equalsIgnoreCase("Ataque"))
			throw new ModelException("A posição deve ser Goleiro,Defesa,Meio Campo ou Ataque.");
		
	}
	
	public static void validarClube(Clube clube) throws ModelException{
		if(clube==null)
			throw new ModelException("O clube deve ser indicado.");
	}

	@Override
	public String toString() {
		return  this.nome;
	}
	
	
}
