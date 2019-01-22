# 자바 웹 어플리케이션 과정 소개

> - 질문 / 답변 웹 서비스를 구현해 가는 전체 과정을 담고 있다.
> - 첫번째 반복 주기부터 로컬 서버 구현에서 원격 서버 배포까지 과정을 담고 있다.
> - 과정을 반복하면서 문제점을 인식하고, 해결책을 찾는 방식으로 진행한다.



> ### **의식적인 연습** 과 **단계적 접근**
>
> > 정신적 능력을 향상시키는 핵심은 단기기억의 한계를 극복하고, **다량의 정보를 한꺼번에 효율적으로 다룰** 수 있게 해주는 **심적 구조물(심적 표상)**을 만들어 내는 것
>
> > 심적 구조물(심적 표상) 이란?
> >
> > - 사물, 관념, 정보, 이외에 구체적이든 추상적이든 **뇌가 생각하고 있는 대상에 상응하는 이미지**
>
> > **"의식적인 연습"**의 핵심목적은 **효과적인 심적 표상을 개발하는 것**이며, 심적 표상은 다시 "의식적인 연습"에서 핵심 역할을 한다.
>
> 
>
> ### 의식적인 연습을 위한 활동
>
> 1. 현재 자신의 수준보다 **한 단계 난이도가 있는 문제**에 **도전**
> 2. **같은 프로그램을 여러 번 반복적으로 구현**, 반복할 때 마다 **다른 방식으로 접근**하기위해 노력한다.
> 3. 주변의 피드백을 최대한 활용한다. **피드백을 받고 개선하는 경험**을 반복해야 한다.
>
> 
>
> ### 연습 방법
>
> - ~~연습 1 - 동영상을 보면서 전체 과정을 성공하는 것에 집중~~
> - <u>연습 2.  동영상을 보면서 각 과정의 중요한 부분을 메모한다.</u>
> - 연습 3. 가능한 동영상을 보지 않고, 메모를 참고해 전체 과정을 진행
> - 연습 4. 메모를 참고하면서 좀 더 추가적으로 학습하고 싶은 내용에 대해 한, 두가지씩 추가학습한 후 정리
> - 자신이 만족하는 수준까지 연습 4를 반복한다.
> - 최종 단계는 메로를 보지 않고도 전체 과정을 성공하도록 한다.
> - 최종 단계 이후에도 연습을 하고 싶다면 시작해서 끝나는 시간을 단축하기 위한 연습을 한다.
> - 이 같은 연습을 익숙해지는 시점까지 매일 일정 시간을 투자한다. 한번에 한 한복주기로 자주하는 것이 좋다.
>
> 
>
> ------
>
> 



> ## 1. 로컬 개발환경 세팅
>
> - spring boot project
>
>   - Web/mustache/dev-tools(변경사항있을 시, 자동 재시작해줌)
>
> - Hello World" welcom 페이지
>
> - live reload chrome extension 설치
>
>   
>
> ### 1.1 Spring Boot 로컬 개발환경 세팅
>
> > 1. ~~Dev-tools(live reload 사용하기위해 필요함), web, mustach dependency 추가~~
> > 2. ~~html 파일 추가해서 Hello world 찍기~~
> > 3. ~~live reload 설치 후 활성화 및 테스트~~
>
> #### 메모
>
> > - Vscode로도 프로젝트 생성이 잘된다.
> > - Vscode 상에서는 프로젝트 실행할 때, java 경로 에러가 떠서, sts로 프로젝트 생성 후에 import 하였음
>
> 
>
> ### 1.2 HTML 페이지 개발
>
> > 1. ~~bootstrap start html 추가~~
> >
> > 1. ~~bootstrap css 라이브러리 추가~~
> >
> > 1. ~~jquery javascript 라이브러리 추가~~
> >
> > 1. ~~index.html => navigation bar 추가~~
> >
> > 1. ~~회원가입 페이지 개발~~
>
> 
>
> #### 메모
>
> > - 크롬 네트워크 부분에서 css, js를 잘 로드해오는지 확인할 수 있다.
> > - mvnrepository.com 을 통해 의존 라이브러리 관리
> > - 의존 라이브러리 추가하고 적용할 때, 서버 재시작 해줘야된다.
>
> 
>
> 
>
> ### 1.3 github에 소스 코드 추가
>
> > 1. ~~sourcetree에 저장소 추가~~ -> vscode로 대체
> > 2. ~~github에 소스 코드 추가~~
>
> 
>
> 
>
> ### 1.4 ~1.6 원격 서버에 소스 코드 배포하기는 생략





---------------



## 반복주기 2 학습 목표

> - 동적인 HTML 웹 페이지 개발
> - Spring MVC의 Model, View, Controller 기반 개발



## 강의 순서

