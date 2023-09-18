package pro.sky.CWork2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.CWork2.domain.Question;
import pro.sky.CWork2.exception.BadRequestException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl examinerServiceMock;

    List<Question> testList = new ArrayList<>();

    @BeforeEach
    void addTest() {
        testList.add(new Question("вопрос1", "ответ1"));
        testList.add(new Question("вопрос2", "ответ2"));
        testList.add(new Question("вопрос3", "ответ3"));
    }

    @Test
    void testGetQuestionsException() {
        when(javaQuestionServiceMock.getAll()).thenReturn(testList);
        assertThrows(BadRequestException.class, () -> examinerServiceMock.getQuestions(javaQuestionServiceMock.getAll().size() + 1));
    }


    @Test
    void testGetQuestions() {
        when(javaQuestionServiceMock.getAll()).thenReturn(testList);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(
                new Question("вопрос1", "ответ1"),
                new Question("вопрос1", "ответ1"),
                new Question("вопрос2", "ответ2"),
                new Question("вопрос2", "ответ2"),
                new Question("вопрос3", "ответ3"));
        assertIterableEquals(testList, examinerServiceMock.getQuestions(3));

    }

}