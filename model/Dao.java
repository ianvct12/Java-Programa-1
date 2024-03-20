package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

abstract public class Dao {

	static {
		System.out.println("Classe Dao Carregada");
		try {
			FileInputStream fis = new FileInputStream("objetos.bin");
			ObjectInputStream ois = new ObjectInputStream(fis);
		
			Clube[] clubes = (Clube[])ois.readObject();
			DaoClube.inicializar(clubes);
			
			Jogador[] jogadores = (Jogador[])ois.readObject();
			DaoJogador.inicializar(jogadores);
			
			ois.close();			
		} catch (FileNotFoundException e) {
			System.out.println("Não foi localizado o arquivo de persistência");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void salvar() {
		try {
			FileOutputStream fos = new FileOutputStream("objetos.bin");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			Clube[] listaClubes = DaoClube.consultarClubes(); 
			oos.writeObject(listaClubes);
			
			
			Jogador[] listaJogadores = DaoJogador.consultarJogadors(); 
			oos.writeObject(listaJogadores);
			// Salva o arquivo de serialização
			oos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
