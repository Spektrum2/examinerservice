package sky.pro.java.course2.examinerservice.service;

import sky.pro.java.course2.examinerservice.domain.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
