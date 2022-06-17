package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String truonghoc;
	private String quanhuyen;
	private String ma;
	private String lop;
	private String hoten;
	private String ngaysinh;
	private String gioitinh;
	private String noisinh;
	private String dantoc;
	private String hokhau;
	private String dienthoai;
	private Double diem1;
	private Double diem2;
	private Double diem3;
	private Double diem4;
	private Double diem5;
	private Double tong5diem;
	private Double diemUT;
	private Double diem;
	private String note;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTruonghoc() {
		return truonghoc;
	}
	public void setTruonghoc(String truonghoc) {
		this.truonghoc = truonghoc;
	}
	public String getQuanhuyen() {
		return quanhuyen;
	}
	public void setQuanhuyen(String quanhuyen) {
		this.quanhuyen = quanhuyen;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getNoisinh() {
		return noisinh;
	}
	public void setNoisinh(String noisinh) {
		this.noisinh = noisinh;
	}
	public String getDantoc() {
		return dantoc;
	}
	public void setDantoc(String dantoc) {
		this.dantoc = dantoc;
	}
	public String getHokhau() {
		return hokhau;
	}
	public void setHokhau(String hokhau) {
		this.hokhau = hokhau;
	}
	public String getDienthoai() {
		return dienthoai;
	}
	public void setDienthoai(String dienthoai) {
		this.dienthoai = dienthoai;
	}
	public Double getDiem1() {
		return diem1;
	}
	public void setDiem1(Double diem1) {
		this.diem1 = diem1;
	}
	public Double getDiem2() {
		return diem2;
	}
	public void setDiem2(Double diem2) {
		this.diem2 = diem2;
	}
	public Double getDiem3() {
		return diem3;
	}
	public void setDiem3(Double diem3) {
		this.diem3 = diem3;
	}
	public Double getDiem4() {
		return diem4;
	}
	public void setDiem4(Double diem4) {
		this.diem4 = diem4;
	}
	public Double getDiem5() {
		return diem5;
	}
	public void setDiem5(Double diem5) {
		this.diem5 = diem5;
	}
	public Double getTong5diem() {
		return tong5diem;
	}
	public void setTong5diem(Double tong5diem) {
		this.tong5diem = tong5diem;
	}
	public Double getDiemUT() {
		return diemUT;
	}
	public void setDiemUT(Double diemUT) {
		this.diemUT = diemUT;
	}
	public Double getDiem() {
		return diem;
	}
	public void setDiem(Double diem) {
		this.diem = diem;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	
}
