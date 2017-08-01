	import java.awt.EventQueue;

	import javax.swing.JFrame;
	import javax.swing.JLabel;

	import java.awt.BorderLayout;

	import javax.swing.GroupLayout;
	import javax.swing.GroupLayout.Alignment;

	import java.awt.Color;
	import java.awt.Font;

	import javax.swing.JSplitPane;
	import javax.swing.JPanel;

	import java.awt.GridLayout;

	import javax.swing.JPasswordField;
	import javax.swing.JButton;
	import javax.swing.JTextField;
	import javax.swing.LayoutStyle.ComponentPlacement;

	import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import java.awt.SystemColor;
import java.io.FileNotFoundException;

public class WinndowPassword2 extends Login{

		static boolean user = false;//user=1(admin), user=0(user)
		static boolean fl=false;
		private JFrame frame;
		private JPasswordField passwordField;
		private JPasswordField passwordField_1;
		private JTextField textField;
		private JTextField textField_1;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						WinndowPassword2 window = new WinndowPassword2();
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
		public WinndowPassword2() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.getContentPane().setBackground(new Color(220, 220, 220));
			frame.getContentPane().setForeground(new Color(0, 102, 204));
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			JLabel lblWelcome = new JLabel("WELCOME!");
			lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblWelcome.setForeground(new Color(0, 0, 128));
			
			JSplitPane splitPane = new JSplitPane();
			
			JButton btnEnter = new JButton("Enter");
			btnEnter.setForeground(new Color(0, 0, 128));
			btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 14));
			btnEnter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					
						if(authenticate1(getUsername(), getPassword()))
						{
							user = false;
							fl=true;
							frame.dispose();
							
						}
						if(authenticate2(getAdminname(), getAdminPassword()))
						{
							user = true;
							fl=true;
							frame.dispose();
							
						}
						System.out.println(user);

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
						try {
							MainWindow window = new MainWindow();
							window.frame.setVisible(true);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(70, 130, 180));
			
			JLabel lblUser = new JLabel("user:");
			lblUser.setForeground(Color.CYAN);
			lblUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(70, 130, 180));
			
			JLabel lblAdmin = new JLabel("admin:");
			lblAdmin.setForeground(Color.CYAN);
			lblAdmin.setFont(new Font("Tahoma", Font.PLAIN, 13));
			
			JLabel lblName = new JLabel("name:");
			lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			JLabel lblPassword = new JLabel("password:");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			JLabel label = new JLabel("name:");
			label.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			JLabel label_1 = new JLabel("password:");
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			GroupLayout gl_panel_2 = new GroupLayout(panel_2);
			gl_panel_2.setHorizontalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGap(0, 56, Short.MAX_VALUE)
			);
			gl_panel_2.setVerticalGroup(
				gl_panel_2.createParallelGroup(Alignment.LEADING)
					.addGap(0, 35, Short.MAX_VALUE)
			);
			panel_2.setLayout(gl_panel_2);
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(10)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addComponent(lblUser, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblName)
							.addComponent(lblPassword)
							.addComponent(lblAdmin, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addComponent(label)
							.addComponent(label_1)))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addGap(9)
						.addComponent(lblUser)
						.addGap(6)
						.addComponent(lblName)
						.addGap(7)
						.addComponent(lblPassword)
						.addGap(6)
						.addComponent(lblAdmin)
						.addGap(6)
						.addComponent(label)
						.addGap(6)
						.addComponent(label_1))
			);
			panel.setLayout(gl_panel);
			GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
						.addGap(177)
						.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(257, Short.MAX_VALUE))
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(76)
								.addComponent(btnEnter, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblWelcome, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
						.addComponent(btnEnter)
						.addContainerGap())
			);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(70, 130, 180));
			splitPane.setLeftComponent(panel_1);
			
			passwordField = new JPasswordField();
			passwordField.setBackground(new Color(250, 240, 230));
			
			passwordField_1 = new JPasswordField();
			passwordField_1.setBackground(new Color(250, 240, 230));
		
			JPanel panel_5 = new JPanel();
			panel_5.setBackground(Color.CYAN);
			
			textField = new JTextField();
			textField.setColumns(10);
			
			JLabel lblInformation = new JLabel("Information");
			lblInformation.setForeground(new Color(0, 0, 128));
			lblInformation.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			JLabel lblSystem = new JLabel("system");
			lblSystem.setForeground(new Color(0, 0, 128));
			lblSystem.setFont(new Font("Tahoma", Font.PLAIN, 14));
			
			JLabel lblFilms = new JLabel("FILMS");
			lblFilms.setForeground(new Color(0, 0, 128));
			lblFilms.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GroupLayout gl_panel_5 = new GroupLayout(panel_5);
			gl_panel_5.setHorizontalGroup(
				gl_panel_5.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel_5.createSequentialGroup()
						.addContainerGap(29, Short.MAX_VALUE)
						.addGroup(gl_panel_5.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblInformation)
							.addComponent(lblFilms)
							.addComponent(lblSystem))
						.addGap(19))
			);
			gl_panel_5.setVerticalGroup(
				gl_panel_5.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_5.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblInformation, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblSystem)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblFilms)
						.addContainerGap(14, Short.MAX_VALUE))
			);
			panel_5.setLayout(gl_panel_5);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGap(20)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
							.addComponent(passwordField)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(2)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addComponent(passwordField_1))))
						.addGap(37)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(23)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(5)
								.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addContainerGap()
								.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)))
						.addContainerGap())
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
