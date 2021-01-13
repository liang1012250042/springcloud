package com.study.jwt01.mapper;

import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
