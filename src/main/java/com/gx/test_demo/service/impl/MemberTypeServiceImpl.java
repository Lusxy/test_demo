package com.gx.test_demo.service.impl;

import com.gx.test_demo.entity.MemberType;
import com.gx.test_demo.mapper.MemberTypeMapper;
import com.gx.test_demo.service.IMemberTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 会员类型 服务实现类
 * </p>
 *
 * @author Lucky
 * @since 2022-06-23
 */
@Service
public class MemberTypeServiceImpl extends ServiceImpl<MemberTypeMapper, MemberType> implements IMemberTypeService {

    private MemberTypeMapper memberType;
    @Autowired
    public MemberTypeServiceImpl(MemberTypeMapper memberType) {
        this.memberType = memberType;
    }







    @Override
    public List<MemberType> selectAllMemberType() {



        return this.memberType.selectAll();
    }
}
