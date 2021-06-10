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
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class MatZipDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfName;
	private JTextField tfMenu;
	private JTextField tfPrice;
	private JLabel lblNewLabel_1_2_1;
	private JComboBox comboStyle_1;
	MainFrame mf;// 窍恩眠啊
	PlacePanel pp;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public MatZipDialog(String name, String mum, String kinds, String tar) {
		setFont(new Font("其捞合 Medium", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/icons8-dining-room-40.png"));
		setBackground(mf.base);
		setTitle("\uC74C\uC2DD\uC810\uC815\uBCF4");
		setBounds(100, 100, 463, 328);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(mf.base);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel picLabel = new JLabel();
		picLabel.setHorizontalAlignment(SwingConstants.CENTER);
		picLabel.setIcon(new ImageIcon("image/icons8-tableware-96.png"));
		picLabel.setBounds(318, 10, 100, 100);
		contentPanel.add(picLabel);
		{
			JLabel lblNewLabel_1 = new JLabel("\uB9DB\uC9D1\uC774\uB984");
			lblNewLabel_1.setFont(new Font("其捞合 Medium", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(12, 14, 67, 18);
			contentPanel.add(lblNewLabel_1);
		}
		
		tfName = new JTextField();
		tfName.setFont(new Font("其捞合 Light", Font.PLAIN, 14));
		tfName.setText(name);
		tfName.setBounds(91, 10, 175, 28);
		contentPanel.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\uBA54\uB274\uBD84\uB958");
		lblNewLabel_1.setFont(new Font("其捞合 Medium", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 64, 67, 18);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\uB300\uD45C\uBA54\uB274");
		lblNewLabel_1_1.setFont(new Font("其捞合 Medium", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(12, 114, 67, 18);
		contentPanel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\uAC00\uACA9\uB300");
		lblNewLabel_1_2.setFont(new Font("其捞合 Medium", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(12, 164, 67, 18);
		contentPanel.add(lblNewLabel_1_2);
		
		JComboBox category = new JComboBox();
		category.setFont(new Font("其捞合 Light", Font.PLAIN, 14));
		category.setBackground(new Color(255, 255, 255));
		category.setEditable(true);
		category.addItem("茄侥");
		category.addItem("剧侥");
		category.addItem("盒侥");
		category.addItem("老侥");
		category.addItem("吝侥");
		category.addItem("其胶飘仟靛");
		category.addItem("墨其");
		category.addItem("扁鸥");
		category.setBounds(91, 60, 175, 28);
		contentPanel.add(category);
		
		tfMenu = new JTextField();
		tfMenu.setFont(new Font("其捞合 Light", Font.PLAIN, 14));
		tfMenu.setText(mum);
		tfMenu.setColumns(10);
		tfMenu.setBounds(91, 110, 175, 28);
		contentPanel.add(tfMenu);
		
		tfPrice = new JTextField();
		tfPrice.setFont(new Font("其捞合 Light", Font.PLAIN, 14));
		tfPrice.setText(kinds);
		tfPrice.setColumns(10);
		tfPrice.setBounds(91, 160, 175, 28);
		contentPanel.add(tfPrice);
		contentPanel.add(getLblNewLabel_1_2_1());
		
		JComboBox star = new JComboBox();
		star.setFont(new Font("其捞合 Light", Font.PLAIN, 14));
		star.setEditable(true);
		star.setBackground(new Color(255, 255, 255));		
		star.addItem("1己");
		star.addItem("2己");
		star.addItem("3己");
		star.setBounds(91, 210, 175, 28);
		contentPanel.add(star);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(mf.Pgreen);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton deletebtn = new JButton("\uC0AD\uC81C");
			deletebtn.setFont(new Font("其捞合 Bold", Font.PLAIN, 12));
			deletebtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			deletebtn.setBackground(mf.BBgreen);
			deletebtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DeleteDialog dd = new DeleteDialog();
					dd.setVisible(true);
					//JOptionPane.showConfirmDialog(MatZipDialog.this, "捞 咐笼沥焊甫 昏力窍矫摆嚼聪鳖?");
				}
			});
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			buttonPane.add(deletebtn);
			{
				JButton cancelButton = new JButton("\uB2EB\uAE30");
				cancelButton.setFont(new Font("其捞合 Bold", Font.PLAIN, 12));
				cancelButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				cancelButton.setBackground(mf.BBgreen);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						MatZipDialog.this.setVisible(false);
					}
				});
				
				JLabel blank = new JLabel("                     ");
				buttonPane.add(blank);
				buttonPane.add(cancelButton);
			}
		}
	}
	public JLabel getLblNewLabel_1_2_1() {
		if (lblNewLabel_1_2_1 == null) {
			lblNewLabel_1_2_1 = new JLabel("\uD3C9\uADE0\uBCC4\uC810");
			lblNewLabel_1_2_1.setFont(new Font("其捞合 Medium", Font.PLAIN, 15));
			lblNewLabel_1_2_1.setBounds(12, 214, 67, 18);
		}
		return lblNewLabel_1_2_1;
	}
	
}
