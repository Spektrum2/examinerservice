package sky.pro.java.course2.examinerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Вопрос не найден")
public class QuestionNotFoundException extends RuntimeException{
}
