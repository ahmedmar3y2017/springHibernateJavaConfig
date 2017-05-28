package service;

import Entities.student;
import dao.studentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ahmed on 5/27/2017.
 */
@Service("studentService")
@Transactional
public class studentServiceImpl implements studentService {
    @Autowired
    private studentDao dao;

    public List<student> GetAllStudents() {
        return dao.getAllStudents();
    }
}
