package design;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Toolkit;
public class SearchDialog extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JDialog dialog;
	private JTable GaTable;
	private JTextField tfFindstr;
	MainFrame mf; //하람추가

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SearchDialog dialog = new SearchDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SearchDialog() {
		getContentPane().setFont(new Font("페이북 Medium", Font.PLAIN, 14));
		setFont(new Font("페이북 Bold", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/icons8-dining-room-40.png"));
		setTitle("\uC74C\uC2DD\uC810\uAC80\uC0C9");
		setBounds(100, 100, 504, 504);
		getContentPane().setLayout(null);
		contentPanel.setFont(new Font("페이북 Light", Font.PLAIN, 14));
		contentPanel.setBackground(mf.base);
		contentPanel.setBounds(0, 0, 484, 428);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JButton btnNewButton = new JButton("\uAC80 \uC0C9");
			btnNewButton.setFont(new Font("페이북 Bold", Font.PLAIN, 14));
			btnNewButton.setBackground(mf.Bgreen);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MemberController mc = new MemberController();
					String findStr = tfFindstr.getText();
					List<Member> list = mc.search(findStr);
					
					DefaultTableModel model = 
						(DefaultTableModel) GaTable.getModel();
					model.setRowCount(0);//기존 표시된 데이터를 모두 삭제
					
					for(int i=0; i<list.size(); i++) {
						Member m = list.get(i); //리스트 생성시 수정 72~73
						String[] data = {m.getName(), m.getMenu(), m.getStar(), m.getCategory(), m.getPrice()};
						model.addRow(data);
					}
				}
			});
			btnNewButton.setBounds(334, 51, 111, 33);
			contentPanel.add(btnNewButton);
		}
		{
			JLabel lblNewLabel = new JLabel("\uC74C\uC2DD\uC810\uBA85\uC744 \uAC80\uC0C9\uD574\uC8FC\uC138\uC694");
			lblNewLabel.setFont(new Font("페이북 Medium", Font.PLAIN, 17));
			lblNewLabel.setBounds(147, 10, 193, 31);
			contentPanel.add(lblNewLabel);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setFont(new Font("페이북 Medium", Font.PLAIN, 14));
			scrollPane.setBackground(mf.Bwhite);
			scrollPane.setBounds(30, 94, 424, 285);
			contentPanel.add(scrollPane);
			{
				String header[] = {"음식점명","메뉴","평점","분류","가격대"};
				DefaultTableModel model = new DefaultTableModel(header,0);
				GaTable = new JTable(model);
				GaTable.setGridColor(mf.red);
				GaTable.setBackground(mf.base);
				GaTable.setFont(new Font("페이북 Light", Font.PLAIN, 14));
				scrollPane.setViewportView(GaTable);
			}
			contentPanel.add(getTfFindstr());


			{
				JPanel buttonPane = new JPanel();
				buttonPane.setBackground(mf.Pgreen);
				buttonPane.setBounds(0, 428, 484, 33);
				getContentPane().add(buttonPane);
				buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				{
					JButton okButton = new JButton("\uC870\uD68C");
					okButton.setFont(new Font("페이북 Bold", Font.PLAIN, 12));
					okButton.setBackground(mf.BBgreen);
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
							SearchDialog.this.setVisible(false);
						}
					});
					{
						JLabel blank = new JLabel("                 ");
						buttonPane.add(blank);
					}
					cancelButton.setActionCommand("Cancel");
					buttonPane.add(cancelButton);
				}
			}
		}
	}
	public JTextField getTfFindstr() {
		if (tfFindstr == null) {
			tfFindstr = new JTextField();
			tfFindstr.setFont(new Font("페이북 Medium", Font.PLAIN, 14));
			tfFindstr.setBounds(32, 54, 279, 27);
			tfFindstr.setColumns(10);
		}
		return tfFindstr;
	}

}
