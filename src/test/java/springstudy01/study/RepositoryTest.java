package springstudy01.study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import springstudy01.study.domain.Answer;
import springstudy01.study.domain.Question;
import springstudy01.study.repository.AnswerRepository;
import springstudy01.study.repository.QuestionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional

class RepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Test
    void 저장() {
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다");
        q1.setCreateDate(LocalDateTime.now());
        questionRepository.save(q1);
    }

    @Test
    void 전체조회() {
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다");
        q1.setCreateDate(LocalDateTime.now());
        questionRepository.save(q1);    // 첫번째 질문 저장

        Question q2 = new Question();
        q2.setSubject("질문 2");
        q2.setContent("질문 2 내용");
        q2.setCreateDate(LocalDateTime.now());
        questionRepository.save(q2);    // 두번째 질문 저장

        List<Question> all = questionRepository.findAll();    // findAll
        Assertions.assertEquals(2, all.size());
        System.out.println(all.get(0));
    }

    @Test
    void 아이디로조회() {
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다");
        q1.setCreateDate(LocalDateTime.now());
        questionRepository.save(q1);

        Optional<Question> oq = questionRepository.findById(1);    //findById
        if (oq.isPresent()) {
            Assertions.assertEquals(q1.getSubject(), oq.get().getSubject());
        }
    }

    @Test
    void 제목으로조회(){
        Question q2 = new Question();
        q2.setSubject("sbb가 무엇인가요?");
        q2.setContent("sbb에 대해서 알고 싶습니다");
        q2.setCreateDate(LocalDateTime.now());
        questionRepository.save(q2);

        Question oq2 = questionRepository.findBySubject(q2.getSubject());	// findBySubject
        Assertions.assertEquals(q2.getId(), oq2.getId());
    }

    @Test
    void 제목과내용으로조회(){
        Question q = new Question();
        q.setSubject("sbb가 무엇인가요?");
        q.setContent("sbb에 대해서 알고 싶습니다");
        q.setCreateDate(LocalDateTime.now());
        questionRepository.save(q);

        Question oq = questionRepository.findBySubjectAndContent(q.getSubject(), q.getContent());
        Assertions.assertEquals(q.getId(), oq.getId());
    }

    @Test
    void 제목특정문자열조회(){

        Question q = new Question();
        q.setSubject("sbb가 무엇인가요?");
        q.setContent("sbb에 대해서 알고 싶습니다");
        q.setCreateDate(LocalDateTime.now());
        questionRepository.save(q);

        List<Question> qList = questionRepository.findBySubjectLike("sbb%");
        Question oq = qList.get(0);
        Assertions.assertEquals(q.getSubject(), oq.getSubject());
    }

    @Test
    void 데이터수정(){

        Question q = new Question();
        q.setSubject("sbb가 무엇인가요?");
        q.setContent("sbb에 대해서 알고 싶습니다");
        q.setCreateDate(LocalDateTime.now());
        questionRepository.save(q);

        q.setSubject("수정된 제목");
        questionRepository.save(q);
    }

    @Test
    void 데이터삭제(){

        Question q = new Question();
        q.setSubject("sbb가 무엇인가요?");
        q.setContent("sbb에 대해서 알고 싶습니다");
        q.setCreateDate(LocalDateTime.now());
        questionRepository.save(q);

        questionRepository.delete(q);
        Assertions.assertEquals(0, questionRepository.count());
    }

    @Test
    void 답변데이터생성후저장(){

        Question q = new Question();
        q.setSubject("sbb가 무엇인가요?");
        q.setContent("sbb에 대해서 알고 싶습니다");
        q.setCreateDate(LocalDateTime.now());
        questionRepository.save(q);

        Answer a = new Answer();
        a.setContent("답변 1");
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());
        answerRepository.save(a);
    }

    @Test
    void 답변조회(){
        Question q = new Question();
        q.setSubject("sbb가 무엇인가요?");
        q.setContent("sbb에 대해서 알고 싶습니다");
        q.setCreateDate(LocalDateTime.now());
        questionRepository.save(q);

        Answer a = new Answer();
        a.setContent("답변 1");
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());
        answerRepository.save(a);

        Answer oa = answerRepository.findByContent(a.getContent());
        Assertions.assertEquals("답변 1", oa.getContent());

    }

    @Test
    void 답변에연결된질문조회(){
        Question q = new Question();
        q.setSubject("sbb가 무엇인가요?");
        q.setContent("sbb에 대해서 알고 싶습니다");
        q.setCreateDate(LocalDateTime.now());
        questionRepository.save(q);

        Answer a = new Answer();
        a.setContent("답변 1");
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());
        answerRepository.save(a);

        Question oq = a.getQuestion();
        Assertions.assertEquals(q.getSubject(), oq.getSubject());
    }

    @Test
    void 질문에연결된답변조회(){
        Question q = new Question();
        q.setSubject("sbb가 무엇인가요?");
        q.setContent("sbb에 대해서 알고 싶습니다");
        q.setCreateDate(LocalDateTime.now());
        questionRepository.save(q);

        Answer a = new Answer();
        a.setContent("답변 1");
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());
        answerRepository.save(a);

        Answer a2 = new Answer();
        a2.setContent("답변 2");
        a2.setQuestion(q);
        a2.setCreateDate(LocalDateTime.now());
        answerRepository.save(a2);

        List<Answer> answerList = q.getAnswerList();
        Assertions.assertEquals(2, answerList.size());
    }

}
