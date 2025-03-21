import React, { useState, useEffect } from "react";
import { useNavigate, useOutletContext } from "react-router-dom";
import styles from "./Feedbacks.module.css";

function Feedbacks() {
    const { searchQuery } = useOutletContext(); // 부모 컴포넌트에서 전달된 searchQuery 사용

    const [dataList, setDataList] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const navigate = useNavigate();

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await fetch("/data/faqData.json");
                if (!response.ok) {
                    throw new Error("데이터를 불러오는 데 실패했습니다.");
                }
                const data = await response.json();
                setDataList(data);
            } catch (err) {
                setError(err.message);
            } finally {
                setLoading(false);
            }
        };

        fetchData();
    }, []);

    // 필터링된 데이터 리스트 생성
    const filteredDataList = dataList.filter(
        (report) =>
            report.title.toLowerCase().includes(searchQuery.toLowerCase()) ||
            report.writeNickname.toLowerCase().includes(searchQuery.toLowerCase())
    );

    const handleViewReport = (faqNumber) => {
        navigate(`/notices/${faqNumber}`);
    };

    const handleAddReport = () => {
        navigate("/notices/new");
    };


    if (loading) return <p>로딩 중...</p>;
    if (error) return <p>에러 발생: {error}</p>;

    return (
        <div className={styles['feedback-container']}>
                    <h2>건의/제보 게시판 리스트</h2>
                    <button className={styles['add-report-btn']} onClick={handleAddReport}>
                        건의/제보 글쓰기
                    </button>
                    <table className={styles['feedback-table']}>
                        <thead>
                            <tr>
                                <th>번호</th>
                                <th>제목</th>
                                <th>작성자</th>
                                <th>날짜</th>
                                <th>상태</th>
                                <th>조회수</th>
                            </tr>
                        </thead>
                        <tbody>
                            {filteredDataList.map((report) => (
                                <tr
                                    key={report.faqNumber}
                                    className={styles['feedback-row']}
                                    onClick={() => handleViewReport(report.faqNumber)}
                                >
                                    <td>{report.faqNumber}</td>
                                    <td>{report.title}</td>
                                    <td>{report.writeNickname}</td>
                                    <td>{report.date}</td>
                                    <td>{report.status}</td>
                                    <td>{report.views}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
        </div>
    );
}

export default Feedbacks;