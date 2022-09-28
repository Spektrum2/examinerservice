package sky.pro.java.course2.examinerservice.repository;

import sky.pro.java.course2.examinerservice.domain.Question;

import java.util.Collection;

public interface QuestionRepository {
    void init();

    Question add(Question question);

    Question find(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
