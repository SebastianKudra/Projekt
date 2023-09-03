package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonDao {
    @PersistenceContext
    private EntityManager entityManager;
    public void savePerson(Person person) {entityManager.persist(person);}
    public String updatePerson (Person person) {
        entityManager.merge(person);
        return "update date";
    }

    public Person findByIdPerson(long id) {return entityManager.find(Person.class, id);}

    public void removePerson(Person person) {
        entityManager.remove(entityManager.contains(person) ? person:entityManager.merge(person));
    }

}
