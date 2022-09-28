package sky.pro.java.course2.examinerservice.repository;

import org.springframework.stereotype.Repository;
import sky.pro.java.course2.examinerservice.domain.Question;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JavaQuestionRepository implements QuestionRepository {
    private final Set<Question> questions;

    public JavaQuestionRepository() {
        this.questions = new HashSet<>();
    }

    @Override
    @PostConstruct
    public void init() {
        questions.add(new Question(
                "Дайте определение понятию исключение",
                "Исключение — это проблема(ошибка) возникающая во время выполнения программы."));
        questions.add(new Question(
                "Какова роль и правила написания оператора выбора (switch)?",
                "Оператор switch сравнивает аргумент на равенство с предложенным значением. Обязательно необходимо ставить break; после завершения тело команды, иначе будет продолжаться выполнение ниже по строчкам."));
        questions.add(new Question(
                "Что вы знаете о функции main, какие обязательные условия ее определения?",
                "Метод main() — точка входа в программу. Может быть несколько методов main. Входные параметры — только массив строк. Если этого метода не будет, то компиляция возможна, но при запуске будет Error: Main method not found."));
        questions.add(new Question(
                "Могут ли нестатические методы перегрузить статические?",
                "Да. Это будут просто два разных метода для программы. Статический будет доступен по имени класса."));
        questions.add(new Question(
                "Как получить доступ к переопределенным методам родительского класса?",
                "super.method();"));
        questions.add(new Question(
                "Что значит слово инициализация?",
                "Инициализация — создание, активация, подготовка к работе, определение параметров."));
        questions.add(new Question(
                "Какими значениями инициализируются переменные по умолчанию?",
                "Числа инициализируются 0 или 0.0. Объекты (в том числе String) — null, char — u0000; boolean — false;"));
        questions.add(new Question(
                "Что такое таблица истинности?",
                "Таблица истинности — это таблица, описывающая логическую функцию."));
        questions.add(new Question(
                "О чем говорят ключевые слова “this”, “super”, где и как их можно использовать?",
                "super — используется для обращения к базовому классу, а this к текущему."));
        questions.add(new Question(
                "Может ли метод принимать разное количество параметров (аргументы переменной длины)?",
                "Да. Запись имеет вид method(type … val). Например public void method(String … strings), где strings это массив, т.е. можно записать"));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question find(Question question) {
        if (!questions.contains(question)) {
            return null;
        }
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new HashSet<>(questions);
    }
}
