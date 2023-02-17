package com.l2m.security.repository.manager;

import com.l2m.security.model.MemberDto;

public interface MemberRepositoryManager {
  /**
   * 회원가입 처리
   * @param joinParam
   * @return
   */
  public MemberDto.join join(MemberDto.joinParam joinParam);
}
