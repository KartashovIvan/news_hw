package org.javaacademy.news.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
public class CategoryRs {
    private String name;
    @EqualsAndHashCode.Exclude
    private List<NewsRs> news;
}
