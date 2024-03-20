package controller;

import viewer.JanelaPrincipal;

public class CtrlPrograma {
	private JanelaPrincipal janela;
	
	
	private CtrlConsultarJogador ctrlConsultarJogador;
	private CtrlConsultarClube	ctrlConsultarClube;
	
	public CtrlPrograma() {
		this.janela= new JanelaPrincipal(this);
		this.janela.setVisible(true);
	}
	
	
	public void iniciarCasoDeUsoCtrlConsultarClube() {
		if(this.ctrlConsultarClube==null)
			ctrlConsultarClube=new CtrlConsultarClube(this);
	}
	public void encerrarCasoDeUsoCtrlConsultarClube() {
		this.ctrlConsultarClube=null;
	}
	
	public void iniciarCasoDeUsoCtrlConsultarJogador() {
		if(this.ctrlConsultarJogador==null)
			ctrlConsultarJogador = new CtrlConsultarJogador(this);
	}
	
	
	public void encerrarCasoDeUsoCtrlConsultarJogador() {
		this.ctrlConsultarJogador=null;
	}
	
	public void encerrarCasoDeUso() {
		System.exit(0);
	}
	public static void main(String[] args) {
		CtrlPrograma p = new CtrlPrograma();
	}



	
}
