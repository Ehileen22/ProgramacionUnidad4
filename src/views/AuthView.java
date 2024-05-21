package views;
import java.sql.*; 
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controllers.Auth;
import models.AuthModel;

public class AuthView {
	private JFrame frame;
	private Auth controller;
	private AuthModel auth;
	public AuthView()
	{
		frame=new JFrame();
		frame.setVisible(false);
		frame.setBounds(120, 50,750, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		
		auth=new AuthModel();
	}
	
	public void login()
	{
		//frame.setVisible(t);
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.decode("#354E8E"));
		JLabel loginTitle=new JLabel("Iniciar sesión",0);
		loginTitle.setSize(300, 80);
		loginTitle.setFont(new Font("Georgia",Font.BOLD ,30));
		loginTitle.setForeground(Color.WHITE);
		loginTitle.setLocation(215, 0);
		loginTitle.setOpaque(false);
		panel.add(loginTitle);
		
		JLabel myAccount=new JLabel("Mi cuenta",0);
		myAccount.setSize(300, 80);
		myAccount.setFont(new Font("Georgia Italic",Font.BOLD ,40));
		myAccount.setForeground(new Color(243, 189, 80));
		myAccount.setLocation(215, 70);
		myAccount.setOpaque(false);
		panel.add(myAccount);
		
		JLabel userName1 = new JLabel("Nombre de usuario");
		userName1.setBounds(215, 161, 300, 35);
		userName1.setFont(new Font("Georgia",Font.BOLD ,20));
		userName1.setForeground(Color.WHITE);
		panel.add(userName1);
		
		JTextField userResponse = new JTextField();
		userResponse.setBounds(215, 212, 300, 35);
		panel.add(userResponse);
		
		
		JLabel pwd = new JLabel("Contraseña");
		pwd.setBounds(220, 275, 300, 35);
		pwd.setFont(new Font("Georgia",Font.BOLD ,20));
		pwd.setForeground(Color.WHITE);
		panel.add(pwd);
		
		JPasswordField pwdResponse = new JPasswordField();
		pwdResponse.setBounds(220, 321, 300, 35);
		panel.add(pwdResponse);
		
		JButton access= new JButton("Iniciar sesión");
		access.setBounds(261, 394, 210, 45);
		access.setFont(new Font("Georgia",Font.BOLD ,25));
		access.setBackground(new Color(243, 189, 80 ));
		access.setOpaque(true);
		access.setBorderPainted(true);
		access.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		panel.add(access);
		access.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("si");
				String passw = new String(pwdResponse.getPassword());
				boolean resultado=auth.login(userResponse.getText(), passw);
				if(resultado!=false)
				{
					pwdResponse.setBorder(BorderFactory.createLineBorder(Color.green, 2));
					userResponse.setBorder(BorderFactory.createLineBorder(Color.green, 2));
					
					JOptionPane.showMessageDialog(null, "Inicio de sesion completado con éxito", null, JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					pwdResponse.setBorder(BorderFactory.createLineBorder(Color.red, 2));
					userResponse.setBorder(BorderFactory.createLineBorder(Color.red, 2));
					
					JOptionPane.showMessageDialog(null, "Los datos que ha ingresado son incorrectos, favor de ingresarlos correctamente.", null, JOptionPane.WARNING_MESSAGE);
				}
			}
			
		});
		
		JLabel cuestion = new JLabel("¿No tienes una cuenta?");
		cuestion.setBounds(300, 493, 134, 35);
		cuestion.setFont(new Font("Georgia",Font.BOLD ,10));
		cuestion.setForeground(Color.WHITE);
		panel.add(cuestion);
		
		JButton signUp= new JButton("Registrarse");
		signUp.setBounds(297, 526, 137, 35);
		signUp.setFont(new Font("Georgia",Font.BOLD ,15));
		signUp.setBackground(new Color(243, 189, 80 ));
		signUp.setOpaque(true);
		signUp.setBorderPainted(true);
		signUp.setBorder(BorderFactory.createLineBorder(Color.WHITE,3));
		panel.add(signUp);
		signUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				frame.remove(panel);
