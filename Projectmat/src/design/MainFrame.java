package design;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Button;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.JRadioButtonMenuItem;
import java.awt.Window.Type;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;

public class MainFrame extends JFrame {
	/**재원*/
	static int aaa = 0;
	/**재원*/
	
	MemberController mc = new MemberController();
	private JPanel contentPane;
	static String[] arry = new String[100];
	static String rrr;
	static int xxx;
	static int yyy;
	static String color;
	static String date;
	static int xx; // 좌표받기 전용 xx
	static int yy; // 좌표받기전용 yy
	AppendDialog ad = new AppendDialog();
	public static List<Member> members = new ArrayList<Member>();

	/**영민- 이하 수정*/
	private JMenu mnNewMenu;
	private JCheckBoxMenuItem chckbxmntmNewCheckItem, chckbxmntmNewCheckItem_2, chckbxmntmNewCheckItem_1;
	static PlacePanel lunchIcon;
	// 메서드 내부에 객체를 선언하면 외부메서드에서 불러올수 없기에 클래스 내부에 다시 선언

	public static Color color1 = new Color(255, 215, 0);
	public static Color color2 = new Color(255, 160, 122);
	public static Color color3 = new Color(169, 169, 169);
	// 타 객체에서 비교해서 사용하기 위해 색을 뽑아서 저장
	// static = 정적 저장 / 메모리에 직접 저장해서 그걸 바로 가져오는 형식 C언어의 포인터같은 개념
	/**영민*/
	
	/**하람*/
	private JButton btnXY;
	public static Color Bwhite = new Color(254,254,254);
	public static Color base = new Color(255,255,242);
	public static Color text = new Color(0,0,0);
	public static Color red = new Color(255,66,66);
	public static Color Pgreen = new Color(212,238,94);
	public static Color Bgreen = new Color(225,237,185);
	public static Color BBgreen = new Color(244,250,210);
	public static Color carrot = new Color(232,156,99);
	public static Color gray = new Color(240,242,235);
	private JLabel blank;
	/**하람*/

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * 토글버튼-> J버튼으로 변경
	 */

	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/icons8-dining-room-40.png"));
		setBackground(Bwhite);
		setResizable(false);
		setTitle("\uC5D0\uC774\uCF58\uC758\uBBFC\uC871");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(916, 987);
		setLocationRelativeTo(null);
		// 화면 가운데 위치

		JMenuBar menuBar = new JMenuBar();
		menuBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		menuBar.setBackground(Bwhite);
		menuBar.setAutoscrolls(true);
		setJMenuBar(menuBar);
		//mc.run();

