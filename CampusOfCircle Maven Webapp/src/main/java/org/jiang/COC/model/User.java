package org.jiang.COC.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 用户注信息表
 * 注册时需要填写信息
 * @author Cherry
 *
 */
@Entity
@Table(name="tb_user")
public class User implements Serializable {
	@Transient
	private static final long serialVersionUID = 4048529031442266867L;
	@Transient
	private UserAdviceNum userAdviceNum;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId", unique = true, nullable = false)
	private long userId;
	@Column(name = "userNickName",length=20)
    private String userNickName;
	@Column(name = "userSex")
    private Integer userSex;
	@Column(name = "userImage",length=300)
    private String userImage;
	@Column(name = "userEmail",length=30)
    private String userEmail;
	@Column(name = "userPhone",length=11)
    private String userPhone;
	@Column(name = "userPassword",length=20)
    private String userPassword;
    @Column(name = "userSchool",length=300)
    private String userSchool;
    @Column(name = "userMajor",length=300)
    private String userMajor;
    @Column(name = "userClass",length=300)
    private String userClass;
    @Column(name = "userAddress",length=300)
    private String userAddress;
    @Column(name = "userRegisterDate",length=20)
    private Date userRegisterDate;
    @Column(name = "userDescription",length=500)
    private String userDescription;
	
   

	public UserAdviceNum getUserAdviceNum() {
		return userAdviceNum;
	}
	public void setUserAdviceNum(UserAdviceNum userAdviceNum) {
		this.userAdviceNum = userAdviceNum;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public Integer getUserSex() {
		return userSex;
	}
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserSchool() {
		return userSchool;
	}
	public void setUserSchool(String userSchool) {
		this.userSchool = userSchool;
	}
	public String getUserMajor() {
		return userMajor;
	}
	public void setUserMajor(String userMajor) {
		this.userMajor = userMajor;
	}
	public String getUserClass() {
		return userClass;
	}
	public void setUserClass(String userClass) {
		this.userClass = userClass;
	}
	public Date getUserRegisterDate() {
		return userRegisterDate;
	}
	public void setUserRegisterDate(Date userRegisterDate) {
		this.userRegisterDate = userRegisterDate;
	}
	public String getUserDescription() {
		return userDescription;
	}
	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}
	
	public User(long userId, String userNickName, Integer userSex,
			String userImage, String userEmail, String userPhone,
			String userPassword, String userSchool, String userMajor,
			String userClass, String userAddress,
			Date userRegisterDate, String userDescription) {
		super();
		this.userId = userId;
		this.userNickName = userNickName;
		this.userSex = userSex;
		this.userImage = userImage;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userPassword = userPassword;
		this.userSchool = userSchool;
		this.userMajor = userMajor;
		this.userClass = userClass;
		this.userAddress = userAddress;
		this.userRegisterDate = userRegisterDate;
		this.userDescription = userDescription;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userNickName=" + userNickName
				+ ", userSex=" + userSex + ", userImage=" + userImage
				+ ", userEmail=" + userEmail + ", userPhone=" + userPhone
				+ ", userPassword=" + userPassword + ", userSchool="
				+ userSchool + ", userMajor=" + userMajor + ", userClass="
				+ userClass + ", userAddress=" + userAddress
				+ ", userRegisterDate=" + userRegisterDate
				+ ", userDescription=" + userDescription + "]";
	}
	
	
	
    

}
