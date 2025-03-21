import styles from "./AdminSidebar.module.css";
import dashboard from "../../../assets/icons/admin_dashboard.svg";
import member from "../../../assets/icons/admin_user.svg";
import matching from "../../../assets/icons/admin_matching.svg";
import team from "../../../assets/icons/admin_team.svg";
import reservation from "../../../assets/icons/admin_reservation.svg";
import board from "../../../assets/icons/admin_board.svg";
import payment from "../../../assets/icons/admin_payment.svg";
import { useLocation, useNavigate } from "react-router-dom";
import { motion } from "framer-motion";

const AdminSidebar = ({ gridArea }) => {
  const navigate = useNavigate();
  const url = useLocation();

  const currentPath = url.pathname.split("/").splice(2);

  // 기본적으로 "대시보드" 메뉴가 선택되도록 처리
  const defaultActive = currentPath.length === 0 || currentPath[0] === 'dashboard';

  const menuItems = [
    {
      id: "dashboard",
      label: "대시보드",
      icon: dashboard,
      handleClick: () => navigate("/admin"),
    },
    {
      id: "member-management",
      label: "회원관리",
      icon: member,
      handleClick: () => navigate("/admin/member-management"),
    },
    {
      id: "matching-management",
      label: "매칭관리",
      icon: matching,
      handleClick: () => navigate("/admin/matching-management"),
    },
    {
      id: "team-management",
      label: "팀관리",
      icon: team,
      handleClick: () => navigate("/admin/team-management"),
    },
    {
      id: "stadium-reservation",
      label: "구장예약",
      icon: reservation,
      handleClick: () => navigate("/admin/stadium-reservation"),
    },
    {
      id: "notice-board",
      label: "게시판",
      icon: board,
      handleClick: () => navigate("/admin/notice-board"),
    },
    {
      id: "payment-management",
      label: "결제관리",
      icon: payment,
      handleClick: () => navigate("/admin/payment-management"),
    },
  ];

  return (
    <div className={styles.sidebar} style={{ gridArea: gridArea }}>
      {menuItems.map(({ id, label, icon, handleClick }) => (
        <motion.button
          key={id}
          whileHover={{
            scale: 1.1, 
            transition: { duration: 0.2 },
          }}
          whileTap={{ scale: 0.95 }}
          className={`${styles['sidebar-item']} 
            ${currentPath.includes(id) || (defaultActive && id === "dashboard") ? styles.active : ""}`}
          onClick={handleClick}
        >
          <img
            src={icon}
            alt={`${label} icon`}
            className={styles['sidebar-icon']}
          />
          <span className={styles['sidebar-text']}>{label}</span>
        </motion.button>
      ))}
    </div>
  );
};

export default AdminSidebar;