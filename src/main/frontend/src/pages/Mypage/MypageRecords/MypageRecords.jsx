import React from 'react';
import styles from './MypageRecords.module.css';
import RecordList from './RecordList';
import { useState, useEffect } from 'react';
import axios from 'axios';


const MypageRecords = ({ gridArea }) => {
  const user = JSON.parse(localStorage.getItem('user')); // localStorage에서 'user' 가져오기
  const [matchingList, setMatchingList] = useState([]);

  // 매칭 정보 저장 (user가 포함한 팀의 매칭데이터 가져옴)
  useEffect(() => {
    axios.get("/data/matchingData.json")
      .then(response => {
        const datas = response.data;
        // user가 포함된 팀 이름이 team1이나 team2에 포함된 매칭 데이터 필터링
        const selectedMatches = datas.filter(data =>
          data.teams.team1.name === user.myTeam || data.teams.team2.name === user.myTeam);
        setMatchingList(selectedMatches);
      })
      .catch(err => {
        console.error("Error fetching matching data:", err);
      });
  }, []);

  return (
    <div style={{ gridArea: gridArea }}>
      <div className={styles.content}>
        <h1 className={styles.title}>마이페이지 &gt; 내활동 &gt; 참가한 경기 목록</h1>
        <div className={styles.actbox}>
          <RecordList records={matchingList} />
        </div>
      </div>
    </div>

  );
};

export default MypageRecords;