		JButton btnAppend = new JButton();
		btnAppend.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAppend.setText("                                                   ");
		btnAppend.setBorder(new LineBorder(BBgreen, 5, true));
		btnAppend.setIconTextGap(8);
		btnAppend.setIcon(new ImageIcon("image/icons8-map-editing-40.png"));
		btnAppend.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAppend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ad.isVisible()==false) {// ***********************하람추가
					ad.setVisible(true);// ***********************하람추가
				}// ***********************하람추가
				addMouseListener(new MouseAdapter()// 좌표 받기
						{
							@Override
							public void mouseClicked(MouseEvent e)
							{	
								
								lunchIcon.ccc((e.getX()-10),(e.getY()-62));
								aaa = 0;

							}

						});
				lunchIcon.updateUI();
			}
		});
		btnAppend.setForeground(text);
		btnAppend.setBackground(base);
		btnAppend.setOpaque(true);
		btnAppend.setMargin(new Insets(0, 0, 0, 0));
		btnAppend.setBounds(new Rectangle(0, 0, 50, 0));
		menuBar.add(btnAppend);

		JButton btnUpdate = new JButton();
		btnUpdate.setBorder(new LineBorder(BBgreen, 5, true));
		btnUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
		btnUpdate.setBounds(new Rectangle(0, 0, 50, 0));
		UpdateDialog ud = new UpdateDialog();
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ud.isVisible()==false) {// ***********************하람추가
					ud.setVisible(true);// ***********************하람추가
				}// ***********************하람추가
			}
		});
		menuBar.add(getBlank());
		btnUpdate.setIconTextGap(8);
		btnUpdate.setIcon(new ImageIcon("image/icons8-location-update-40.png"));
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setBackground(base);
		btnUpdate.setText("                                                   ");
		btnUpdate.setMargin(new Insets(0, 0, 0, 0));
		menuBar.add(btnUpdate);

		JButton btnSearch = new JButton();
		btnSearch.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSearch.setBorder(new LineBorder(BBgreen, 5, true));
		btnSearch.setBounds(new Rectangle(0, 0, 50, 0));
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setIcon(new ImageIcon("image/search.png"));
		btnSearch.setBackground(base);
		btnSearch.setText("                                                   ");
		SearchDialog sd = new SearchDialog();// ***********************하람추가
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(sd.isVisible()==false) {// ***********************하람추가
					sd.setVisible(true);// ***********************하람추가
				}// ***********************하람추가
			}
		});
		
		JLabel blank2 = new JLabel("                ");
		blank2.setHorizontalTextPosition(SwingConstants.CENTER);
		blank2.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(blank2);

		btnSearch.setMargin(new Insets(0, 0, 0, 0));
		btnSearch.setIconTextGap(8);
		menuBar.add(btnSearch);
		
		JLabel blank3 = new JLabel("                ");
		blank3.setHorizontalTextPosition(SwingConstants.CENTER);
		blank3.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(blank3);
		menuBar.add(getBtnXY());
		
		JLabel blank4 = new JLabel("                ");
		blank4.setHorizontalTextPosition(SwingConstants.CENTER);
		blank4.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(blank4);

		mnNewMenu = new JMenu("");
		mnNewMenu.setIconTextGap(8);
		mnNewMenu.setBorderPainted(true);
		mnNewMenu.setIcon(new ImageIcon("image/icons8-filter-40 (1).png"));
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu.setMargin(new Insets(0, 30, 0, 30));
		mnNewMenu.setHorizontalTextPosition(SwingConstants.LEADING);
		mnNewMenu.setMultiClickThreshhold(2000L);
		menuBar.add(mnNewMenu);

		chckbxmntmNewCheckItem = new JCheckBoxMenuItem("\u2605\u2605\u2605");
		chckbxmntmNewCheckItem.setIconTextGap(0);
		chckbxmntmNewCheckItem.setMargin(new Insets(0, 0, 0, 0));
		chckbxmntmNewCheckItem.setBackground(color1);
		chckbxmntmNewCheckItem.setOpaque(true);
		chckbxmntmNewCheckItem.setSelected(true);
		mnNewMenu.add(chckbxmntmNewCheckItem);


		/**영민*/
		chckbxmntmNewCheckItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshPanel();
			}
		});
		//각각 액션리스너 추가
		// 액션리스너 > 마우스로 클릭시 이벤트 발생 > 내부 코드 실행
		/**영민*/

		chckbxmntmNewCheckItem_2 = new JCheckBoxMenuItem("\u2605\u2605");
		chckbxmntmNewCheckItem_2.setIconTextGap(0);
		chckbxmntmNewCheckItem_2.setMargin(new Insets(0, 0, 0, 0));
		chckbxmntmNewCheckItem_2.setOpaque(true);
		chckbxmntmNewCheckItem_2.setBackground(color2);
		chckbxmntmNewCheckItem_2.setSelected(true);
		mnNewMenu.add(chckbxmntmNewCheckItem_2);


		/**영민*/
		chckbxmntmNewCheckItem_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshPanel();
			}
		});
		/**영민*/

		chckbxmntmNewCheckItem_1 = new JCheckBoxMenuItem("\u2605");
		chckbxmntmNewCheckItem_1.setIconTextGap(0);
		chckbxmntmNewCheckItem_1.setMargin(new Insets(0, 0, 0, 0));
		chckbxmntmNewCheckItem_1.setOpaque(true);
		chckbxmntmNewCheckItem_1.setBackground(color3);
		chckbxmntmNewCheckItem_1.setSelected(true);
		mnNewMenu.add(chckbxmntmNewCheckItem_1);


		/**영민*/
		chckbxmntmNewCheckItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				refreshPanel();
			}
		});
		/**영민*/


		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lunchIcon = new PlacePanel();// 음식점버튼만 모아져있는 패널
		lunchIcon.setLocation(0, 0);
		contentPane.add(lunchIcon); //이미지위에 버튼을 올릴시 프로그램 업데이트때마다 버튼이 이미지때문에 가려질 수 있음

		JLabel lengthImgLabel = new JLabel(); // 지도 아래 단위 보여주기용 이미지
		lengthImgLabel.setBounds(799, 875, 101, 15);
		lunchIcon.add(lengthImgLabel);
		lengthImgLabel.setBorder(new LineBorder(new Color(128, 128, 128)));
		lengthImgLabel.setIcon(new ImageIcon("image/경로.jpg"));
		lengthImgLabel.setIconTextGap(0);

		JLabel imgLabel = new JLabel(); // 지도 이미지
		imgLabel.setIconTextGap(0);
		imgLabel.setBounds(0, 0, 900, 900);
		imgLabel.setIcon(new ImageIcon("image/지도900.jpg"));
		contentPane.add(imgLabel);


		/**영민*/
		///////////////////////////////////
		refreshPanel();
		///////////////////////////////////
	}

	private void refreshPanel() {
		// 이 메서드는 체크된 메뉴를 비교해서 체크되어 있다면 해당 점포를 보이지 않게 하는 기능을 구현했다.
		JCheckBoxMenuItem[] list = { chckbxmntmNewCheckItem, chckbxmntmNewCheckItem_2, chckbxmntmNewCheckItem_1 };
		// 반복문을 사용하기 위해 각 개체를 배열로 다시 저장
		// 객체지향의 약한참조 기능 사용
		for (Component comp : lunchIcon.getComponents()) {
			// Component JAVA Swing의 최상위 개체
			// lunchIcon의 컴포넌트를 불러와서 반복문을 사용
			// 타언어의 For each문과 같은 역할
			if (comp instanceof JButton) {
				// 컴포넌트가 JButton과 같을 시
				((JButton) comp).setVisible(true);
				// 일단 전체적으로 보이게 설정하고 아래 조건과 맞지않으면 보이지 않게한다.
				for (int i = 0; i < list.length; i++) {
					if (!list[i].isSelected() && list[i].getBackground().equals(((JButton) comp).getBackground())) {
						// list[i].isSelected() list[i]가 선택됐으면
						// list[i].getBackground().equals(((JButton) comp).getBackground()) >
						// list[i].getBackground()  list[i]의 배경색을 가져옴
						// ((JButton) comp).getBackground() 반복문 돌리고 있는 lunchIcon의 컴포넌트의 배경색을 가져옴
						// .equals 왼쪽의 객체와, 괄호안의 개체가 같으면 True, 아니면 False
						((JButton) comp).setVisible(false);
						// 그래서 하나라도 배경색이 같은 체크박스가 체크되어있으면 보이지 않는다.
					}
				}
			}
		}

		lunchIcon.revalidate();
		lunchIcon.repaint();
		// setVisible 사용 시 보이지 않는다고 설정이 되지만
		// 사용자 화면에는 띄워져있어 다시 컴포넌트를 재구성 하는 명령어
	}
	public JButton getBtnXY() {
		if (btnXY == null) {
			btnXY = new JButton();
			btnXY.setBorder(new LineBorder(BBgreen, 5, true));
			btnXY.setHorizontalTextPosition(SwingConstants.CENTER);
			btnXY.setText("                                                   ");
			btnXY.setBounds(new Rectangle(0, 0, 50, 0));
			btnXY.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btnXY.setIconTextGap(8);
			btnXY.setIcon(new ImageIcon("image/icons8-address-40.png"));
			btnXY.setBackground(base); // ***********************하람추가
			XYDialog xy = new XYDialog();// ***********************하람추가
			btnXY.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(xy.isVisible()==false) {// ***********************하람추가
						xy.setVisible(true);
					}// ***********************하람추가
						addMouseListener(new MouseAdapter()// 좌표 받기
								{

							@Override
							public void mouseClicked(MouseEvent e)
							{	
								
								lunchIcon.ccc((e.getX()-10),(e.getY()-62));
								
								
								xx  = (e.getX()-10);
								yy = (e.getY()-62);
								xy.xxyy(xx,yy);
								contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
							}
								});
				}
			});
			btnXY.setMargin(new Insets(0, 0, 0, 0));
		}
		return btnXY;
	}
	public JLabel getBlank() {
		if (blank == null) {
			blank = new JLabel("                ");
			blank.setHorizontalTextPosition(SwingConstants.CENTER);
			blank.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return blank;
	}
	}

