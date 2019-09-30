package programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;

public class DietaJanela extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodUsuario;
	private int codNutricionista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DietaJanela frame = new DietaJanela();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DietaJanela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dieta e Dicas:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblNewLabel.setBounds(29, 11, 166, 32);
		contentPane.add(lblNewLabel);
		
		txtCodUsuario = new JTextField();
		txtCodUsuario.setColumns(10);
		txtCodUsuario.setBounds(29, 89, 86, 20);
		contentPane.add(txtCodUsuario);
		
		JLabel lblCod = new JLabel("Escolha o c\u00F3digo do usu\u00E1rio:");
		lblCod.setBounds(29, 64, 207, 14);
		contentPane.add(lblCod);
		
		JLabel lblCasoNoSaiba = new JLabel("Caso n\u00E3o saiba o c\u00F3digo do usu\u00E1rio");
		lblCasoNoSaiba.setBounds(281, 64, 243, 14);
		contentPane.add(lblCasoNoSaiba);
		
		JButton btnVerCdigos = new JButton("Ver c\u00F3digos");
		btnVerCdigos.setBounds(315, 88, 122, 23);
		contentPane.add(btnVerCdigos);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(58, 182, 379, 158);
		contentPane.add(textPane);
		
		JLabel lblDigiteSuaDietamx = new JLabel("Digite sua dieta(m\u00E1x 300 caracteres):");
		lblDigiteSuaDietamx.setBounds(58, 157, 288, 14);
		contentPane.add(lblDigiteSuaDietamx);
		
		JRadioButton rdbtnSeg = new JRadioButton("Seg");
		rdbtnSeg.setBounds(58, 385, 52, 23);
		contentPane.add(rdbtnSeg);
		
		JRadioButton rdbtnTer = new JRadioButton("Ter");
		rdbtnTer.setBounds(112, 385, 52, 23);
		contentPane.add(rdbtnTer);
		
		JRadioButton rdbtnQua = new JRadioButton("Qua");
		rdbtnQua.setBounds(166, 385, 52, 23);
		contentPane.add(rdbtnQua);
		
		JRadioButton rdbtnQui = new JRadioButton("Qui");
		rdbtnQui.setBounds(220, 385, 52, 23);
		contentPane.add(rdbtnQui);
		
		JRadioButton rdbtnSex = new JRadioButton("Sex");
		rdbtnSex.setBounds(280, 385, 52, 23);
		contentPane.add(rdbtnSex);
		
		JRadioButton rdbtnSb = new JRadioButton("S\u00E1b");
		rdbtnSb.setBounds(334, 385, 52, 23);
		contentPane.add(rdbtnSb);
		
		JRadioButton rdbtnDom = new JRadioButton("Dom");
		rdbtnDom.setBounds(388, 385, 52, 23);
		contentPane.add(rdbtnDom);
		
		JLabel lblSelecioneODia = new JLabel("Selecione o dia para a dieta ser implementada:");
		lblSelecioneODia.setBounds(58, 364, 367, 14);
		contentPane.add(lblSelecioneODia);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(194, 433, 89, 23);
		contentPane.add(btnEnviar);
	}
	
	public void setCodNutriLogado(int codNutricionista) {
		this.codNutricionista = codNutricionista;
	}
}
