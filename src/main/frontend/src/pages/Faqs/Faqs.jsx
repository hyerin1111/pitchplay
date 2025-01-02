// components/FAQAccordion/FAQAccordion.jsx
import React, { useState, useMemo } from 'react';
import { motion, AnimatePresence } from 'framer-motion';
import { useOutletContext } from 'react-router-dom';
import styles from './Faqs.module.css';

function Faqs() {
  const { searchQuery } = useOutletContext(); // 부모 컴포넌트에서 전달된 searchQuery 사용
  const [openIndex, setOpenIndex] = useState(null);
  const [activeIndex, setActiveIndex] = useState(null);

  // 자주 묻는 질문 리스트
  const faqs = useMemo(
    () => [
      {
        Q : '소셜 매치 취소/변경 환불 규정을 알고 싶어요',
        A : `소셜 매치 취소 시 환불 정책
  • 매치 2일 전: 무료 취소
  • 매치 1일 전: 80% 환불
  • 당일 ~ 매치 시작 90분 전까지: 20% 환불
  • 매치 시작 90분 이내: 환불 불가
  
  그 외 취소 기준
  • 취소 수수료 발생 시 사용된 포인트를 우선 차감 후 차액을 캐시로 지급합니다. 
  • 결제 후 30분 이내에는 하루 1회에 한해 무료 취소가 가능합니다. (단, 매치 시작 90분 이내일 경우 불가, 슈퍼서브 취소 포함)
  • 쿠폰 신청자는 매치 시작 90분 전까지 취소 시 쿠폰이 반환됩니다.
  • 결제 시 실 결제금액(쿠폰 제외)을 기준으로 위 규정에 따라 환불됩니다.
  • 매치 시작 90분 전까지 최소 인원이 모이지 않을 시 카카오톡 혹은 LMS으로 안내되며, 자동 전액 환불됩니다.
   (단, 공지 전 직접 취소하시는 경우 상단 일반 환불 규정대로 처리되니 유의하시길 바랍니다)
  
  다음의 경우는 환불이 불가합니다.
  • 구장, 날짜, 시간 등을 실수로 잘못 선택한 경우
  • 부상, 취업 등 개인 사정으로 신청된 매치에 참여하지 못하는 경우
  • 단체 혹은 지인과의 참가로 매치 취소 혹은 변경을 원하는 경우
  • 황사/미세먼지로 인해 취소 혹은 변경을 요청하는 경우
  • 단순 변심으로 취소 혹은 변경을 요청하는 경우
  
  유의사항
  무단 불참하거나 매치 시작 90분 이내에 취소하면 패널티를 받을 수 있습니다.
  (참여가 어려울 경우, 환불이 불가능하더라도 원활한 매치 진행을 위해 나의 플랩에서 미리 취소해주세요.)
  
  소셜 매치 변경 정책
  • 변경은 취소와 동일한 환불 규정으로 적용됩니다.
  • 변경은 상단 환불 정책 기준 100% 환불일 경우에만 가능하며, 규정 외 요청은 적용이 불가합니다.`
      },
      {
        Q : '매치 진행을 위한 최소 인원이 궁금해요',
        A : `매치 성격 및 구장 크기에 따라 진행을 위한 최소 인원은 달라질 수 있습니다. 
  
  확인 방법
  1. 신청 전:  매치 [상세 페이지] → [매치 포인트] 확인
  2. 신청 후: [마이페이지] → [신청내역] → [매치 성격] 확인 
  
  기본 최소 인원
  • 4:4 3파전 매치: 최소 인원 6명 
  • 5:5, 6:6 3파전 매치: 최소 인원 10명
  • 7:7 3파전 매치: 최소 인원 12명(단, 제주 외도 YJ 풋살장 Y구장의 경우 최소 인원 10명)
  • 8:8 축구 매치: 최소 인원 16명
  • 11:11 축구 매치: 최소 인원 16명(화성 봉담) 
  • 11:11 축구 매치: 최소 인원 20명(경기 광주 팀업캡퍼스, 고양 원흥 PMP, 대구 팔공 K스타디움)
  
  매치 시작 1시간 30분 전까지 최소 인원이 모일 경우 매치가 확정되며, 확정/취소 알림톡을 통해 플레이어분들께 진행 여부를 안내 드리고 있어요.
  
  단, 매치가 확정되더라도 최소 인원만 모일 경우 로테이션 방식이 기존과 달라질 수 있습니다.`
      },
      {
        Q : '계정 탈퇴를 하고 싶어요',
        A : `이용자 및 법정 대리인은 언제든지 자신의 개인정보를 조회하거나 수정할 수 있으며, 수집 및 이용에 대한 동의 철회(가입 해지)를 요청할 수 있습니다.
  
  탈퇴 방법
  [마이페이지] → [설정] → [탈퇴하기]
  * 회원 탈퇴 시 해당 아이디는 즉시 이용 중단 돼요.
  
  유의할 점
  • 보유 중인 캐시가 있다면 전액 환불 처리 후 신청해주세요.
  • 대기 중인 일정이 있다면 일정을 취소하거나 끝난 후 탈퇴할 수 있어요.
  • 운영 중인 팀이 있다면 팀 삭제 또는 운영자 양도를 신청해주세요.
  • 회원 탈퇴 후 30일 동안 재가입이 불가능 해요.
  • 레드카드, 이용 정지 이력이 있는 경우 재가입이 영구적으로 불가능 해요.
  • 개인정보와 서비스 이용 내역은 30일 후 모두 삭제되며, 복구 불가능 해요.`
      },
      {
        Q : '충전한 캐시를 환불받고 싶어요',
        A : `환불 방법
  • [마이페이지] → [충전 내역] → [잔액 환불 클릭]
  • 실제 캐시 잔액에 한해 환불 가능(포인트는 환불 불가)
  
  환불은 매주 월요일, 금요일 저녁 5 - 6시 사이에 일괄 처리됩니다.
  
  공휴일은 월요일 대신 화요일 오전에, 금요일 대신 목요일 오후에 환불됩니다.`
      },
      {
        Q : '비가 와도 매치를 진행하나요?',
        A : `피치플레이에서는 강수 예보에도 참여를 원하시는 플레이어분들이 있다면 가능한 경기를 진행하고 있습니다.
  
  또한 실시간으로 확인해 1mm이상의 예보가 있다면 매치 시작 4시간 전에 알림톡을 발송해드립니다.
  
  강수 알림톡을 받으신 경우 매치 시작 1시간 30분 전까지 취소하면 전액 환불되오니,
  
  참여를 원하지 않는다면 매치 시작 1시간 30분 전까지 사전 취소 부탁드립니다.
  
  단, 다수의 취소자 발생, 구장 상태가 좋지 않아 진행이 어렵다면 플레이어분들의 안전을 위해 매치 시작 90분 이내라도 취소될 수 있습니다.`
      },
      {
        Q : '비(눈)으로 인한 매치 현장 취소/중단 시 환불은 언제 되나요?',
        A : `비(눈)으로 인한 매치 현장 취소/중단은 캐시, 이용권 플레이어를 대상으로 환불 되고 있어요.
  
  진행하지 못한 시간만큼 익일 오전 중 포인트로 반환 되고 있습니다.
  
  * 강수 알림톡이 발송된 매치의 경우, 조기 귀가로 인한 미참여 시간에 대한 환불은 불가합니다.`
      },
      {
        Q : '구장 예약이 무엇인가요?',
        A : `플레이어는 홈페이지를 통해 원하는 시간에 구장을 쉽게 예약할 수 있어요.
  
  홈페이지에 공개된 구장 중 원하는 일정을 선택해 예약을 직접 진행해주시면 됩니다. 
  
  단, 소셜 매치와 달리 매니저가 배정되지 않으며 함께 공을 찰 분들을 직접 구하셔야 해요.`
      },
      {
        Q : '옐로카드를 받았어요',
        A : `• 옐로 카드 발급 시 발급일이 표시됩니다. 
  • 발급 후 5경기 동안 신고를 받지 않으면 마지막 경기 기준 4일 뒤 새벽 1시에 자동 해제됩니다. 
  • 5경기 동안 추가적으로 비매너 신고를 받으면 내역에 표시됨과 동시에, 옐로카드 해제를 위한 경기 수가 그만큼 늘어나게 됩니다.  
  (ex. 5경기 중 1경기에서 비매너 신고 추가 접수 시, 6경기 후 비활성화)
  • 옐로카드가 해제되어도 신고 내역 및 누적횟수는 계속 기록됩니다. . 
  • 주의의 의미로 1차 안내를 하는 것이 목적이기 때문에 여러 경기, 여러 명의 신고가 누적되어 객관성이 확보된 경우 발급됩니다. 
  • 따라서 일시적으로 슈퍼서브 사용이 중단될 뿐 매치 참여에는 제한이나 불이익이 생기지 않습니다. 
  • 개인의 신고 내역을 타인에게 공개하지 않지 않습니다.
  
  자세한 카드 발급 사유는 [마이페이지] → [옐로카드] → [자세히 보기]에서 확인 가능합니다.`
      },
    ],
    []
  );

  // searchQuery에 따라 필터링된 FAQ 리스트
  const filteredFaqs = faqs.filter(
    (faq) => faq.Q.toLowerCase().includes(searchQuery.toLowerCase()) || faq.A.toLowerCase().includes(searchQuery.toLowerCase())
  );

  const toggleAccordion = (index) => {
    setOpenIndex(openIndex === index ? null : index);
    setActiveIndex(openIndex === index ? null : index);
  };

  return (
    <div className={styles['accordion-container']}>
      {filteredFaqs.length > 0 ? (
        filteredFaqs.map((faq, index) => (
          <div key={index} className={styles['accordion-item']}>
            <div
              className={`${styles['accordion-title']} ${activeIndex === index ? styles['active'] : ''}`}
              onClick={() => toggleAccordion(index)}
            >
              <h3><strong>Q :</strong> {faq.Q}</h3>
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
                  <p><strong>A :</strong> {faq.A}</p>
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

export default Faqs;
