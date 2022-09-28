package sky.pro.java.course2.examinerservice.service;

import sky.pro.java.course2.examinerservice.domain.Question;

import java.util.Collection;


public interface QuestionService {
    Question add(String question, String answer);

    Question find(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
