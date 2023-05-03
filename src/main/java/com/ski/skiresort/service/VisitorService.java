package com.ski.skiresort.service;

import com.ski.skiresort.domain.entity.Visitor;

import java.util.List;

public interface VisitorService {
    List<Visitor> findAll();
    Visitor save(Visitor theVisitor);
    void  deleteById(long theId);
    Visitor findById(long theId);
}
