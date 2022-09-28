package sky.pro.java.course2.examinerservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import sky.pro.java.course2.examinerservice.domain.Question;
import sky.pro.java.course2.examinerservice.exceptions.QuestionInvalidAmountException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;
    @InjectMocks
    private ExaminerServiceImpl out;

    @Test
    void getQuestionsTest() {
        Set<Question> expected = new HashSet<>(Set.of(
                new Question("Hello", "World"),
                new Question("Bay", "Friend")
        ));
        Question question = new Question("Hello", "World");
        Question question2 = new Question("Bay", "Friend");

        when(javaQuestionService.getRandomQuestion()).thenReturn(question);
        when(mathQuestionService.getRandomQuestion()).thenReturn(question2);
        List<Question> actual = new ArrayList<>(out.getQuestions(1));
        assertThat(actual.get(0)).isIn(expected);
        assertThat(out.getQuestions(2)).containsExactlyInAnyOrderElementsOf(expected);
    }

    @Test
    void shouldThrowExceptions() {
        assertThatExceptionOfType(QuestionInvalidAmountException.class).isThrownBy(() -> out.getQuestions(-1));
        assertThatExceptionOfType(QuestionInvalidAmountException.class).isThrownBy(() -> out.getQuestions(11));
    }
}