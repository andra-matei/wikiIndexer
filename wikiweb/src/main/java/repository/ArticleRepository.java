package repository;

import model.Article;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by azburatura on 8/11/2016.
 */
@Repository
public class ArticleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveArticle(Article article) {
        entityManager.persist(article);
    }

    public void updateArticle(Article article){
        entityManager.merge(article);
    }

}
