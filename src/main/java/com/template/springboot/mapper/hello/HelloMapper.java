package com.template.springboot.mapper.hello;

import com.template.springboot.domain.hello.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HelloMapper {
    City selectCityById(Long id);
    List<City> selectAllCity();
    void insertCity(City city);
}
