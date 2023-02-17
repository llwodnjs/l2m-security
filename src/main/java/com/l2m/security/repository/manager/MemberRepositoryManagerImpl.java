package com.l2m.security.repository.manager;

import javax.persistence.EntityManager;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.l2m.security.domain.Member;
import com.l2m.security.model.MemberDto;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 회원 관련 RepositoryManager
 * 
 * by jaewon
 */
@Repository
@RequiredArgsConstructor
public class MemberRepositoryManagerImpl implements MemberRepositoryManager {
  @NonNull
  private EntityManager entityManager;

  @NonNull
  private PasswordEncoder passwordEncoder;

  @Override
  public MemberDto.join join(MemberDto.joinParam joinParam) {
    final Member member = Member.joinMember(joinParam, passwordEncoder::encode).get();
    entityManager.persist(member);
    return new MemberDto.join(member.getBusinessKey());
  }
}
