package dao;

import Entities.student;

import java.util.List;

/**
 * Created by ahmed on 5/27/2017.
 */
public interface studentDao {
//    void saveStudent(student student);
    List<student> getAllStudents();
}
