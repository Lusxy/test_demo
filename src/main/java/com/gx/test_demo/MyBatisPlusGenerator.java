package com.gx.test_demo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MyBatisPlusGenerator {
    public static void main(String[] args) {
        String url="jdbc:mysql://127.0.0.1:3306/test20220623?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=GMT%2b8&allowPublicKeyRetrieval=true";

        FastAutoGenerator.create(url, "root", "root")
                .globalConfig(builder -> {
                    builder.author("Lucky") // 设置作者
                            // .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\gerener"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.gx.test_demo") // 设置父包名
                            // .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "E:\\gerener\\xml")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    // builder.addInclude("t_simple") // 设置需要生成的表名
                    //         .addTablePrefix("t_", "c_"); // 设置过滤表前缀
                    builder.addTablePrefix("");
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
