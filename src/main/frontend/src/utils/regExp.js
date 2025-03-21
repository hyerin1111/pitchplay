// 이메일 유효성 검사 정규 표현식
export const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;

// 전화번호 유효성 검사 정규 표현식
export const phonePattern = /^[0-9]{3}-[0-9]{3,4}-[0-9]{4}$/;

// 비밀번호 유효성 검사 정규 표현식(영문 숫자 조합8~16자 이내)
export const pwPattern = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z\d]{8,16}$/;

// 이름 유효성 검사 정규 표현식 (한글,영문 1~20자 이내)
export const namePattern =  /^[a-zA-Z가-힣]{1,20}$/;

// 아이디 유효성 검사 정규 표현식 (영문 숫자 조합 4~20자 이내)
export const idPattern = /^[a-zA-Z0-9]{4,20}$/;

// 닉네임 유효성 검사 정규 표현식 (영문,한글,숫자,공백 2~8자 이내 첫자는 숫자와 공백 금지)
export const nicknamePattern = /^[^0-9\s][a-zA-Z0-9가-힣\s]{1,7}$/;

// 생년월일 유효성 검사 정규표현식
//(년도 2자리 : 1900년대 2000년대만 가능 ,월 2자리 : 1~12 사이만 가능, 일 두자리 : 1~31 사이만 가능)
export const birthPattern =  /^(19|20)\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|3[01])$/;

// 팀 이름 생성 유효성 검사 정규표현식 (한글,영문,숫자,특수문자 1~15자 첫글자는 한글 영어만 가능)
export const TNamePattern =   /^[a-zA-Z가-힣][a-zA-Z0-9가-힣!@#$%^&*()_+={}\[\]:;"'<>,.?/`~-]{0,14}$/;

// 소개(팀또는 개인) 유효성 검사 정규표현식 (한글,영어,숫자,특수문자 1~200 글자 이내)
export const ReportPattern = /^[a-zA-Z0-9ㄱ-ㅎ가-힣!@#$%^&*()_+={}\[\]:;"'<>,.?/-|\\`~]{1,200}$/;

// 검색 유효성 검사 정규표현식 (한글,영어,숫자,특수문자 1~50글자 이내 첫글자는 특수문자 제외)
export const SearchPattern = /^[a-zA-Z0-9가-힣][a-zA-Z0-9가-힣!@#$%^&*()_+={}\[\]:;"'<>,.?/-]*$/;

// 팀 코드 생성 유효성 검사 정규표현식 (영문, 숫자만 1~20자 첫글자 영문)
export const TeamCodePattern = /^[A-Za-z][A-Za-z0-9]{0,19}$/;

// 팀 소개글 유효성 검사 정규표현식
export const TeamDescriptionPattern = /^[\w\Wㄱ-ㅎㅏ-ㅣ가-힣\s]{0,300}$/;

// 모집 게시글 유효성 검사 정규표현식 ( 100~ 2000자 ) 
export const postDescriptionPattern = /^.{100,2000}$/;
// 계좌 번호 유효성 검사 정규표현식
export const accountNum = /^\d{8,30}$/;