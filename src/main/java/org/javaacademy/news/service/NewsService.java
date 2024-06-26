package org.javaacademy.news.service;

import lombok.AllArgsConstructor;
import org.javaacademy.news.dto.*;
import org.javaacademy.news.entyti.*;
import org.javaacademy.news.mapper.*;
import org.javaacademy.news.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.*;

@Service
@AllArgsConstructor
public class NewsService {
    private CategoryRepository categoryRepository;
    private NewsRepository newsRepository;
    private NewsMapper newsMapper;
    private CategoryMapper categoryMapper;

    @Transactional
    public void createNews(NewsRq news) {
        Category category = categoryRepository.findByName(news.getCategoryName())
                .orElse(categoryMapper.convertToEntity(news));
        News newNews = newsMapper.convertToNewsEntity(news);
        newNews.setCategory(category);
        newsRepository.save(newNews);
    }

    @Transactional(readOnly = true)
    public List<CategoryRs> tateTodayNews() {
        List<News> allNewByDate = newsRepository.findAllByDate(LocalDate.now());
        return parsToListCategoryRs(allNewByDate);
    }

    @Transactional(readOnly = true)
    public List<CategoryRs> getCategoryByDate(String categoryName, LocalDate date) {
        Category category = categoryRepository.findByName(categoryName).orElseThrow();
        List<News> allNewsByCategory = newsRepository.findAllByDateAndCategoryId(date, category.getId());
        return parsToListCategoryRs(allNewsByCategory);
    }

    private List<CategoryRs> parsToListCategoryRs(List<News> allNewByDate) {
        List<CategoryRs> list = new ArrayList<>();
        for (News news : allNewByDate) {
            CategoryRs categoryRs = categoryMapper.convertToCategoryRs(news.getCategory());
            NewsRs newsRs = newsMapper.toNewsRs(news);
            if (!list.contains(categoryRs)) {
                list.add(categoryRs);
                categoryRs.setNews(new ArrayList<>());
                categoryRs.getNews().add(newsRs);
            } else {
                CategoryRs existCategory = list.get(list.indexOf(categoryRs));
                existCategory.getNews().add(newsRs);
            }
        }
        return list;
    }
}
