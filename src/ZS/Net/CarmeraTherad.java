package ZS.Net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.Zs.View.MainFrm;

public class CarmeraTherad extends Thread{
//	private Socket socket;
	private MainFrm mainFrm;
	
	public CarmeraTherad(MainFrm mainFrm) {
		// TODO Auto-generated constructor stub
		this.mainFrm = mainFrm;
	}
	
	@Override
	public void run() {
		String filePath = "D:\\carmera.jpg";  
		PrintWriter printWriter;
		
	    DataInputStream dis ;
	    try {
	    	mainFrm.catchCarmera();
	    	this.sleep(1000);
	    	//1.连接诶服务器
			Socket s = new Socket(NetThread.IP,8089);//127.0.0.1 连接本机
			mainFrm.setLinkButtonText("断开");
			mainFrm.setlinkStationLabelText("连接状态：已连接");
			mainFrm.linkStation = 1;
			printWriter = new PrintWriter(s.getOutputStream(), true);
			printWriter.println("即将发送图片");
			this.sleep(2000);
			System.out.println("已连接到服务器8089端口，准备传送图片...");
			//获取图片字节流
			FileInputStream fis = new FileInputStream(filePath);
			//获取输出流
			OutputStream out = s.getOutputStream();
			byte[] buf = new byte[1024];
			int len = 0;
			//2.往输出流里面投放数据
			while ((len = fis.read(buf)) != -1)
			{
				out.write(buf,0,len);
			}
			//通知服务端，数据发送完毕
			s.shutdownOutput();
			//3.获取输出流，接受服务器传送过来的消息“上传成功”
			InputStream in = s.getInputStream();
			byte[] bufIn = new byte[1024];
			int num = in.read(bufIn);
			System.out.println(new String(bufIn,0,num));
			//关闭资源
			fis.close();
			out.close();
			in.close();
			s.close();
//            server.close();    
	            this.interrupt();
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	}
}
