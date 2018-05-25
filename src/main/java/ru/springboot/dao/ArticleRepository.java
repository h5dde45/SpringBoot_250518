package ru.springboot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.springboot.model.Article;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Integer> {
}
