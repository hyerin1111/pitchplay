import React, { useState, useEffect } from "react";
import axios from "axios";
import { useStore as TeamStore } from "../../../stores/TeamStore/useStore";
import { useStore as UserStore } from "../../../stores/UserStore/useStore";
import { useStore as CollectionStore } from "../../../stores/CollectionStore/useStore";
import styles from "./MypageTeamApplication.module.css";
import AppStatus from "./AppStatus";
import MercenaryStatus from "./MercenaryStatus";
import { useParams } from "react-router-dom";

const MypageTeamApplication = ({ gridArea }) => {
  const { teamCode } = useParams();

  // 멤버 목록과 로딩 상태를 관리하는 state
  const [pendingMembers, setPendingMembers] = useState([]); // 대기 중인 멤버 목록
  const [mercenaryMembers, setMercenaryMembers] = useState([]); // 용병 멤버 목록
  const [pendingMemberList, setPendingMemberList] = useState([]); // 대기 멤버 상세 정보 목록
  const [mercenaryMemberList, setMercenaryMemberList] = useState([]); // 용병 멤버 상세 정보 목록
  const [userData, setUserData] = useState(null); // 사용자 데이터
  const [loading, setLoading] = useState(true); // 로딩 상태
  const [collectionTime, setCollectionTime] = useState(null);

  // 스토어에서 상태와 액션을 가져옴
  const { state: userState, actions: userActions } = UserStore();
  const { state: teamState } = TeamStore();
  const { actions: collectionActions } = CollectionStore();

  // 로컬 스토리지에서 사용자 데이터 로드
  useEffect(() => {
    const userDataFromStorage = JSON.parse(localStorage.getItem("user")); // 로컬 스토리지에서 사용자 정보 가져오기
    if (userDataFromStorage) {
      setUserData(userDataFromStorage); // 사용자 데이터를 상태에 저장
    } else {
      console.error("유저 데이터가 로컬스토리지에 없습니다.");
    }
  }, []);

  // 팀 및 컬렉션 데이터 로드
  useEffect(() => {
    if (!teamCode) return; // 팀 코드가 없으면 실행하지 않음

    setLoading(true); // 로딩 상태 활성화

    Promise.all([
      axios.get("/data/teamData.json"),
      axios.get("/data/collectionsData.json"),
    ])
      .then(([teamRes, collectionRes]) => {
        const team = teamRes.data.find((t) => t.teamCode === teamCode); // 팀 데이터 검색
        const collections = collectionRes.data.filter(
          (c) => c.teamCode === teamCode
        ); // 팀 코드로 컬렉션 필터링

        // 각 컬렉션에서 mercenaryMembers와 collectionTime을 추출하여 병합
        const allMercenaryMembers = collections.flatMap(
          ({ mercenaryMembers, collectionTime }) =>
            mercenaryMembers.map((member) => ({
              ...member, // mercenaryMembers에 있는 데이터를 유지
              collectionTime, // 해당 collection의 collectionTime 추가
            }))
        );

        if (team) setPendingMembers(team.pendingMembers || []); // 대기 멤버 설정

        setMercenaryMembers(allMercenaryMembers || []); // 용병 멤버 설정
      })
      .catch((err) => console.error("데이터 로딩 오류:", err))
      .finally(() => setLoading(false)); // 로딩 상태 해제
  }, [teamCode]); // teamCode가 변경될 때마다 실행

  // 대기 멤버 상세 정보 업데이트
  useEffect(() => {
    if (pendingMembers.length === 0) return; // 대기 멤버가 없으면 실행하지 않음

    axios
      .get("/data/userData.json") // 사용자 데이터 가져오기
      .then((response) => {
        const userData = response.data; // 사용자 데이터 전체
        const detailedPendingMembers = pendingMembers
          .map((member) => {
            const user = userData.find(
              (u) => u.nickname === member.pendingnickname
            ); // 해당 멤버의 상세 정보 검색
            return user
              ? {
                  pendingnickname: user.nickname, // 닉네임
                  description: user.myDescription || "정보 없음", // 설명
                  profileImg: user.profileImg || "/default-profile.jpg", // 프로필 이미지
                  applicationDate: member.applicationDate, // 신청일
                }
              : null;
          })
          .filter(Boolean); // 유효한 데이터만 필터링
        setPendingMemberList(detailedPendingMembers); // 상태 업데이트
      })
      .catch((err) => console.error("대기 멤버 데이터 로딩 오류:", err));
  }, [pendingMembers]);

  // ------------------------------------------------------
  // 용병 멤버 상세 정보 업데이트
  useEffect(() => {
    if (mercenaryMembers.length === 0) return; // 용병 멤버가 없으면 실행하지 않음

    axios
      .get("/data/userData.json") // 사용자 데이터 가져오기
      .then((response) => {
        const userData = response.data;
        const detailedMercenaryMembers = mercenaryMembers
          .map((member) => {
            const user = userData.find(
              (u) => u.nickname === member.mercenarynickname
            );
            return user
              ? {
                  mercenarynickname: user.nickname,
                  description: user.myDescription || "정보 없음",
                  profileImg: user.profileImg || "/default-profile.jpg",
                  applicationDate: member.applicationDate,
                  collectionTime: member.collectionTime,
                }
              : null;
          })
          .filter(Boolean);

        // 중복 제거: 새로운 데이터와 기존 상태를 병합하지 않고 교체
        setMercenaryMemberList(detailedMercenaryMembers);
      })
      .catch((err) => console.error("용병 멤버 데이터 로딩 오류:", err));
  }, [mercenaryMembers]); // 상태 변경 시 중복 호출 방지

  // 대기 멤버 승인 및 거절 처리
  const onApprove = (member) => {
    userActions.changeMyTeam(member);
    setPendingMembers((prev) =>
      prev.filter((m) => m.pendingnickname !== member.pendingnickname)
    );
    setPendingMemberList((prev) =>
      prev.filter((m) => m.pendingnickname !== member.pendingnickname)
    );
  };

  const onReject = (member) => {
    setPendingMembers((prev) =>
      prev.filter((m) => m.pendingnickname !== member.pendingnickname)
    ); // 목록에서 제거
    setPendingMemberList((prev) =>
      prev.filter((m) => m.pendingnickname !== member.pendingnickname)
    ); // 상세 목록에서 제거
  };

  // 용병 멤버 승인 및 거절 처리
  const onApproveMercenary = (member) => {
    collectionActions.changeMercenary(member); // 용병을 팀에 추가
    setMercenaryMembers((prev) =>
      prev.filter((m) => m.mercenarynickname !== member.mercenarynickname)
    ); // 목록에서 제거
    setMercenaryMemberList((prev) =>
      prev.filter((m) => m.mercenarynickname !== member.mercenarynickname)
    ); // 상세 목록에서 제거
  };

  const onRejectMercenary = (member) => {
    setMercenaryMembers((prev) =>
      prev.filter((m) => m.mercenarynickname !== member.mercenarynickname)
    ); // 목록에서 제거
    setMercenaryMemberList((prev) =>
      prev.filter((m) => m.mercenarynickname !== member.mercenarynickname)
    ); // 상세 목록에서 제거
  };

  // 로딩 상태 표시
  if (loading) return <div>로딩 중...</div>;

  return (
    <div style={{ gridArea }}>
      <div className={styles.containerGrid}>
        <div className={styles.content}>
          <h1 className={styles.title}>
            마이페이지 &gt; 내 활동 &gt; 나의 팀 관리
          </h1>
          <div className={styles.teamInfo}>
            <AppStatus
              pendingMembers={pendingMemberList}
              onApprove={onApprove}
              onReject={onReject}
            />
            <MercenaryStatus
              mercenaryMembers={mercenaryMemberList}
              collectionTime={collectionTime} // collectionTime 전달
              onApprove={onApproveMercenary}
              onReject={onRejectMercenary}
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default MypageTeamApplication;
