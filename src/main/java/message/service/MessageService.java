package message.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import message.dto.messageDTO;
import message.entity.MessageEntity;
import message.entity.MemberEntity;
import message.repository.MessageRepository;
import message.repository.MemberRepository;

import java.util.List;
import java.util.ArrayList;

@RequiredArgsConstructor
@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public messageDTO write(messageDTO messageDto){
        MemberEntity receiverMember = memberRepository.findByName((messageDto.getReceiverMember()));
        MemberEntity senderMember = memberRepository.findByName((messageDto.getSenderMember()));

        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setReceiverMember(receiverMember);
        messageEntity.setSenderMember(senderMember);

        messageEntity.setMessageId(messageDto.getMessage_Id());
        messageEntity.setContent(messageDto.getContent());
        messageRepository.save(messageEntity);

        return messageDTO.toDTO(messageEntity);
    }


    @Transactional(readOnly = true)
    public List<messageDTO> receivedMessage(MemberEntity memberEntity){
        //받은 편지함 불러오기
        List<MessageEntity> Messages = messageRepository.findAllByReceiverMember(memberEntity);
        List<messageDTO> messageDTOS = new ArrayList<>();

    return messageDTOS;
    }

    @Transactional(readOnly = true)
    public List<messageDTO> sentMessage(MemberEntity memberEntity) {
        // 보낸 편지함 불러오기
        List<MessageEntity> messages = messageRepository.findAllBySenderMember(memberEntity);
        List<messageDTO> messageDTOS = new ArrayList<>();

        return messageDTOS;
    }
}
