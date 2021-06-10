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
	
	/**재원*/
	int i =0;
	static int[] ButtonInt = new int[100];
	/**재원*/
	
	ArrayList<String> address =new ArrayList<String>();
	
	public PlacePanel() {
		setBackground(new Color(255,0,0,0));
		setSize(new Dimension(900, 900));
		setLayout(null);
		
		btn1 = new JButton(); //김밥천국 -1점짜리
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String findStr = mf.date;
				Member m = mc.selectOne(findStr);
				 String mName = m.getName();
			      String mMenu = m.getMenu();
			      String mPrice = m.getPrice();
			      String mStar = m.getStar();
				 MatZipDialog mzDia = new MatZipDialog(mName,mMenu,mPrice,mStar); //조회dialog
				mzDia.setVisible(true); // 조회dialog 보이기
			}
		});
		btn1.setBackground(new Color(169, 169, 169));
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn1.setBounds(472, 461, 15, 15);
		add(btn1);
		
		btn2 = new JButton(); // 컨트리맨즈- 3점짜리
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String findStr = mf.date;
				Member m = mc.selectOne(findStr);
				 String mName = m.getName();
			      String mMenu = m.getMenu();
			      String mPrice = m.getPrice();
			      String mStar = m.getStar();
					MatZipDialog mzDia = new MatZipDialog(mName,mMenu,mPrice,mStar); //조회dialog
				mzDia.setVisible(true); //조회dialog 보이기
			}
		});
		btn2.setBackground(new Color(255, 215, 0));
		btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn2.setName("\uCEE8\uD2B8\uB9AC\uB9E8\uC988 \uC885\uB85C\uC810");
		btn2.setBounds(563, 366, 15, 15);
		add(btn2);
		
		btn3 = new JButton(); // 한스델리 - 2점짜리
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String findStr = mf.date;
				Member m = mc.selectOne(findStr);
				 String mName = m.getName();
			      String mMenu = m.getMenu();
			      String mPrice = m.getPrice();
			      String mStar = m.getStar();
					MatZipDialog mzDia = new MatZipDialog(mName,mMenu,mPrice,mStar); //조회dialog
				mzDia.setVisible(true); //조회dialog 보이기
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
	
	/**재원*/
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
							MatZipDialog mzDia = new MatZipDialog(mName,mMenu,mPrice,mStar); //조회dialog

							mzDia.setVisible(true);
						}
						}

					}
				});
				
				if(mf.color == "1성") {
					Butt.setBackground(new Color(169, 169, 169));
				}else if(mf.color == "2성") {
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
	/**재원*/

	
	/**영민*/
	public void paintComponent(Graphics g) {
		// 컴포넌트 드로우 시 이 메서드를 실행하는데, 오버라이딩하여 사용
		String path = System.getProperty("user.dir") + "\\image\\지도900.jpg";
		// System.getProperty("user.dir") 현재 폴더 위치 얻어옴
		// 파일 위치를 얻어옴 / 추후 컴퓨터마다 위치가 달라질 수 있어 이 코드를 사용함
		// C:\Users\dudal\eclipse-workspace\src\지도900.jpg
		try {
			g.drawImage(ImageIO.read(new File(path)).getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH), 0,
					0, 900, 900, null);
			// ImageIo.read > 이미지파일 불러옴
			// .getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)
			// Image.SCALE_SMOOTH 이미지 부드럽게 조정하는 옵션
			// 현재 컴포넌트 크기에 맞춰서 이미지 크기 리사이징
			// g.drawImage(Image, x, y, Width, Height)
			// Image 이미지 파일
			// x 시작 x축 위치
			// y 시작 y축 위치
			// Width 가로츠기 - getWidth() 현재 컴포넌트의 가로크기 불러옴
			// Height 세로크기 - getHeight() 현재 컴포넌트의 세로크기 불러옴
		} catch (IOException e) {
			// IOException 파일 로딩 시 오류가 나오면 이 캐치문으로 들어옴
			e.printStackTrace();
		}
	}
	/**영민*/
	
	public void save(ArrayList<String> data) {
		try {
			System.out.println("출력");
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
