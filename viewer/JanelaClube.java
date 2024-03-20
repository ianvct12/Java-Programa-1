package viewer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlIncluirClube;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JanelaClube extends JFrame {

	private static final long serialVersionUID = 1L;
	final private CtrlIncluirClube ctrl;
	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfCidade;
	private JTextField tfUf;

	

	/**
	 * Create the frame.
	 */
	public JanelaClube(CtrlIncluirClube ctrl) {
		setTitle("Incluir Clube");
		this.ctrl=ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(10, 40, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cidade:");
		lblNewLabel_1.setBounds(10, 96, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Uf:");
		lblNewLabel_2.setBounds(10, 155, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		tfNome = new JTextField();
		tfNome.setBounds(73, 37, 86, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfCidade = new JTextField();
		tfCidade.setBounds(73, 93, 86, 20);
		contentPane.add(tfCidade);
		tfCidade.setColumns(10);
		
		tfUf = new JTextField();
		tfUf.setBounds(73, 152, 86, 20);
		contentPane.add(tfUf);
		tfUf.setColumns(10);
		
		JButton btOk = new JButton("Ok");
		btOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = tfNome.getText();
				String cidade = tfCidade.getText();
				String uf = tfUf.getText();
				
				ctrl.incluirClube(nome, cidade, uf);
			}
		});
		btOk.setBounds(45, 211, 89, 23);
		contentPane.add(btOk);
		
		JButton btCancelar = new JButton("Cancelar");
		btCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.encerrarCasoDeUso();
			}
		});
		btCancelar.setBounds(231, 211, 89, 23);
		contentPane.add(btCancelar);
	}
	public void notificar(String texto) {
		JOptionPane.showMessageDialog(null, texto);
	}
}
