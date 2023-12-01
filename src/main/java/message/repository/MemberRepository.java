package message.repository;


import message.entity.MemberEntity;
import message.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByEmail(String email);

    // 중복 방지를 위한 존재 여부 체크
    boolean existsByEmail(String email);
    boolean existsByName(String name);

    // 관리자 존재 여부 체크용.
    MemberEntity findByRole(Role role);
}
