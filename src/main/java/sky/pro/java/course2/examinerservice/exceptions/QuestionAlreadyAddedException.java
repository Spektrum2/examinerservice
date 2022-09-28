package sky.pro.java.course2.examinerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Вопрос Уже имеется в списке")
public class QuestionAlreadyAddedException extends RuntimeException {
}
