package backend.controllers;

import backend.service.RegOnPracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("*")
public class RegOnPracticeController {
    @Autowired
    RegOnPracticeService regOnPracticeService;

    @GetMapping("get-all-reg-on-practice")
    public ResponseEntity getAllRegOnPractice(){
        return ResponseEntity.ok(regOnPracticeService.getAllRegOnPractice());
    }

    @PostMapping("reg-computer-on-practice")
    public ResponseEntity regComputerOnPractice(@RequestBody Map<String, Integer> map){
        regOnPracticeService.regComputerOnPractice(map.get("id"));
        return ResponseEntity.ok("ok");
    }
}
