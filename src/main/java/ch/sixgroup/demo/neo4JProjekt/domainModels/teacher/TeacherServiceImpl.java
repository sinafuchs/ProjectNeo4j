package ch.sixgroup.demo.neo4JProjekt.domainModels.teacher;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.NoSuchElementException;

public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher create(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        return (List<Teacher>) teacherRepository.findAll();
    }

    @Override
    public Teacher findById(int id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public Teacher updateById(int id, Teacher teacher) {
        if(teacherRepository.existsById(id)) {
            teacher.setId((long) id);
            teacherRepository.save(teacher);

            return teacher;
        } else {
            throw new NoSuchElementException("No value");
        }
    }

    @Override
    public void deleteById(int id) {
        teacherRepository.deleteById(id);
    }
}
