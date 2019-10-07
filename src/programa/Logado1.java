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
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void setCodNutriLogado(int codNutricionista) {
		this.codNutricionista = codNutricionista;
	}
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem vindo(a)!");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 36));
		lblNewLabel.setBounds(308, 161, 231, 42);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ver Usu\u00E1rios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TodosUsuarios tdsUsers = new TodosUsuarios();
				tdsUsers.setVisible(true);
				tdsUsers.setCodNutricionista(codNutricionista);
				tdsUsers.inserirValores();
			}
		});
		btnNewButton.setBounds(150, 232, 136, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Enviar Dietas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DietaJanela jan = new DietaJanela();
				jan.setVisible(true);
				jan.setCodNutriLogado(codNutricionista);
			}
		});
		btnNewButton_1.setBounds(329, 232, 145, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Editar Perfil");
		btnNewButton_2.setBounds(512, 232, 146, 29);
		contentPane.add(btnNewButton_2);
	}
	
}
