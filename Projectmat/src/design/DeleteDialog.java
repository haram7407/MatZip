package design;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class DeleteDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	MainFrame mf;
	MatZipDialog mz;
	PlacePanel pp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DeleteDialog dialog = new DeleteDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DeleteDialog() {
		setFont(new Font("페이북 Bold", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/icons8-dining-room-40.png"));
		setBackground(mf.base);
		setTitle("\uC74C\uC2DD\uC810\uC0AD\uC81C");
		setBounds(100, 100, 324, 167);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(mf.base);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		{
			JLabel lblNewLabel_1 = new JLabel();
			lblNewLabel_1.setIcon(new ImageIcon("image/icons8-eraser-80.png"));
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel = new JLabel("\uD604 \uC74C\uC2DD\uC810\uC744 \uC0AD\uC81C\uD558\uC2DC\uACA0\uC2B5\uB2C8\uAE4C?");
			lblNewLabel.setFont(new Font("페이북 Medium", Font.PLAIN, 15));
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(mf.Pgreen);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("페이북 Bold", Font.PLAIN, 12));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {

							String str = mz.getTitle();
							System.out.println(str);
							
						JOptionPane.showMessageDialog(DeleteDialog.this, "정보가 삭제되었습니다.");
						DeleteDialog.this.dispose(); //하람수정
						mz.dispose(); //하람수정
						} catch(Exception ex) {
							ex.printStackTrace();
							JOptionPane.showMessageDialog(DeleteDialog.this, "삭제 도중 오류가 발생하였습니다.");
							DeleteDialog.this.dispose();//하람수정
							mz.dispose();//하람수정
						}
						
						
					}
				});
				okButton.setBackground(mf.BBgreen);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("페이북 Bold", Font.PLAIN, 12));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DeleteDialog.this.setVisible(false);
					}
				});
				{
					JLabel blank = new JLabel("          ");
					buttonPane.add(blank);
				}
				cancelButton.setBackground(mf.BBgreen);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
