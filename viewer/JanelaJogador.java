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

import controller.CtrlIncluirJogador;
import model.Clube;
import model.Jogador;

public class JanelaJogador extends JFrame {

	private static final long serialVersionUID = 1L;
	final private CtrlIncluirJogador ctrl;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfApelido;
	private JComboBox cbClube;
	private JComboBox cbPosicao;
	
	/**
	 * Create the frame.
	 */
	public JanelaJogador(CtrlIncluirJogador ctrl,Clube[] listaClubes) {
		setTitle("Incluir Jogador");
		this.ctrl=ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 35, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apelido:");
		lblNewLabel_1.setBounds(10, 88, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Posição:");
		lblNewLabel_2.setBounds(10, 123, 63, 14);
		contentPane.add(lblNewLabel_2);
		
		tfNome = new JTextField();
		tfNome.setBounds(76, 32, 86, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfApelido = new JTextField();
		tfApelido.setBounds(76, 85, 86, 20);
		contentPane.add(tfApelido);
		tfApelido.setColumns(10);
		
		cbPosicao = new JComboBox();
		cbPosicao.addItem("Goleiro");
		cbPosicao.addItem("Defesa");
		cbPosicao.addItem("Meio Campo");
		cbPosicao.addItem("Ataque");
		
		cbPosicao.setBounds(110, 119, 116, 22);
		contentPane.add(cbPosicao);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tfNome.getText();
				String apelido = tfApelido.getText();
				
				
				String posicao = (String)cbPosicao.getSelectedItem();//NÃO ESQUECER DE COLOCAR ISSO

				
				
				Clube b = (Clube)cbClube.getSelectedItem();//NÃO ESQUECER DE COLOCAR ISSO
				
				ctrl.incluirJogador(nome, apelido, posicao, b);
			}
		});
		btOk.setBounds(56, 198, 89, 23);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.encerrarCasoDeUso();
			}
		});
		btCancelar.setBounds(239, 198, 89, 23);
		contentPane.add(btCancelar);
		
		JLabel lblNewLabel_3 = new JLabel("Clube:");
		lblNewLabel_3.setBounds(10, 162, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		
		cbClube = new JComboBox(listaClubes);
		cbClube.setBounds(79, 165, 184, 22);
		contentPane.add(cbClube);
	}
	public void notificar(String texto) {
		JOptionPane.showMessageDialog(null, texto);		
	}
}
