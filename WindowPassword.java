import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;


public class WindowPassword extends Login{
	static boolean user = false;//user=1(admin), user=0(user)
	static boolean fl=false;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowPassword window = new WindowPassword();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public WindowPassword() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblInputPassword = new JLabel("WELCOM");
		
		JSplitPane splitPane = new JSplitPane();
		
		JButton btnInput = new JButton("Input");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
					if(authenticate1(getUsername(), getPassword()))
					{
						user = false;
						fl=true;
						frame.dispose();
						System.out.println(fl);
					}
					if(authenticate2(getAdminname(), getAdminPassword()))
					{
						user = true;
						fl=true;
						frame.dispose();
				
					}
				if(!fl)
				{
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								WindowErr window = new WindowErr();
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				else
				{
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								MainWindow window = new MainWindow();
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(191)
					.addComponent(lblInputPassword)
					.addContainerGap(199, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(splitPane, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(193, Short.MAX_VALUE)
					.addComponent(btnInput)
					.addGap(182))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblInputPassword)
					.addGap(18)
					.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnInput)
					.addContainerGap(16, Short.MAX_VALUE))
		);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		
		JLabel lblUser = new JLabel("User:");
		
		passwordField = new JPasswordField();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(68)
							.addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(passwordField, Alignment.LEADING)
								.addComponent(textField, Alignment.LEADING))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(61, Short.MAX_VALUE)
					.addComponent(lblPassword)
					.addGap(59))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblUser)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPassword)
					.addGap(18)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		
		JLabel lblAdmin = new JLabel("Admin:");
		
		JLabel lblPassword_1 = new JLabel("Password:");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		passwordField_1 = new JPasswordField();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(99)
							.addComponent(lblPassword_1))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(99)
							.addComponent(lblAdmin))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(79)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField_1)
								.addComponent(textField_1))))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAdmin)
					.addGap(18)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblPassword_1)
					.addGap(18)
					.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		frame.getContentPane().setLayout(groupLayout);
	}
	public String getUsername() {
        return textField.getText().trim();
    }
 
    public String getPassword() {
        return new String(passwordField.getPassword());
    }
    public String getAdminname() {
        return textField_1.getText().trim();
    }
 
    public String getAdminPassword() {
        return new String(passwordField_1.getPassword());
    }
}
