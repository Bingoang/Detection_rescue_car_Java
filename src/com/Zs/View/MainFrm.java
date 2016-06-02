/*
 * MainFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.Zs.View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.sql.Connection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.Zs.DbDao.DbRecord_4ItemDao;
import com.Zs.DbDao.DbRecord_4ItemMemb;
import com.Zs.DbUtil.DbUtil;
import com.mysql.jdbc.Util;

//import com.socket.test.MyThread;

import ZS.JLable.Camera.CameraCapture.IgetBufferedImag;
import ZS.Net.CarmeraTherad;
import ZS.Net.NetThread;
import ZS.RXTX.Comm.ZS_RXTX_Test;
import ZS.RXTX.Comm.ZS_RXTX_Test.IZS_RXTX_ReceiveString;
import ZS.Util.Bgp.BackgroundPanel;
import ZS.Util.Time.TestDate;
import ZsUtil.Beep;

/**
 *
 * @author  __USER__
 */
public class MainFrm extends javax.swing.JFrame implements
		IZS_RXTX_ReceiveString, IgetBufferedImag {
	//******************报警***********************//
	public Beep beep = new Beep();
	//***********************NET ****************/
	public int linkStation = 0;// 0 断开 1 正在连接 2以连接
	private NetThread netThread = null;
	public CarmeraTherad carmeraTherad;
	//******************************************//
	private BackgroundPanel bgp;
	private ZS_RXTX_Test zS_RXTX_Test = new ZS_RXTX_Test();
	private String Port;
	private Integer ComNumber = 1;
	private static byte[] byt = { 0x10, 0x00, 0x11 };//用来发送命令！
	private ZS.JLable.Camera.CameraCapture carCameraCapture = new ZS.JLable.Camera.CameraCapture(); //声明全局变量CameraCapture，BufferedImage
	private int cameraFlag = 0;

	private String imageURL = "http://192.168.8.1:8083/?action=snapshot";
	private MyThread myThread = null;
	private boolean flagFlag = false;
	private BufferedImage image = null;

	//控制小车、小车数据传输的
	private static final long serialVersionUID = 11L;
	Socket socket;
	private static Thread thread;
	private static String HOST = "192.168.8.1";
	private static int POST = 2001;
	BufferedReader in = null;
	PrintWriter writer = null;
	private boolean flagFlag1 = false;

	/** Creates new form MainFrm 
	 * @throws MalformedURLException */
	public MainFrm() throws MalformedURLException {

		//改变系统默认字体
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}

		initComponents();//所有控件等类都付处置，记住此初始化函数一定要放在第一位，否则出现空指针现象！

		initBackground(); //背景初始化一般放第二位！

		//开启摄像头的线程。使用jLabel2放置显示的图像
		myThread = new MyThread();
		myThread.start();
		myThread.suspend();
		jLabel2.setIcon(null);

		this.SearchingTabbedPane.addTab("简单检索", new SearchingSimplePanel());
		this.SearchingTabbedPane.addTab("专家检索", new SearchingExpertPanel());
		zS_RXTX_Test.addIZS_RXTX_ReceiveString(this);
	}

	//第1步：自己写一个初始化装背景的容器函数；第2步，单独写一个类BackgroundPanel；
	private void initBackground() {
		bgp = new BackgroundPanel((new ImageIcon("images\\5.jpg")).getImage());//引入背景图片
		//bgp.setBounds(0,0,400,300);
		this.jPanelNB.add(bgp);

	}
	
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanelNB = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel1 = new javax.swing.JLabel();
		btnCamera = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		SearchingTabbedPane = new javax.swing.JTabbedPane();
		linkStationLabel = new javax.swing.JLabel();
		linkButton = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		sb = new javax.swing.JLabel();
		jButton5 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		wendu = new javax.swing.JLabel();
		shidu = new javax.swing.JLabel();
		zhangaiwu = new javax.swing.JLabel();
		xingshijuli = new javax.swing.JLabel();
		jButton7 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton9 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanelNB.setForeground(new java.awt.Color(255, 255, 255));

		jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 14));
		jLabel1.setForeground(new java.awt.Color(0, 0, 255));
		jLabel1.setText("\u6ce8\u518c");
		jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel1MouseClicked(evt);
			}
		});

		btnCamera.setText("\u5f00\u542f\u76d1\u63a7");
		btnCamera.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnCameraActionPerformed(evt);
			}
		});

		jButton4.setText("\u76d1\u63a7\u622a\u56fe");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton4ActionPerformed(evt);
			}
		});

		linkStationLabel.setFont(new java.awt.Font("微软雅黑", 1, 12));
		linkStationLabel.setForeground(new java.awt.Color(255, 255, 255));
		linkStationLabel.setText("\u8fde\u63a5\u72b6\u6001:\u672a\u8fde\u63a5");

		linkButton.setText("\u8fde\u63a5");
		linkButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				linkButtonActionPerformed(evt);
			}
		});

		jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel3.setForeground(new java.awt.Color(255, 255, 255));
		jLabel3.setText("\u5f53\u524d\u6e29\u5ea6\uff1a");

		jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel4.setForeground(new java.awt.Color(255, 255, 255));
		jLabel4.setText("\u5f53\u524d\u6e7f\u5ea6\uff1a");

		jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel5.setForeground(new java.awt.Color(255, 255, 255));
		jLabel5.setText("\u969c\u788d\u7269\u8ddd\u79bb\uff1a");

		jLabel6.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel6.setForeground(new java.awt.Color(255, 255, 255));
		jLabel6.setText("\u884c\u8f66\u8ddd\u79bb\uff1a");

		sb.setFont(new java.awt.Font("微软雅黑", 0, 18));
		sb.setForeground(new java.awt.Color(255, 255, 255));
		sb.setText("\u6ca1\u6709\u68c0\u6d4b\u5230\u751f\u547d");

		jButton5.setText("\u6682\u505c");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton5ActionPerformed(evt);
			}
		});

		jButton8.setText("\u540e");
		jButton8.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton8ActionPerformed(evt);
			}
		});

		jButton6.setText("\u5de6");
		jButton6.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton6ActionPerformed(evt);
			}
		});

		wendu.setFont(new java.awt.Font("微软雅黑", 0, 18));
		wendu.setForeground(new java.awt.Color(255, 255, 255));
		wendu.setText("\u2014\u2014");

		shidu.setFont(new java.awt.Font("微软雅黑", 0, 18));
		shidu.setForeground(new java.awt.Color(255, 255, 255));
		shidu.setText("\u2014\u2014");

		zhangaiwu.setFont(new java.awt.Font("微软雅黑", 0, 18));
		zhangaiwu.setForeground(new java.awt.Color(255, 255, 255));
		zhangaiwu.setText("\u2014\u2014");

		xingshijuli.setFont(new java.awt.Font("微软雅黑", 0, 18));
		xingshijuli.setForeground(new java.awt.Color(255, 255, 255));
		xingshijuli.setText("\u2014\u2014");

		jButton7.setText("\u53f3");
		jButton7.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton7ActionPerformed(evt);
			}
		});

		jButton2.setText("\u524d");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton2ActionPerformed(evt);
			}
		});

		jButton9.setText("\u5f00\u542f\u63a2\u7167\u706f");
		jButton9.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton9ActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanelNBLayout = new javax.swing.GroupLayout(
				jPanelNB);
		jPanelNB.setLayout(jPanelNBLayout);
		jPanelNBLayout
				.setHorizontalGroup(jPanelNBLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								jPanelNBLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelNBLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																jPanelNBLayout
																		.createSequentialGroup()
																		.addGroup(
																				jPanelNBLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addGroup(
																								jPanelNBLayout
																										.createSequentialGroup()
																										.addGroup(
																												jPanelNBLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																linkStationLabel)
																														.addGroup(
																																jPanelNBLayout
																																		.createSequentialGroup()
																																		.addGroup(
																																				jPanelNBLayout
																																						.createParallelGroup(
																																								javax.swing.GroupLayout.Alignment.LEADING)
																																						.addGroup(
																																								jPanelNBLayout
																																										.createSequentialGroup()
																																										.addGroup(
																																												jPanelNBLayout
																																														.createParallelGroup(
																																																javax.swing.GroupLayout.Alignment.TRAILING)
																																														.addComponent(
																																																jLabel4)
																																														.addComponent(
																																																jLabel3))
																																										.addPreferredGap(
																																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																										.addGroup(
																																												jPanelNBLayout
																																														.createParallelGroup(
																																																javax.swing.GroupLayout.Alignment.LEADING)
																																														.addComponent(
																																																wendu)
																																														.addComponent(
																																																shidu)))
																																						.addComponent(
																																								sb))
																																		.addGap(64,
																																				64,
																																				64)
																																		.addGroup(
																																				jPanelNBLayout
																																						.createParallelGroup(
																																								javax.swing.GroupLayout.Alignment.LEADING)
																																						.addGroup(
																																								jPanelNBLayout
																																										.createSequentialGroup()
																																										.addGap(235,
																																												235,
																																												235)
																																										.addComponent(
																																												jButton6))
																																						.addGroup(
																																								jPanelNBLayout
																																										.createSequentialGroup()
																																										.addGroup(
																																												jPanelNBLayout
																																														.createParallelGroup(
																																																javax.swing.GroupLayout.Alignment.LEADING)
																																														.addComponent(
																																																jLabel5)
																																														.addComponent(
																																																jLabel6))
																																										.addPreferredGap(
																																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																										.addGroup(
																																												jPanelNBLayout
																																														.createParallelGroup(
																																																javax.swing.GroupLayout.Alignment.LEADING)
																																														.addComponent(
																																																xingshijuli)
																																														.addComponent(
																																																zhangaiwu))))))
																										.addGap(7,
																												7,
																												7)
																										.addGroup(
																												jPanelNBLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jButton2)
																														.addComponent(
																																jButton8)
																														.addGroup(
																																jPanelNBLayout
																																		.createSequentialGroup()
																																		.addComponent(
																																				jButton5)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(
																																				jButton7)))
																										.addGap(56,
																												56,
																												56))
																						.addGroup(
																								jPanelNBLayout
																										.createSequentialGroup()
																										.addComponent(
																												linkButton)
																										.addGap(75,
																												75,
																												75)
																										.addComponent(
																												jLabel1)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)
																										.addComponent(
																												jButton9)
																										.addGap(92,
																												92,
																												92)))
																		.addGroup(
																				jPanelNBLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								false)
																						.addComponent(
																								btnCamera,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								jButton4,
																								javax.swing.GroupLayout.Alignment.LEADING,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addGap(27,
																				27,
																				27))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanelNBLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				638,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(65,
																				65,
																				65)))
										.addComponent(
												SearchingTabbedPane,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												535,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(736, 736, 736)));
		jPanelNBLayout
				.setVerticalGroup(jPanelNBLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanelNBLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanelNBLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanelNBLayout
																		.createSequentialGroup()
																		.addComponent(
																				SearchingTabbedPane,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				653,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanelNBLayout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				470,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(18,
																				18,
																				18)
																		.addGroup(
																				jPanelNBLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								jPanelNBLayout
																										.createSequentialGroup()
																										.addGroup(
																												jPanelNBLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																jLabel3)
																														.addComponent(
																																jLabel5)
																														.addComponent(
																																wendu)
																														.addComponent(
																																zhangaiwu))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												jPanelNBLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																jLabel4)
																														.addComponent(
																																jLabel6)
																														.addComponent(
																																shidu)
																														.addComponent(
																																xingshijuli))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												sb)
																										.addGap(38,
																												38,
																												38)
																										.addComponent(
																												linkStationLabel)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												jPanelNBLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																linkButton)
																														.addComponent(
																																jButton9)
																														.addComponent(
																																jLabel1)))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING,
																								jPanelNBLayout
																										.createSequentialGroup()
																										.addGroup(
																												jPanelNBLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																btnCamera)
																														.addComponent(
																																jButton2))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												jPanelNBLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jButton4)
																														.addGroup(
																																jPanelNBLayout
																																		.createSequentialGroup()
																																		.addGroup(
																																				jPanelNBLayout
																																						.createParallelGroup(
																																								javax.swing.GroupLayout.Alignment.BASELINE)
																																						.addComponent(
																																								jButton5)
																																						.addComponent(
																																								jButton6)
																																						.addComponent(
																																								jButton7))
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																																		.addComponent(
																																				jButton8)))
																										.addGap(43,
																												43,
																												43)))
																		.addGap(27,
																				27,
																				27)))
										.addContainerGap(22, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanelNB, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanelNB, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {

		if (flagFlag1) {
			sendstr('h');
			flagFlag1 = false;
			jButton9.setText("开启探照灯");

		} else {
			sendstr('f');
			flagFlag1 = true;
			jButton9.setText("关闭探照灯");

		}
	}

	private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {
		//停止	
		sendstr('e');
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		//前进
		sendstr('a');
	}

	private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {
		//右转
		sendstr('d');
	}

	private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {
		//左转
		sendstr('c');
	}

	private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {
		sendstr('b'); //后退	
	}

	//发数据给小车
	private void sendstr(char order) {
		writer.print(order);
		writer.flush();
	}

	private void linkButtonActionPerformed(java.awt.event.ActionEvent evt) {/*------------给小车发接收数据并显示-------------------*/
		thread = new Thread(new Runnable() {
			public void run() {
				try {
					socket = new Socket(HOST, POST);
					MainFrm.this.setLinkButtonText("断开");
					MainFrm.this.setlinkStationLabelText("连接状态：已连接");
					int flag = 0;
					in = new BufferedReader(new InputStreamReader(socket
							.getInputStream()));
					writer = new PrintWriter(socket.getOutputStream(), true);
					String content;
					char[] buffer1, buffer2;
					while (socket.isConnected()) {

						if ((content = in.readLine()) != null) {
//							flag++;
//														if (flag > 5)//改时间差
//														{
//															flag = 0;

							System.out.println(content);
							//zhangaiwu.setText(content);
							buffer1 = content.toCharArray();
							if (buffer1.length != 0) {
								buffer2 = new char[buffer1.length - 1];

								for (int i = 0; i < buffer1.length - 1; i++) {
									buffer2[i] = buffer1[i + 1];
								}
								String str2 = String.valueOf(buffer2);
								if (buffer1[0] == 'z') {
									if(buffer1[1] =='9'){
										zhangaiwu.setText("无障碍物");
										DbRecord_4ItemMemb dbRecord_4ItemMemb = new DbRecord_4ItemMemb();
										String str = "";
										for (int i = 0; i < buffer2.length; i++) {
											str = str + buffer2[i];
										}
										DbUtil dbUtil = new DbUtil();//建立连接
										Connection con = dbUtil.getCon();
										dbRecord_4ItemMemb.setBarrier("无障碍物");
										DbRecord_4ItemDao.dbRecord_4ItemAdd(con,
												dbRecord_4ItemMemb);
										con.close();
									}
									else{
									zhangaiwu.setText(str2 + "cm");
									DbRecord_4ItemMemb dbRecord_4ItemMemb = new DbRecord_4ItemMemb();
									String str = "";
									for (int i = 0; i < buffer2.length; i++) {
										str = str + buffer2[i];
									}
									DbUtil dbUtil = new DbUtil();//建立连接
									Connection con = dbUtil.getCon();
									dbRecord_4ItemMemb.setBarrier(str + "cm");
									DbRecord_4ItemDao.dbRecord_4ItemAdd(con,
											dbRecord_4ItemMemb);
									con.close();
									}
								} else if (buffer1[0] == 'j') {
									xingshijuli.setText(str2 + "cm");
									DbRecord_4ItemMemb dbRecord_4ItemMemb = new DbRecord_4ItemMemb();
									String str = "";
									for (int i = 0; i < buffer2.length; i++) {
										str = str + buffer2[i];
									}
									DbUtil dbUtil = new DbUtil();//建立连接
									Connection con = dbUtil.getCon();
									dbRecord_4ItemMemb.setRunningDistance(str
											+ "cm");
									DbRecord_4ItemDao.dbRecord_4ItemAdd(con,
											dbRecord_4ItemMemb);
									con.close();
								} else if (buffer1[0] == 't') {
									wendu.setText(str2 + "℃");
									DbRecord_4ItemMemb dbRecord_4ItemMemb = new DbRecord_4ItemMemb();
									String str = "";
									for (int i = 0; i < buffer2.length; i++) {
										str = str + buffer2[i];
									}
									DbUtil dbUtil = new DbUtil();//建立连接
									Connection con = dbUtil.getCon();
									dbRecord_4ItemMemb
											.setTemperature(str + "℃");
									DbRecord_4ItemDao.dbRecord_4ItemAdd(con,
											dbRecord_4ItemMemb);
									con.close();
								} else if (buffer1[0] == 'r') {
									shidu.setText(str2 + "%");
									DbRecord_4ItemMemb dbRecord_4ItemMemb = new DbRecord_4ItemMemb();
									String str = "";
									for (int i = 0; i < buffer2.length; i++) {//转化为字符串
										str = str + buffer2[i];
									}
									DbUtil dbUtil = new DbUtil();//建立连接
									Connection con = dbUtil.getCon();
									dbRecord_4ItemMemb.setHumidity(str + "%");
									DbRecord_4ItemDao.dbRecord_4ItemAdd(con,
											dbRecord_4ItemMemb);
									con.close();
								} else if (buffer1[0] == 'n') {
									sb.setText("没有检测到生命");
									sb.setForeground(Color.white);
									DbRecord_4ItemMemb dbRecord_4ItemMemb = new DbRecord_4ItemMemb();
									DbUtil dbUtil = new DbUtil();//建立连接
									Connection con = dbUtil.getCon();
									dbRecord_4ItemMemb.setLive("无生命");
									DbRecord_4ItemDao.dbRecord_4ItemAdd(con,
											dbRecord_4ItemMemb);
									con.close();
								} else if (buffer1[0] == 'p') {
									sb.setText("检测到生命!");
									sb.setForeground(Color.red);
									DbRecord_4ItemMemb dbRecord_4ItemMemb = new DbRecord_4ItemMemb();
									DbUtil dbUtil = new DbUtil();//建立连接
									Connection con = dbUtil.getCon();
									dbRecord_4ItemMemb.setLive("有生命");
									DbRecord_4ItemDao.dbRecord_4ItemAdd(con,
											dbRecord_4ItemMemb);
									con.close();

								}
							} else {
								System.out.println("数组长度为0！！");
							}

//						}
					}
										}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		linkNetClick();
	}

	private void linkNetClick() {
		switch (linkStation) {
		case 0:
			linkStation = 1;
			thread.start();
			setlinkStationLabelText("连接状态：正在连接");
			setLinkButtonText("正在连接");
			break;
		case 1:
			linkStation = 0;
			thread.suspend();
			setlinkStationLabelText("连接扎状态：断开");
			setLinkButtonText("连接");
			break;
		case 2:
			thread.suspend();
			linkStation = 0;
			setlinkStationLabelText("连接扎状态：断开");
			setLinkButtonText("连接");
			break;
		default:
			break;
		}
	}

	private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			ImageIO.write(image, "jpg",
					new File("c:\\tmp\\" + TestDate.getTime() + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //调用了TestDate类中的getTime()函数
		System.out.println("成功");
	}

	//开启摄像头、暂停监控、重启键控一件合成！
	private void btnCameraActionPerformed(java.awt.event.ActionEvent evt) {
		openCarmera();

	}

	public void openCarmera() {
		if (flagFlag) {
			myThread.suspend();
			jLabel2.setIcon(null);
			flagFlag = false;
			btnCamera.setText("开启监控");
		} else {

			myThread.resume();
			flagFlag = true;
			btnCamera.setText("暂停监控");
		}
	}

	class MyThread extends Thread {
		URL url = new URL(imageURL);

		public MyThread() throws MalformedURLException {
		}

		@Override
		public void run() {
			while (true) {
				InputStream inputStream;
				try {
					inputStream = url.openConnection().getInputStream();
					image = ImageIO.read(inputStream);
					System.out.println("running");
					jLabel2.setIcon(new ImageIcon((Image) image));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
		SignFrm a = new SignFrm();
		a.setVisible(true);
		a.setMain(this);
		this.setEnabled(false);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new MainFrm().setVisible(true);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTabbedPane SearchingTabbedPane;
	private javax.swing.JButton btnCamera;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JPanel jPanelNB;
	private javax.swing.JButton linkButton;
	private javax.swing.JLabel linkStationLabel;
	private javax.swing.JLabel sb;
	private javax.swing.JLabel shidu;
	private javax.swing.JLabel wendu;
	private javax.swing.JLabel xingshijuli;
	private javax.swing.JLabel zhangaiwu;

	// End of variables declaration//GEN-END:variables
	/**
	 * 接收到的数据在这里
	 */
	@Override
	public void zS_RXTX_ReceiveString(String arg0, byte[] byt) {
		// TODO Auto-generated method stub
		int i = 0;
		System.out.println("接收到：" + arg0);
		while (byt[i] != 0) {
			System.out.println("接收到：" + byt[i]);
			i++;
		}

	}

	@Override
	public void getGrabImage(BufferedImage bufferedImage) {
		// TODO Auto-generated method stub

	}

	//******************NET****************//
	public void setLinkButtonText(String str) {
		linkButton.setText(str);
	}

	public void setlinkStationLabelText(String str) {
		this.setLayout(null);//设置布局管理器为空
		linkStationLabel.setText(str);
	}

	public int getCameraFlag() {
		return cameraFlag;
	}

	public void setCameraFlag(int cameraFlag) {
		this.cameraFlag = cameraFlag;
	}

	public void catchCarmera() {
		try {
			ImageIO.write(image, "jpg", new File("D:\\carmera.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //调用了TestDate类中的getTime()函数
		System.out.println("截图成功  for send");
	}

}