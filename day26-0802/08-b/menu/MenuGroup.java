package com.eomcs.pms.menu;

public class MenuGroup extends Menu { // 메뉴를 상속받았으니까 얘도 메뉴의 일종임
  Menu[] childs = new Menu[100];
  int size;

  // 생성자를 정의하지 않으면 컴파일러가 기본 생성자를 자동으로 추가해 준다.
  // 문제는 컴파일러가 추가한 기본 생성자는 수퍼 클래스의 기본 생성자를 호출하기 때문에
  // 컴파일 오류가 발생한다.
  // Menu 클래스에는 기본 생성자가 없다.
  // 따라서 개발자가 직접 생성자를 정의해야 한다.
  public MenuGroup(String title) {
    super(title); /// super클래스에서 title을 생성하는 생성자를 불러옴
  }

  // MenuGroup이 포함하는 하위 Menu를 다룰 수 있도록 메서드를 정의한다.
  public void add(Menu child) {
    if (this.size == this.childs.length) {
      return; // 하위 메뉴를 저장하는 배열이 꽉 찼다면 더이상 저장해서는 안된다.
    }
    this.childs[this.size++] = child;
  }

  // 배열에 들어 있는 Menu 객체를 찾아 제거한다.
  public Menu remove(Menu child) {
    /// remove 메서드에서 보통 쓰이는 패턴. return값(null) 받기 위해 void를 Menu로 바꿔줌
    int index = indexOf(child);
    if (index == -1) { /// 못 찾았으면
      return null;
    }
    for (int i = index + 1; i < this.size; i++) {
      this.childs[i - 1] = this.childs[i];
    }
    childs[--this.size] = null;
    return child;
  }

  // 배열에 들어 있는 Menu 객체를 인덱스를 알아낸다.
  public int indexOf(Menu child) {
    for (int i = 0; i < this.size; i++) {
      if (this.childs[i] == child) {
        return i;
      }
    }
    return -1;
  }

  // 배열에 들어 있는 Menu 객체를 찾는다.
  public Menu getMenu(String title) { 
    for (int i = 0; i < this.size; i++) {
      if(this.chids[i].title.equals(title)) {
        return this.childs[i];
      }
    return null;
  }

  @Override // 컴파일러에게 오버라이딩을 제대로 하는지 조사해 달라고 요구한다.
  public void execute() {
    while (true) {
      System.out.printf("[%s]\n", this.title);
      for (int i = 0; i < this.size; i++) {
        System.out.printf("%d. %s\n", i + 1, this.childs[i].title);
      }
      System.out.printf("0.이전메뉴");
      int menuNo = Prompt.inputInt("선택> ");
      int (menuNo == 0){
        return;
      }
      
      if (menuNo < 0 || menuNo > this.size) {
        System.out.println("무효한 메뉴 번호입니다.");
        continue; // 출력했으면 while문으로 다시 되돌아감
      }
      
      this.childs[menuNo - 1].execute();
          /// 위에 index보다 하나 큰 값을 출력하려고 i+1을 해줬기 때문에
    }
  }
}
