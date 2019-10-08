package programa;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.daos.Usuarios;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import bd.daos.*;
import bd.dbos.*;


public class DietaJanela extends JFrame {

	private JPanel contentPane;
	private ButtonGroup grupoDias;
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
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
		btnVerCdigos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TodosUsuarios tdsUsers = new TodosUsuarios();
				tdsUsers.setVisible(true);
				tdsUsers.setCodNutricionista(codNutricionista);
				tdsUsers.inserirValores();
			}
		});
		btnVerCdigos.setBounds(315, 88, 122, 23);
		contentPane.add(btnVerCdigos);
		
		JTextPane txtDieta = new JTextPane();
		txtDieta.setBounds(58, 182, 379, 158);
		contentPane.add(txtDieta);
		
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
		
		JRadioButton rdbtnSab = new JRadioButton("S\u00E1b");
		rdbtnSab.setBounds(334, 385, 52, 23);
		contentPane.add(rdbtnSab);
		
		JRadioButton rdbtnDom = new JRadioButton("Dom");
		rdbtnDom.setBounds(388, 385, 52, 23);
		contentPane.add(rdbtnDom);
		
		JLabel lblSelecioneODia = new JLabel("Selecione o dia para a dieta ser implementada:");
		lblSelecioneODia.setBounds(58, 364, 367, 14);
		contentPane.add(lblSelecioneODia);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(codigoValido(txtCodUsuario.getText()))
				{
					try 
					{
						String dia = "";
						if(rdbtnSeg.isSelected())
							dia = "seg";
						else if(rdbtnTer.isSelected())
							dia = "ter";
						else if(rdbtnQua.isSelected())
							dia = "qua";
						else if(rdbtnQui.isSelected())
							dia = "qui";
						else if(rdbtnSex.isSelected())
							dia = "sex";
						else if(rdbtnSab.isSelected())
							dia = "sab";
						else if(rdbtnDom.isSelected())
							dia = "dom";
						if(!(dia.equals(""))) 
						{
							int codUsuario = Integer.parseInt(txtCodUsuario.getText());
							Dietas.inserir(codUsuario, txtDieta.getText(), dia);
							JOptionPane.showMessageDialog(null,"Dieta inserida com sucesso!");
						}
						else 
						{
							JOptionPane.showMessageDialog(null,"Selecione o dia para implementar a dieta!");
						}
						
					}
					catch(Exception ex) 
					{
						JOptionPane.showMessageDialog(null,ex.getMessage());
					}
				}		

			}
		});
		
		
		grupoDias = new ButtonGroup();
		grupoDias.add(rdbtnSeg);
		grupoDias.add(rdbtnTer);
		grupoDias.add(rdbtnQua);
		grupoDias.add(rdbtnQui);
		grupoDias.add(rdbtnSex);
		grupoDias.add(rdbtnSab);
		grupoDias.add(rdbtnDom);
		
		btnEnviar.setBounds(194, 433, 89, 23);
		contentPane.add(btnEnviar);
	}
	
	public void setCodNutriLogado(int codNutricionista) {
		this.codNutricionista = codNutricionista;
	}
	
	private boolean codigoValido(String codigo) {
		int codigoInt = Integer.parseInt(codigo);
		
		if(codigo.isEmpty() || codigo.trim().equals("") || codigoInt < 0) 
		{
			JOptionPane.showMessageDialog(null,"Código inválido!");
			return false;
		}
		
		try 
		{
			if(!(Usuarios.cadastrado(codigoInt)))
			{
				JOptionPane.showMessageDialog(null,"Código de usuário não cadastrado!");
				return false;
			}
			
			Usuario selecionado = Usuarios.getUsuario(codigoInt);
			
			if(selecionado.getCodNutricionista() != this.codNutricionista) 
			{
				JOptionPane.showMessageDialog(null,"Este usuário pertence à outro nutricionista!");
				return false;
			}
		}
		catch(Exception ex) 
		{
			JOptionPane.showMessageDialog(null,ex.getMessage());
		}
		
		return true;			
		}
	}

