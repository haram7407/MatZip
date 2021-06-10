package design;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class PlacePanel extends JPanel {

	MainFrame mf;
	String name;
	String mum;
	String kind;
	int i1 = 0;
	MemberController mc = new MemberController();
	
	
	/**
	 * Create the panel.
	 */
	static String date1;
	private JButton btn1, btn2, btn3;
	
	/**���*/
	int i =0;
	static int[] ButtonInt = new int[100];
	/**���*/
	
	ArrayList<String> address =new ArrayList<String>();
	
	public PlacePanel() {
		setBackground(new Color(255,0,0,0));
		setSize(new Dimension(900, 900));
		setLayout(null);
		
		btn1 = new JButton(); //���õ�� -1��¥��
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String findStr = mf.date;
				Member m = mc.selectOne(findStr);
				 String mName = m.getName();
			      String mMenu = m.getMenu();
			      String mPrice = m.getPrice();
			      String mStar = m.getStar();
				 MatZipDialog mzDia = new MatZipDialog(mName,mMenu,mPrice,mStar); //��ȸdialog
				mzDia.setVisible(true); // ��ȸdialog ���̱�
			}
		});
		btn1.setBackground(new Color(169, 169, 169));
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn1.setBounds(472, 461, 15, 15);
		add(btn1);
		
		btn2 = new JButton(); // ��Ʈ������- 3��¥��
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String findStr = mf.date;
				Member m = mc.selectOne(findStr);
				 String mName = m.getName();
			      String mMenu = m.getMenu();
			      String mPrice = m.getPrice();
			      String mStar = m.getStar();
					MatZipDialog mzDia = new MatZipDialog(mName,mMenu,mPrice,mStar); //��ȸdialog
				mzDia.setVisible(true); //��ȸdialog ���̱�
			}
		});
		btn2.setBackground(new Color(255, 215, 0));
		btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn2.setName("\uCEE8\uD2B8\uB9AC\uB9E8\uC988 \uC885\uB85C\uC810");
		btn2.setBounds(563, 366, 15, 15);
		add(btn2);
		
		btn3 = new JButton(); // �ѽ����� - 2��¥��
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String findStr = mf.date;
				Member m = mc.selectOne(findStr);
				 String mName = m.getName();
			      String mMenu = m.getMenu();
			      String mPrice = m.getPrice();
			      String mStar = m.getStar();
					MatZipDialog mzDia = new MatZipDialog(mName,mMenu,mPrice,mStar); //��ȸdialog
				mzDia.setVisible(true); //��ȸdialog ���̱�
			}
		});
		btn3.setBackground(new Color(255, 160, 122));
		btn3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn3.setName("\uD55C\uC2A4\uB378\uB9AC");
		btn3.setBounds(437, 323, 15, 15);
		add(btn3);
		
		revalidate();
		repaint();


	}
	
	/**���*/
	public  JButton ccc(int x,int y) {
		if(MainFrame.aaa == 1) {
	
			mf.arry[i1] = mf.date;
			i1 = i1 +1;
				JButton Butt = new JButton();
				Butt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for(int ii = 0 ; ii < mf.arry.length; ii++) {
						if(mf.arry[ii] == mf.date) {
							Member m = mc.selectOne(mf.arry[ii]);
							 String mName = m.getName();
						      String mMenu = m.getMenu();
						      String mPrice = m.getPrice();
						      String mStar = m.getStar();
							MatZipDialog mzDia = new MatZipDialog(mName,mMenu,mPrice,mStar); //��ȸdialog

							mzDia.setVisible(true);
						}
						}

					}
				});
				
				if(mf.color == "1��") {
					Butt.setBackground(new Color(169, 169, 169));
				}else if(mf.color == "2��") {
					Butt.setBackground(new Color(255, 160, 122));
				}else {
					Butt.setBackground(new Color(255, 215, 0));
				}
				setVisible(true);
				Butt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				Butt.setBounds(x, y, 15, 15);
				
				
				
				this.add(Butt);
				
				
				updateUI();
				return Butt;


		}
		return null;
	
	}
	/**���*/

	
	/**����*/
	public void paintComponent(Graphics g) {
		// ������Ʈ ��ο� �� �� �޼��带 �����ϴµ�, �������̵��Ͽ� ���
		String path = System.getProperty("user.dir") + "\\image\\����900.jpg";
		// System.getProperty("user.dir") ���� ���� ��ġ ����
		// ���� ��ġ�� ���� / ���� ��ǻ�͸��� ��ġ�� �޶��� �� �־� �� �ڵ带 �����
		// C:\Users\dudal\eclipse-workspace\src\����900.jpg
		try {
			g.drawImage(ImageIO.read(new File(path)).getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH), 0,
					0, 900, 900, null);
			// ImageIo.read > �̹������� �ҷ���
			// .getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)
			// Image.SCALE_SMOOTH �̹��� �ε巴�� �����ϴ� �ɼ�
			// ���� ������Ʈ ũ�⿡ ���缭 �̹��� ũ�� ������¡
			// g.drawImage(Image, x, y, Width, Height)
			// Image �̹��� ����
			// x ���� x�� ��ġ
			// y ���� y�� ��ġ
			// Width �������� - getWidth() ���� ������Ʈ�� ����ũ�� �ҷ���
			// Height ����ũ�� - getHeight() ���� ������Ʈ�� ����ũ�� �ҷ���
		} catch (IOException e) {
			// IOException ���� �ε� �� ������ ������ �� ĳġ������ ����
			e.printStackTrace();
		}
	}
	/**����*/
	
	public void save(ArrayList<String> data) {
		try {
			System.out.println("���");
			String name = data.get(0);
			
			File writename = new File("address\\"+name+".txt");
			writename.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(writename,true));
			for(int i=0; i<data.size();i++) {
				out.write(data.get(i));
				out.write("\n");
			}
			out.flush();
			out.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
