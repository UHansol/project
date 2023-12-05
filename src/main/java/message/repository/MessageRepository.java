package message.repository;

import org.aspectj.bridge.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import message.entity.MessageEntity;
import message.entity.MemberEntity;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {
    List<MessageEntity> findAllBySenderMember(MemberEntity memberEntity);
    List<MessageEntity> findAllByReceiverMember(MemberEntity memberEntity);
}
