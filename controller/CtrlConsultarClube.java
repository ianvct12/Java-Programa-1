package controller;

import model.Clube;
import model.DaoClube;
import viewer.JanelaConsultarClube;

public class CtrlConsultarClube {
	final private CtrlPrograma ctrlPai;
	final private JanelaConsultarClube janela;
	
	private CtrlIncluirClube ctrlIncluirClube;
	
	private CtrlExcluirClube ctrlExcluirClube;
	
	public CtrlConsultarClube(CtrlPrograma ctrlPai) {
		this.ctrlPai=ctrlPai;
		
		DaoClube dao = new DaoClube();
		Clube[] listaClubes = dao.consultarClubes();
		
		this.janela = new JanelaConsultarClube(this,listaClubes);
		this.janela.setVisible(true);
	}
	
	public void iniciarCasoDeUsoCtrlIncluirClube() {
		if(this.ctrlIncluirClube==null)
			this.ctrlIncluirClube=new CtrlIncluirClube(this);
	}
	public void encerrarCasoDeUsoCtrlIncluirClube() {
		this.ctrlIncluirClube=null;
		DaoClube dao = new DaoClube();
		Clube[] listaClubes = dao.consultarClubes(); 
		this.janela.atualizarDados(listaClubes);
	}
	
	public void iniciarCasoDeUsoExcluirClube() {
		if(this.ctrlExcluirClube==null)
			ctrlExcluirClube= new CtrlExcluirClube(this);
	}
	public void encerrarCasoDeUsoExcluirClube() {
		this.ctrlExcluirClube=null;
		DaoClube dao = new DaoClube();
		Clube[] listaClubes = dao.consultarClubes(); 
		this.janela.atualizarDados(listaClubes);
	}
	public void encerrarCasoDeUso() {
		this.janela.setVisible(false);
		this.ctrlPai.encerrarCasoDeUsoCtrlConsultarClube();
	}
	
	
}
