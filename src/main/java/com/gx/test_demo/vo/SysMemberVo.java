package com.gx.test_demo.vo;

import com.gx.test_demo.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SysMemberVo extends Member {
    //其他字段
    /**
     * 序号
     */
    private Integer sort;

    /**
     * 会员类型名称
     */
    private String memberTypeName;

    /**
     * 证件类型名称 certificate _type_id
     */
    private String certificateTypeName;



}
