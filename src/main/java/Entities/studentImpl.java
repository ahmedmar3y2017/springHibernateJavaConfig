package Entities;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ahmed on 5/24/2017.
 */
public class studentImpl implements studentDao {
    private SessionFactory sessionFactory;

    public studentImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Transactional
    public List<student> list() {
        @SuppressWarnings("unchecked")
        List<student> listUser = (List<student>) sessionFactory.getCurrentSession()
                .createCriteria(student.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return listUser;
    }
}
