import React, { useState, useMemo } from "react";
import { useOutletContext } from "react-router-dom";
import { motion, AnimatePresence } from "framer-motion";
import styles from "./Notices.module.css";

function NoticeAccordion() {
  const { searchQuery } = useOutletContext(); // 부모 컴포넌트에서 전달된 searchQuery 사용
  const [openIndex, setOpenIndex] = useState(null);

  const notices = useMemo(
    () => [
    { id: 1, title: '[공지] 매치 취소 시 환불정책', content: '소셜 매치 취소 시 환불 정책• 매치 2일 전: 무료 취소• 매치 1일 전: 80% 환불• 당일 ~ 매치 시작 90분 전까지: 20% 환불• 매치 시작 90분 이내: 환불 불가그 외 취소 기준• 취소 수수료 발생 시 사용된 포인트를 우선 차감 후 차액을 캐시로 지급합니다. • 결제 후 30분 이내에는 하루 1회에 한해 무료 취소가 가능합니다. (단, 매치 시작 90분 이내일 경우 불가, 슈퍼서브 취소 포함)• 쿠폰 신청자는 매치 시작 90분 전까지 취소 시 쿠폰이 반환됩니다.• 결제 시 실 결제금액(쿠폰 제외)을 기준으로 위 규정에 따라 환불됩니다.• 매치 시작 90분 전까지 최소 인원이 모이지 않을 시 카카오톡 혹은 LMS으로 안내되며, 자동 전액 환불됩니다. (단, 공지 전 직접 취소하시는 경우 상단 일반 환불 규정대로 처리되니 유의하시길 바랍니다)' },
    { id: 2, title: '[공지] 강수 알림톡이 발송된 매치 환불 규정 변경', content: '안녕하세요, 피치 플레이입니다. 오는 11월 18일 매치부터 비·눈이 오는 매치 중 강수 알림톡이 발송된 매치의 환불 규정이 변경됩니다. 아래의 변경 사항을 확인하시어, 서비스 이용에 참고 부탁드립니다.  • 변경 전 강수 알림톡 발송 여부 관계없이 매치 중 조기 귀가 시 미참여 시간만큼 포인트 환불 • 변경 후 강수 알림톡이 발송된 매치 참여 중 중도 포기하여 귀가하는 경우 환불 불가 • 변경 시점 2024년 11월 18일 09시 매치부터 적용 항상 저희 서비스를 이용해 주셔서 감사드리며, 앞으로도 플레이어님들께 더욱 신뢰 받는 서비스로 보답할 수 있도록 최선을 다하겠습니다. 감사합니다.' },
    { id: 3, title: '[공지] 분실물 발생 시 안내 및 유의사항', content: '안녕하세요, 피치 플레이입니다. 피치 플레이 서비스를 사랑해 주시는 플레이어님들께 진심으로 감사드리며, 최근 분실물 관련 문의가 증가함에 따라 이에 대한 안내를 드리고자 합니다. 매치 중 분실물이 발생할 경우 플레이어님께서 직접 구장을 방문하여 물품을 두셨던 장소를 확인해 보시는 것을 권장드립니다. 아울러 모든 분실물에 대한 책임은 플레이어 본인에게 있음을 안내드리며, 개인 물품 관리에 각별한 주의를 기울여 주시길 부탁드립니다. 항상 플레이어님들의 협조에 감사드리며, 더욱 만족스러운 서비스를 제공하기 위해 최선을 다하겠습니다. 감사합니다.' },
    { id: 4, title: '[공지] 매치 취소 시 환불정책', content: '소셜 매치 취소 시 환불 정책• 매치 2일 전: 무료 취소• 매치 1일 전: 80% 환불• 당일 ~ 매치 시작 90분 전까지: 20% 환불• 매치 시작 90분 이내: 환불 불가그 외 취소 기준• 취소 수수료 발생 시 사용된 포인트를 우선 차감 후 차액을 캐시로 지급합니다. • 결제 후 30분 이내에는 하루 1회에 한해 무료 취소가 가능합니다. (단, 매치 시작 90분 이내일 경우 불가, 슈퍼서브 취소 포함)• 쿠폰 신청자는 매치 시작 90분 전까지 취소 시 쿠폰이 반환됩니다.• 결제 시 실 결제금액(쿠폰 제외)을 기준으로 위 규정에 따라 환불됩니다.• 매치 시작 90분 전까지 최소 인원이 모이지 않을 시 카카오톡 혹은 LMS으로 안내되며, 자동 전액 환불됩니다. (단, 공지 전 직접 취소하시는 경우 상단 일반 환불 규정대로 처리되니 유의하시길 바랍니다)' },
    { id: 5, title: '[공지] 강수 알림톡이 발송된 매치 환불 규정 변경', content: '안녕하세요, 피치 플레이입니다. 오는 11월 18일 매치부터 비·눈이 오는 매치 중 강수 알림톡이 발송된 매치의 환불 규정이 변경됩니다. 아래의 변경 사항을 확인하시어, 서비스 이용에 참고 부탁드립니다.  • 변경 전 강수 알림톡 발송 여부 관계없이 매치 중 조기 귀가 시 미참여 시간만큼 포인트 환불 • 변경 후 강수 알림톡이 발송된 매치 참여 중 중도 포기하여 귀가하는 경우 환불 불가 • 변경 시점 2024년 11월 18일 09시 매치부터 적용 항상 저희 서비스를 이용해 주셔서 감사드리며, 앞으로도 플레이어님들께 더욱 신뢰 받는 서비스로 보답할 수 있도록 최선을 다하겠습니다. 감사합니다.' },
    { id: 6, title: '[공지] 분실물 발생 시 안내 및 유의사항', content: '안녕하세요, 피치 플레이입니다. 피치 플레이 서비스를 사랑해 주시는 플레이어님들께 진심으로 감사드리며, 최근 분실물 관련 문의가 증가함에 따라 이에 대한 안내를 드리고자 합니다. 매치 중 분실물이 발생할 경우 플레이어님께서 직접 구장을 방문하여 물품을 두셨던 장소를 확인해 보시는 것을 권장드립니다. 아울러 모든 분실물에 대한 책임은 플레이어 본인에게 있음을 안내드리며, 개인 물품 관리에 각별한 주의를 기울여 주시길 부탁드립니다. 항상 플레이어님들의 협조에 감사드리며, 더욱 만족스러운 서비스를 제공하기 위해 최선을 다하겠습니다. 감사합니다.' },
    { id: 7, title: '[공지] 매치 취소 시 환불정책', content: '소셜 매치 취소 시 환불 정책• 매치 2일 전: 무료 취소• 매치 1일 전: 80% 환불• 당일 ~ 매치 시작 90분 전까지: 20% 환불• 매치 시작 90분 이내: 환불 불가그 외 취소 기준• 취소 수수료 발생 시 사용된 포인트를 우선 차감 후 차액을 캐시로 지급합니다. • 결제 후 30분 이내에는 하루 1회에 한해 무료 취소가 가능합니다. (단, 매치 시작 90분 이내일 경우 불가, 슈퍼서브 취소 포함)• 쿠폰 신청자는 매치 시작 90분 전까지 취소 시 쿠폰이 반환됩니다.• 결제 시 실 결제금액(쿠폰 제외)을 기준으로 위 규정에 따라 환불됩니다.• 매치 시작 90분 전까지 최소 인원이 모이지 않을 시 카카오톡 혹은 LMS으로 안내되며, 자동 전액 환불됩니다. (단, 공지 전 직접 취소하시는 경우 상단 일반 환불 규정대로 처리되니 유의하시길 바랍니다)' },
    { id: 8, title: '[공지] 강수 알림톡이 발송된 매치 환불 규정 변경', content: '안녕하세요, 피치 플레이입니다. 오는 11월 18일 매치부터 비·눈이 오는 매치 중 강수 알림톡이 발송된 매치의 환불 규정이 변경됩니다. 아래의 변경 사항을 확인하시어, 서비스 이용에 참고 부탁드립니다.  • 변경 전 강수 알림톡 발송 여부 관계없이 매치 중 조기 귀가 시 미참여 시간만큼 포인트 환불 • 변경 후 강수 알림톡이 발송된 매치 참여 중 중도 포기하여 귀가하는 경우 환불 불가 • 변경 시점 2024년 11월 18일 09시 매치부터 적용 항상 저희 서비스를 이용해 주셔서 감사드리며, 앞으로도 플레이어님들께 더욱 신뢰 받는 서비스로 보답할 수 있도록 최선을 다하겠습니다. 감사합니다.' },
    { id: 9, title: '[공지] 분실물 발생 시 안내 및 유의사항', content: '안녕하세요, 피치 플레이입니다. 피치 플레이 서비스를 사랑해 주시는 플레이어님들께 진심으로 감사드리며, 최근 분실물 관련 문의가 증가함에 따라 이에 대한 안내를 드리고자 합니다. 매치 중 분실물이 발생할 경우 플레이어님께서 직접 구장을 방문하여 물품을 두셨던 장소를 확인해 보시는 것을 권장드립니다. 아울러 모든 분실물에 대한 책임은 플레이어 본인에게 있음을 안내드리며, 개인 물품 관리에 각별한 주의를 기울여 주시길 부탁드립니다. 항상 플레이어님들의 협조에 감사드리며, 더욱 만족스러운 서비스를 제공하기 위해 최선을 다하겠습니다. 감사합니다.' },
    { id: 10, title: '[공지] 매치 취소 시 환불정책', content: '소셜 매치 취소 시 환불 정책• 매치 2일 전: 무료 취소• 매치 1일 전: 80% 환불• 당일 ~ 매치 시작 90분 전까지: 20% 환불• 매치 시작 90분 이내: 환불 불가그 외 취소 기준• 취소 수수료 발생 시 사용된 포인트를 우선 차감 후 차액을 캐시로 지급합니다. • 결제 후 30분 이내에는 하루 1회에 한해 무료 취소가 가능합니다. (단, 매치 시작 90분 이내일 경우 불가, 슈퍼서브 취소 포함)• 쿠폰 신청자는 매치 시작 90분 전까지 취소 시 쿠폰이 반환됩니다.• 결제 시 실 결제금액(쿠폰 제외)을 기준으로 위 규정에 따라 환불됩니다.• 매치 시작 90분 전까지 최소 인원이 모이지 않을 시 카카오톡 혹은 LMS으로 안내되며, 자동 전액 환불됩니다. (단, 공지 전 직접 취소하시는 경우 상단 일반 환불 규정대로 처리되니 유의하시길 바랍니다)' },
    { id: 11, title: '[공지] 강수 알림톡이 발송된 매치 환불 규정 변경', content: '안녕하세요, 피치 플레이입니다. 오는 11월 18일 매치부터 비·눈이 오는 매치 중 강수 알림톡이 발송된 매치의 환불 규정이 변경됩니다. 아래의 변경 사항을 확인하시어, 서비스 이용에 참고 부탁드립니다.  • 변경 전 강수 알림톡 발송 여부 관계없이 매치 중 조기 귀가 시 미참여 시간만큼 포인트 환불 • 변경 후 강수 알림톡이 발송된 매치 참여 중 중도 포기하여 귀가하는 경우 환불 불가 • 변경 시점 2024년 11월 18일 09시 매치부터 적용 항상 저희 서비스를 이용해 주셔서 감사드리며, 앞으로도 플레이어님들께 더욱 신뢰 받는 서비스로 보답할 수 있도록 최선을 다하겠습니다. 감사합니다.' },
    { id: 12, title: '[공지] 분실물 발생 시 안내 및 유의사항', content: '안녕하세요, 피치 플레이입니다. 피치 플레이 서비스를 사랑해 주시는 플레이어님들께 진심으로 감사드리며, 최근 분실물 관련 문의가 증가함에 따라 이에 대한 안내를 드리고자 합니다. 매치 중 분실물이 발생할 경우 플레이어님께서 직접 구장을 방문하여 물품을 두셨던 장소를 확인해 보시는 것을 권장드립니다. 아울러 모든 분실물에 대한 책임은 플레이어 본인에게 있음을 안내드리며, 개인 물품 관리에 각별한 주의를 기울여 주시길 부탁드립니다. 항상 플레이어님들의 협조에 감사드리며, 더욱 만족스러운 서비스를 제공하기 위해 최선을 다하겠습니다. 감사합니다.' },
    ],
    []
  );

  const filteredNotices = useMemo(
    () =>
      notices.filter(
        (notice) =>
          notice.title.includes(searchQuery) ||
          notice.content.includes(searchQuery)
      ),
    [notices, searchQuery]
  );

  const toggleAccordion = (index) => {
    setOpenIndex(openIndex === index ? null : index);
  };

  return (
    <div className={styles['accordion-container']}>
      {filteredNotices.length > 0 ? (
        filteredNotices.map((notice, index) => (
          <div key={notice.id} className={styles['accordion-item']}>
            <div
              className={`${styles['accordion-title']} ${openIndex === index ? styles['active'] : ''}`}
              onClick={() => toggleAccordion(index)}
            >
              <h3>{notice.title}</h3>
            </div>
            <AnimatePresence>
              {openIndex === index && (
                <motion.div
                  className={styles['accordion-content']}
                  initial={{ height: 0 }}
                  animate={{ height: 'auto' }}
                  exit={{ height: 0 }}
                  transition={{ duration: 0.3, ease: 'easeInOut' }}
                >
                  <p>{notice.content}</p>
                </motion.div>
              )}
            </AnimatePresence>
          </div>
        ))
      ) : (
        <p>검색 결과가 없습니다.</p>
      )}
    </div>
  );
}

export default NoticeAccordion;