package com.l2m.security.service;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.l2m.security.config.security.JwtProvider;
import com.l2m.security.domain.Member;
import com.l2m.security.model.MemberDto;
import com.l2m.security.repository.MemberRepository;
import com.l2m.security.repository.manager.MemberRepositoryManager;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 회원관련 Service정의
 * 
 * by jaewon
 */
@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  @NonNull
  private JwtProvider jwtProvider;

  @NonNull
  private MemberRepository memberRepository;

  @NonNull
  private MemberRepositoryManager memberRepositoryManager;

  @NonNull
  private PasswordEncoder passwordEncoder;
  
  @Override
  public MemberDto.join join(MemberDto.joinParam joinParam) {
    return memberRepositoryManager.join(joinParam);
  }

  @Override
  public MemberDto.login login(MemberDto.loginParam loginParam) {
    // 회원 정보
    final Member member = memberRepository.findByUsername(loginParam.getUsername())
                            .orElseThrow(() -> new UsernameNotFoundException("아이디 또는 비밀번호가 맞지 않습니다."));

    // 패스워드 확인
    if (!passwordEncoder.matches(loginParam.getPassword(), member.getPassword())) {
      throw new BadCredentialsException("아이디 또는 비밀번호가 맞지 않습니다.");
    }

    // 토큰 팔행
    String token = jwtProvider.createToken(member.getBusinessKey(), member.getRoles());

    // System.out.print(jwtProvider.getAccount(token));

    return new MemberDto.login(member, token);
  }
}
