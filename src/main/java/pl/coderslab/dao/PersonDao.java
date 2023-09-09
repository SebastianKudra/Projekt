package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    private EntityManager entityManager;
    public void savePerson(User person) {entityManager.persist(person);}
    public String updatePerson (User person) {
        entityManager.merge(person);
        return "update date";
    }

    public User findByIdPerson(long id) {return entityManager.find(User.class, id);}

    public void removePerson(User person) {
        entityManager.remove(entityManager.contains(person) ? person:entityManager.merge(person));
    }

}
