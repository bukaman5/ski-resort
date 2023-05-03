package com.ski.skiresort.dao;

import com.ski.skiresort.domain.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitorRepository extends JpaRepository<Visitor, Long>, VisitorRepositoryCustom {
}
