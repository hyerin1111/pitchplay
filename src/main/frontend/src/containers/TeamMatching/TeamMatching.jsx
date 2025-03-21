import TeamMatchingItem from "./TeamMatchingItem";
import CircleImg from "../../components/CircleImg";
import Button from "../../components/Button/Button";
import styles from "./TeamMatching.module.css";
import { motion } from "framer-motion";
import { useNavigate } from "react-router-dom";

function TeamMatching({ content }) {
    const { teams, matchingDate, locDetail, location,gender, level, views } = content;
    const team1 = teams.team1; // 팀 1 정보
    const team2 = teams.team2; // 팀 2 정보

    const navigate = useNavigate();  // useNavigate 훅 사용
    const user = JSON.parse(localStorage.getItem('user'));

    const handleViewDetailsClick = () => {
        if (!user) {
            navigate("/login");  // 로그인 페이지로 이동
        } else {
            navigate(`/matching/${content.matchingNum}`);  // 소셜 매칭 상세 페이지로 이동
        }
    };

    return (
        <div className={styles["matching-box"]}>
            {/* 상태 텍스트 */}
            <div className={styles["matching-top"]}>
                {team2.name && team2.name !== "null" ? "매칭완료" : "신청가능"}
            </div>
            <motion.div
                className={styles["matching-grid"]}
                whileHover={{
                    scale: 1.02,
                    boxShadow: "0px 10px 15px rgba(0, 0, 0, 0.1)",
                }}
                transition={{ type: "spring", stiffness: 300, damping: 20 }}
            >
                {/* 팀 1 이미지 */}
                <CircleImg src={team1.src} alt={`${team1.name} 이미지`} gridArea="team1" />

                {/* 매칭 아이템 */}
                <TeamMatchingItem
                    team1={team1.name}
                    team2={team2.name !== "null" ? team2.name : null}
                    date={matchingDate}
                    location={location}
                    locDetail={locDetail}
                    gender={gender}
                    level={level}
                    views={views}
                    gridArea="text"
                />
                {/* 팀 2 이미지 또는 버튼 */}
                {team2.name && team2.name !== "null" ? (
                    <CircleImg src={team2.src} alt={`${team2.name} 이미지`} gridArea="team2" />
                ) : (
                
                    <Button
                    onClick={handleViewDetailsClick}
                    color="var(--main-color)" gridArea="team2">
                        신청하기
                    </Button>
                )}
            </motion.div>
        </div>
    );
}

export default TeamMatching;