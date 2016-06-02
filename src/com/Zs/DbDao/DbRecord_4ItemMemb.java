package com.Zs.DbDao;

import java.util.Date;


public class DbRecord_4ItemMemb {
	private String humidity;
	private String temperature;
	private String barrier;
	private String runningDistance;
	private String live;
	private Date inStime;
	private int id;
	
			
	public DbRecord_4ItemMemb() {
		super();
	}
	
	public DbRecord_4ItemMemb(String humidity, String temperature, String barrier,
			String runningDistance,String live,Date inStime) {
		super();
		this.humidity=humidity;
		this.temperature=temperature;
		this.barrier=barrier;
		this.runningDistance=runningDistance;
		this.live=live;
		this.inStime = inStime;
	}


	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getBarrier() {
		return barrier;
	}
	public void setBarrier(String barrier) {
		this.barrier = barrier;
	}
	public String getRunningDistance() {
		return runningDistance;
	}
	public void setRunningDistance(String runningDistance) {
		this.runningDistance = runningDistance;
	}
	public Date getInStime() {
		return inStime;
	}
	public void setInStime(Date inStime) {
		this.inStime = inStime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLive() {
		return live;
	}
	public void setLive(String live) {
		this.live = live;
		
	}
	
}
