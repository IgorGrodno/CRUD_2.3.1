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
      entityManager.persist(user);
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
   public void edit(User user, Long id) {
      User existingUser = entityManager.find(User.class, id);
      if (existingUser != null) {
         existingUser.setFirstName(user.getFirstName());
         existingUser.setLastName(user.getLastName());
         existingUser.setEmail(user.getEmail());
         entityManager.merge(existingUser);
      }
   }

   @Override
   public User getUser(long id) {
      return entityManager.find(User.class, id);
   }


}
