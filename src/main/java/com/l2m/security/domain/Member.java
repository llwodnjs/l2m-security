package com.l2m.security.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.l2m.security.domain.base.enums.DomainPrefix;
import com.l2m.security.domain.global.BaseEntity;
import com.l2m.security.model.MemberDto;
import com.l2m.security.util.global.BusinessKeyUtil;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 회원 Entity
 * 
 * by jaewon
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {
  @Id
  @GeneratedValue
  @Column(name = "memberId")
  private Long id;

  // 비즈니스 키
  @Column
  private String businessKey;

  // 회원 아이디
  @Column
  private String username;

  // 회원명
  @Column
  private String name;

  // 패스워드
  @Column
  private String password;

  @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
  private List<Authority> roles = new ArrayList<>();

  public void settingRoles(List<Authority> role) {
    this.roles = role;
    role.forEach(o -> o.settingMember(this));
  }

  /**
   * AllArgsConstructor
   * 
   * @param createUserKey
   * @param createDateTime
   * @param updateUserKey
   * @param updateDateTime
   * @param id
   * @param businessKey
   * @param username
   * @param name
   * @param password
   */
  protected Member(String createUserKey, LocalDateTime createDateTime, String updateUserKey,
      LocalDateTime updateDateTime,
      Long id, String businessKey, String username, String name, String password) {
    super(createUserKey, createDateTime, updateUserKey, updateDateTime);
    this.id = id;
    this.businessKey = businessKey;
    this.username = username;
    this.name = name;
    this.password = password;
  }

  /**
   * clone용 생성자
   * 
   * @param member
   */
  protected Member(Member member) {
    super(member.getCreateUserKey(), member.getCreateDateTime(), member.getUpdateUserKey(), member.getUpdateDateTime());
    this.businessKey = member.getBusinessKey();
    this.username = member.getUsername();
    this.name = member.getName();
    this.password = member.getPassword();
  }

  /**
   * 회원가입 생성자
   * 
   * @param joinParam
   */
  protected Member(MemberDto.joinParam joinParam, Function<String, String> passwordEncoder) {
    // super(member.getCreateUserKey(), member.getCreateDateTime(),
    // member.getUpdateUserKey(), member.getUpdateDateTime());
    this.businessKey = BusinessKeyUtil.create(DomainPrefix.MEMBER);
    this.username = joinParam.getUsername();
    this.name = joinParam.getName();
    this.password = passwordEncoder.apply(joinParam.getPassword());
  }

  /**
   * 회원가입 처리
   * 
   * @return
   */
  public static Supplier<Member> joinMember(MemberDto.joinParam joinParam, Function<String, String> passwordEncoder) {
    final Member member = new Member(joinParam, passwordEncoder);
    member.roles.add(Authority.createAuth(member).get());
    return () -> member;
  }
}
