package levelp.model;

import levelp.model.contacts.Contact;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 */
@Repository
@Transactional
public class ContactRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Contact save(Contact contact) {
        entityManager.persist(contact);
        return contact;
    }
}
