package message.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MessageEntityTest {
    private static EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction tx;

    @BeforeEach
    public void init() {
        emf = Persistence.createEntityManagerFactory("YourPersistenceUnitName");
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
    }

    @AfterEach
    public void tearDown() {
        tx.rollback();
        em.close();
        emf.close();
    }
    @Test
    public void testMessageEntity() {
        // 테스트용 MemberEntity 생성
        MemberEntity sender = new MemberEntity();
        sender.setMemberId(1L);
        sender.setName("User1");

        MemberEntity receiver = new MemberEntity();
        receiver.setMemberId(2L);
        receiver.setName("User2");


        // 테스트용 MessageEntity 인스턴스 생성
        MessageEntity message = MessageEntity.builder()
                .senderMember(sender)
                .receiverMember(receiver)
                .Content("asd111")
                .sendDate(LocalDateTime.now())
                .readStatus(0L)
                .archStatus(0L)
                .delectStatus(0L)
                .reportStatus(0L)
                .build();


        // DB 저장된 MessageEntity 검색
        MessageEntity retrievedMessage = em.find(MessageEntity.class, message.getMessageId());

        // 예상 결과를 기반으로 엔터티를 테스트하기 위한 어서션 수행
        assertNotNull(retrievedMessage);
        assertEquals("테스트 메시지 내용", retrievedMessage.getContent());
        assertEquals(sender, retrievedMessage.getSenderMember());
        assertEquals(receiver, retrievedMessage.getReceiverMember());
        assertEquals(0L, retrievedMessage.getReadStatus());
        assertEquals(0L, retrievedMessage.getArchStatus());
        assertEquals(0L, retrievedMessage.getDelectStatus());
        assertEquals(0L, retrievedMessage.getReportStatus());
    }
}