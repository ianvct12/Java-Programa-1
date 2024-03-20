package controller;

import model.Jogador;
import model.DaoJogador;
import viewer.JanelaConsultarJogador;

public class CtrlConsultarJogador {
	final private CtrlPrograma ctrlPai;
	final private JanelaConsultarJogador janela;
	
	private CtrlIncluirJogador ctrlIncluirJogador;
	
	private CtrlExcluirJogador ctrlExcluirJogador;
	
	public CtrlConsultarJogador(CtrlPrograma ctrlPai) {
		this.ctrlPai=ctrlPai;
		
		DaoJogador dao = new DaoJogador();
		Jogador[] listaJogadors = dao.consultarJogadors();
		
		this.janela = new JanelaConsultarJogador(this,listaJogadors);
		this.janela.setVisible(true);
	}
	
	public void iniciarCasoDeUsoCtrlIncluirJogador() {
		if(this.ctrlIncluirJogador==null)
			this.ctrlIncluirJogador=new CtrlIncluirJogador(this);
	}
	public void encerrarCasoDeUsoCtrlIncluirJogador() {
		this.ctrlIncluirJogador=null;
		DaoJogador dao = new DaoJogador();
		Jogador[] listaJogadors = dao.consultarJogadors();
		this.janela.atualizarDados(listaJogadors);

	}
	
	public void iniciarCasoDeUsoExcluirJogador() {
		if(this.ctrlExcluirJogador==null)
			ctrlExcluirJogador= new CtrlExcluirJogador(this);
	}
	
	public void encerrarCasoDeUsoExcluirJogador() {
		this.ctrlExcluirJogador=null;
		DaoJogador dao = new DaoJogador();
		Jogador[] listaJogadors = dao.consultarJogadors();
		this.janela.atualizarDados(listaJogadors);
	}
	public void encerrarCasoDeUso() {
		this.janela.setVisible(false);
		this.ctrlPai.encerrarCasoDeUsoCtrlConsultarJogador();
	}
}
