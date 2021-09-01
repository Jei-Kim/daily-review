package com.studywithus.handler;

import com.studywithus.domain.NewMember;
import com.studywithus.util.Prompt;

public class NewMemberHandlerJe2 {
  static final int MAX_LENGTH = 5;
  int size = 0;

  public NewMember[] newMembers = new NewMember[MAX_LENGTH];

  public NewMember[] add(NewMember[] loginInfo) {
    NewMember newMember = new NewMember();

    newMember.name = Prompt.inputString("이름을 입력해주세요: ");
    newMember.id = Prompt.inputString("사용할 아이디를 입력해주세요: ");
    newMember.pwd = Prompt.inputString("사용할 비밀번호를 입력해주세요: ");
    System.out.println();
    System.out.println("회원가입이 완료되었습니다.");
    loginInfo[this.size++] = newMember;
    return loginInfo;
  }

  NewMember searchId(String name) throws Exception{
    NewMember m = new NewMember();
    return m;
  }

  NewMember searchPwd(String Id) throws Exception{
    NewMember m = new NewMember();
    return m;
  }

  private NewMember findMemberId(String name) {
    for (int i = 0; i < this.size; i++) {
      if (this.newMembers[i].name == name) {
        return newMember.getId();
      }
    }
    return null;
  }

  private NewMember findMemberPwd(String id) {
    for (int i = 0; i < this.size; i++) {
      if (this.newMembers[i].id == id) {
        return newMember.getPwd();
      }
    }
    return null;
  }

}