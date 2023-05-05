package com.ski.skiresort.controller;

import com.ski.skiresort.domain.entity.SkiPass;
import com.ski.skiresort.service.SkiPassService;
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
public class SkiPassController {
    private final SkiPassService skiPassService;

    @Autowired
    public SkiPassController(SkiPassService theSkiPassService) {
        skiPassService = theSkiPassService;
    }

    @GetMapping("/skiPass")
    public List<SkiPass> findAll() {
        return skiPassService.findAll();
    }

    @PostMapping("/skiPasses")
    public SkiPass addSkiPass(@RequestBody SkiPass theSkiPass) {
        SkiPass dbSkipass = skiPassService.save(theSkiPass);
        return dbSkipass;
    }

    @GetMapping("/skiPasses/{theId}")
    public SkiPass findById(@PathVariable long theId) {
        return skiPassService.findById(theId);
    }

    @PutMapping("/skiPasses")
    public SkiPass updateSkiPass(@RequestBody SkiPass theSkiPass) {
        SkiPass dbSkipass = skiPassService.save(theSkiPass);
        return dbSkipass;
    }

    @DeleteMapping("skiPasses/{skiPassId}")
    public String deleteSkiPass(@PathVariable long skiPassId) {
        SkiPass tempSkiPass = skiPassService.findById(skiPassId);
        if (tempSkiPass == null) {
            throw new RuntimeException("No coach with this id:" + skiPassId);
        }
        skiPassService.deleteById(skiPassId);
        return "Done, deleted visitor:" + tempSkiPass;
    }

}