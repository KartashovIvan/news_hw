package org.javaacademy.news.repository;

import org.javaacademy.news.entyti.News;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findAllByDate(LocalDate date);

    List<News> findAllByDateAndCategoryId(LocalDate date, Long categoryId);
}
