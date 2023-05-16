package com.ski.skiresort.service;

import com.ski.skiresort.domain.entity.SkiPass;

import java.util.List;

public interface SkiPassService {

    List<SkiPass> findAll();

    SkiPass save(SkiPass theSkiPass);

    void deleteById(long theId);

    SkiPass findById(long theId);

}
