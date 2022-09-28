package sky.pro.java.course2.examinerservice.service;

import org.springframework.stereotype.Service;
import sky.pro.java.course2.examinerservice.domain.Question;
import sky.pro.java.course2.examinerservice.exceptions.MethodNotAllowedException;

import java.util.*;

@Service("mathQuestion")
public class MathQuestionService implements QuestionService {
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
      throw new MethodNotAllowedException();
    }

    @Override
    public Question find(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question remove(Question question) {
        throw new MethodNotAllowedException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questionsRandom = new ArrayList<>(List.of(
                new Question("Решить двойное неравенство 4 < 3 - 2x <= 9", "[-3; -0.5)"),
                new Question("Найти значение выражения (m + n)² - 3n, если m = 1/6, n = 1/3", "-3/4"),
                new Question("Решить уравнение 2(x - 3) + 3x = 4", "x = 2"),
                new Question("Упростить выражение 7a + 23 + 2(-4a + 1)", "-a + 25"),
                new Question("Вычислить 4 * (-5)³ + 8 * 0.5", "–496"),
                new Question("Выполнить умножение 2a²b(-5b² + 2ab)", "-10a²b³ + 4a³b²"),
                new Question("Упростить выражение 5x(x² + 4x - 2) - 2x²(3x - 1)", "-x³ + 22x² - 10x"),
                new Question("Решить уравнение 2x(2x + 3) - 7 = 4x² - 4", "x = 0.5"),
                new Question("Выполнить умножение (2a + b - 3c) * (-4a)", "-8a² - 4ab + 12ac"),
                new Question("Разложить на множители многочлен -2a²b - 8a²b² + 10ab²", "-2ab(a + 4ab - 5b)")
        ));
        int pos = random.nextInt(questionsRandom.size());
        return questionsRandom.get(pos);
    }
}
