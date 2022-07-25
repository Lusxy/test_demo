package com.gx.test_demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * certificate_type
 * </p>
 *
 * @author Lucky
 * @since 2022-06-23
 */
@TableName("certificate_type")
public class CertificateType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 证件类型id
     */
    @TableId(value = "certificate_type_id", type = IdType.AUTO)
    private Integer certificateTypeId;

    /**
     * 证件类型
     */
    private String certificateType;

    /**
     * 是否有效
     */
    private Boolean isValid;

    public Integer getCertificateTypeId() {
        return certificateTypeId;
    }

    public void setCertificateTypeId(Integer certificateTypeId) {
        this.certificateTypeId = certificateTypeId;
    }
    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }
    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        return "CertificateType{" +
            "certificateTypeId=" + certificateTypeId +
            ", certificateType=" + certificateType +
            ", isValid=" + isValid +
        "}";
    }
}
