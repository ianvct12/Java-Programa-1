package model;

public class DaoClube extends Dao {
	//
	// Constantes
	//
	final public static int TAM_INICIAL = 10;
	final public static int FATOR_CRESCIMENTO = 5;
	
	//
	// Atributos
	
	private static Clube[]  listaClubes;
	private static int 		 numClubes;
	
	public static void inicializar(Clube[] array) {
		DaoClube.listaClubes = array;
		for(int i = 0; i < array.length; i++) {
			if(array[i] == null)
				break;
			DaoClube.numClubes++;
		}
	}


	public static int getNumClubes() {
		return DaoClube.numClubes;
	}
	
	
	public void incluir(Clube p) {
		
		if(DaoClube.listaClubes == null) {
			DaoClube.listaClubes = new Clube[TAM_INICIAL];
			DaoClube.numClubes = 0;
		} 
		
		if(DaoClube.listaClubes.length == DaoClube.numClubes) {
			int novoTamanho = DaoClube.listaClubes.length + FATOR_CRESCIMENTO;
			Clube[] novoArray = new Clube[novoTamanho];
			for(int i = 0; i < DaoClube.numClubes; i++)
				novoArray[i] = DaoClube.listaClubes[i];
			DaoClube.listaClubes = novoArray;
		}
		DaoClube.listaClubes[DaoClube.numClubes] = p;
		DaoClube.numClubes++;	
		Dao.salvar();
	}
	
	
	public void alterar(Clube p) throws ModelException {
	
		if(DaoClube.listaClubes == null) 
			throw new ModelException("Não se pode fazer a alteração pois a área não foi previamente inicializada");
		
		for(int i = 0; i < DaoClube.numClubes;i++) {
			
			if(DaoClube.listaClubes[i] == p) {
				
				Dao.salvar();
				return;
			}
		}
		
		throw new ModelException("Solicitação de Alteração de um objeto que não foi salvo anteriormente");
	}
	
	/**
	 * Promove a exclusão de um objeto no DaoClube 
	 */
	public void excluir(Clube p) throws ModelException {
	
		if(DaoClube.listaClubes == null) 
			throw new ModelException("Não se pode fazer a alteração pois a área não foi previamente inicializada");
		
		for(int i = 0; i < DaoClube.numClubes;i++) {
			if(DaoClube.listaClubes[i] == p) {
				
				for(int j = i; j < DaoClube.numClubes-1; j++) 
					DaoClube.listaClubes[j] = DaoClube.listaClubes[j + 1];
				DaoClube.listaClubes[numClubes-1] = null;
				DaoClube.numClubes--;
				Dao.salvar();
				return;
			}
		}
		
		throw new ModelException("Solicitação de Exclusão de um objeto que não foi salvo anteriormente");
	}
	
	/**
	 * Retorna todas as pessoas criadas
	 */
	public static Clube[] consultarClubes() {
		Clube[] copia = new Clube[DaoClube.numClubes];
		for(int i = 0; i < DaoClube.numClubes; i++)
			copia[i] = DaoClube.listaClubes[i];
		return copia;
	}
}
