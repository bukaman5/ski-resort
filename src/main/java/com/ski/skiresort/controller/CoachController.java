package com.ski.skiresort.controller;

import com.ski.skiresort.domain.dto.CoachSkiPassDto;
import com.ski.skiresort.domain.entity.Coach;
import com.ski.skiresort.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CoachController {
    private CoachService coachService;

    @Autowired
    public CoachController(CoachService theCoachService) {
        coachService = theCoachService;
    }

    @GetMapping("/coach")
    public List<Coach> findAll() {
        return coachService.findAll();
    }

    @PostMapping("/coaches")
    public Coach addCoach(@RequestBody Coach theCoach) {
        Coach dbCoach = coachService.save(theCoach);
        return dbCoach;
    }

    @GetMapping("/coaches/{theId}")
    public Coach findById(@PathVariable long theId) {
        return coachService.findById(theId);
    }

    @PutMapping("/coaches")
    public Coach updateCoach(@RequestBody Coach theCoach) {
        Coach dbCoach = coachService.save(theCoach);
        return dbCoach;
    }

    @DeleteMapping("coaches/{coachId}")
    public String deleteCoach(@PathVariable long coachId) {
        Coach tempCoach = coachService.findById(coachId);
        if (tempCoach == null) {
            throw new RuntimeException("No coach with this id:" + coachId);
        }
        coachService.deleteById(coachId);
        return "Done, deleted visitor:" + tempCoach;
    }

    @PostMapping("coaches/addSkiPass")
    public void addSkiPass(@RequestBody CoachSkiPassDto dto) {
        coachService.addSkiPass(dto);
    }


}