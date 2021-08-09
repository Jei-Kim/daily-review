* 10 - h
- Board private으로 변경 => BoardHandler에서 이제 board.00 직접 접근 불가함
- 이제 세터, 게터로 접근해야함 => 게터, 세터 생성해주고 핸들러에서 no-> setNo
- viewCount의 내용 직접 변경할 수 x, 불러와서 +1 해주기

* ex07 > a > Exam05
- 추상메서드를 호출하라고 하면, 서브클래스에서 구현한 인스턴스를 호출함?
- 큰 흐름은 수퍼클래스에서 정하고, 상세한 구현은 서브클래스에서!

* ex07 > b > Exam01
- Arrays.copyOf(values, values.length);
기존의 배열과 같은 배열과 같은(값, 크기) 복사해서 만든다

- BubbleSort
-- visualgo.net // 알고리즘, 자료구조 등 시각적으로 볼 수 있는 사이트. 참고하기.
