package sky.pro.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import sky.pro.java.course2.examinerservice.domain.Question;
import sky.pro.java.course2.examinerservice.exceptions.QuestionInvalidAmountException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> questionServices;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService, MathQuestionService mathQuestionService) {
        this.questionServices = new ArrayList<>(List.of(javaQuestionService, mathQuestionService));
    }

    private final Random random = new Random();

    @Override
    public Collection<Question> getQuestions(int amount) {
        Set<Question> questions = new HashSet<>();
        Set<Question> questionsMath = new HashSet<>();
        int countJava;
        int countMath;
        if (amount < 1 || amount > 10) {
            throw new QuestionInvalidAmountException();
        }
        if (amount == 1) {
            questions.add(questionServices.get(random.nextInt(2)).getRandomQuestion());
            return questions;
        }
        countJava = random.nextInt(amount - 1) + 1;
        countMath = amount - countJava;
        while (questions.size() != countJava) {
            questions.add(questionServices.get(0).getRandomQuestion());
        }
        while (questionsMath.size() != countMath) {
            questionsMath.add(questionServices.get(1).getRandomQuestion());
        }
        questions.addAll(questionsMath);
        return questions;
    }
}
