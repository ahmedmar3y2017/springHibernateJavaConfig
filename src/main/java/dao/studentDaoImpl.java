package dao;

import Entities.student;
import org.hibernate.criterion.Projections;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ahmed on 5/27/2017.
 */
@Repository("studentDao")
public class studentDaoImpl extends AbstractDao implements studentDao {

    public List<student> getAllStudents() {
        return getAll();
    }
}
