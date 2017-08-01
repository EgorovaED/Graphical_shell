import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.util.Arrays;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.List;


public class MainWindow extends JFrame{

	static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JList list1;
	private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel l5;
    private JButton image;
    private ImageIcon icon;
	protected int del;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 * @throws FileNotFoundException 
	 */
	public MainWindow() throws FileNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize() throws FileNotFoundException {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FileWork.read(Books.fileName);
		JLabel lblFavoriteBooks = new JLabel("Favorite books");
		
		JSplitPane splitPane = new JSplitPane();
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
		 icon = new ImageIcon(((Books)FileWork.vPoints.elementAt(0)).getName()+ ".jpg");
         
	        Image im = icon.getImage();
	        im = im.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	        icon.setImage(im);
	       
	        image = new JButton(icon); 
	        
	        image.setPreferredSize(new Dimension(200,300));
		JPanel panel_1 = new JPanel();
		
		JButton btnDelete = new JButton("Delete");
		
		
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		JButton btnAdd = new JButton("Add:");
		btnAdd.addActionListener(new ActionListener() {			 
            public void actionPerformed(ActionEvent e) {
            	if(WinndowPassword2.user)
            	{
            		String name, autor, year, mainCh, description;
        			name = textField.getText();
        			autor =	textField_1.getText();	
        			year = textField_2.getText();
        			mainCh = textField_3.getText();
        			description = textField_4.getText();
        			//int b = Integer.parseInt(year);
        			Books a = new Books(name, autor,year ,mainCh ,description );
        			FileWork.update(Books.fileName, a); 			
        			FileWork.vPoints.clear();
        			MainWindow.frame.dispose();
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
            	else
            	{
            		EventQueue.invokeLater(new Runnable() {
        				public void run() {
        					try {
        						WRUser window = new WRUser();
        						window.frame.setVisible(true);
        					} catch (Exception e) {
        						e.printStackTrace();
        					}
        				}
        			});
            	}
            
		}
		});
		
		
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblAuthor = new JLabel("Author:");
		
		JLabel lblYear = new JLabel("Year:");
		
		JLabel lblMainCharecter = new JLabel("Main Charecter:");
		
		JLabel lblDescriptin = new JLabel("Descriptin:");
		
		l1 = new JLabel("Name");
		
		l2 = new JLabel("Autor");
		
		l3 = new JLabel("Year");
		
		l4 = new JLabel("Gharecret");
		
		l5 = new JLabel("Discription");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblDescriptin)
							.addGap(44))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblYear)
								.addComponent(lblMainCharecter))
							.addGap(18))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName)
								.addComponent(lblAuthor))
							.addGap(60)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAdd)
						.addComponent(textField_4)
						.addComponent(textField_3)
						.addComponent(textField_2)
						.addComponent(textField_1)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
					.addGap(89)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(l5)
							.addContainerGap())
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(l4, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(l3)
									.addContainerGap())
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(l1)
										.addContainerGap())
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(l2)
											.addContainerGap())
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
											.addGap(94))))))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(16)
					.addComponent(l1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(l2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(l3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(l4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(l5)
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(btnDelete)
							.addGap(27)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(10))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblName)
							.addGap(18)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblAuthor)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblYear)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMainCharecter))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDescriptin)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnAdd)
					.addContainerGap(250, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		
		
		JLabel lblBooks = new JLabel("Books:");
		
		JPanel panel_2 = new JPanel();
				
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(21)
							.addComponent(lblBooks))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(image, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
					.addGap(23))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(image, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
					.addGap(23)
					.addComponent(lblBooks)
					.addGap(18)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(230, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE))
		);
		
		String[] namesF = new String[FileWork.vPoints.size()];
	    for(int i=0;i<FileWork.vPoints.size();i++)
		{
	    	namesF[i]=((Books)FileWork.vPoints.get(i)).getName();
	    	System.out.println(namesF[i]);
		}
	    list1 = new JList(namesF);
	    
		JScrollPane li = new JScrollPane(list1);
		li.setPreferredSize(new Dimension(100,200));
		
		list1.addListSelectionListener( new ListSelectionListener() {
			
			int del;
			public void valueChanged(ListSelectionEvent arg0) {
				int returns[] = ((JList<?>)arg0.getSource()).getSelectedIndices();
			       del=returns[0];
			    		   String toString = Arrays.toString(returns);
			        Books el = (Books)FileWork.vPoints.elementAt(returns[0]);
			            icon = new ImageIcon(el.getName()+".jpg");
			            
			            
			            Image im = icon.getImage();
			            im = im.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			            icon.setImage(im);
			            Books.number=del;
			            
			            image.setIcon(icon);
			            l1.setText(((Books)FileWork.vPoints.elementAt(returns[0])).getName());
			            l2.setText(((Books)FileWork.vPoints.elementAt(returns[0])).getAuthor());
			            l3.setText(((Books)FileWork.vPoints.elementAt(returns[0])).getYear());
			            l4.setText(((Books)FileWork.vPoints.elementAt(returns[0])).getMainCharacter());
			            l5.setText(((Books)FileWork.vPoints.elementAt(returns[0])).getDescription());
				
			}
      });
		
		btnDelete.addActionListener(new ActionListener() {			 
            public void actionPerformed(ActionEvent e) {
            	if(WinndowPassword2.user)
            	{            	
            		try {
						FileWork.DeletEl(Books.number);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        			FileWork.vPoints.clear();
        			MainWindow.frame.dispose();
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
            	else
            	{
            		EventQueue.invokeLater(new Runnable() {
        				public void run() {
        					try {
        						WRUser window = new WRUser();
        						window.frame.setVisible(true);
        					} catch (Exception e) {
        						e.printStackTrace();
        					}
        				}
        			});
            	}
            
		}
		});
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(li, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(li, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		panel.setLayout(gl_panel);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(246, Short.MAX_VALUE)
					.addComponent(lblFavoriteBooks, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addGap(205))
				.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, 534, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblFavoriteBooks)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(splitPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
