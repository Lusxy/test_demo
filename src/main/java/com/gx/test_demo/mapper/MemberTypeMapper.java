package com.gx.test_demo.mapper;

import com.gx.test_demo.entity.MemberType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 会员类型 Mapper 接口
 * </p>
 *
 * @author Lucky
 * @since 2022-06-23
 */
@Repository
public interface MemberTypeMapper extends BaseMapper<MemberType> {

    @Select("SELECT * FROM member_type")
    List<MemberType> selectAll();
}
