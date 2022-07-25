package com.gx.test_demo.mapper;

import com.gx.test_demo.entity.CertificateType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * certificate_type Mapper 接口
 * </p>
 *
 * @author Lucky
 * @since 2022-06-23
 */
@Repository
public interface CertificateTypeMapper extends BaseMapper<CertificateType> {

    @Select("SELECT * FROM certificate_type")
    List<CertificateType> selectAll();
}
