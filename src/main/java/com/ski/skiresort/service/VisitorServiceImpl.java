package com.ski.skiresort.service;

import com.ski.skiresort.dao.VisitorRepository;
import com.ski.skiresort.domain.entity.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VisitorServiceImpl implements VisitorService {
    private VisitorRepository visitorRepository;

    @Autowired
    public VisitorServiceImpl(VisitorRepository theVisitorRepository) {
        visitorRepository = theVisitorRepository;
    }

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
            throw new RuntimeException("Didnt find visitor id0" + theId);
        }
        return theVisitor;
    }
}
