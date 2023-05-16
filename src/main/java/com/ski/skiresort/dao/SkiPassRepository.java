package com.ski.skiresort.dao;

import com.ski.skiresort.domain.entity.SkiPass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkiPassRepository extends JpaRepository<SkiPass, Long> {
}
