package sky.pro.java.course2.examinerservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import sky.pro.java.course2.examinerservice.domain.Question;
import sky.pro.java.course2.examinerservice.exceptions.MethodNotAllowedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    private final MathQuestionService out = new MathQuestionService();

    @ParameterizedTest
    @MethodSource("provideParamsForAddTest")
    void addTest(String question, String answer) {
        assertThatExceptionOfType(MethodNotAllowedException.class).isThrownBy(() -> out.add(question, answer));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    void findTest(Question question) {
        assertThatExceptionOfType(MethodNotAllowedException.class).isThrownBy(() -> out.find(question));
    }

    @ParameterizedTest
    @MethodSource("provideParamsForTests")
    void removeTest(Question question) {
        assertThatExceptionOfType(MethodNotAllowedException.class).isThrownBy(() -> out.remove(question));
    }

    @Test
    void getAllTest() {
        assertThatExceptionOfType(MethodNotAllowedException.class).isThrownBy(out::getAll);
    }

    @Test
    void getRandomQuestionTest() {
        List<Question> expected = new ArrayList<>(List.of(
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
        assertThat(out.getRandomQuestion()).isIn(expected);
    }

    public static Stream<Arguments> provideParamsForAddTest() {
        return Stream.of(
                Arguments.of("Как найти необходимый символ в строке?", "str.indexOf(char ch) или lastIndexOf(char c) — вернет индекс первого и последнего вхождения символа"),
                Arguments.of("Дайте определение понятию класс", "Класс – это шаблон, описывающий общие свойства группы объектов"),
                Arguments.of("Что такое поле/атрибут класса?", "Поле (атрибут) класса — это характеристика объекта")
        );
    }

    public static Stream<Arguments> provideParamsForTests() {
        return Stream.of(
                Arguments.of(new Question("Как найти необходимый символ в строке?", "str.indexOf(char ch) или lastIndexOf(char c) — вернет индекс первого и последнего вхождения символа")),
                Arguments.of(new Question("Дайте определение понятию класс", "Класс – это шаблон, описывающий общие свойства группы объектов")),
                Arguments.of(new Question("Что такое поле/атрибут класса?", "Поле (атрибут) класса — это характеристика объекта"))
        );
    }

}