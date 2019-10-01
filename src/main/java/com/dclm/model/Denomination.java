package com.dclm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "denomination")
public class Denomination {

	@Id
	@Column(name = "id", unique = true)
	private int id;
	
	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "sname", unique = true)
	private String sname;
	
	@Column(name = "country", unique = true)
	private String country;
	
	@Column(name = "founder", unique = true)
	private String founder;
	
	@Column(name = "start_date", unique = true)
	private Date startDate;
	
	@Column(name = "hq", unique = true)
	private String hq;
	
	@Column(name = "gpsLat", unique = true)
	private double gpsLat;

	@Column(name = "gpsLong", unique = true)
	private double gpsLong;
	
	@Column(name = "logo", unique = true)
	private String logo;

	@Column(name = "mission", unique = true)
	private String mission;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFounder() {
		return founder;
	}

	public void setFounder(String founder) {
		this.founder = founder;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getHq() {
		return hq;
	}

	public void setHq(String hq) {
		this.hq = hq;
	}

	public double getGpsLat() {
		return gpsLat;
	}

	public void setGpsLat(double gpsLat) {
		this.gpsLat = gpsLat;
	}

	public double getGpsLong() {
		return gpsLong;
	}

	public void setGpsLong(double gpsLong) {
		this.gpsLong = gpsLong;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getMission() {
		return mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
	}

}
