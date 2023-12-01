package message.repository;

import message.entity.MemberEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {
    @Autowired
    private MemberRepository repository;

    @Test
    @Transactional
    void showAll() {
        List<MemberEntity> members = repository.findAll();

        for (MemberEntity member : members) {
            System.out.printf("name:%7s\tEmail:%15s\tRole:%7s\n", member.getName(), member.getEmail(), member.getRole());
        }
    }

    @Test
    @Transactional
    void showAdmin(){

    }
}