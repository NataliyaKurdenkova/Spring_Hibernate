package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public Optional<User> getUserByCarModelAndSeries(int carSeries, String model) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("from User where car.series = :carSeries and car.model = :model");
        query.setParameter("carSeries", carSeries);
        query.setParameter("model", model);
        return Optional.of((User) query.getSingleResult());
    }


}
