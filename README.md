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
        

### REFACTOR
- ToDoList

        1. 응집도 낮추기
        2. 생성자는 객체 생성만 관여하게 변경
        3. 커서 비교하는 방식을 메소드화
           -> 변수를 비교할 때 반드시 타입을 같게 해주어야 함
        4. 현재 게임 매니저를 스테이지 매니저로, 상위 게임 매니저를 추가하여
            Stage 변경 화면, 게임 시작 메뉴, 현재 stage 등 출력
        5. Junit 사용해서 테스트코드 작성해보기
        
### GM기능 추가
- TooDoList

        1. Stage간 Stage 변경 화면 추가
        2. 게임 시작시 Start, end화면 선택
        3. 게임 UI에 현재 stage, 현재 map, 움직인 횟수 기록
        4. 맵 추가
        