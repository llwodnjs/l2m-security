package com.l2m.security.domain.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 각 도메인별 PREFIX 모음
 *
 * by jaewon
 */
@AllArgsConstructor
public enum DomainPrefix {
  SYSTEM("SYS", "System Default Prefix", "널을 대신하는 기본값. 시스템에서 자동입력된 임의값임을 알림."),
  MEMBER("MEM", "Member", "회원 비즈니스 키"),
  AUTH("AUT", "Auth", "회원 권한")
  ;

  /**
   * - 실제 prefix 코드
   * - 개발자 내부 description
   */
  @Getter
  private String code;

  @Getter
  private String descripton;

  @Getter
  private String descriptonKr;

  // this 자신이 DomainPrefix.SYS 인지 여부를 반환.
  public boolean isSystem() {
    return this.equals(SYSTEM);
  }
}
