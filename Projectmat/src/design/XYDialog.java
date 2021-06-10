package design;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;

public class XYDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextField tfX;
	private JLabel lblY;
	private JTextField tfY;
	MainFrame mf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			XYDialog dialog = new XYDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public XYDialog() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/icons8-dining-room-40.png"));
		setTitle("\uC88C\uD45C\uC0DD\uC131");
		setBounds(100, 100, 225, 205);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(mf.base);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getTfX());
		contentPanel.add(getLblY());
		contentPanel.add(getTfY());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(mf.Pgreen);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("\uB2EB\uAE30");
				okButton.setFont(new Font("其捞合 Bold", Font.PLAIN, 12));
				okButton.setBackground(mf.BBgreen);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						XYDialog.this.setVisible(false);
						tfX.setText(null);//x,y蔼 昏力
						tfY.setText(null);
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("X");
			lblNewLabel.setFont(new Font("其捞合 Medium", Font.PLAIN, 15));
			lblNewLabel.setBounds(29, 36, 16, 15);
		}
		return lblNewLabel;
	}
	public JTextField getTfX() {
		if (tfX == null) {
			tfX = new JTextField();
			tfX.setFont(new Font("其捞合 Light", Font.PLAIN, 14));
			tfX.setBackground(mf.base);
			tfX.setEditable(false);
			tfX.setBounds(57, 33, 116, 21);
			tfX.setColumns(10);
		}
		return tfX;
	}
	public JLabel getLblY() {
		if (lblY == null) {
			lblY = new JLabel("Y");
			lblY.setFont(new Font("其捞合 Medium", Font.PLAIN, 15));
			lblY.setBounds(29, 82, 16, 15);
		}
		return lblY;
	}
	public JTextField getTfY() {
		if (tfY == null) {
			tfY = new JTextField();
			tfY.setFont(new Font("其捞合 Light", Font.PLAIN, 14));
			tfY.setBackground(mf.base);
			tfY.setEditable(false);
			tfY.setColumns(10);
			tfY.setBounds(57, 79, 116, 21);
		}
		return tfY;
	}
	public void xxyy(int x, int y) {
		String xx = Integer.toString(x);
		String yy = Integer.toString(y);


		tfY.setText(yy);
		tfX.setText(xx);
		
	}
}
