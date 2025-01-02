import React from "react";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import { RecoilRoot } from 'recoil';

// 메인페이지 (최상위)
import Main from "./pages/Main/Main";
// 메인페이지 본문
import MainContent from "./pages/MainContent/MainContent";
// 로그인, 회원가입, 찾기
import Login from "./pages/Login/Login";
import FindIdPw from "./pages/FindIdPw/FindIdPw";
import FindIdPage from "./pages/FindIdPage/FindIdPage";
import FindPwPage from "./pages/FindPwPage/FindPwPage";
import Register from "./pages/Register/Register";
//소셜매칭
import SocialMatchings from "./pages/SocialMatchings/SocialMatchings";
import SocialMatchingDetail from "./pages/SocialMatchingDetail/SocialMatchingDetail";
//팀매칭
import Post from "./pages/Post/Post";
import TeamMatchings from "./pages/TeamMatchings/TeamMatchings";
import TeamCollections from "./pages/TeamCollections/TeamCollections";
import GuestRecruitment from "./pages/GuestRecruitment/GuestRecruitment";
import TeamCreation from "./pages/TeamCreation/TeamCreation";
import TeamCollectionDetail from "./pages/TeamCollectionDetail/TeamCollectionDetail";
import TeamMatchingDetail from "./pages/TeamMatchingDetail/TeamMatchingDetail";
import GuestRecruitmentDetail from "./pages/GuestRecruitmentDetail/GuestRecruitmentDetail";
import GuestRecruitmentCreation from "./pages/GuestRecruitmentCreation/GuestRecruitmentCreation";
//구장예약
import StadiumPage from "./pages/StadiumPage/StadiumPage";
import StadiumDetail from "./pages/StadiumDetail/StadiumDetail";
//공지사항
import NoticePost from "./pages/NoticePost/NoticePost";
import Notices from "./pages/Notices/Notices";
import Faqs from "./pages/Faqs/Faqs";
import Feedbacks from "./pages/Feedbacks/Feedbacks";
import Conducts from "./pages/Conducts/Conducts";
import ReportDetail from "./pages/ReportDetail/ReportDetail";
import WriteReport from "./pages/WritingReport/WriteReport";
//마이페이지
import MyPage from "./pages/Mypage/Mypage";
import MyInfo from "./pages/Mypage/MyInfo/MyInfo";
//마이페이지 - 내활동 
import MypageAct from "./pages/Mypage/MypageAct/MypageAct";
import MypageMatches from "./pages/Mypage/MypageMatches/MypageMatches";
import MypageRecords from "./pages/Mypage/MypageRecords/MypageRecords";
import MypageTeamSection from "./pages/Mypage/MypageTeamSection/MypageTeamSection";
import MypageTeamSchedule from "./pages/Mypage/MypageTeamSchedule/MypageTeamSchedule";
import MypageTeamMembers from "./pages/Mypage/MypageTeamMembers/MypageTeamMembers";
import MypageTeamApplication from "./pages/Mypage/MypageTeamApplication/MypageTeamApplication";
//마이페이지 - 커뮤니티
import MyPageCommunity from "./pages/Mypage/MyPageCommunity/MyPageCommunity";
import MyPagePostInfo from "./pages/Mypage/MyPagePostInfo/MyPagePostInfo";
import MyPageCommentInfo from "./pages/Mypage/MyPageCommentInfo/MyPageCommentInfo";
//마이페이지 - 설정
import Setting from "./pages/Mypage/Setting/Setting";
//마이페이지 - 캐시
import ChargeMain from "./pages/Mypage/ChargeMain/ChargeMain";
import RefundMain from "./pages/Mypage/RefundMain/RefundMain";
import HistoryPage from "./pages/Mypage/HistoryPage/HistoryPage";
import ChangeSetting from "./pages/Mypage/ChangeSet/ChangeSetting";
//관리자페이지
import AdminPage from "./pages/AdminPage/AdminPage";
import Dashboard from "./pages/AdminPageDashboard/Dashboard";
import AdminMemeberManagement from "./pages/AdminMemberManagement/AdminMemberManagement";
import AdminTeamManagement from "./pages/AdminTeamManagement/AdminTeamManagement";
import AdminStadiumReservation from "./pages/AdminStadiumManagement/AdminStadiumManagement";
import AdminNoticeBoard from "./pages/AdminNoticeBoard/AdminNoticeBoard";
import NoticeBoardWrite from "./pages/AdminNoticeBoard/NoticeBoardWrite/NoticeBoardWrite";
import AdminPaymentManagement from "./pages/AdminPaymentManagement/AdminPaymentManagement";
import AdminMatchingManagement from "./pages/AdminMatchingManagement/AdminMatchingManagement";
//이용약관, 개인정보처리방침,사업자정보확인
import PSinformation from "./pages/PSinformation";
import Terms from "./pages/Terms";
import BusinessInfo from "./pages/BusinessInfo";


