package org.javaacademy.news.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CategoryRq {
    private String name;
    private LocalDate date;
}
