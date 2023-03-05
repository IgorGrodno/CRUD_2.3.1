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
   public void delete(User user) {
      entityManager.remove(user);
   }

   @Override
   public void edit(User user) {

   }


}
