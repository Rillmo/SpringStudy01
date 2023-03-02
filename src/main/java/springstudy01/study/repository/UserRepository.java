package springstudy01.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springstudy01.study.domain.SiteUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findByusername(String username);

}
