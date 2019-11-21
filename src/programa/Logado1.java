package programa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Logado1 extends JFrame {

	private JPanel contentPane;
	private int codNutricionista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logado1 frame = new Logado1();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Setter do código do nutricionista
	 * Seta o atributo do código do nutricionista logado com o valor passado como parâmetro
	 * @param codNutricionista código a ser setado
	 */
	public void setCodNutriLogado(int codNutricionista) {
		this.codNutricionista = codNutricionista;
	}
	/**
	 * Get do código do nutricionista
	 * @return o valor do atributo do código
	 */
	public int getCodNutriLogado() {
		return this.codNutricionista;
	}

	/**
	 * Create the frame.
	 */
	public Logado1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem vindo(a)!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		lblNewLabel.setBounds(288, 196, 231, 42);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ver Usu\u00E1rios");
		/**
		 * Click no botão de exibir todos usuários
		 * Abre a janela com a tabela de todos usuários
		 * E após abrir, chama o método que insere os valores na JTable.
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TodosUsuarios tdsUsers = new TodosUsuarios();
				tdsUsers.setVisible(true);
				tdsUsers.setCodNutricionista(codNutricionista); 
				tdsUsers.inserirValores(); // insere a informações na tabela
			}
		});
		btnNewButton.setBounds(150, 293, 136, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Enviar Dietas");
		/**
		 * Click no botão de Dieta
		 * Abre a janela que permite o nutricionista enviar dietas aos seus usuários
		 */
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DietaJanela jan = new DietaJanela();
				jan.setVisible(true);
				jan.setCodNutriLogado(codNutricionista);
			}
		});
		btnNewButton_1.setBounds(331, 293, 145, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Editar Perfil");
		
		/**
		 * Click no botão de editar perfil.
		 * Abre a janela de edição de perfil do nutricionista
		 */
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarPerfil editJan = new EditarPerfil();
				editJan.setVisible(true);
				editJan.setCodNutricionista(codNutricionista);
				editJan.exibirDados();
			}
		});
		btnNewButton_2.setBounds(518, 293, 146, 29);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Logado1.class.getResource("/imgs/logo.png")));
		lblNewLabel_1.setBounds(209, 44, 397, 110);
		contentPane.add(lblNewLabel_1);
	}
}
