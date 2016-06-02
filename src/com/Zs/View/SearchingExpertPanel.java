/*
 * SearchingExpertPanel.java
 *
 * Created on __DATE__, __TIME__
 */

package com.Zs.View;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.text.html.HTMLDocument.Iterator;
import javax.xml.crypto.Data;

import com.Zs.DbDao.DbRecord_4ItemDao;
import com.Zs.DbUtil.DbUtil;
import ZsUtil.DateChooserJButton;
import ZsUtil.ZsUtil;

/**
 *
 * @author  __USER__
 */
public class SearchingExpertPanel extends javax.swing.JPanel {
	private DateChooserJButton dateChooserJButton_1 = new DateChooserJButton();
	private DateChooserJButton dateChooserJButton_2 = new DateChooserJButton();
	private DefaultListModel defaultListModel = new DefaultListModel();
	private DefaultListModel m = new DefaultListModel();
	DbUtil dbUtil = new DbUtil();
	DbRecord_4ItemDao dbRecord_4ItemDao = new DbRecord_4ItemDao();

	/** Creates new form SearchingExpertPanel */
	public SearchingExpertPanel() {
		initComponents();
		CreatDateChooserButton();

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jScrollPane1 = new javax.swing.JScrollPane();
		SearchingExpertList = new javax.swing.JList();
		jButton1 = new javax.swing.JButton();
		SD_CheckBox = new javax.swing.JCheckBox();
		ZA_CheckBox = new javax.swing.JCheckBox();
		jLabel1 = new javax.swing.JLabel();
		XC_CheckBox = new javax.swing.JCheckBox();
		All_CheckBox = new javax.swing.JCheckBox();
		jLabel3 = new javax.swing.JLabel();
		LiveBox = new javax.swing.JCheckBox();
		jCheckBox1 = new javax.swing.JCheckBox();

		SearchingExpertList.setModel(new javax.swing.AbstractListModel() {
			String[] strings = { "请选择您想要查询的内容" };

			public int getSize() {
				return strings.length;
			}

			public Object getElementAt(int i) {
				return strings[i];
			}
		});
		jScrollPane1.setViewportView(SearchingExpertList);

		jButton1.setText("\u67e5\u8be2\u8bb0\u5f55");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton1ActionPerformed(evt);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		SD_CheckBox.setText("\u6e7f\u5ea6");

		ZA_CheckBox.setText("\u969c\u788d\u7269\u8ddd\u79bb");
		ZA_CheckBox.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				actionPerformed(evt);
			}
		});

		jLabel1.setText("\u4e8b\u4ef6");

		XC_CheckBox.setText("\u884c\u8f66\u8ddd\u79bb");

		All_CheckBox.setSelected(true);
		All_CheckBox.setText("\u6240\u6709\u8bb0\u5f55");

		jLabel3.setText("\u8bf7\u9009\u62e9\u67e5\u8be2\u65f6\u95f4\u533a\u95f4");

		LiveBox.setText("\u751f\u547d\u68c0\u6d4b");

		jCheckBox1.setText("\u6e29\u5ea6");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jScrollPane1,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		432,
																		Short.MAX_VALUE)
																.addContainerGap())
												.addGroup(
														layout.createSequentialGroup()
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING)
																				.addGroup(
																						layout.createSequentialGroup()
																								.addGap(4,
																										4,
																										4)
																								.addComponent(
																										jCheckBox1)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										SD_CheckBox)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										ZA_CheckBox)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										XC_CheckBox)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										LiveBox)
																								.addPreferredGap(
																										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																								.addComponent(
																										All_CheckBox))
																				.addComponent(
																						jLabel1))
																.addGap(28, 28,
																		28))
												.addComponent(jLabel3)
												.addGroup(
														layout.createSequentialGroup()
																.addComponent(
																		jButton1)
																.addContainerGap(
																		363,
																		Short.MAX_VALUE)))));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addContainerGap()
								.addComponent(jLabel1)
								.addGap(4, 4, 4)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(SD_CheckBox)
												.addComponent(ZA_CheckBox)
												.addComponent(XC_CheckBox)
												.addComponent(All_CheckBox)
												.addComponent(LiveBox)
												.addComponent(jCheckBox1))
								.addGap(36, 36, 36)
								.addComponent(jLabel3)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										105, Short.MAX_VALUE)
								.addComponent(jScrollPane1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										374,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										25,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(12, 12, 12)));
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
			throws Exception {
		Connection con = dbUtil.getCon();
		defaultListModel.clear();

		m.clear();
		defaultListModel = this.getList(con);//得到没有时间约束的数据
		defaultListModel = this.getResultListBydate(defaultListModel);//时间约束
		for (int i = 0; i < defaultListModel.getSize(); i++) {
			String str = (defaultListModel.get(i) + "").replaceAll("null", "");
			defaultListModel.remove(i);
			defaultListModel.add(0, str);
		}
		for (int i = 0; i < defaultListModel.getSize(); i++) {
			int length = defaultListModel.get(i).toString().length();//将10150311095447转化为2015年03月11日09时54分47秒
			String str = DbRecord_4ItemDao
					.getStringFromSqlDate(defaultListModel.get(i).toString()
							.substring(length - 14));
			m.addElement(defaultListModel.get(i).toString()
					.substring(0, length - 14)
					+ str);
		}

		//System.out.println(str6);
		this.showList(m);
		dbUtil.closeCon(con);
	}

	/**
	 * 得到制定内容
	 * @param con 数据库连接
	 * @param item 表格中的那一列的列明
	 * @param content 那一列的内容
	 * @throws Exception
	 */

	/**
	 * 输入变量 显示在LIST上
	 * @param SearchingExpertModel
	 */
	private void showList(DefaultListModel SearchingExpertModel) {

		this.SearchingExpertList.setModel(SearchingExpertModel);
		this.SearchingExpertList = new JList(SearchingExpertModel);
		this.SearchingExpertList.invalidate();
		this.SearchingExpertList.repaint();
	}

	//	private void setOpenDoorCheckBoxEnabled() {
	//		this.ZW_CheckBox.setEnabled(this.KM_CheckBox.isSelected());
	//		this.DXSQKM_CheckBox.setEnabled(this.KM_CheckBox.isSelected());
	//		this.SJKM_CheckBox.setEnabled(this.KM_CheckBox.isSelected());
	//		this.YSKM_CheckBox.setEnabled(this.KM_CheckBox.isSelected());
	//		this.DNSQKM_CheckBox.setEnabled(this.KM_CheckBox.isSelected());
	//	}

	private void CreatDateChooserButton() {
		this.add(dateChooserJButton_1);
		this.add(dateChooserJButton_2);
		this.dateChooserJButton_1.setSize(150, 20);
		this.dateChooserJButton_1.setLocation(20, 120);
		this.dateChooserJButton_2.setSize(150, 20);
		this.dateChooserJButton_2.setLocation(20, 160);
		return;
	}

	private DefaultListModel getList(Connection con) throws SQLException {
		DefaultListModel m = new DefaultListModel();
		m.clear();
		if (All_CheckBox.isSelected()) {
			m = dbRecord_4ItemDao.getAll(con);
		} else {
				if (jCheckBox1.isSelected()) {
				m = ZsUtil.DftMd_Add(m,
						dbRecord_4ItemDao.getSearchingDb_(con, "Temperature"));
			}

			if (SD_CheckBox.isSelected()) {
				m = ZsUtil.DftMd_Add(m,
						dbRecord_4ItemDao.getSearchingDb_(con, "Humidity"));
			}
			if (ZA_CheckBox.isSelected()) {
				m = ZsUtil.DftMd_Add(m,
						dbRecord_4ItemDao.getSearchingDb_(con, "Barrier"));
			}
			if (XC_CheckBox.isSelected()) {
				m = ZsUtil.DftMd_Add(m, dbRecord_4ItemDao.getSearchingDb_(con,
						"RunningDistance"));
			}
			if (LiveBox.isSelected()) {
				m = ZsUtil.DftMd_Add(m,
						dbRecord_4ItemDao.getSearchingDb_(con, "Live"));
			}

		}
		return m;
	}

	private DefaultListModel getResultListBydate(DefaultListModel m) {
		DefaultListModel result = new DefaultListModel();
		Date date1 = this.dateChooserJButton_1.getDate();
		Date date2 = this.dateChooserJButton_2.getDate();
		String date1_String = ZsUtil.DateToSqlDate_String(date1);
		String date2_String = ZsUtil.DateToSqlDate_String(date2);

		if (date1.compareTo(date2) < 0)//如果date1<date2
		{
			for (int i = 0; i < m.getSize(); i++) {
				if ((ZsUtil.compareSqlDateString(m.get(i).toString(),
						date1_String) > 0)
						&& ZsUtil.compareSqlDateString(m.get(i).toString(),
								date2_String) < 0)//如果m的日期在我们给定的日期以内
				{
					result.addElement(m.get(i));
				}

			}
		} else {
			for (int i = 0; i < m.getSize(); i++) {
				if ((ZsUtil.compareSqlDateString(m.get(i).toString(),
						date1_String) < 0)
						&& ZsUtil.compareSqlDateString(m.get(i).toString(),
								date2_String) > 0)//如果m的日期在我们给定的日期以内
				{
					result.addElement(m.get(i));
				}

			}
		}
		return result;
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JCheckBox All_CheckBox;
	private javax.swing.JCheckBox LiveBox;
	private javax.swing.JCheckBox SD_CheckBox;
	private javax.swing.JList SearchingExpertList;
	private javax.swing.JCheckBox XC_CheckBox;
	private javax.swing.JCheckBox ZA_CheckBox;
	private javax.swing.JButton jButton1;
	private javax.swing.JCheckBox jCheckBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	// End of variables declaration//GEN-END:variables

}