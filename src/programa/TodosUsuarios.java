package programa;
import java.util.List;
import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bd.dbos.*;
import bd.daos.*;
import javax.swing.JLabel;
import java.awt.Font;

public class TodosUsuarios extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private int codNutricionista;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TodosUsuarios frame = new TodosUsuarios();
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
	public TodosUsuarios() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nome", "Email", "Telefone", "Peso", "Altura", "Pontua\u00E7\u00E3o"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(59);
		table.getColumnModel().getColumn(1).setPreferredWidth(152);
		table.getColumnModel().getColumn(2).setPreferredWidth(138);
		table.getColumnModel().getColumn(3).setPreferredWidth(97);
		table.getColumnModel().getColumn(4).setPreferredWidth(66);
		table.getColumnModel().getColumn(5).setPreferredWidth(59);
		
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(table);
		
		JScrollPane scroll = new JScrollPane(table);
		contentPane.add(scroll);
		
		
		JLabel lblTodosOsSeus = new JLabel("Todos os seus usu\u00E1rios");
		lblTodosOsSeus.setFont(new Font("Tahoma", Font.PLAIN, 27));
		contentPane.add(lblTodosOsSeus, BorderLayout.NORTH);
		
	}
	
	public void setCodNutricionista(int codigo) 
	{
		this.codNutricionista = codigo;
	}
	
	public void inserirValores() 
	{
		try 
		{
			DefaultTableModel modelo = (DefaultTableModel) table.getModel(); // pega o modelo da tabela para inserir linhas
			
			List<Usuario> list = Usuarios.selecionarUsuarios(this.codNutricionista); // lista com todos usuarios do nutricionista
			
			
			for(int i = 0; i < list.size(); i++) 
			{
				Usuario user = list.get(i);
				
				Object[] linha = {user.getCodUsuario(), // linha que será adicionada na tabela
						user.getNome(),
						user.getEmail(), 
						user.getTelefone(),
						user.getPeso(), 
						user.getAltura(), 
						user.getPontuacao()};
				
				modelo.addRow(linha);
			}
		}
		catch(Exception ex) 
		{
			JOptionPane.showMessageDialog(null,"Erro ao procurar usuários");
		}
	}
}
