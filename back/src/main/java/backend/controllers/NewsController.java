package backend.controllers;

import backend.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("*")
public class NewsController {
    @Autowired
    NewsService newsService;
    @GetMapping("get-six-news")
    public ResponseEntity getFirstSixNews(){
        return ResponseEntity.ok(newsService.getFirstSixNews());
    }

    @GetMapping("get-all-news")
    public ResponseEntity getAllNews(){
        return ResponseEntity.ok(newsService.getAllNews());
    }

    @PostMapping("get-news-by-id")
    public ResponseEntity getNewsById(@RequestBody Map<String, Integer> map){
        return ResponseEntity.ok(newsService.getNewsById(map.get("id")));
    }
}
