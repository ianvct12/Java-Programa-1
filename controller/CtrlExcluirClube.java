package controller;

import model.Clube;
import model.DaoClube;
import model.ModelException;
import viewer.JanelaExcluirClube;

public class CtrlExcluirClube {
	final private CtrlConsultarClube ctrlPai;
	final private JanelaExcluirClube janela;
	
	public CtrlExcluirClube(CtrlConsultarClube ctrlPai) {
		this.ctrlPai=ctrlPai;
		DaoClube dao = new DaoClube();
		Clube[] listaClubes=DaoClube.consultarClubes();
		this.janela= new JanelaExcluirClube(this,listaClubes);
		this.janela.setVisible(true);
	}
	public void excluirClube(Clube b) {
		try {
			DaoClube dao = new DaoClube();
			dao.excluir(b);
		}
		catch(ModelException me) {
			this.janela.notificar("ERRO: " + me.getMessage());
			return;
		}
		this.janela.notificar("Disciplina Excluída: " + b);
		
		this.encerrarCasoDeUso();
	}
	public void encerrarCasoDeUso() {
		janela.setVisible(false);
		this.ctrlPai.encerrarCasoDeUsoExcluirClube();
	}
	
}
