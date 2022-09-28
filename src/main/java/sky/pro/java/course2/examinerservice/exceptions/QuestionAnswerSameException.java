package sky.pro.java.course2.examinerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Вопрос и ответ совпадают")
public class QuestionAnswerSameException extends RuntimeException {
}
