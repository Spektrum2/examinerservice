package sky.pro.java.course2.examinerservice.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.java.course2.examinerservice.domain.Question;
import sky.pro.java.course2.examinerservice.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/math")
public class MathQuestionController {
    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestion") QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public Collection<Question> getQuestion() {
        return questionService.getAll();
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/find")
    public Question findQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question question1 = new Question(question, answer);
        return questionService.find(question1);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer) {
        Question question1 = new Question(question, answer);
        return questionService.remove(question1);
    }
}
