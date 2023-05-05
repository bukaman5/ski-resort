package com.ski.skiresort.service;

import com.ski.skiresort.dao.VisitorRepository;
import com.ski.skiresort.domain.dto.VisitorCoachDto;
import com.ski.skiresort.domain.dto.VisitorSkiPassDto;
import com.ski.skiresort.domain.entity.Coach;
import com.ski.skiresort.domain.entity.SkiPass;
import com.ski.skiresort.domain.entity.Visitor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VisitorServiceImpl implements VisitorService {
    private final VisitorRepository visitorRepository;
    private final CoachService coachService;
    private final SkiPassService skiPassService;


    @Override
    public List<Visitor> findAll() {
        return visitorRepository.findAll();
    }

    @Override
    public Visitor save(Visitor theVisitor) {
        return visitorRepository.save(theVisitor);
    }

    @Override
    public void deleteById(long theId) {
        visitorRepository.deleteById(theId);
    }

    @Override
    public Visitor findById(long theId) {
        Optional<Visitor> result = visitorRepository.findById(theId);
        Visitor theVisitor;
        if (result.isPresent()) {
            theVisitor = result.get();
        } else {
            throw new RuntimeException("Didnt find visitor id" + theId);
        }
        return theVisitor;
    }

    @Transactional
    @Override
    public void addCoach(VisitorCoachDto dto) {
        Visitor visitor = findById(dto.getVisitorId());
        Coach coach = coachService.findById(dto.getCoachId());
        visitor.getCoaches().add(coach);
        Visitor visitor1 = visitorRepository.save(visitor);
    }

    @Transactional
    @Override
    public void addSkiPass(VisitorSkiPassDto dto) {
        Visitor visitor = findById(dto.getVisitorId());
        SkiPass skiPass = skiPassService.findById(dto.getSkiPassId());
        visitor.getSkiPasses().add(skiPass);
        Visitor visitor1 = visitorRepository.save(visitor);

    }
}
