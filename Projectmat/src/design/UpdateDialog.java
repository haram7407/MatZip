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
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.Dimension;

public class UpdateDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfName;
	private JTextField tfMenu;
	private JTextField tfPrice;
	private JSeparator separator;
	private JLabel lblNewLabel;
	private JTextField tfFindStr;
	private JButton btnSearch;
	private JLabel lblNewLabel_1_3;
	private JComboBox star;
	MainFrame mf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UpdateDialog dialog = new UpdateDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public UpdateDialog() {
		setBackground(mf.base);
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/icons8-dining-room-40.png"));
		setTitle("\uC74C\uC2DD\uC810\uC218\uC815");
		setBounds(100, 100, 426, 365);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(mf.base);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel_1 = new JLabel("\uB9DB\uC9D1\uC774\uB984");
			lblNewLabel_1.setFont(new Font("페이북 Medium", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(12, 68, 67, 18);
			contentPanel.add(lblNewLabel_1);
		}
		
		tfName = new JTextField();
		tfName.setFont(new Font("페이북 Light", Font.PLAIN, 14));
		tfName.setSelectionColor(new Color(0, 0, 0));
		tfName.setBounds(90, 63, 175, 28);
		contentPanel.add(tfName);
		tfName.setEditable(false);
		tfName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uBA54\uB274\uBD84\uB958");
		lblNewLabel_1.setFont(new Font("페이북 Medium", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 108, 67, 18);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uB300\uD45C\uBA54\uB274");
		lblNewLabel_1_1.setFont(new Font("페이북 Medium", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(12, 148, 67, 18);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uAC00\uACA9\uB300");
		lblNewLabel_1_2.setFont(new Font("페이북 Medium", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(12, 188, 67, 18);
		contentPanel.add(lblNewLabel_1_2);
		
		JComboBox category = new JComboBox();
		category.setFont(new Font("페이북 Light", Font.PLAIN, 14));
		category.setBackground(new Color(255, 255, 255));
		category.addItem("한식");
		category.addItem("양식");
		category.addItem("분식");
		category.addItem("일식");
		category.addItem("중식");
		category.addItem("페스트푸드");
		category.addItem("카페");
		category.addItem("기타");
		category.setBounds(90, 103, 175, 28);
		contentPanel.add(category);
		
		tfMenu = new JTextField();
		tfMenu.setFont(new Font("페이북 Light", Font.PLAIN, 14));
		tfMenu.setColumns(10);
		tfMenu.setBounds(90, 143, 175, 28);
		contentPanel.add(tfMenu);
		
		tfPrice = new JTextField();
		tfPrice.setFont(new Font("페이북 Light", Font.PLAIN, 14));
		tfPrice.setColumns(10);
		tfPrice.setBounds(91, 183, 175, 28);
		
		JLabel imgLabel = new JLabel();
		imgLabel.setMaximumSize(new Dimension(100, 100));
		imgLabel.setBounds(new Rectangle(0, 0, 100, 100));
		imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imgLabel.setIcon(new ImageIcon("image/icons8-tableware-96.png"));
		imgLabel.setBounds(293, 63, 100, 100);
		contentPanel.add(imgLabel);
		
		
		contentPanel.add(tfPrice);
		contentPanel.add(getSeparator());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getTfFindStr());
		contentPanel.add(getBtnSearch());
		contentPanel.add(getLblNewLabel_1_3());
		contentPanel.add(getStar());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(mf.Pgreen);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\uC218\uC815");
				okButton.setFont(new Font("페이북 Bold", Font.PLAIN, 12));
				okButton.setBackground(mf.BBgreen);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) { // 수정 버튼 클릭시
						String mName = tfName.getText();
						String mMenu = tfMenu.getText();
						String mPrice = tfPrice.getText();
						String mStar = (String) star.getSelectedItem();
						String mCategory = (String) category.getSelectedItem();
						
						 if((mName.length() == 0)||(mMenu.length() == 0)||(mPrice.length() == 0)) {//하람추가
		                	  
		                	  JOptionPane.showMessageDialog(UpdateDialog.this, "빈칸을 채워주세요."); //하람추가
		                	  
		                  }else {
						
		                	  Member m = new Member(mName,mMenu,mStar,mCategory,mPrice);
						MemberController mc = new MemberController();
						String msg = mc.update(m);
						JOptionPane.showMessageDialog(UpdateDialog.this, msg);
						 dispose();//하람추가
		                  tfName.setText(null);
		                  tfMenu.setText(null);
		                  tfPrice.setText(null);
		                  category.setSelectedIndex(0);
		                  star.setSelectedIndex(0);
		                  
		                  tfFindStr.setText(null);
		                  }
					}
				});
				buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("\uB2EB\uAE30");
				cancelButton.setFont(new Font("페이북 Bold", Font.PLAIN, 12));
				cancelButton.setBackground(mf.BBgreen);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
		                  dispose();//하람추가
		                  tfName.setText(null);
		                  tfMenu.setText(null);
		                  tfPrice.setText(null);
		                  category.setSelectedIndex(0);
		                  star.setSelectedIndex(0);
		                  
		                  tfFindStr.setText(null);
					}
				});
				{
					JLabel blank = new JLabel("                  ");
					buttonPane.add(blank);
				}
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(mf.carrot);
			separator.setBounds(12, 53, 274, 2);
		}
		return separator;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("\uC774\uB984\uAC80\uC0C9");
			lblNewLabel.setFont(new Font("페이북 Medium", Font.PLAIN, 15));
			lblNewLabel.setBounds(12, 20, 67, 18);
		}
		return lblNewLabel;
	}
	public JTextField getTfFindStr() {
		if (tfFindStr == null) {
			tfFindStr = new JTextField();
			tfFindStr.setFont(new Font("페이북 Light", Font.PLAIN, 14));
			tfFindStr.setBounds(90, 15, 175, 28);
			tfFindStr.setColumns(10);
		}
		return tfFindStr;
	}
	public JButton getBtnSearch() {
		if (btnSearch == null) {
			btnSearch = new JButton("\uAC80\uC0C9");
			btnSearch.setFont(new Font("페이북 Bold", Font.PLAIN, 14));
			btnSearch.setBackground(mf.Bgreen);
			btnSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String findStr = tfFindStr.getText();
					MemberController mc = new MemberController();
					Member m = mc.selectOne(findStr);
					if(m == null) {
						JOptionPane.showMessageDialog(UpdateDialog.this, "찾는 데이터가 없습니다.");
					}else {
						tfName.setText(m.getName());
						tfMenu.setText(m.getMenu());
						tfPrice.setText(m.getPrice());
						
					}		
				}
			});
			btnSearch.setBounds(279, 15, 80, 25);
		}
		return btnSearch;
	}
	public JLabel getLblNewLabel_1_3() {
		if (lblNewLabel_1_3 == null) {
			lblNewLabel_1_3 = new JLabel("\uC810\uC218");
			lblNewLabel_1_3.setFont(new Font("페이북 Medium", Font.PLAIN, 15));
			lblNewLabel_1_3.setBounds(12, 228, 67, 18);
		}
		return lblNewLabel_1_3;
	}
	public JComboBox getStar() {
		if (star == null) {
			star = new JComboBox();
			star.setFont(new Font("페이북 Light", Font.PLAIN, 14));
			star.setBackground(new Color(255, 255, 255));
			star.addItem("1성");
			star.addItem("2성");
			star.addItem("3성");
			star.setBounds(90, 223, 175, 28);
		}
		return star;
	}
}
