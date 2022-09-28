package sky.pro.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import sky.pro.java.course2.examinerservice.domain.Question;
import sky.pro.java.course2.examinerservice.exceptions.QuestionAlreadyAddedException;
import sky.pro.java.course2.examinerservice.exceptions.QuestionAnswerSameException;
import sky.pro.java.course2.examinerservice.exceptions.QuestionNotFoundException;
import sky.pro.java.course2.examinerservice.repository.JavaQuestionRepository;

import java.util.*;

@Service("javaQuestion")
public class JavaQuestionService implements QuestionService {

    private final JavaQuestionRepository javaQuestionRepository;

    private final Random random = new Random();

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question question1 = new Question(question, answer);
        if (question.equals(answer)) {
            throw new QuestionAnswerSameException();
        }
        if (javaQuestionRepository.getAll().contains(question1)) {
            throw new QuestionAlreadyAddedException();
        }

        return javaQuestionRepository.add(question1);
    }

    @Override
    public Question find(Question question) {
        if (!javaQuestionRepository.getAll().contains(question)) {
            throw new QuestionNotFoundException();
        }
        return javaQuestionRepository.find(question);
    }

    @Override
    public Question remove(Question question) {
        if (!javaQuestionRepository.getAll().contains(question)) {
            throw new QuestionNotFoundException();
        }
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questions = new ArrayList<>(javaQuestionRepository.getAll());
        return javaQuestionRepository.find(questions.get(random.nextInt(questions.size())));
    }
}