> - 2-1. Controller 추가 및 mustache에 인자 전달
> - 2-2. 회원가입 기능 구현
> - 2-3. 사용자 목록 페이지 구현
> - 2-4. 원격 서버에 소스 코드 배포
> - 2-5. 이전 상태로 원복 후 반복 구현



### 2-1 mustache를 활용한 동적 HTML과 MVC



#### 메모

> * Controller를 추가할 때, 해당 클래스가 Controller인지 의미를 부여하기 위해 애노테이션을 사용한다.
>
>   ```java 
>   @Controller
>   public class WelcomeController {
>       
>   }
>   ```
>
>   
>
> * mustach에 접근하려면 무조건 Controller를 통해야한다
>
>   ```java 
>   @Controller
>   public class WelcomeController {
>       public String welcome() {
>           return "welcome";
>       }
>   }
>   ```
>
>   * wecome 함수가 리턴하는 String 값은 welcome에 맞추어서, **resource/template/welcome.html에 매핑 된다.**
>
>     
>
> * 어떤 url로 요청할 것인지를 명시해줘야한다.
>
>   ```java 
>   @Controller
>   public class WelcomeController {
>       @GetMapping("/helloworld")
>       public String welcome() {
>           return "welcome";
>       }
>   }
>   ```
>   * application.properties 에 다음 설정 값을 추가해줘야 정상 동작한다.
>
>     ```java 
>     spring.mustache.suffix=.html
>     ```
>
> * 브라우저에서 서버로 요청 보낼 떄, parameter 넘기기
>
>   ```java 
>   @Controller
>   public class WelcomeController {
>       @GetMapping("/helloworld")
>       public String welcome(String name) {
>           System.out.println("name : " + name);
>           return "welcome";
>       }
>   }
>   ```
>
>   
>
>   ![image-20190122103111351](assets/image-20190122103111351.png)
>
>   ![image-20190122103132918](assets/image-20190122103132918.png)
>
>   ```java 
>   @Controller
>   public class WelcomeController {
>       @GetMapping("/helloworld")
>       //Model객체를 매개변수로 지정
>       public String welcome(String name, Model model) {
>           System.out.println("name : " + name);
>   
>           //addAttribute 메소드를 통해서 "name"이라는 이름으로, name 값을 저장
>           //mustach template 상에서 {{name}}으로 접근 할 수 있다.
>           model.addAttribute("name", name);
>           return "welcome";
>       }
>   }
>   ```

#### 잘 모르거나 좀 더 학습이 필요한 것들

> 1. Model 클래스의 addAttribute 메소드에 대해서





### 2-2 회원가입 기능 구현



#### 메모

> * GET , POST 사용
>
>   * GET
>     * 데이터를 가져올 때 쓴다.
>     * 사용자 목록, 특정 회원 정보 등
>   * POST
>     * 서버에 데이터를 전송해서, 새로운 데이터를 추가 혹은 수정 할 떄 사용
>     * 로그인, 회원가입 등
>
> * 넘어가는 매개변수가 너무 길다.
>
>   ```java 
>   @Controller
>   public class UserController {
>       @PostMapping("/create")
>       public String create(String userId, String userPassword, String userName, String userEmail) {
>           System.out.println("userId: " + userId);
>           return "index";
>       }
>   }
>   ```
>
>   * 각각을 일일이 넘기지 말고, 객체로 넘기면 코드를 깔끔하게 유지할 수 있다.
>
>   * User.java 파일을 따로 만들고, 데이터를 저장할 User class를 생성한다.
>
>   * get,set method를 만들어주고, toString도 만들어 준다. - 자동생성하자
>
>     ```java 
>     package com.example.demo.web;
>     
>     /**
>      * User
>      */
>     public class User {
>     
>         private String userId;
>         private String userPassword;
>         private String userName;
>         private String userEmail;
>     
>         public String getUserId() {
>             return this.userId;
>         }
>     
>         public void setUserId(String userId) {
>             this.userId = userId;
>         }
>     
>         public String getUserPassword() {
>             return this.userPassword;
>         }
>     
>         public void setUserPassword(String userPassword) {
>             this.userPassword = userPassword;
>         }
>     
>         public String getUserName() {
>             return this.userName;
>         }
>     
>         public void setUserName(String userName) {
>             this.userName = userName;
>         }
>     
>         public String getUserEmail() {
>             return this.userEmail;
>         }
>     
>         public void setUserEmail(String userEmail) {
>             this.userEmail = userEmail;
>         }
>     
>         @Override
>         public String toString() {
>             return "{" + " userId='" + getUserId() + "'" + ", userPassword='" + getUserPassword() + "'" + ", userName='"
>                     + getUserName() + "'" + ", userEmail='" + getUserEmail() + "'" + "}";
>         }
>     
>     }
>     ```
>
>     
>
>     기존 UserController.java는 아래와 같이 깔끔하게 코드를 줄일 수 있다.
>
>     ```java 
>     //이렇게 깔끔해진다..
>     
>     @Controller
>     public class UserController {
>         @PostMapping("/create")
>         public String create(User user) {
>             System.out.println("user: " + user);
>             return "index";
>         }
>     }
>     ```
>
>     ```java 
>     user: { userId='kwon5604', userPassword='fv3528no!', userName='sdafasdf', userEmail='kwon5604@naver.com'}
>     ```
>
>     * 더하여서, toString()의 영향으로 위와 같이 깔끔하게 저장하고 있는 유저정보에 대해서 출력까지 해준다.
>
>     





