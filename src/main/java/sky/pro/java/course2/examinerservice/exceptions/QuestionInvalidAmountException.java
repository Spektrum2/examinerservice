package sky.pro.java.course2.examinerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Не верно введено количество вопрос. Нужно вводить от 1 до 10")
public class QuestionInvalidAmountException extends RuntimeException {
}
