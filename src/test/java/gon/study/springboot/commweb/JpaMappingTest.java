package gon.study.springboot.commweb;

import gon.study.springboot.commweb.domain.Board;
import gon.study.springboot.commweb.domain.User;
import gon.study.springboot.commweb.domain.enums.BoardType;
import gon.study.springboot.commweb.repository.BoardRepository;
import gon.study.springboot.commweb.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaMappingTest {
    private final String boardTestTitle = "Test";
    private final String email = "test@gmail.com";

    @Autowired
    UserRepository userRepository;

    @Autowired
    BoardRepository boardRepository;

    @Before
    public void init() {
        User user = userRepository.save(User.builder()
            .name("havi")
            .password("test")
            .email(email)
            .createdDate(LocalDateTime.now())
            .build());

        boardRepository.save(Board.builder()
            .title(boardTestTitle)
            .subTitle("Sub Title")
            .content("Contents")
            .boardType(BoardType.free)
            .createdDate(LocalDateTime.now())
            .updatedDate(LocalDateTime.now())
            .user(user).build());

    }

    @Test
    public void testIfWorkWell() {
        User user = userRepository.findByEmail(email);
        assertThat(user.getName(), is("havi"));
        assertThat(user.getPassword(), is("test"));
        assertThat(user.getEmail(), is(email));

        Board board = boardRepository.findByUser(user);
        assertThat(board.getTitle(), is(boardTestTitle));
        assertThat(board.getSubTitle(), is("Sub Title"));
        assertThat(board.getContent(), is("Contents"));
        assertThat(board.getBoardType(), is(BoardType.free));

    }
}
