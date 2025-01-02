import { Outlet } from "react-router-dom";
import AdminSidebar from "../../components/Sidebar/AdminSidebar/AdminSidebar";
import styles from "./AdminPage.module.css";

function AdminPage({ gridArea }) {
    return (
        <div className={styles['admin-page-grid']} style={{ gridArea: gridArea }}>
            <AdminSidebar gridArea="side" />
            <div className={styles['admin-page-content']}>
                <Outlet />
            </div>
        </div>
    )
}
export default AdminPage;