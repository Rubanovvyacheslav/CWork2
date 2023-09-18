package pro.sky.CWork2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.CWork2.domain.Question;
import pro.sky.CWork2.exception.QuestionNotFoundException;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {

    private QuestionService out;

    @BeforeEach
    void beforeEach() {
        out = new JavaQuestionService();
        out.add(new Question("вопрос1", "ответ1"));
        out.add(new Question("вопрос2", "ответ2"));
        out.add(new Question("вопрос3", "ответ3"));
    }

    @Test
    void testAdd() {
        Set<Question> expected = new HashSet<>();
        expected.add(new Question("вопрос1", "ответ1"));
        expected.add(new Question("вопрос2", "ответ2"));
        expected.add(new Question("вопрос3", "ответ3"));
        assertEquals(expected, out.getAll());
    }

    @Test
    void testAddDuplicate() {
        Set<Question> expected = new HashSet<>();
        expected.add(new Question("вопрос1", "ответ1"));
        expected.add(new Question("вопрос2", "ответ2"));
        expected.add(new Question("вопрос3", "ответ3"));
        expected.add(new Question("вопрос3", "ответ3"));
        assertEquals(expected, out.getAll());
    }

    @Test
    void testRemove() {
        Set<Question> expected = new HashSet<>();
        expected.add(new Question("вопрос1", "ответ1"));
        expected.add(new Question("вопрос2", "ответ2"));
        out.remove(new Question("вопрос3", "ответ3"));
        assertEquals(expected, out.getAll());
    }


    @Test
    void testGetAll() {
        Set<Question> expected = new HashSet<>();
        expected.add(new Question("вопрос1", "ответ1"));
        expected.add(new Question("вопрос2", "ответ2"));
        expected.add(new Question("вопрос3", "ответ3"));
        assertEquals(expected, out.getAll());

    }

    @Test
    void testGetRandomQuestionWhenEmpty() {
        out.remove(new Question("вопрос1", "ответ1"));
        out.remove(new Question("вопрос2", "ответ2"));
        out.remove(new Question("вопрос3", "ответ3"));
        assertThrows(QuestionNotFoundException.class, () -> out.getRandomQuestion());
    }

    @Test
    void testGetRandomQuestion() {
        assertTrue(out.getAll().contains(out.getRandomQuestion()));
    }
}