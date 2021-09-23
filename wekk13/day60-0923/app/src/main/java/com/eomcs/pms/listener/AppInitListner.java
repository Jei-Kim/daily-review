package com.eomcs.pms.listener;

import com.eomcs.context.ApplicationContextListener;

// 애플리케이션이 시작하거나 종료할 때 보고를 받는 객체
// => ApplicationContextListener 규칙에 따라 클래스를 정의한다.

public class AppInitListener implements ApplicationContextListener {

  @Override
  public void contextInitialized(Map<String, Object> params) {
    System.out.println("****************************************");
    System.out.println("* 미니 프로젝트 관리시스템 ver 1.0     *");
    System.out.println("*    (C)Copyright BitCamp              *");
    System.out.println("****************************************");
  }

  @Override
  public void contextInitialized(Map<String, Object> params) {
    System.out.println("****************************************");
    System.out.println("* 미니 프로젝트 관리시스템 종료!     *");
    System.out.printf("*  마지막 실행일:              *");
    System.out.println("****************************************");
  }

}
