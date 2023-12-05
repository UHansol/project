package message.repository;

import org.junit.jupiter.api.Test;
import message.entity.MemberEntity;
import message.entity.MessageEntity;
import message.entity.Role;
import message.dto.messageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

@SpringBootTest
class repositoryTest {
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
    void testToDTO() {
        // Create a sample MessageEntity
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setMessageId(1L);
        messageEntity.setContent("Test content");

        MemberEntity sender = new MemberEntity();
        sender.getName();

        MemberEntity receiver = new MemberEntity();
        receiver.getName();

        messageEntity.setSenderMember(sender);
        messageEntity.setReceiverMember(receiver);

        // Convert MessageEntity to messageDTO
        messageDTO dto = messageDTO.toDTO(messageEntity);

        // Check if the conversion is correct
        assertEquals(messageEntity.getMessageId(), dto.getMessage_Id());
        assertEquals(messageEntity.getContent(), dto.getContent());
        assertEquals(messageEntity.getSenderMember().getName(), dto.getSenderMember());
        assertEquals(messageEntity.getReceiverMember().getName(), dto.getReceiverMember());
    }

}