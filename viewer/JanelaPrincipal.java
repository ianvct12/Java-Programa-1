package viewer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlPrograma;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	final private CtrlPrograma ctrl;
	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal(CtrlPrograma ctrl) {
		setTitle("Consulta");
		this.ctrl=ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.encerrarCasoDeUso();
			}
		});
		btSair.setBounds(166, 214, 89, 23);
		contentPane.add(btSair);
		
		JButton btConsultarClube = new JButton("Consultar Clube");
		btConsultarClube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarCasoDeUsoCtrlConsultarClube();
			}
		});
		btConsultarClube.setBounds(133, 31, 141, 62);
		contentPane.add(btConsultarClube);
		
		JButton btConsultarJogador = new JButton("Consultar Jogador");
		btConsultarJogador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.iniciarCasoDeUsoCtrlConsultarJogador();
			}
		});
		btConsultarJogador.setBounds(133, 132, 141, 62);
		contentPane.add(btConsultarJogador);
	}
}
