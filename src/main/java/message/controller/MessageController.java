package message.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import message.dto.messageDTO;
import message.entity.MemberEntity;
import message.repository.MemberRepository;
import message.service.MessageService;

@RequiredArgsConstructor
@RestController
public class MessageController {

    private final MessageService messageService;
    private final MemberRepository memberRepository;

}
