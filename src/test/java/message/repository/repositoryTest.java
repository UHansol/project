package message.repository;

import org.junit.jupiter.api.Test;
import message.entity.MemberEntity;
import message.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@SpringBootTest
class RepositoryTest {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Transactional
    void memberList() {
        List<MemberEntity> list = memberRepository.findAll();

        for (MemberEntity item : list) {
            System.out.println(item);
        }
    }

    @Test
    @Transactional
    void adminList() {
        List<MemberEntity> list = memberRepository.findAllByRole(Role.ADMIN);

        for (MemberEntity item : list) {
            System.out.println(item);
        }
    }

    @Test
    @Transactional
    void messageList() {

    }

}