### 2-3 사용자 목록 기능 구현



#### 메모

> - 현재는 단순히 출력만 한다.
>
> - 사용자 목록을 보여주려면, 서버에 값을 가지고 있어야 하는데,
>
> - 회원가입한 사용자를 저장할 수 있는 List collection을 사용한다.
>
> - 그러나, 이것은 잠시 메인 메모리에 저장하기 때문에, 서버를 재시작 하면, 데이터가 사라진다.
>
> - 영구적으로 저장할 수 있는 DB가 필요하다.
>
>   ```java 
>   private List<User> users = new ArrayList<User>();private List<User> users = new ArrayList<User>();
>   
>       @PostMapping("/create")
>       public String create(User user) {
>           System.out.println("user: " + user);
>           users.add(user);//users에 user를 추가한다.
>           return "redirect:/list";
>       }
>   ```
>
>   
>
> - 위에서 List collection의 users 가 static이 아니여도 되는 이유
>
>   - Controller 인스턴스가 Spring에 의해 관리되고 있는데, 서버가 동작하는 한 개의 인스턴스가 생성되어 재사용되는 구조
>   - 따라서, 굳이 static을 사용하지 않아도 똑같은 효과를 낸다.
>   - Spring을 사용하는 이유중 하나가 Single 인스턴스 관리를 static을 사용하지 않고 가능하기 때문
>
>   
>
> - 템플릿 반영할 때, 재시작 안하고 반영하기 위한 설정
>
>   ```java 
>   //application.properties
>   handlebars.cache=false
>   ```
>
>   
>
> - mustach 문법 if 문
>
>   ```html
>   {{#users}}
>       <tr>
>           <th scope="row">1</th>
>           <td>{{ userId }}</td>
>           <td>{{ userName }}</td>
>           <td>{{ userEmail }}</td>
>       </tr>
>   {{/users}}
>   ```
>
>   



#### 잘 모르겠는 내용

> 1. Spring을 사용하는 이유중 하나가 Single 인스턴스 관리를 static을 사용하지 않고 가능하기 때문 ???
> 2. Controller 인스턴스가 Spring에 의해 관리되고 있는데, 서버가 동작하는 한 개의 인스턴스가 생성되어 재사용되는 구조???
> 3. Contoller도 Bean 이고 Bean은 기본적으로 싱글톤이기 때문???



### 2-4, 2-5는 생략



-----------



## 반복주기 3 학습 목표

> - 데이터베이스에 사용자 데이터 추가
> - 개인정보 수정 기능 구현
> - 질문하기, 질문목록 기능 구현



## 강의 순서

> - 3-1. QnA HTML 템플릿, H2 데이터베이스 설치, 설정 관리툴 확인
> - 3-2. 자바 객체와 테이블 매핑, 회원가입 기능 구현
> - 3-3  HTML 정리, URL 정리
> - 3-4 개인정보 수정 기능 구현
> - 3-5. 질문하기, 질문목록 기능 구현
> - 3-6. 원격 서버에 소스 코드 배포



### 3-1 QnA HTML 템플릿, H2 데이터베이스 설치, 설정 관리툴 확인



### 메모

> - h2 데이터베이스 설치는 Maven을 통해서 간단히 설치 가능
> - http://localhost:8080/h2-console/ 로 접속
> - h2 데이터베이스 설치 후, pom.xml 에서 <scope>test<scope> 이거 삭제해줘야된다.



### 3-2 자바 객체와 테이블 매핑, 회원가입 기능 구현



### 메모

