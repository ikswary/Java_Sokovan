#소코반

##ToDoList
1. 스테이지 로딩

1. 캐릭터 이동 및 박스 이동 기능

1. 스테이지 클리어 판단 기능

1. 캐릭터 위치 및 맵 되돌리기 기능

1. 맵 확장성 고려하기

##구조
- Domain
    - 게임 전체를 추상화하는 Sokovan 클래스
    
            player 객체, 스테이지 객체
           
    - 캐릭터를 추상화하는 Player 클래스
       
- View
    - awt, swing을 활용한 input View
    - console.flush() 메소드를 활용한 Output View
     
- Controller

        SokovanController 클래스를 메인 클래스에서 호출하여 게임 실행