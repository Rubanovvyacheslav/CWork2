package pro.sky.CWork2.service;

import pro.sky.CWork2.domain.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
