package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   EntityManager entityManager;

   @Override
   public void add(User user) {
      entityManager.persist(user);;
   }

   @Override
   public List<User> listUsers() {
      return entityManager.createQuery("from User").getResultList();
   }

   @Override
   public void delete(long id) {
      entityManager.remove(getUser(id));
   }

   @Override
   public void edit(User user) {
      User userToEdit = getUser(user.getId());
      userToEdit.setEmail(user.getEmail());
      userToEdit.setFirstName(user.getFirstName());
      userToEdit.setLastName(user.getLastName());
      entityManager.merge(userToEdit);
   }

   @Override
   public User getUser(long id) {
      return entityManager.find(User.class, id);
   }


}
