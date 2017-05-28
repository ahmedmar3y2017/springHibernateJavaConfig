package dao;

import Entities.student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractDao {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

//	public void persist(Object entity) {
//		getSession().persist(entity);
//	}
//
//	public void delete(Object entity) {
//		getSession().delete(entity);
//	}

    public List<student> getAll() {

//        return getSession().createCriteria(Entities.student.class).setProjection(Projections.projectionList()
//                .add(Projections.property("username"), "username")
//                .add(Projections.property("address"), "address")).setResultTransformer(Transformers.aliasToBean(Entities.student.class)).list();


        return getSession().createCriteria(student.class).list();
    }
}
