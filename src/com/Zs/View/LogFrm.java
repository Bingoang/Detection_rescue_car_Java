/*
 * LogFrm.java
 *
 * Created on __DATE__, __TIME__
 */

package com.Zs.View;

import java.awt.Font;
import java.sql.Connection;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.Zs.DbDao.DbLogUserDao;
import com.Zs.DbDao.DbLogUserMemb;
import com.Zs.DbUtil.DbUtil;

import ZsUtil.ZsUtil;

/**
 *
 * @author  __USER__
 */
public class LogFrm extends javax.swing.JFrame {
	DbUtil dbUtil = new DbUtil();
	DbLogUserDao dbLogUserDao = new DbLogUserDao();

	/** Creates new form LogFrm */
	public LogFrm() {
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

		initComponents();
		//设置fram居中显示
		this.setLocationRelativeTo(null);
	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		userText = new javax.swing.JTextField();
		passwordTxt = new javax.swing.JPasswordField();
		jButton1 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setFont(new java.awt.Font("方正姚体", 0, 10));
		setResizable(false);

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 24));
		jLabel1.setIcon(new javax.swing.ImageIcon(
				"D:\\JAVA2\\Car_Client\\images\\car.png")); // NOI18N
		jLabel1.setText("\u667a\u80fd\u6551\u63f4\u63a2\u6d4b\u5c0f\u8f66");

		jLabel2.setText("\u7528\u6237\u540d");

		jLabel3.setText("\u5bc6  \u7801");

		jButton1.setText("\u767b\u9646");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton3.setText("\u9000\u51fa");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt);
			}
		});

		jLabel4.setForeground(new java.awt.Color(0, 0, 153));
		jLabel4.setText("\u5fd8\u8bb0\u5bc6\u7801\uff1f");
		jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel4MouseClicked(evt);
			}
		});

		jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel5.setText("\u5411\u8d35\u519b \u738b\u4f73\u96ef \u674e\u8f69\u6602 \u4e25\u5c0f\u71d5");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(329, Short.MAX_VALUE)
								.addComponent(jLabel4).addGap(30, 30, 30))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		jLabel1))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(60, 60,
																		60)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														jLabel2)
																												.addComponent(
																														jLabel3))
																								.addGap(49,
																										49,
																										49)
																								.addGroup(
																										layout.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.LEADING)
																												.addComponent(
																														passwordTxt,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														204,
																														Short.MAX_VALUE)
																												.addComponent(
																														userText,
																														javax.swing.GroupLayout.DEFAULT_SIZE,
																														204,
																														Short.MAX_VALUE)))
																				.addGroup(
																						layout.createSequentialGroup()
																								.addComponent(
																										jButton1,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										69,
																										javax.swing.GroupLayout.PREFERRED_SIZE)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																										153,
																										Short.MAX_VALUE)
																								.addComponent(
																										jButton3,
																										javax.swing.GroupLayout.PREFERRED_SIZE,
																										67,
																										javax.swing.GroupLayout.PREFERRED_SIZE)))))
								.addGap(70, 70, 70))
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addContainerGap(98, Short.MAX_VALUE)
								.addComponent(jLabel5).addGap(90, 90, 90)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(31, 31, 31)
								.addComponent(jLabel1)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel5)
								.addGap(27, 27, 27)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel2)
												.addComponent(
														userText,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(37, 37, 37)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel3)
												.addComponent(
														passwordTxt,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(30, 30, 30)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton3))
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addComponent(jLabel4).addGap(17, 17, 17)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {
		this.dispose();
		new FindBackPWFrm_sub().setVisible(true);
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String userName = userText.getText();
		String passWord = new String(passwordTxt.getPassword());
		if (ZsUtil.stringIsEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空");
			return;
		}
		if (ZsUtil.stringIsEmpty(passWord)) {
			JOptionPane.showMessageDialog(null, "密码不能为空");
			return;
		}
		DbLogUserMemb user = new DbLogUserMemb(userName, passWord);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			DbLogUserMemb currentUser = dbLogUserDao.login(con, user);
			if (currentUser != null) {
				JOptionPane.showMessageDialog(null, "登陆成功");
				this.dispose();
				new MainFrm().setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "用户名或密码错误");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "登陆失败");
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		ZsUtil.distroyFrm(this);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new LogFrm().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPasswordField passwordTxt;
	private javax.swing.JTextField userText;
	// End of variables declaration//GEN-END:variables

}