package com.gx.test_demo.service;

import com.gx.test_demo.entity.MemberType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 会员类型 服务类
 * </p>
 *
 * @author Lucky
 * @since 2022-06-23
 */
public interface IMemberTypeService extends IService<MemberType> {
    List<MemberType> selectAllMemberType();
}
