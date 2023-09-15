package pro.sky.CWork2.service;

import org.junit.jupiter.api.Test;
import pro.sky.CWork2.domain.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService = new JavaQuestionService();
    Question question1 = new Question("вопрос1", "ответ1");
    Question question2 = new Question("вопрос2", "ответ2");
    Question question3 = new Question("вопрос3", "ответ3");

    @Test
    void add() {
        javaQuestionService.add("вопрос1", "ответ1");
        Set<Question> actual = (Set<Question>) javaQuestionService.getAll();
        Set<Question> expected = new HashSet<>();
        expected.add(question1);
        assertEquals(actual, expected);
    }

    @Test
    void addStringCorrectTest() {
        Question actual = javaQuestionService.add("вопрос1", "ответ1");
        assertEquals(true, javaQuestionService.getAll().contains(question1));
    }

    @Test
    void remove() {
        javaQuestionService.add("вопрос1", "ответ1");
        javaQuestionService.add("вопрос2", "ответ2");
        javaQuestionService.remove(new Question("вопрос1", "ответ1"));
        Set<Question> actual = (Set<Question>) javaQuestionService.getAll();
        Set<Question> expected = new HashSet<>();
        expected.add(question2);
        assertEquals(actual, expected);
    }

    @Test
    void getAll() {
        javaQuestionService.add("вопрос1", "ответ1");
        javaQuestionService.add("вопрос2", "ответ2");
        javaQuestionService.add("вопрос3", "ответ3");
        Set<Question> actual = (Set<Question>) javaQuestionService.getAll();
        Set<Question> expected = new HashSet<>();
        expected.add(question1);
        expected.add(question2);
        expected.add(question3);
        assertEquals(actual, expected);
    }

    @Test
    void getRandomQuestion() {
    }
}