package com.template.springboot.service.city;

import com.template.springboot.mapper.city.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityService {

    @Autowired
    CityMapper cityMapper;
}
