# 인터넷 뱅킹 이체 시스템
- 사용자의 계좌를 조회하고 이체를 할 수 있는 간단한 콘솔 프로젝트

<br>

## 팀원
<table>
  <tr>
    <td align="center">
      <a href="https://github.com/LouiIII3">
        <img src="https://github.com/LouiIII3.png" alt="이성희" width="150" height="150"/>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/ksp0814">
        <img src="https://github.com/ksp0814.png" alt="강세필" width="150" height="150"/>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/rlfrkdms1">
        <img src="https://github.com/rlfrkdms1.png" alt="길가은" width="150" height="150"/>
      </a>
    </td>
        <td align="center">
      <a href="https://github.com/yaejinkong">
        <img src="https://github.com/yaejinkong.png" alt="공예진" width="150" height="150"/>
      </a>
    </td>
  </tr>
   <tr>
    <td align="center">
      <a href="https://github.com/LouiIII3">
        <b>이성희</b>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/ksp0814">
        <b>강세필</b>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/rlfrkdms1">
        <b>길가은</b>
      </a>
    </td>
    <td align="center">
      <a href="https://github.com/yaejinkong">
        <b>공예진</b>
      </a>
    </td>
  </tr>
</table>
<br>

<br>

## 프로젝트 기간
2024년 8월 21일(수) ~ 2024년 8월 22일(목)

<br>

## 디렉토리 구조
src/ <br>
├── main/ <br>
│   ├── java/ <br>
│   │   └── controller/ # 애플리케이션의 주요 로직을 담당하는 클래스 <br>
│   │   └── data/ # 데이터베이스와 상호작용하는 DAO 클래스 <br>
│   │   └── db/ # 데이터베이스 설정 및 유틸리티 클래스 <br>
│   │   └── domain/ # 도메인 모델 클래스 <br>
│   │   └── view/ # 사용자 입력 및 출력을 처리하는 클래스들 <br>
│   └── resource/ <br>
│       └── jdbc.properties # 데이터베이스 연결 설정 파일 <br>

<br>

## 주요 기능
1. **사용자 계좌 조회**: 사용자 계좌 목록을 조회하며, 계좌 번호, 상품 유형(예: 입출금, 적금), 계좌 잔액을 확인할 수 있습니다.
2. **상세 계좌 정보**: 사용자가 선택한 계좌의 거래 내역(입출금 내역, 거래 금액, 메모)을 확인할 수 있습니다.
3. **계좌 이체 기능** : 사용자가 은행과 계좌를 선택한 후, 이체할 금액을 입력합니다. 이체를 성공하면 잔액이 갱신되며, 실패 시 적절한 오류 메시지가 표시됩니다.

<br>
   
## Project Setting
- jdk 11
- Maven 기반 프로젝트
  - 빌드 및 의존성 관리
- 외부 라이브러리
  - mysql-connector-j-8.0.33.jar
  - lombok-1.18.24.jar
