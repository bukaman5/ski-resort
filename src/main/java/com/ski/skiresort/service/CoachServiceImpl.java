package com.ski.skiresort.service;

import com.ski.skiresort.dao.CoachRepository;
import com.ski.skiresort.domain.dto.CoachSkiPassDto;
import com.ski.skiresort.domain.entity.Coach;
import com.ski.skiresort.domain.entity.SkiPass;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoachServiceImpl implements CoachService {
    private final CoachRepository coachRepository;
    private final SkiPassService skiPassService;


    @Override
    public List<Coach> findAll() {
        return coachRepository.findAll();
    }

    @Override
    public Coach save(Coach theCoach) {
        return coachRepository.save(theCoach);
    }

    @Override
    public void deleteById(long theId) {
        coachRepository.deleteById(theId);
    }

    @Override
    public Coach findById(long theId) {
        Optional<Coach> result = coachRepository.findById(theId);
        Coach theCoach;
        if (result.isPresent()) {
            theCoach = result.get();
        } else {
            throw new RuntimeException("Didnt find coach with id" + theId);
        }
        return theCoach;
    }

    @Transactional
    @Override
    public void addSkiPass(CoachSkiPassDto dto) {
        Coach coach = findById(dto.getCoachId());
        SkiPass skiPass = skiPassService.findById(dto.getSkiPassId());
        coach.getSkiPasses().add(skiPass);
        Coach coach1 = coachRepository.save(coach);
    }
}
