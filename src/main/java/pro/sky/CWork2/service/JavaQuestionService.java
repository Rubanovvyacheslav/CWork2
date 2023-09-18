package pro.sky.CWork2.service;

import org.springframework.stereotype.Service;
import pro.sky.CWork2.domain.Question;
import pro.sky.CWork2.exception.QuestionNotFoundException;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private final Random random = new Random();
    private final Set<Question> questions = new HashSet<>();


    @Override
    public Question add(String question1, String answer1) {
        return add(new Question(question1, answer1));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            throw new QuestionNotFoundException();
        }
        List<Question> randomQuestion = new ArrayList<>(questions);
        int rand = random.nextInt(questions.size());
        return randomQuestion.get(rand);

    }
}
