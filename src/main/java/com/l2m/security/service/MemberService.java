package com.l2m.security.service;

import com.l2m.security.model.MemberDto;

public interface MemberService {
  /**
   * 회원가입
   * @param joinParam
   * @return
   */
  public MemberDto.join join(MemberDto.joinParam joinParam);

  /**
   * 로그인
   * @param loginParam
   */
  public MemberDto.login login(MemberDto.loginParam loginParam);
}
