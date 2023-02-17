package com.l2m.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.l2m.security.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
  Optional<Member> findByUsername(String username);
}