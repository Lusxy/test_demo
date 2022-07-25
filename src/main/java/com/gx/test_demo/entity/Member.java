package com.gx.test_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 会员
 * </p>
 *
 * @author Lucky
 * @since 2022-06-23
 */
@TableName("member")
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会员Id
     */
    @TableId(value = "member_id", type = IdType.AUTO)
    private Integer memberId;

    /**
     * 会员姓名
     */
    private String memberName;

    /**
     * 会员类型id
     */
    private Integer memberTypeId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 注册时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime registerTime;

    /**
     * 证件类型id
     */
    private Integer certificateTypeId;

    /**
     * 证件号
     */
    private String certificateNumber;

    /**
     * 性别
     */
    private Boolean sex;

    /**
     * 照片
     */
    private String photo;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 是否有效
     */
    private Boolean isValid;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public Integer getMemberTypeId() {
        return memberTypeId;
    }

    public void setMemberTypeId(Integer memberTypeId) {
        this.memberTypeId = memberTypeId;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }
    public Integer getCertificateTypeId() {
        return certificateTypeId;
    }

    public void setCertificateTypeId(Integer certificateTypeId) {
        this.certificateTypeId = certificateTypeId;
    }
    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }
    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        return "Member{" +
            "memberId=" + memberId +
            ", memberName=" + memberName +
            ", memberTypeId=" + memberTypeId +
            ", phone=" + phone +
            ", password=" + password +
            ", registerTime=" + registerTime +
            ", certificateTypeId=" + certificateTypeId +
            ", certificateNumber=" + certificateNumber +
            ", sex=" + sex +
            ", photo=" + photo +
            ", email=" + email +
            ", isValid=" + isValid +
        "}";
    }
}
