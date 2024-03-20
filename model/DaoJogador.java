package model;

public class DaoJogador extends Dao {
	//
	// Constantes
	//
	final public static int TAM_INICIAL = 10;
	final public static int FATOR_CRESCIMENTO = 5;
	
	//
	// Atributos
	
	private static Jogador[]  listaJogadors;
	private static int 		 numJogadors;
	
	public static void inicializar(Jogador[] array) {
		DaoJogador.listaJogadors = array;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == null)
				break;
			DaoJogador.numJogadors++;
		}
	}


	public static int getNumJogadors() {
		return DaoJogador.numJogadors;
	}
	
	
	public void incluir(Jogador p) {
		
		if(DaoJogador.listaJogadors == null) {
			DaoJogador.listaJogadors = new Jogador[TAM_INICIAL];
			DaoJogador.numJogadors = 0;
		} 
		
		if(DaoJogador.listaJogadors.length == DaoJogador.numJogadors) {
			int novoTamanho = DaoJogador.listaJogadors.length + FATOR_CRESCIMENTO;
			Jogador[] novoArray = new Jogador[novoTamanho];
			for(int i = 0; i < DaoJogador.numJogadors; i++)
				novoArray[i] = DaoJogador.listaJogadors[i];
			DaoJogador.listaJogadors = novoArray;
		}
		// Incluindo o novo objeto no array
		DaoJogador.listaJogadors[DaoJogador.numJogadors] = p;
		DaoJogador.numJogadors++;	
		// Salvando o objeto
		Dao.salvar();
	}
	
	
	public void alterar(Jogador p) throws ModelException {
		
		if(DaoJogador.listaJogadors == null) 
			throw new ModelException("Não se pode fazer a alteração pois a área não foi previamente inicializada");
		
		for(int i = 0; i < DaoJogador.numJogadors;i++) {
			if(DaoJogador.listaJogadors[i] == p) {
				Dao.salvar();
				return;
			}
		}
	
		throw new ModelException("Solicitação de Alteração de um objeto que não foi salvo anteriormente");
	}
	
	/**
	 * Promove a exclusão de um objeto no DaoJogador 
	 */
	public void excluir(Jogador p) throws ModelException {
		
		if(DaoJogador.listaJogadors == null) 
			throw new ModelException("Não se pode fazer a alteração pois a área não foi previamente inicializada");
		
		for(int i = 0; i < DaoJogador.numJogadors;i++) {
			if(DaoJogador.listaJogadors[i] == p) {
				
				for(int j = i; j < DaoJogador.numJogadors-1; j++) 
					DaoJogador.listaJogadors[j] = DaoJogador.listaJogadors[j + 1];
				DaoJogador.listaJogadors[numJogadors-1] = null;
				DaoJogador.numJogadors--;
				Dao.salvar();
				return;
			}
		}
	
		throw new ModelException("Solicitação de Exclusão de um objeto que não foi salvo anteriormente");
	}
	
	/**
	 * Retorna todas as pessoas criadas
	 */
	public static Jogador[] consultarJogadors() {
		Jogador[] copia = new Jogador[DaoJogador.numJogadors];
		for(int i = 0; i < DaoJogador.numJogadors; i++)
			copia[i] = DaoJogador.listaJogadors[i];
		return copia;
	}
}