const router = createBrowserRouter([
  {
    // 메인
    path: "/",
    element: <Main />,
    children: [
      { path: "/", element: <MainContent gridArea="section"/> },
      { path: "/login", element: <Login gridArea="section"/> },
      {
        path: "/recovery",
        element: <FindIdPw gridArea="section" />,
        children: [
          { path: "id", element: <FindIdPage /> },
          { path: "pw", element: <FindPwPage /> },
        ],
      },
      { path: "/users/new", element: <Register gridArea="section"/> },
      // 소셜매칭
      { path: "/social", element: <SocialMatchings gridArea="section"/> },
      // 소셜매칭 - 자세히보기
      { path: "/social/:socialNumber", element: <SocialMatchingDetail gridArea="section" />},
      // 팀매칭
      {
        path: "/team",
        element: <Post gridArea="section"/>,
        children: [
          { path: "", element: <TeamMatchings /> },
          { path: "member", element: <TeamCollections /> },
          { path: "guestplayer", element: <GuestRecruitment /> },
          { path: "creation", element: <TeamCreation isOpen={true} /> },
        ],
      },
      // 팀매칭 - 자세히보기
      { path: "/team/:teamCode", element: <TeamCollectionDetail gridArea="section"/> },
      { path: "/matching/:matchingNum", element: <TeamMatchingDetail gridArea="section" />},
      { path: "/guestplayer/:postNumber",element: <GuestRecruitmentDetail gridArea="section"/>},
      // 팀매칭 - 용병모집 글쓰기
      { path: "/guestplayer/:reservationNum/new", element: <GuestRecruitmentCreation gridArea="section" />},
      // 구장예약
      { path: "/stadium", element: <StadiumPage gridArea="section"/>},
      { path: "/stadium/:stadiumId", element: <StadiumDetail gridArea="section"/>},
      // 공지사항
      {
        path: "/notices",
        element: <NoticePost gridArea="section"/>,
        children: [
          { path: "", element: <Notices/> },
          { path: "faq", element: <Faqs/> },
          { path: "feedback", element: <Feedbacks/> },
          { path: "conduct", element: <Conducts/> },
        ],
      },
      // 공지사항 - 건의제보 & 매너/제재 자세히보기
      { path: "/notices/:faqNumber", element: <ReportDetail gridArea="section"/>},
      // 공지사항 - 글쓰기
      { path: "/notices/new", element: <WriteReport gridArea="section"/> },
      // 마이페이지
      {
        path: "/mypage/:id",
        element: <MyPage gridArea="section"/>,
        children: [
          // 마이페이지 - 내정보
          { path: "", element: <MyInfo /> },
          // 마이페이지 - 내활동
          { path: "act", element: <MypageAct gridArea="section"/> },
          // 마이페이지 - 내활동 - 예약한 경기
          { path: "matches", element: <MypageMatches gridArea="section"/> },
          // 마이페이지 - 내활동 - 참가한 경기
          { path: "records", element: <MypageRecords gridArea="section"/> },
          // 마이페이지 - 내활동 - 내 팀 정보
          { path: "team-section",element: <MypageTeamSection gridArea="section"/>},
          { path: "team-schedule",element: <MypageTeamSchedule gridArea="section"/>},
          { path: "team-members",  element: <MypageTeamMembers gridArea="section"/>},          
          { path: ":teamCode/application", element: <MypageTeamApplication gridArea="section"/>},
          // 마이페이지 - 커뮤니티
          { path: "community", element: <MyPageCommunity gridArea="section"/> },
          { path: "post-info", element: <MyPagePostInfo gridArea="section"/> },          
          { path: "comment-info", element: <MyPageCommentInfo gridArea="section"/>},
          // 마이페이지 - 설정
          { path: "setting", element: <Setting gridArea="section"/> },
          { path: "changeset", element: <ChangeSetting gridArea="section"/>},

          // 마이페이지 - 캐시
          { path: "charges", element: <ChargeMain gridArea="section"/> },
          { path: "refunds", element: <RefundMain gridArea="section"/> },
          { path: "history", element: <HistoryPage gridArea="section"/> },
        ],
      },
      //이용약관
      { path: "/psinfo", element: <PSinformation gridArea="section"/> },
      //개인정보 처리방침
      { path: "/term", element: <Terms gridArea="section"/> },
      //사업자정보 확인
      { path: "/business", element: <BusinessInfo gridArea="section"/> },
      // 관리자페이지
      {
        path: "/admin",
        element: <AdminPage gridArea="section"/>,
        children: [
          { path: "", element: <Dashboard /> },
          { path: "matching-management", element: <AdminMatchingManagement /> },
          { path: "member-management", element: <AdminMemeberManagement /> },
          { path: "team-management/:id?", element: <AdminTeamManagement /> },
          { path: "stadium-reservation/:id?", element: <AdminStadiumReservation gridArea="section"/>},
          { path: "notice-board", element: <AdminNoticeBoard gridArea="section"/>},
          { path: "notice-board/write", element: <NoticeBoardWrite gridArea="section"/>,},
          { path: "payment-management", element: <AdminPaymentManagement gridArea="section"/>},
        ],
      },
    ],
  },


]);

function App() {
  return (
    <RecoilRoot>
      <RouterProvider router={router} />
    </RecoilRoot>
  );
}

export default App;
