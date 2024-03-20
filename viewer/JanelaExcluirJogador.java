package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CtrlExcluirJogador;
import model.Jogador;

public class JanelaExcluirJogador extends JFrame {
	//
	// ATRIBUTOS
	//
	final private CtrlExcluirJogador ctrl;
	private JPanel     contentPane;
	private JComboBox  cbJogador;

	/**
	 * Create the frame.
	 */
	public JanelaExcluirJogador(CtrlExcluirJogador c, Jogador[] listaJogadors) {
		this.ctrl = c;
		setTitle("Excluir Jogador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Jogador d = (Jogador)cbJogador.getSelectedItem();
				
				
				ctrl.excluirJogador(d);
			}
		});
		btOk.setBounds(78, 110, 89, 23);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.encerrarCasoDeUso();
			}
		});
		btCancelar.setBounds(261, 110, 89, 23);
		contentPane.add(btCancelar);
		
		JLabel lblNewLabel_3_1 = new JLabel("Selecione o Jogador a ser Excluído:");
		lblNewLabel_3_1.setBounds(30, 31, 375, 14);
		contentPane.add(lblNewLabel_3_1);
		
	
		cbJogador = new JComboBox(listaJogadors);
		cbJogador.setBounds(30, 64, 375, 22);
		contentPane.add(cbJogador);
	}

	/**
	 * Coloca uma mensagem para o usuário
	 */
	public void notificar(String texto) {
		JOptionPane.showMessageDialog(null, texto);		
	}
}
