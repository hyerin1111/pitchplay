# Pitchplay
Pitchplay는 사용자가 간편하게 축구 경기를 예약하고 매칭 팀 혹은 인원을 구할 수 있도록 지원하는 축구 매칭 플랫폼입니다.
* 기간 : 2024.11.04 ~ 2024.12.18

* 기술스택
  - Frontend : JavaScript, React.js, HTML, CSS
  - Backend : Java, Spring Boot, JPA, MariaDB
  - Database : MariaDB
  - Design : Figma
  - Diagram : draw.io, PlantUML
<br>

## 소개
>### 메인
- ###### 메인화면을 직관적으로 구성하여 편의성을 높였습니다.
~~~
소셜 : 소셜 매칭(개인매칭) 게시판 | 팀 : 팀 매칭 게시판(팀 매칭, 팀원모집, 팀 생성) | 구장 : 구장 예약 게시판 
~~~
![main](https://github.com/user-attachments/assets/244adcb7-6fd1-4bca-b548-d0026e3443b7)
![main-menu](https://github.com/user-attachments/assets/bd50e419-8bd5-41a6-9b16-34f562808622)

---

>### 소셜 매칭
- ###### 소셜 매칭 게시물은 개인이 구장 예약 시에 등록되며, 신청하기를 통해 해당 매칭에 참여할 수 있습니다.
#### 소셜 매칭 게시물
- ###### 소셜 매칭 게시물 상세 보기에서 매치정보, 신청선수 명단 및 구장정보를 확인할 수 있습니다.
- ###### 구장 지도는 카카오맵API와 연동되었습니다.
![pitchplay-social](https://github.com/user-attachments/assets/ff9b5125-5ca3-4d57-bfc3-b0e3a89dd0ba)

---

>### 팀 매칭
#### 팀 매칭 
- ###### 팀 매칭 게시물은 팀 리더가 구장 예약 시에 등록되며, 신청하기를 통해 팀 끼리 매칭을 진행할 수 있습니다.
- ###### 팀 매칭 게시물 신청하기를 누르면 매치정보, 신청 팀 이름 및 구장정보를 확인할 수 있습니다. 
![pitchplay-teammatching](https://github.com/user-attachments/assets/ee786561-2c68-454f-8876-01b3b5eb1745)
---
#### 팀원 모집 
- ###### 팀원 모집 게시물은 팀이 생성 시에 등록되며, 팀 리더의 승인 후에 팀에 가입할 수 있습니다.
- ###### 팀원 모집 게시물 상세 보기에서 팀의 활동 위치, 활동 요일, 팀원 구성 및 팀 레벨을 확인할 수 있습니다. 
![pitchplay-teamrecruitment](https://github.com/user-attachments/assets/1c79421d-9c92-4a26-bc03-fe5892cef0fe)
---
#### 용병 모집
- ###### 팀 리더가 예약된 경기에서 추가 인원이 필요한 경우, 용병 모집 게시물을 작성하여 선수를 구할 수 있습니다.
![pitchplay-newguest](https://github.com/user-attachments/assets/2603fd00-c124-43f1-820f-2b01a8df760d)
---
#### 팀 생성
- ###### 팀 생성하기를 통하여 팀을 새로 생성할 수 있습니다. 
![pitchplay-teamcreation](https://github.com/user-attachments/assets/d7a4ebea-9079-465b-b6a2-325932fbfb91)

---

>### 구장예약
- ###### 구장 예약은 서울시 체육시설 공공서비스 예약 정보를 기반으로 이루어지며, 예약 신청 후 관리자가 최종 예약을 진행합니다.
- ###### 구장 예약 시에 사용자가 충전해놓은 캐시를 사용하여 결제를 할 수 있습니다.
![pitchplay-stadiumreservation](https://github.com/user-attachments/assets/68fd64bf-61cb-4f8a-bf70-be87a54b60ac)

---

>### 공지사항
#### 공지사항 | 자주묻는질문
- ###### 공지사항 및 자주 묻는 질문을 확인할 수 있습니다.
![pitchplay-notices](https://github.com/user-attachments/assets/5ed9e976-1a3d-4eb3-85f6-06c9fe23cf94)
---
#### 건의제보 | 매너제재
- ###### 관리자에게 건의 사항을 제출하거나, 제재가 필요한 유저에 대한 내용을 작성할 수 있습니다.
![pitchplay-report](https://github.com/user-attachments/assets/a0380120-125c-4758-9545-5866800d4a7c)
- ###### 댓글을 사용하여 유저 간의 커뮤니케이션이 가능합니다.
![pitchplay-comment](https://github.com/user-attachments/assets/8ef01f3e-1f9b-4ce9-97c0-450f0d40ad77)

---

>### 유저
#### 내정보
- ###### 프로필 수정 및 캐시에 관련된 정보를 확인할 수 있습니다.
![mypage](https://github.com/user-attachments/assets/7bf81e7c-216e-4758-8f7a-4b44b585ff9e)
---
#### 내활동
- ###### 경기, 팀, 나의 댓글에 관련된 정보를 확인할 수 있습니다.
![pitchplay-myactivity](https://github.com/user-attachments/assets/a423f4ec-be48-49b2-9364-0b931261d4d4)
- ###### 예약한 경기 목록
![reservedgame](https://github.com/user-attachments/assets/7ad2e880-c45b-462b-a180-7f1a80ec6898)
- ###### 참가한 경기 목록
![donegame](https://github.com/user-attachments/assets/169ef96f-48f3-4a64-b87e-ce949b012213)
- ###### 내 팀 정보 : 팀의 매니저인 경우에 팀원 신청 관리 및 멤버 관리가 가능합니다.
![pitchplay-team](https://github.com/user-attachments/assets/3beeddc4-4c22-45c6-b632-0039a34836ec)

---

#### 커뮤니티
- ###### 작성한 게시물과 댓글을 확인할 수 있습니다.
![mycommunity](https://github.com/user-attachments/assets/0f4d2e1d-7f0c-4c81-a8f6-731dbfbcb643)

---

#### 설정
- ###### 유저의 개인정보를 관리할 수 있습니다. 
![setting](https://github.com/user-attachments/assets/844b37f6-57bf-497b-b225-6f337d4daea0)

---

#### 통합검색
- ###### 통합 검색을 통해 사용자는 선호하는 날짜, 지역, 선수 성별, 매칭 인원을 저장하여 검색에 활용할 수 있습니다. 해당 정보는 로컬스토리지에 저장됩니다. 
---

>### 관리자
---
