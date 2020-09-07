package co.uk.atlantis.dvsatestfinder.controller;

import co.uk.atlantis.dvsatestfinder.service.ExamFinderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/exams")
public class ExamFinderController {

    private ExamFinderService examFinderService;

    public ExamFinderController(ExamFinderService examFinderService) {
        this.examFinderService = examFinderService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Map<String, List<String>>> getAllExams() {
        log.info("");
        return ResponseEntity.ok(examFinderService.findAvailableTestDate());
    }


}
