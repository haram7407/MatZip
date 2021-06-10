package design;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Cursor;
import java.awt.Toolkit;

public class AppendDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfName;
	private JTextField tfMenu;
	private JTextField tfPrice;
	private JLabel lblNewLabel_1_2_1;
	private JComboBox star;
	ArrayList<String> data =new ArrayList<String>();
	static public MainFrame mf;

	/**
	 * Launch the application.
	 */
	int aaa = 0;
	private JLabel picLabel;
	private JLabel blank;
	public static void main(String[] args) {
		try {
			AppendDialog dialog = new AppendDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AppendDialog() {
		setFont(new Font("페이북 Bold", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/icons8-dining-room-40.png"));
		setBackground(new Color(255, 255, 255));
		setTitle("\uC74C\uC2DD\uC810\uCD94\uAC00");
		setBounds(100, 100, 426, 384);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(mf.base);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("\uB9DB\uC9D1\uC774\uB984");
			lblNewLabel_1.setFont(new Font("페이북 Medium", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(12, 24, 67, 18);
			contentPanel.add(lblNewLabel_1);
		}
		
		tfName = new JTextField();
		tfName.setFont(new Font("페이북 Light", Font.PLAIN, 14));
		tfName.setBounds(91, 20, 175, 28);
		contentPanel.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uBA54\uB274\uBD84\uB958");
		lblNewLabel_1.setFont(new Font("페이북 Medium", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 74, 67, 18);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uB300\uD45C\uBA54\uB274");
		lblNewLabel_1_1.setFont(new Font("페이북 Medium", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(12, 124, 67, 18);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uAC00\uACA9\uB300");
		lblNewLabel_1_2.setFont(new Font("페이북 Medium", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(12, 174, 67, 18);
		contentPanel.add(lblNewLabel_1_2);
		
		JComboBox category = new JComboBox();
		category.setFont(new Font("페이북 Light", Font.PLAIN, 14));
		category.setBackground(new Color(255,255,255));
		category.setEditable(true);
		category.addItem("한식");
		category.addItem("양식");
		category.addItem("분식");
		category.addItem("일식");
		category.addItem("중식");
		category.addItem("페스트푸드");
		category.addItem("카페");
		category.addItem("기타");
		category.setBounds(91, 70, 175, 28);
		contentPanel.add(category);
		
		tfMenu = new JTextField();
		tfMenu.setFont(new Font("페이북 Light", Font.PLAIN, 14));
		tfMenu.setColumns(10);
		tfMenu.setBounds(91, 120, 175, 28);
		contentPanel.add(tfMenu);
		
		tfPrice = new JTextField();
		tfPrice.setFont(new Font("페이북 Light", Font.PLAIN, 14));
		tfPrice.setColumns(10);
		tfPrice.setBounds(91, 170, 175, 28);
		contentPanel.add(tfPrice);
		contentPanel.add(getLblNewLabel_1_2_1());
		contentPanel.add(getStar());
		contentPanel.add(getPicLabel());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(mf.Pgreen);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\uCD94\uAC00");
				okButton.setFont(new Font("페이북 Bold", Font.PLAIN, 12));
				okButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				okButton.setBackground(mf.BBgreen);
				/**재원,지용*/
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

				          String mName = tfName.getText();
		                  String mMenu = tfMenu.getText();
		                  String mPrice= tfPrice.getText();
		                  String mCategory = (String) category.getSelectedItem();
		                  String mStar = (String) star.getSelectedItem();
		                  
		                  if((mName.length() == 0)||(mMenu.length() == 0)||(mPrice.length() == 0)) {//하람추가
		                	  
		                	  JOptionPane.showMessageDialog(AppendDialog.this, "빈칸을 채워주세요."); //하람추가
		                	  
		                  }else {
			                  
		                	  Member m = new Member(mName, mMenu, mStar, mCategory, mPrice);
			                  MemberController mc = new MemberController();
			                  String msg = mc.append(m);
			                  mf.date = tfName.getText(); // 조회를 하기 위해서
			                  mf.aaa = 1;
			                  mf.color = (String) star.getSelectedItem();
			                  
			                  JOptionPane.showMessageDialog(AppendDialog.this, msg); //하람추가
			                  dispose();
			                  tfName.setText(null);//하람추가
			                  tfMenu.setText(null);
			                  tfPrice.setText(null);
			                  category.setSelectedIndex(0);
			                  star.setSelectedIndex(0);
		                  }
		                  
					}
				});
				buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				buttonPane.add(okButton);
			}
			{
				JButton cancelButton = new JButton("\uB2EB\uAE30");
				cancelButton.setFont(new Font("페이북 Bold", Font.PLAIN, 12));
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.setBackground(mf.BBgreen);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AppendDialog.this.dispose();
		                  tfName.setText(null);//하람추가
		                  tfMenu.setText(null);
		                  tfPrice.setText(null);
		                  category.setSelectedIndex(0);
		                  star.setSelectedIndex(0);
					}
				});
				buttonPane.add(getBlank());
				buttonPane.add(cancelButton);
			}
		}
	}
	public JLabel getLblNewLabel_1_2_1() {
		if (lblNewLabel_1_2_1 == null) {
			lblNewLabel_1_2_1 = new JLabel("\uC810\uC218");
			lblNewLabel_1_2_1.setFont(new Font("페이북 Medium", Font.PLAIN, 15));
			lblNewLabel_1_2_1.setBounds(12, 227, 67, 18);
		}
		return lblNewLabel_1_2_1;
	}
	public JComboBox getStar() {
		if (star == null) {
			star = new JComboBox();
			star.setFont(new Font("페이북 Light", Font.PLAIN, 14));
			star.setBackground(new Color(255,255,255));
			star.addItem("1성");
			star.addItem("2성");
			star.addItem("3성");
			star.setBounds(91, 222, 175, 28);
		}
		return star;
	}
	public JLabel getPicLabel() {
		if (picLabel == null) {
			picLabel = new JLabel("");
			picLabel.setHorizontalAlignment(SwingConstants.CENTER);
			picLabel.setIcon(new ImageIcon("image/icons8-meal-96.png"));
			picLabel.setBounds(302, 20, 96, 96);
		}
		return picLabel;
	}
	public JLabel getBlank() {
		if (blank == null) {
			blank = new JLabel("               ");
		}
		return blank;
	}
}
