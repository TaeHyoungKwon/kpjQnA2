> 1. 
>
>   # 자바 웹 어플리케이션 과정 소개
>
>   - 질문 / 답변 웹 서비스를 구현해 가는 전체 과정을 담고 있다.
>   - 첫번째 반복 주기부터 로컬 서버 구현에서 원격 서버 배포까지 과정을 담고 있다.
>   - 과정을 반복하면서 문제점을 인식하고, 해결책을 찾는 방식으로 진행한다.
>
>   
>
>   ### **의식적인 연습** 과 **단계적 접근**
>
>   > 정신적 능력을 향상시키는 핵심은 단기기억의 한계를 극복하고, **다량의 정보를 한꺼번에 효율적으로 다룰** 수 있게 해주는 **심적 구조물(심적 표상)**을 만들어 내는 것
>
>   > 심적 구조물(심적 표상) 이란?
>   >
>   > - 사물, 관념, 정보, 이외에 구체적이든 추상적이든 **뇌가 생각하고 있는 대상에 상응하는 이미지**
>
>   > **"의식적인 연습"**의 핵심목적은 **효과적인 심적 표상을 개발하는 것**이며, 심적 표상은 다시 "의식적인 연습"에서 핵심 역할을 한다.
>
>   
>
>   ### 의식적인 연습을 위한 활동
>
>   1. 현재 자신의 수준보다 **한 단계 난이도가 있는 문제**에 **도전**
>   2. **같은 프로그램을 여러 번 반복적으로 구현**, 반복할 때 마다 **다른 방식으로 접근**하기위해 노력한다.
>   3. 주변의 피드백을 최대한 활용한다. **피드백을 받고 개선하는 경험**을 반복해야 한다.
>
>   
>
>   ### 연습 방법
>
>   - ~~연습 1 - 동영상을 보면서 전체 과정을 성공하는 것에 집중~~
>   - <u>연습 2.  동영상을 보면서 각 과정의 중요한 부분을 메모한다.</u>
>   - 연습 3. 가능한 동영상을 보지 않고, 메모를 참고해 전체 과정을 진행
>   - 연습 4. 메모를 참고하면서 좀 더 추가적으로 학습하고 싶은 내용에 대해 한, 두가지씩 추가학습한 후 정리
>   - 자신이 만족하는 수준까지 연습 4를 반복한다.
>   - 최종 단계는 메로를 보지 않고도 전체 과정을 성공하도록 한다.
>   - 최종 단계 이후에도 연습을 하고 싶다면 시작해서 끝나는 시간을 단축하기 위한 연습을 한다.
>   - 이 같은 연습을 익숙해지는 시점까지 매일 일정 시간을 투자한다. 한번에 한 한복주기로 자주하는 것이 좋다.
>
>   
>
>   ------
>
>   
>
>   
>
>   ## 1. 로컬 개발환경 세팅
>
>   - spring boot project
>
>     - Web/mustache/dev-tools
>
>   - Hello World" welcom 페이지
>
>   - live reload chrome extension 설치
>
>     
>
>   ### 1.1 Spring Boot 로컬 개발환경 세팅
>
>   > 1. ~~Dev-tools(live reload 사용하기위해 필요함), web, mustach dependency 추가~~
>   > 2. ~~html 파일 추가해서 Hello world 찍기~~
>   > 3. ~~live reload 설치 후 활성화 및 테스트~~
>
>   #### 메모
>
>   > - Vscode로도 프로젝트 생성이 잘된다.
>   > - Vscode 상에서는 프로젝트 실행할 때, java 경로 에러가 떠서, sts로 프로젝트 생성 후에 import 하였음
>
>   
>
>   ### 1.2 HTML 페이지 개발
>
>   > 1. ~~bootstrap start html 추가~~
>   >
>   > 1. ~~bootstrap css 라이브러리 추가~~
>   >
>   > 1. ~~jquery javascript 라이브러리 추가~~
>   >
>   > 1. ~~index.html => navigation bar 추가~~
>   >
>   > 1. ~~회원가입 페이지 개발~~
>
>   
>
>   #### 메모
>
>   > - 크롬 네트워크 부분에서 css, js를 잘 로드해오는지 확인할 수 있다.
>   > - mvnrepository.com 을 통해 의존 라이브러리 관리
>   > - 의존 라이브러리 추가하고 적용할 때, 서버 재시작 해줘야된다.
>
>   
>
>   
>
>   ### 1.3 github에 소스 코드 추가
>
>   > 1. ~~sourcetree에 저장소 추가~~ -> vscode로 대체
>   > 2. ~~github에 소스 코드 추가~~
>
>   
>
>   
>
>   ### 1.4 ~1.6 원격 서버에 소스 코드 배포하기는 생략
>
>   
>
>   ------
>
>   
>
>   ## 반복주기 2 학습 목표
>
>   > - 동적인 HTML 웹 페이지 개발
>   > - Spring MVC의 Model, View, Controller 기반 개발
>
>   
>
>   ## 강의 순서
>
>   > - 2-1. Controller 추가 및 mustache에 인자 전달
>   > - 2-2. 회원가입 페이지 구현
>   > - 2-3. 사용자 목록 페이지 구현
>   > - 2-4. 원격 서버에 소스 코드 배포
>   > - 2-5. 이전 상태로 원복 후 반복 구현
