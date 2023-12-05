package message.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import message.entity.MessageEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class messageDTO {
    private Long message_Id;
    private String content;
    private String senderMember;
    private String receiverMember;

    public static messageDTO toDTO(MessageEntity message) {
        return new messageDTO(
                message.getMessageId(),
                message.getContent(),
                message.getSenderMember().getName(),
                message.getReceiverMember().getName()
        );
    }
}