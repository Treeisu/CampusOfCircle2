package org.jiang.COC.model;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.*;
@Entity
@Table(name="t_student")
public class Student implements Serializable {

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 4061717892088141595L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",length=11,nullable=false,columnDefinition="int")
	private int id;
	@Column(name="stu_name",length=16,nullable=false,columnDefinition="varchar")
	private String stuName;
	@Column(name="age",length=11,nullable=true,columnDefinition="int")
	private int age;//学锟斤拷锟斤拷锟斤拷
	@Column(name="gender",length=11,nullable=true,columnDefinition="int")
	private  int gender;//学锟斤拷锟皆憋拷
	@Column(name="address",length=128,nullable=true,columnDefinition="varcahr")
	private String address;//学锟斤拷锟街?
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Student(int id, String stuName, int age, int gender, String address) {
		super();
		this.id = id;
		this.stuName = stuName;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", stuName=" + stuName + ", age=" + age
				+ ", gender=" + gender + ", address=" + address + "]";
	}
	public Student(Map<String, Object> map){
		this.id =(Integer) map.get("id");
		this.stuName = (String) map.get("stu_name");
		this.age = (Integer) map.get("age");
		this.gender = (Integer) map.get("gender");
		this.address = (String) map.get("address");
	}	
}
