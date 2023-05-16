package com.ski.skiresort.service;

import com.ski.skiresort.dao.SkiPassRepository;
import com.ski.skiresort.domain.entity.SkiPass;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkiPassServiceImpl implements SkiPassService {
    private final SkiPassRepository skiPassRepository;


    @Override
    public List<SkiPass> findAll() {
        return skiPassRepository.findAll();
    }

    @Override
    public SkiPass save(SkiPass theSkiPass) {
        return skiPassRepository.save(theSkiPass);
    }

    @Override
    public void deleteById(long theId) {
        skiPassRepository.deleteById(theId);
    }

    @Override
    public SkiPass findById(long theId) {
        Optional<SkiPass> result = skiPassRepository.findById(theId);
        SkiPass theSkiPass;
        if (result.isPresent()) {
            theSkiPass = result.get();
        } else {
            throw new RuntimeException("Didnt find skipass with id" + theId);
        }
        return theSkiPass;
    }
}
