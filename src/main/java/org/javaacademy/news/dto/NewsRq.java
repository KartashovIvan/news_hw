package org.javaacademy.news.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class NewsRq {
    private String title;
    private String categoryName;
    private String content;
    private LocalDate date;
}
