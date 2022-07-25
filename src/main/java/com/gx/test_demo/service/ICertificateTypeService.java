package com.gx.test_demo.service;

import com.gx.test_demo.entity.CertificateType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * certificate_type 服务类
 * </p>
 *
 * @author Lucky
 * @since 2022-06-23
 */
public interface ICertificateTypeService extends IService<CertificateType> {

     List<CertificateType> selectAllCertificateType();

}
