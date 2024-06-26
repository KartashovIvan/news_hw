package org.javaacademy.news.controller;

import lombok.AllArgsConstructor;
import org.javaacademy.news.dto.CategoryRs;
import org.javaacademy.news.dto.NewsRq;
import org.javaacademy.news.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class NewsController {
    private NewsService newsService;

    @PostMapping("/create")
    public ResponseEntity<?> createNews(@RequestBody NewsRq news) {
        newsService.createNews(news);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/todayNews")
    public ResponseEntity<List<CategoryRs>> takeTodayNews() {
        return ResponseEntity.ok(newsService.tateTodayNews());
    }

    @GetMapping
    public ResponseEntity<List<CategoryRs>> takeCategoryByDate(@RequestParam String catName,
                                                               @RequestParam String date) {
        return ResponseEntity.ok(newsService.getCategoryByDate(catName, LocalDate.parse(date)));
    }
}
