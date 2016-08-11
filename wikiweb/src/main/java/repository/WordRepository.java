package repository;

import model.Cuvant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by azburatura on 8/11/2016.
 */
@Repository
public class WordRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public void saveWord(Cuvant cuvant) {
        entityManager.persist(cuvant);
    }

}
