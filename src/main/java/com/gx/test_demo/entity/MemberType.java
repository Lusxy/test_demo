package com.gx.test_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 会员类型
 * </p>
 *
 * @author Lucky
 * @since 2022-06-23
 */
@TableName("member_type")
public class MemberType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 会员类型id
     */
    @TableId(value = "member_type_id", type = IdType.AUTO)
    private Integer memberTypeId;

    /**
     * 会员类型
     */
    private String memberType;

    /**
     * 折扣
     */
    private BigDecimal discount;

    /**
     * 说明
     */
    private String explains;

    /**
     * 是否有效
     */
    private Boolean isValid;

    public Integer getMemberTypeId() {
        return memberTypeId;
    }

    public void setMemberTypeId(Integer memberTypeId) {
        this.memberTypeId = memberTypeId;
    }
    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
    public String getExplains() {
        return explains;
    }

    public void setExplains(String explains) {
        this.explains = explains;
    }
    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        return "MemberType{" +
            "memberTypeId=" + memberTypeId +
            ", memberType=" + memberType +
            ", discount=" + discount +
            ", explains=" + explains +
            ", isValid=" + isValid +
        "}";
    }
}
