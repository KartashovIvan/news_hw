package org.javaacademy.news.mapper;

import org.javaacademy.news.dto.NewsRq;
import org.javaacademy.news.dto.NewsRs;
import org.javaacademy.news.entyti.News;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NewsMapper {
    News convertToNewsEntity(NewsRq newsRq);

    NewsRs toNewsRs (News news);
}
