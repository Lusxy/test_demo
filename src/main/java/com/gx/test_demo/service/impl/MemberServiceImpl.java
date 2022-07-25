package com.gx.test_demo.service.impl;

import com.gx.test_demo.entity.Member;
import com.gx.test_demo.mapper.MemberMapper;
import com.gx.test_demo.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gx.test_demo.vo.SysMemberVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 会员 服务实现类
 * </p>
 *
 * @author Lucky
 * @since 2022-06-23
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member>
        implements IMemberService {


    private MemberMapper memberMapper;
    @Autowired
    public MemberServiceImpl(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @Override
    public List<SysMemberVo> selectVoData() {

        List<SysMemberVo> SysMemberVo=this.memberMapper.selectVoData();

           return SysMemberVo;
    }



    @Override
    public int addMember(Member member) {

        return this.memberMapper.insert(member);
    }

    @Override
    public SysMemberVo selectById(Integer id) {
        return this.memberMapper.selectData(id);
    }

    @Override
    public int updateMember(Member member) {

        return this.memberMapper.updateData(member);
    }

    @Override
    public int deleteMember(Integer id) {
          int into=this.memberMapper.deleteData(id);
        return into;
    }
}
