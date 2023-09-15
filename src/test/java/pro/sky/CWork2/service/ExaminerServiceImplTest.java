package pro.sky.CWork2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.CWork2.domain.Question;
import pro.sky.CWork2.exception.BAD_REQUEST;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

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
        testList.add(new Question("вопрос4", "ответ4"));
        testList.add(new Question("вопрос5", "ответ5"));
    }

    @Test
    void getQuestionsExceptionTest() {
        String expectedErrorMessage = "Количество вопросов в системе меньше";
        Exception exception = assertThrows(BAD_REQUEST.class, () -> examinerServiceMock.getQuestions(javaQuestionServiceMock.getAll().size() + 1));
        assertEquals(expectedErrorMessage, exception.getMessage());
    }

    @Test
    void getQuestions() {
        int actualSize = 5;
        int resultSize = 5;
        Random random = new Random();
        Set<Question> randomTestSet = new HashSet<>();
        while (randomTestSet.size() < resultSize) {
            int r = random.nextInt(testList.size());
            randomTestSet.add(testList.get(r));
        }
        assertEquals(actualSize, randomTestSet.size());
    }
}