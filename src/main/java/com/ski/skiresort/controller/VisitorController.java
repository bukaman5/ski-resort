package com.ski.skiresort.controller;

import com.ski.skiresort.domain.entity.Visitor;
import com.ski.skiresort.service.VisitorService;
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
public class VisitorController {
    private VisitorService visitorService;

    @Autowired
    public VisitorController(VisitorService theVisitorService) {
        visitorService = theVisitorService;
    }

    @GetMapping("/visitor")
    public List<Visitor> findAll() {
        return visitorService.findAll();
    }
    @PostMapping("/visitors")
    public Visitor addVisitor(@RequestBody Visitor theVisitor){
        theVisitor.setId(0);
        Visitor dbVisitor = visitorService.save(theVisitor);
        return dbVisitor;
    }
    @GetMapping("/visitors/{theId}")
    public Visitor findById(@PathVariable long theId){
        return visitorService.findById(theId);
    }
    @PutMapping("/visitors")
    public Visitor updateVisitor(@RequestBody Visitor theVisitor){
        Visitor dbVisitor = visitorService.save(theVisitor);
        return dbVisitor;
    }
    @DeleteMapping("visitors/{visitorId}")
    public String deleteVisitor(@PathVariable long visitorId){
        Visitor tempVisitor = visitorService.findById(visitorId);
        if(tempVisitor==null){
            throw new RuntimeException("No visitor with this id:" + visitorId);
        }
         visitorService.deleteById(visitorId);
        return "Done, deleted visitor:" + tempVisitor;
    }
}
