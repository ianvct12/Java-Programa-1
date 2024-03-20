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

import controller.CtrlConsultarClube;
import controller.CtrlPrograma;
import model.Clube;

public class JanelaConsultarClube extends JFrame {

	//
	// ATRIBUTOS
	//
	final private CtrlConsultarClube ctrl;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable tabela;
	private JButton btIncluirClube;
	private JButton btExcluirClube;

	/**
	 * Create the frame.
	 */
	public JanelaConsultarClube(CtrlConsultarClube c, Clube[] listaClubes) {
		this.ctrl = c;
		setTitle("Consultar Clubes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		this.atualizarDados(listaClubes);

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
		
		btIncluirClube = new JButton("Incluir Clube");
		btIncluirClube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarCasoDeUsoCtrlIncluirClube();
			}
		});
		btIncluirClube.setBounds(20, 227, 120, 23);
		contentPane.add(btIncluirClube);
		
		btExcluirClube = new JButton("Excluir Clube");
		btExcluirClube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarCasoDeUsoExcluirClube();
			}
		});
		btExcluirClube.setBounds(301, 227, 123, 23);
		contentPane.add(btExcluirClube);
	}

	/**
	 * Atualiza os dados apresentados no JTable da janela
	 */
	public void atualizarDados(Clube[] listaClubes) {
		HelperTableModel h = new HelperTableModel(listaClubes);
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
