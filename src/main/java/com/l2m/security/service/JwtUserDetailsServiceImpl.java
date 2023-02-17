package com.l2m.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.l2m.security.domain.Member;
import com.l2m.security.model.CustomUserDetails;
import com.l2m.security.repository.MemberRepository;

import lombok.NonNull;

@Service
@Transactional
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService {
  @NonNull
  private MemberRepository memberRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Member member = memberRepository.findByUsername(username).orElseThrow(
        () -> new UsernameNotFoundException("Invalid authentication!"));

    return new CustomUserDetails(member);
  }
}
