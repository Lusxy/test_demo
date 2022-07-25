package com.gx.test_demo.service;

import com.gx.test_demo.entity.Member;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gx.test_demo.vo.SysMemberVo;

import java.util.List;

/**
 * <p>
 * 会员 服务类
 * </p>
 *
 * @author Lucky
 * @since 2022-06-23
 */
public interface IMemberService extends IService<Member> {

    List<SysMemberVo> selectVoData();

    int addMember(Member member);

    SysMemberVo selectById(Integer id);

    int updateMember(Member member);

    int deleteMember(Integer id);
}
