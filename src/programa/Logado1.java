package programa;

import java.awt.BorderLayout;

import bd.daos.Nutricionistas;
import bd.dbos.*;
import bd.dbos.*;
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
	 * Setter do c�digo do nutricionista
	 * Seta o atributo do c�digo do nutricionista logado com o valor passado como par�metro
	 * @param codNutricionista c�digo a ser setado
	 */
	public void setCodNutriLogado(int codNutricionista) {
		this.codNutricionista = codNutricionista;
	}
	/**
	 * Get do c�digo do nutricionista
	 * @return o valor do atributo do c�digo
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
		
	
		
		JButton btnNewButton = new JButton("Ver Usu\u00E1rios");
		/**
		 * Click no bot�o de exibir todos usu�rios
		 * Abre a janela com a tabela de todos usu�rios
		 * E ap�s abrir, chama o m�todo que insere os valores na JTable.
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TodosUsuarios tdsUsers = new TodosUsuarios();
				tdsUsers.setVisible(true);
				tdsUsers.setCodNutricionista(codNutricionista); 
				tdsUsers.inserirValores(); // insere a informa��es na tabela
			}
		});
		btnNewButton.setBounds(147, 319, 136, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Enviar Dietas");
		/**
		 * Click no bot�o de Dieta
		 * Abre a janela que permite o nutricionista enviar dietas aos seus usu�rios
		 */
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DietaJanela jan = new DietaJanela();
				jan.setVisible(true);
				jan.setCodNutriLogado(codNutricionista);
			}
		});
		btnNewButton_1.setBounds(326, 319, 145, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Editar Perfil");
		
		/**
		 * Click no bot�o de editar perfil.
		 * Abre a janela de edi��o de perfil do nutricionista
		 */
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditarPerfil editJan = new EditarPerfil();
				editJan.setVisible(true);
				editJan.setCodNutricionista(codNutricionista);
				editJan.exibirDados();
			}
		});
		btnNewButton_2.setBounds(522, 319, 146, 29);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Logado1.class.getResource("/imgs/logo.png")));
		lblNewLabel_1.setBounds(209, 44, 397, 110);
		contentPane.add(lblNewLabel_1);
	}
	
	/**
	 * Cria o label de bem vindo.
	 * Int�ncia o nutricionista que est� usando a aplica��o e pega-se o seu nome
	 * O nome � guardado em uma var�avel string e ent�o, cria-se o label com a mensgaem de bem vindo e o nome
	 */
	public void ajuste() 
	{
		String nome = "";
		try {
			Nutricionista nutri = Nutricionistas.getNutricionista(this.codNutricionista);
			nome = nutri.getNome();
			
		}
		catch(Exception ex) {}
		
		JLabel lblBemVindo = new JLabel("Bem vindo(a) " + nome);
		lblBemVindo.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		lblBemVindo.setBounds(209, 196, 500, 42);
		contentPane.add(lblBemVindo);
	}
}