> * h2 접속 관련
>
>   * Application.properties에 다음 설정 값을 추가
>
>     ```java 
>     spring.datasource.url=jdbc:h2:~/kpjQnA;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
>     spring.datasource.driverClassName=org.h2.Driver
>     spring.datasource.username=sa
>     spring.datasource.password=
>     spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
>     ```
>
>     ```java 
>     //로그인 할 때 다음 경로로 로그인 한다.
>     jdbc:h2:~/kpjQnA
>     ```
>
>     ![image-20190122122657210](assets/image-20190122122657210.png)
>
>   
>
> * jpa 추가 -> Maven Repository에서 추가한다.
>
> * User 클래스에 데이터베이스와 매핑하는 애노테이션을 추가한다.
>
>   ```java 
>   @Entity // User 클래스에 데이터베이스와 매핑하는 애노테이션을 추가
>   public class User {
>       @Id
>       @GeneratedValue
>       private Long id; // @Id로 primary key 지정, @GeneratedValue == Auto Increment
>   
>       @Column(nullable = false) // null 관리
>       private String userId;
>       private String userPassword;
>       private String userName;
>       private String userEmail;
>   ```
>
>   ![image-20190122122756853](assets/image-20190122122756853.png)
>
>   * 위와 같이 db 테이블이 만들어진 것을 확인할 수 있다.
>
> * 데이터베이스에 데이터를 조회 혹은 삽입하려면 인터페이스를 만들어야 한다.
>
>   ```java 
>   //UserRepository
>   
>   package com.example.demo.domain;
>   
>   import org.springframework.data.jpa.repository.JpaRepository;
>   
>   // JpaRepository는 User에 대한 repository 이고, 두번쨰는 User의 primary Key 타입 
>   // 기본적으로 데이터베이스에 저장하고, 조회하는 기능 구현은 끝
>   public interface UserRepository extends JpaRepository<User, Long> {
>   
>   }
>   ```
>
> * 만들어진 UserRepository를 쓰기위해서는 @Autowired를 이용해서 땡겨서 쓴다.???
>
>   ```java 
>   @Controller
>   public class UserController {
>       private List<User> users = new ArrayList<User>();
>   
>       //UserRepository 인터페이스를 따로 구현해서 쓰지 않고,
>       //다음과 같이 @Autowired 애노테이션을 이용해서 바로 가져다가 사용한다.
>       @Autowired
>       private UserRepository userRepository;
>   
>       @PostMapping("/create")
>       public String create(User user) {
>           System.out.println("user: " + user);
>           users.add(user);
>           //JpaRepository 내부 어딘가에 save는 구현이 되어있다.
>           userRepository.save(user);// db에 값 추가한다.
>           return "redirect:/list";
>       }
>       //...
>   }
>       
>   ```
>   * 정상적으로 DB에 값이 들어가면, 아래와 같이 보인다.
>
>     ![image-20190122123845564](assets/image-20190122123845564.png)
>
>   
>
> * 데이터베이스에서 값 가져오기(유저 리스트)
>
>   ```java 
>    @GetMapping("/list")
>       public String list(Model model) {
>           //List collection 객체 users를 userRepository.findAll()로 교체
>           model.addAttribute("users", userRepository.findAll());
>           return "list";
>       }
>   ```
>
>   



### 잘 모르겠는 내용

> 1. @Autowired에 대해서





### 3-3 HTML 정리, URL 정리



### 메모

> - UserController를 다음과 같이 수정한다.
>
>   ```java 
>   
>   @Controller
>   public class UserController {
>   
>       @Autowired
>       private UserRepository userRepository;
>   
>       @PostMapping("/user/create")
>       public String create(User user) {
>           System.out.println("user: " + user);
>           userRepository.save(user);// db에 값 추가
>           //user폴더에 list.html로 리다이렉팅 한다.
>           return "redirect:/user/list";
>       }
>   
>       @GetMapping("/user/list")
>       public String list(Model model) {
>           model.addAttribute("users", userRepository.findAll());
>           //user 폴더에 list.html로 매핑된다.
>           return "/user/list";
>       }
>   }
>   
>   ```
>
>   
>
> - Controller의 중복을 제거하면, 이와같이 쓸 수도 있다.
>
>   ```java 
>   
>   @Controller
>   // 대표url을 지정함으로써, 중복을 제거한다.
>   @RequestMapping("/users")
>   public class UserController {
>   
>       @Autowired
>       private UserRepository userRepository;
>   
>       @PostMapping("")
>       public String create(User user) {
>           System.out.println("user: " + user);
>           userRepository.save(user);// db에 값 추가
>           return "redirect:/users";
>       }
>   
>       @GetMapping("")
>       public String list(Model model) {
>           model.addAttribute("users", userRepository.findAll());
>           return "/user/list";
>       }
>   }
>   
>   ```
>
> - Mustache 사용해서 html 중복 코드 제거
>
>   ```html
>   {{> /include/navigation}} 
>   
>   //이런 식으로 include 이하에 각각 파트를 나눈 html을 만들고,
>   //위의 방식 대로 넣어주면 된다.
>   ```
>
>   





### 3-4 개인정보 수정 기능 구현-1



### 메모

> - 주소창에서 입력받은 id 값 메소드에 넘길 때
>
>   ```java 
>   @GetMapping("/{id}/form")
>       public String updateForm(@PathVariable Long id) {
>           return "/user/updateForm";
>       }
>   ```
>
>   * @PathVariable을 사용한다.