//				register();
				controller=new Auth();
				frame.removeAll();
				frame.setVisible(false);
				controller.register();
			}
			
			
		});
		
		JLabel color = new JLabel();
		color.setBackground(new Color(48, 67, 117));
		color.setBounds(40,76 , 650, 395);
		color.setOpaque(true);
		color.setFont(new Font("Georgia",Font.BOLD ,25));
		panel.add(color);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
	}
	
	public void register()
	{
		
		JPanel account2= new JPanel();
		account2.setSize(frame.getWidth(),frame.getHeight());
		account2.setLocation(0,0);
		account2.setBackground(Color.decode("#354E8E"));
		account2.setLayout(null);
		
		JLabel loginTitle=new JLabel("Registrarse",0);
		loginTitle.setSize(300, 80);
		loginTitle.setFont(new Font("Georgia",Font.BOLD ,40));
		loginTitle.setForeground(new Color(243, 189, 80));
		loginTitle.setLocation(202, -2);
		loginTitle.setOpaque(false);
		account2.add(loginTitle);
		
		
		JLabel userName1 = new JLabel("Ingresa tu nombre");
		userName1.setBounds(213, 89, 300, 35);
		userName1.setFont(new Font("Georgia",Font.BOLD ,20));
		userName1.setForeground(Color.WHITE);
		account2.add(userName1);
		
		JTextField userResponse = new JTextField();
		userResponse.setBounds(215, 126, 300, 35);
		account2.add(userResponse);
		
		
		JLabel apellido = new JLabel("Ingresa tu apellido");
		apellido.setBounds(213, 160, 300, 35);
		apellido.setFont(new Font("Georgia",Font.BOLD ,20));
		apellido.setForeground(Color.WHITE);
		account2.add(apellido);
		
		JTextField apellidoResponse = new JTextField();
		apellidoResponse.setBounds(213, 194, 300, 35);
		account2.add(apellidoResponse);
		JLabel correo = new JLabel("Correo electrónico");
		correo.setBounds(213, 230, 300, 35);
		correo.setFont(new Font("Georgia",Font.BOLD ,20));
		correo.setForeground(Color.WHITE);
		account2.add(correo);
		
		JTextField correoResponse = new JTextField();
		correoResponse.setBounds(213, 264, 300, 35);
		account2.add(correoResponse);
		
		JLabel pwd = new JLabel("Contraseña");
		pwd.setBounds(213, 302, 300, 35);
		pwd.setFont(new Font("Georgia",Font.BOLD ,20));
		pwd.setForeground(Color.WHITE);
		account2.add(pwd);
		
		JPasswordField pwdResponse = new JPasswordField();
		pwdResponse.setBounds(213, 334, 300, 35);
		account2.add(pwdResponse);
		
		JLabel pwdConf = new JLabel("Confirmar contraseña");
		pwdConf.setBounds(213, 371, 300, 35);
		pwdConf.setFont(new Font("Georgia",Font.BOLD ,20));
		pwdConf.setForeground(Color.WHITE);
		account2.add(pwdConf);
		
		JPasswordField pwdConfResponse = new JPasswordField();
		pwdConfResponse.setBounds(213, 404, 300, 35);
		account2.add(pwdConfResponse);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Acepto los términos y condiciones, vendo mi alma al cielo.");
		chckbxNewCheckBox.setFont(new Font("Georgia",Font.BOLD ,9));
		chckbxNewCheckBox.setForeground(new Color(255, 255, 255));
		chckbxNewCheckBox.setOpaque(false);
		chckbxNewCheckBox.setBounds(212, 446, 301, 23);
		account2.add(chckbxNewCheckBox);
		
		JButton access= new JButton("Registrarse");
		access.setBounds(283, 480, 167, 45);
		access.setFont(new Font("Georgia",Font.BOLD ,25));
		access.setBackground(new Color(243, 189, 80 ));
		access.setOpaque(true);
		access.setBorderPainted(true);
		access.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		account2.add(access);
		access.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String passw = new String(pwdResponse.getPassword());
		        String confir = new String(pwdConfResponse.getPassword());
		        String nom=userResponse.getText();
		        String ape=apellidoResponse.getText();
		        String correoE=correoResponse.getText();
				if(passw.equals(confir)&& !passw.equals("") &&!confir.equals(""))
				{
					pwdResponse.setBorder(BorderFactory.createLineBorder(Color.green, 2));
					pwdConfResponse.setBorder(BorderFactory.createLineBorder(Color.green, 2));;
				}
				else
				{
					pwdResponse.setBorder(BorderFactory.createLineBorder(Color.red, 2));
					pwdConfResponse.setBorder(BorderFactory.createLineBorder(Color.red, 2));;
				}
				
				if(nom.length()<=0)
				{
					userResponse.setBorder(BorderFactory.createLineBorder(Color.red, 2));
					
				}
				else
				{
					userResponse.setBorder(BorderFactory.createLineBorder(Color.green, 2));
				}
				
				if(ape.length()<=0)
				{
					apellidoResponse.setBorder(BorderFactory.createLineBorder(Color.red, 2));
				}
				else
				{
					apellidoResponse.setBorder(BorderFactory.createLineBorder(Color.green, 2));
				}
				if(correoE.length()<=0)
				{
					correoResponse.setBorder(BorderFactory.createLineBorder(Color.red, 2));
					
				}
				else
				{
					correoResponse.setBorder(BorderFactory.createLineBorder(Color.green, 2));
				}
				if(!chckbxNewCheckBox.isSelected())
				{
					chckbxNewCheckBox.setBorderPainted(true);
					chckbxNewCheckBox.setBorder(BorderFactory.createLineBorder(Color.red, 2));
				}
				else
				{
					chckbxNewCheckBox.setBorderPainted(true);
					chckbxNewCheckBox.setBorder(BorderFactory.createLineBorder(Color.green, 2));
				}
			}
		});
		//getContentPane().add(account2);
		
		JLabel color = new JLabel();
		color.setBackground(new Color(48, 67, 117));
		color.setBounds(40,79 , 650, 461);
		color.setOpaque(true);
		color.setFont(new Font("Georgia",Font.BOLD ,25));
		account2.add(color);
		
		JButton btnNewButton = new JButton("¿Ya tienes una cuenta?");
		btnNewButton.setForeground(Color.white);
		btnNewButton.setBounds(283, 547, 167, 23);
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(Color.decode("#354E8E"));
		account2.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				frame.remove(account2);
//				register();
				controller=new Auth();
				frame.removeAll();
				frame.setVisible(false);
				controller.login();
					
			}
			
			
		});
		
		frame.add(account2);
		frame.setVisible(true);
		frame.repaint();
		frame.revalidate();
				
	}

}
