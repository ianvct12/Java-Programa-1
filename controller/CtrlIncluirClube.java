package controller;

import model.Clube;
import model.DaoClube;
import model.ModelException;
import viewer.JanelaClube;

public class CtrlIncluirClube {
	final private CtrlConsultarClube ctrlPai;
	final private JanelaClube janela;
	
	CtrlIncluirClube(CtrlConsultarClube ctrlPai){
		this.ctrlPai=ctrlPai;
		this.janela= new JanelaClube(this);
		this.janela.setVisible(true);
	}
	public void incluirClube(String nome, String cidade, String uf) {
		Clube cb;
		
		try {
			cb = new Clube(nome,cidade,uf);
		}
		catch(ModelException me) {
			janela.notificar("ERRO:" + me.getMessage());
			return;
		}
		janela.notificar("Novo Clube criado: " + cb);
		
		DaoClube dao = new DaoClube();
		dao.incluir(cb);
		
		this.encerrarCasoDeUso();
	}
	
	public void encerrarCasoDeUso() {
		this.janela.setVisible(false);
		this.ctrlPai.encerrarCasoDeUsoCtrlIncluirClube();
	}
}
