package gon.study.springboot.commweb.repository;

import gon.study.springboot.commweb.domain.Board;
import gon.study.springboot.commweb.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
