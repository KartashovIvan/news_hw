package org.javaacademy.news.mapper;

import org.javaacademy.news.dto.CategoryRs;
import org.javaacademy.news.dto.NewsRq;
import org.javaacademy.news.entyti.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "name", source = "categoryName")
    Category convertToEntity(NewsRq newsRq);

    @Mapping(target = "news", source = "news", ignore = true)
    CategoryRs convertToCategoryRs(Category category);

}
