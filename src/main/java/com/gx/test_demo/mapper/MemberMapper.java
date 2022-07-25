package com.gx.test_demo.mapper;

import com.gx.test_demo.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gx.test_demo.vo.SysMemberVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 会员 Mapper 接口
 * </p>
 *
 * @author Lucky
 * @since 2022-06-23
 */

@Repository
public interface MemberMapper extends BaseMapper<Member> {

List<SysMemberVo> selectVoData();

SysMemberVo selectData(Integer id);

    @Delete("DELETE  FROM member WHERE member_id=#{id}")
    int deleteData(Integer id);

    int updateData(Member member);
}
