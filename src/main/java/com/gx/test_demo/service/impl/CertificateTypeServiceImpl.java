package com.gx.test_demo.service.impl;

import com.gx.test_demo.entity.CertificateType;
import com.gx.test_demo.mapper.CertificateTypeMapper;
import com.gx.test_demo.service.ICertificateTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * certificate_type 服务实现类
 * </p>
 *
 * @author Lucky
 * @since 2022-06-23
 */
@Service
public class CertificateTypeServiceImpl extends ServiceImpl<CertificateTypeMapper, CertificateType> implements ICertificateTypeService {


    private CertificateTypeMapper certificateTypeMapper;
    @Autowired
    public CertificateTypeServiceImpl(CertificateTypeMapper certificateTypeMapper) {
        this.certificateTypeMapper = certificateTypeMapper;
    }

    @Override
    public List<CertificateType> selectAllCertificateType() {
       List<CertificateType> selectAll=this.certificateTypeMapper.selectAll();

       return selectAll;
    }
}
