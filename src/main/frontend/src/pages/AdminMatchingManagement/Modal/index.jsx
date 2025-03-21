import Modal from "../../../components/Modal/Modal";
import { Table, TableCell, TableRow } from "../../../components/Table/Table";
import Button from "../../../components/Button/Button";
import MatchingManagementSVG from "../../../assets/icons/admin_matching.svg";
import styles from "./index.module.css";
import ConfirmationModal, {
  ConfirmationModalTrigger,
} from "../../../components/ConfirmationModal/index";
import axios from "axios";

const headers = {
  id: "매칭번호",
  matchType: "매치타입",
  teamSize: "경기종류",
  gender: "성별",
  date: "경기 날짜",
  time: "경기 시간",
  location: "경기장",
  isClosed: "마감여부",
  reservationedMembers: "예약한 회원",
  teams: "참가팀",
};

const AdminMatchingManagementModal = ({isOpen, closeModal, matchingState}) => {
  const handleConfirmModal = () => {
    mutate({ id: matchingState.id });
    closeModal();
  };

  const { id: firstHeader, teams: teamsHeader, ...restHeaders} = headers;
  const {
    id: firstData,
    teams: teamsData,
    ...restData
  } = matchingState;

  const rowCount = Object.keys(restData).length;

  const entriesWithHeader = Object.entries(restData).map(([key, value]) => {
    if (typeof value === "boolean") {
      value = value ? "Y" : "N";
    }
    return {
      header: restHeaders[key],
      value: value,
    };
  });

  return (
    <>
      <Modal isOpen={isOpen} closeModal={closeModal}>
        <h2 className={styles["modal-header"]}>
          <img
            src={MatchingManagementSVG}
            style={{ width: "24px", height: "24px" }}
          />
          <p>팀 매칭 상세페이지</p>
        </h2>
        <div className={styles["modal-sub-header"]}>
          <h2>팀 매칭</h2> ({firstData}) <h4>상세페이지</h4>
        </div>
        <Table columCount={2} rowCount={rowCount} maxRowCount={rowCount}>
          <TableRow>
            <TableCell isHeader={true}>{firstHeader}</TableCell>
            <TableCell isHeader={true}>{firstData}</TableCell>
          </TableRow>
          {entriesWithHeader.map(({ header, value }) => (
            <TableRow key={header}>
              <TableCell>{header}</TableCell>
              <TableCell>{value}</TableCell>
            </TableRow>
          ))}
        </Table>
        <div style={{ display: "flex", justifyContent: "end", padding: "8px" }}>
          <ConfirmationModal
            onConfirm={handleConfirmModal}
            completeText={`팀 / 소셜 매칭 ( ${matchingState.id} ) 가 취소되었습니다.`}
            content={`팀 / 소셜 매칭 ( ${matchingState.id} ) 을 \n 취소시키시겠습니까?`}
          >
            <ConfirmationModalTrigger>
              <Button color="var(--main-color)">매칭 취소</Button>
            </ConfirmationModalTrigger>
          </ConfirmationModal>
        </div>
      </Modal>
    </>
  );
};

export default AdminMatchingManagementModal;
