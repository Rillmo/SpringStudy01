package springstudy01.study;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import springstudy01.study.service.QuestionService;

@SpringBootTest
public class PagingTest {
    @Autowired
    private QuestionService questionService;

    @Test
    public void 페이징테스트() {
        for (int i = 0; i < 300; i++) {
            String subject = "테스트 데이터입니다 :" + i;
            String content = "테스트";
            questionService.create(subject, content, null);
        }
    }
}
