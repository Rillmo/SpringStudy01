package springstudy01.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springstudy01.study.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    Answer findByContent(String Content);
}
