package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controller.CtrlConsultarJogador;
import controller.CtrlPrograma;
import model.Jogador;

public class JanelaConsultarJogador extends JFrame {

	//
	// ATRIBUTOS
	//
	final private CtrlConsultarJogador ctrl;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tabela;
	private JButton btIncluirJogador;
	private JButton btExcluirJogador;

	/**
	 * Create the frame.
	 */
	public JanelaConsultarJogador(CtrlConsultarJogador c, Jogador[] listaJogadors) {
		this.ctrl = c;
		setTitle("Consultar Jogador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.atualizarDados(listaJogadors);

		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.encerrarCasoDeUso();
			}
		});
		btSair.setBounds(181, 227, 89, 23);
		contentPane.add(btSair);

		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBounds(10, 11, 414, 200);
		contentPane.add(scrollPane);
		
		btIncluirJogador = new JButton("Incluir Jogador");
		btIncluirJogador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarCasoDeUsoCtrlIncluirJogador();
			}
		});
		btIncluirJogador.setBounds(20, 227, 120, 23);
		contentPane.add(btIncluirJogador);
		
		btExcluirJogador = new JButton("Excluir Jogador");
		btExcluirJogador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarCasoDeUsoExcluirJogador();
			}
		});
		btExcluirJogador.setBounds(301, 227, 123, 23);
		contentPane.add(btExcluirJogador);
	}

	/**
	 * Atualiza os dados apresentados no JTable da janela
	 */
	public void atualizarDados(Jogador[] listaJogadors) {
		HelperTableModel h = new HelperTableModel(listaJogadors);
		if(tabela==null)
			tabela = new JTable(h.getTableModel());
		else
			tabela.setModel(h.getTableModel());
	}

	/**
	 * Coloca uma mensagem para o usuário
	 */
	public void notificar(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}
}
