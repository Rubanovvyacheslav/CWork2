package pro.sky.CWork2.service;

import org.springframework.stereotype.Service;
import pro.sky.CWork2.domain.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    Set<Question> questions = new HashSet<>();
//    public JavaQuestionService(){
//        questions.add(new Question("вопрос1", "ответ1"));
//        questions.add(new Question("вопрос2", "ответ2"));
//        questions.add(new Question("вопрос3", "ответ3"));
//        questions.add(new Question("вопрос4", "ответ4"));
//        questions.add(new Question("вопрос5", "ответ5"));
//        questions.add(new Question("вопрос6", "ответ6"));
//    }


    @Override
    public Question add(String question1, String answer1) {
        Question question = new Question(question1, answer1);
        questions.add(question);
        return question;
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
        List<Question> randomQuestion = new ArrayList<>(questions);
        Random random = new Random();
        int rand = random.nextInt(questions.size());
        return randomQuestion.get(rand);

    }
}
