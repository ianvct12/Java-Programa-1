package controller;

import model.Clube;
import model.Clube;
import model.DaoClube;
import model.DaoJogador;
import model.Jogador;
import model.ModelException;
import viewer.JanelaJogador;

public class CtrlIncluirJogador {
	final private CtrlConsultarJogador ctrlPai;
	final private JanelaJogador janela;
	
	CtrlIncluirJogador(CtrlConsultarJogador ctrlPai){
		this.ctrlPai=ctrlPai;
		
		DaoClube dao = new DaoClube();
		Clube[] listaClubes=DaoClube.consultarClubes();
		
		this.janela= new JanelaJogador(this,listaClubes);
		this.janela.setVisible(true);
	}
	public void incluirJogador(String nome, String apelido, String posicao,Clube clube) {
		Jogador j;
		
		try {
			j = new Jogador(nome,apelido,posicao,clube);
		}
		catch(ModelException me) {
			janela.notificar("ERRO:" + me.getMessage());
			return;
		}
		janela.notificar("Novo Jogador criado: " + j);
		
		DaoJogador dao = new DaoJogador();
		dao.incluir(j);
		
		this.encerrarCasoDeUso();
	}
	
	public void encerrarCasoDeUso() {
		this.janela.setVisible(false);
		this.ctrlPai.encerrarCasoDeUsoCtrlIncluirJogador();
	}
}
