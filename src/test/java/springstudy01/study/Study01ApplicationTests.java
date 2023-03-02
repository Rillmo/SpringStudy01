package springstudy01.study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import springstudy01.study.domain.Question;
import springstudy01.study.repository.QuestionRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
class Study01ApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void questionRepositoryTestSave() {
		Question q1 = new Question();
		q1.setSubject("sbb가 무엇인가요?");
		q1.setContent("sbb에 대해서 알고 싶습니다");
		q1.setCreateDate(LocalDateTime.now());
		questionRepository.save(q1);	// 첫번째 질문 저장

		Question q2 = new Question();
		q2.setSubject("질문 2");
		q2.setContent("질문 2 내용");
		q2.setCreateDate(LocalDateTime.now());
		questionRepository.save(q2);	// 두번째 질문 저장

		List<Question> all = questionRepository.findAll();	// findAll
		Assertions.assertEquals(2, all.size());
		System.out.println(all.get(0));

		Question q = all.get(0);
		Assertions.assertEquals("sbb가 무엇인가요?", q.getSubject());

		Optional<Question> oq = questionRepository.findById(1);	//findById
		if (oq.isPresent()) {
			Assertions.assertEquals(q1.getSubject(), oq.get().getSubject());
		}

		Question oq2 = questionRepository.findBySubject(q2.getSubject());	// findBySubject
		Assertions.assertEquals(q2.getId(), oq2.getId());
	}



}
