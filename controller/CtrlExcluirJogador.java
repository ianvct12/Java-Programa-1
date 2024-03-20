package controller;

import model.Jogador;
import model.DaoJogador;
import model.ModelException;
import viewer.JanelaExcluirJogador;

public class CtrlExcluirJogador {
	final private CtrlConsultarJogador ctrlPai;
	final private JanelaExcluirJogador janela;
	
	public CtrlExcluirJogador(CtrlConsultarJogador ctrlPai) {
		this.ctrlPai=ctrlPai;
		DaoJogador dao = new DaoJogador();
		Jogador[] listaJogadors=DaoJogador.consultarJogadors();
		this.janela= new JanelaExcluirJogador(this,listaJogadors);
		this.janela.setVisible(true);
	}
	public void excluirJogador(Jogador j) {
		try {
			DaoJogador dao = new DaoJogador();
			dao.excluir(j);
		}
		catch(ModelException me) {
			this.janela.notificar("ERRO: " + me.getMessage());
			return;
		}
		this.janela.notificar("Disciplina Excluída: " + j);
		
		this.encerrarCasoDeUso();
	}
	public void encerrarCasoDeUso() {
		janela.setVisible(false);
		this.ctrlPai.encerrarCasoDeUsoExcluirJogador();
	}
	
}
