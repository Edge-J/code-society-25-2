package com.example.lesson02;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.codedifferently.instructional.quiz.QuizQuestion;

public class Lesson2Test {

    @Test
    void answersAreProvided() {
        List<QuizQuestion> quiz = Lesson2.quiz();

        assertNotNull(quiz, "quiz list is null");
        assertFalse(quiz.isEmpty(), "quiz should not be empty");

        for (QuizQuestion q : quiz) {
            // Use the actual API from the instructional-lib
            assertTrue(q.getQuestionNumber() > 0, "question number is invalid");
            assertNotNull(q.getQuestionPrompt(), "prompt is null");
            assertFalse(q.getQuestionPrompt().isBlank(), "prompt is blank");

            String ans = q.getAnswer(); // returns "" if null
            assertNotNull(ans, "answer is null");
            assertFalse(ans.isBlank(), "answer is blank");
            assertNotEquals("UNANSWERED", ans,
                "Found UNANSWERED for question " + q.getQuestionNumber());
        }
    }
}
