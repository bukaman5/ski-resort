package com.ski.skiresort.service;

import com.ski.skiresort.domain.dto.VisitorCoachDto;
import com.ski.skiresort.domain.dto.VisitorSkiPassDto;
import com.ski.skiresort.domain.entity.Visitor;

import java.util.List;

public interface VisitorService {
    List<Visitor> findAll();

    Visitor save(Visitor theVisitor);

    void deleteById(long theId);

    Visitor findById(long theId);

    void addCoach(VisitorCoachDto dto);

    void addSkiPass(VisitorSkiPassDto dto);
}
