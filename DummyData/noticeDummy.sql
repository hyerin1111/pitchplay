-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        11.5.2-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 테이블 데이터 pitchplay.notice:~41 rows (대략적) 내보내기
INSERT INTO `notice` (`notice_id`, `author_user_uid`, `create_at`, `notice_content`, `notice_type`, `notice_title`) VALUES
	('0485944c-56d7-4e94-976b-5e55c1abf7b5', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:01:11.189157', '안녕하세요, 피치 플레이입니다. 2025년 8월부터 피치 플레이와 제휴된 매장에서 할인 혜택을 제공합니다. 매치 예약 시 회원 인증을 통해 제휴 매장에서 사용 가능한 다양한 할인 혜택을 받으실 수 있습니다. 제휴 매장 목록과 할인 내용은 홈페이지에서 확인 가능합니다.', 'ANNOUNCEMENT', '[공지] 신규 제휴 매장 할인 안내'),
	('08455a8d-2363-4cb1-8b42-5acb4c9d35db', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:01:13.048158', '안녕하세요, 피치 플레이입니다. 2025년 9월 1일부터 새로운 앱 버전이 업데이트됩니다. 이 버전에서는 UI/UX 개선과 함께 안정성 향상, 일부 기능 추가가 이루어집니다. 최신 버전으로 업데이트하여 더 나은 서비스를 이용해 주세요.', 'ANNOUNCEMENT', '[공지] 앱 업데이트 안내'),
	('09b55f1d-46c0-4545-b29b-1a932c30d46e', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:24:46.728327', 'A: 네, 소셜 매치 환불 규정이 업데이트되었습니다. 변경된 규정은 아래와 같습니다:\n\n• 매치 3일 전: 무료 취소\n• 매치 2일 전: 70% 환불\n• 매치 1일 전: 50% 환불\n• 당일 ~ 매치 시작 60분 전까지: 20% 환불\n• 매치 시작 60분 이내: 환불 불가\n\n변경된 환불 규정은 2025년 6월 1일부터 적용됩니다.', 'FAQ', '소셜 매치 환불 규정이 업데이트되었나요?'),
	('0d6c2566-1643-4b30-8ee9-2a3736b83f2d', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:26:25.689135', 'A: 매치 취소 시 잔여 포인트는 환불되지 않으며, 취소 규정에 따라 포인트가 차감되거나 캐시로 환불될 수 있습니다. \n• 취소 수수료가 발생할 경우, 사용된 포인트가 우선 차감되고 나머지 차액이 캐시로 지급됩니다.', 'FAQ', '매치 취소 후 잔여 포인트는 어떻게 되나요?'),
	('0eef0107-684a-48b9-89ee-dfb154a79dac', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:26:22.798218', 'A: 매치가 특정 날짜에 열리지 않는 경우는 다음과 같은 이유가 있을 수 있습니다. \n• 구장의 사정에 의한 예약 불가 \n• 시즌 종료 또는 특정 기념일로 인한 휴무 \n• 최소 인원 미달로 매치 취소 \n• 기타 시스템 오류 등\n• 자세한 사항은 고객센터를 통해 확인 가능합니다.', 'FAQ', '특정 날짜에 매치가 열리지 않는 이유는 무엇인가요?'),
	('1313ab59-f913-4670-9918-4c8304b5c11d', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:24:54.574455', 'A: 매치 취소 시 환불은 다음과 같습니다:\n\n• 매치 시작 2일 전: 전액 환불\n• 매치 시작 1일 전: 80% 환불\n• 매치 시작 90분 전까지: 20% 환불\n• 매치 시작 90분 이내: 환불 불가\n\n환불은 원칙적으로 결제 금액에 대해 진행되며, 환불 처리에 필요한 시간은 최대 5일이 소요됩니다.', 'FAQ', '매치 취소 시 환불은 어떻게 되나요?'),
	('1d591046-999f-44d3-8f79-5d6d8d880583', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:25:10.562327', 'A: 매치 시작 후 현장에서 취소하거나 중단할 경우 환불이 불가합니다. \n• 다만, 특별한 사정으로 현장에서 취소 및 중단을 요청할 경우, 사후 처리는 고객센터를 통해 확인 후 안내드릴 수 있습니다.', 'FAQ', '현장 취소 또는 중단 시 환불은 어떻게 되나요?'),
	('238d5d9e-5432-4dd1-81cf-749548d72946', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 16:59:38.953539', '안녕하세요, 피치 플레이입니다. 2025년 2월부터 신규 매치가 추가됩니다. 다양한 스포츠 종목과 시간대를 포함하여 더 많은 선택지를 제공할 예정입니다. 새로운 매치에 대한 세부 사항은 추후 공지드리겠습니다. 많은 관심 부탁드립니다.', 'ANNOUNCEMENT', '[공지] 신규 매치 추가 안내'),
	('4cbe5ad3-a85c-40b6-ba42-cf004684ff7e', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:25:06.763441', 'A: 매치 시작 90분 전까지 최소 인원이 충족되지 않으면 자동으로 매치는 취소되며, 전액 환불이 처리됩니다. \n• 해당 매치는 카카오톡 또는 LMS를 통해 안내드리며, 회원은 취소된 매치에 대해 환불을 받게 됩니다.', 'FAQ', '소셜 매치 최소 인원 충족되지 않으면 어떻게 되나요?'),
	('5108a783-876f-466d-90fa-6f8379c78382', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:24:52.760072', 'A: 비가 오는 경우에도 자동 환불은 이루어지지 않습니다.\n\n• 강수 알림톡 발송 후 매치가 진행되면 환불은 불가합니다.\n• 강수 알림톡 발송 이전에 취소 요청 시 80% 환불이 가능합니다.', 'FAQ', '비가 오면 소셜 매치가 자동으로 환불되나요?'),
	('5803b1d7-6937-4268-bc3c-ce76e3ed6956', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:01:03.409715', '안녕하세요, 피치 플레이입니다. 신규 고객을 위한 전담 지원 서비스가 추가되었습니다. 고객 지원팀은 24시간 온라인 채팅을 통해 실시간 상담을 제공하며, 자주 묻는 질문에 대한 답변도 빠르게 확인할 수 있습니다. 고객님의 만족도를 높이기 위해 항상 노력하겠습니다.', 'ANNOUNCEMENT', '[공지] 신규 고객 지원 서비스 안내'),
	('5883d602-a5cb-4c37-904c-58c50c1cfc06', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 16:59:42.648993', '안녕하세요, 피치 플레이입니다. 최근 스포츠 매치 중 안전사고에 대한 우려가 커짐에 따라, 안전사고 예방을 위한 규정을 강화하였습니다. 이용자분들의 안전을 위해 규정을 철저히 지켜주시기 바랍니다. 안전한 매치 환경을 제공하기 위해 지속적으로 노력하겠습니다. 감사합니다.', 'ANNOUNCEMENT', '[공지] 안전사고 예방을 위한 안내'),
	('5b374f7a-69ed-4d5a-bb72-058d49a7771c', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:24:50.843519', 'A: 주간 매치 취소 및 환불 규정은 다음과 같습니다:\n\n• 매치 4일 전: 무료 취소\n• 매치 3일 전: 70% 환불\n• 매치 2일 전: 50% 환불\n• 매치 1일 전: 30% 환불\n• 매치 시작 1시간 전까지: 10% 환불\n• 매치 시작 1시간 이내: 환불 불가\n\n각 매치의 취소 및 환불은 위 규정에 따라 처리됩니다.', 'FAQ', '주간 매치 취소 규정은 어떻게 되나요?'),
	('5d706e52-17f4-4a6c-87fe-72bdedbeacdf', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 16:59:37.241668', '안녕하세요, 피치 플레이입니다. 2025년 1월 15일 00:00부터 02:00까지 서버 점검이 예정되어 있습니다. 이 시간 동안 서비스 이용이 불가능하오니, 이용에 참고해 주시기 바랍니다. 점검 후 더 나은 서비스를 제공할 수 있도록 노력하겠습니다. 감사합니다.', 'ANNOUNCEMENT', '[공지] 서버 점검 안내'),
	('5eccba72-0a48-4374-8eeb-bd93b5c49722', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:24:58.338609', 'A: 매치 시작 전 취소 시 환불 규정은 아래와 같습니다:\n\n• 매치 시작 3일 전: 무료 취소\n• 매치 시작 2일 전: 70% 환불\n• 매치 시작 1일 전: 50% 환불\n• 매치 시작 30분 전까지: 10% 환불\n• 매치 시작 30분 이내: 환불 불가\n\n환불은 결제금액 기준으로 처리되며, 포인트 환불 시 차액은 캐시로 지급됩니다.', 'FAQ', '매치 시작 전 취소 시 환불 규정은 무엇인가요?'),
	('65839553-5c84-4f70-9ab6-0c3a4279f2b4', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:20:48.479295', 'A : 소셜 매치 취소 시 환불 정책  • 매치 2일 전: 무료 취소  • 매치 1일 전: 80% 환불  • 당일 ~ 매치 시작 90분 전까지: 20% 환불  • 매치 시작 90분 이내: 환불 불가  그 외 취소 기준  • 취소 수수료 발생 시 사용된 포인트를 우선 차감 후 차액을 캐시로 지급합니다.   • 결제 후 30분 이내에는 하루 1회에 한해 무료 취소가 가능합니다. (단, 매치 시작 90분 이내일 경우 불가, 슈퍼서브 취소 포함)  • 쿠폰 신청자는 매치 시작 90분 전까지 취소 시 쿠폰이 반환됩니다.  • 결제 시 실 결제금액(쿠폰 제외)을 기준으로 위 규정에 따라 환불됩니다.  • 매치 시작 90분 전까지 최소 인원이 모이지 않을 시 카카오톡 혹은 LMS으로 안내되며, 자동 전액 환불됩니다.   (단, 공지 전 직접 취소하시는 경우 상단 일반 환불 규정대로 처리되니 유의하시길 바랍니다)  다음의 경우는 환불이 불가합니다.  • 구장, 날짜, 시간 등을 실수로 잘못 선택한 경우  • 부상, 취업 등 개인 사정으로 신청된 매치에 참여하지 못하는 경우  • 단체 혹은 지인과의 참가로 매치 취소 혹은 변경을 원하는 경우  • 황사/미세먼지로 인해 취소 혹은 변경을 요청하는 경우  • 단순 변심으로 취소 혹은 변경을 요청하는 경우  유의사항  무단 불참하거나 매치 시작 90분 이내에 취소하면 패널티를 받을 수 있습니다.  (참여가 어려울 경우, 환불이 불가능하더라도 원활한 매치 진행을 위해 나의 플랩에서 미리 취소해주세요.)  소셜 매치 변경 정책  • 변경은 취소와 동일한 환불 규정으로 적용됩니다.  • 변경은 상단 환불 정책 기준 100% 환불일 경우에만 가능하며, 규정 외 요청은 적용이 불가합니다.', 'FAQ', '소셜 매치 취소/변경 환불 규정을 알고 싶어요'),
	('71f86f1e-cbb1-4012-b374-75a7996e85f8', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:01:15.353121', '안녕하세요, 피치 플레이입니다. 2025년 10월부터 회원 등급 시스템이 개편됩니다. 기존의 회원 등급에 따라 다양한 혜택을 제공하며, 새로운 등급에 따라 더욱 풍성한 혜택을 누리실 수 있습니다. 새로운 회원 등급 시스템에 대한 자세한 사항은 홈페이지를 통해 확인해 주세요.', 'ANNOUNCEMENT', '[공지] 회원 등급 시스템 개편 안내'),
	('78f9fc21-2f2c-495b-86d4-074951255d0b', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:24:56.536978', 'A: 소셜 매치 취소 시 발생하는 수수료는 사용된 포인트로 차감됩니다.\n• 수수료 차감 후 남은 금액은 캐시로 환불됩니다.\n• 쿠폰 신청자는 매치 시작 90분 전까지 취소 시 쿠폰이 반환됩니다.\n\n기타 취소 관련 사항은 고객센터로 문의해 주세요.', 'FAQ', '소셜 매치 취소 시 포인트 차감은 어떻게 되나요?'),
	('7aeceb6e-9d3a-4d15-977a-b290dd1f7130', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 16:59:25.731329', '소셜 매치 취소 시 환불 정책• 매치 2일 전: 무료 취소• 매치 1일 전: 80% 환불• 당일 ~ 매치 시작 90분 전까지: 20% 환불• 매치 시작 90분 이내: 환불 불가그 외 취소 기준• 취소 수수료 발생 시 사용된 포인트를 우선 차감 후 차액을 캐시로 지급합니다. • 결제 후 30분 이내에는 하루 1회에 한해 무료 취소가 가능합니다. (단, 매치 시작 90분 이내일 경우 불가, 슈퍼서브 취소 포함)• 쿠폰 신청자는 매치 시작 90분 전까지 취소 시 쿠폰이 반환됩니다.• 결제 시 실 결제금액(쿠폰 제외)을 기준으로 위 규정에 따라 환불됩니다.• 매치 시작 90분 전까지 최소 인원이 모이지 않을 시 카카오톡 혹은 LMS으로 안내되며, 자동 전액 환불됩니다. (단, 공지 전 직접 취소하시는 경우 상단 일반 환불 규정대로 처리되니 유의하시길 바랍니다)', 'ANNOUNCEMENT', '[공지] 매치 취소 시 환불정책'),
	('85cdb167-00b1-4f11-80af-807595c5832e', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:26:27.634186', 'A: 쿠폰은 매치 예약 시 결제 페이지에서 입력하여 적용할 수 있습니다. \n• 쿠폰은 결제 시 실 결제 금액에서 차감되며, 일부 쿠폰은 특정 매치에만 사용 가능합니다. \n• 쿠폰 사용 조건 및 유효기간을 확인한 후 적용하시기 바랍니다.', 'FAQ', '쿠폰은 매치 예약에 어떻게 적용하나요?'),
	('86b73159-615c-4f95-8096-e2a9e76691b0', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:25:14.768544', 'A: 옐로카드는 소셜 매치에서 규정을 위반한 경우 발급됩니다. \n• 옐로카드를 받으면 향후 매치 참여에 제한이 있을 수 있으며, 누적 시 패널티가 적용될 수 있습니다. \n• 자세한 사항은 고객센터를 통해 문의하시기 바랍니다.', 'FAQ', '옐로카드를 받으면 어떻게 되나요?'),
	('8a836a1b-de30-4c15-82f8-6812408c1ea8', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 16:59:40.862732', '안녕하세요, 피치 플레이입니다. 2025년 3월부터 멤버십 혜택이 일부 변경됩니다. 변경된 사항은 홈페이지 및 앱을 통해 확인하실 수 있습니다. 혜택 변경에 따라 서비스 이용에 차질이 없도록 미리 확인해 주세요. 감사합니다.', 'ANNOUNCEMENT', '[공지] 멤버십 혜택 변경 안내'),
	('8ab8fd08-7093-49e6-8ee3-df1c59e934c1', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:24:48.873013', 'A: 네, 매치 환불 정책이 개선되었습니다.\n\n• 매치 5일 전: 무료 취소\n• 매치 4일 전: 80% 환불\n• 매치 3일 전: 50% 환불\n• 매치 2일 전: 30% 환불\n• 매치 시작 2시간 전까지: 10% 환불\n• 매치 시작 2시간 이내: 환불 불가\n\n취소 시 30분 이내에는 포인트를 우선 차감하며, 나머지는 캐시로 지급됩니다.', 'FAQ', '매치 환불 정책이 개선되었나요?'),
	('8f368f96-bd13-4644-8a4d-1f2d0257bac0', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 16:59:31.132954', '안녕하세요, 피치 플레이입니다. 피치 플레이 서비스를 사랑해 주시는 플레이어님들께 진심으로 감사드리며, 최근 분실물 관련 문의가 증가함에 따라 이에 대한 안내를 드리고자 합니다. 매치 중 분실물이 발생할 경우 플레이어님께서 직접 구장을 방문하여 물품을 두셨던 장소를 확인해 보시는 것을 권장드립니다. 아울러 모든 분실물에 대한 책임은 플레이어 본인에게 있음을 안내드리며, 개인 물품 관리에 각별한 주의를 기울여 주시길 부탁드립니다. 항상 플레이어님들의 협조에 감사드리며, 더욱 만족스러운 서비스를 제공하기 위해 최선을 다하겠습니다. 감사합니다.', 'ANNOUNCEMENT', '[공지] 분실물 발생 시 안내 및 유의사항'),
	('8f49301e-6c2e-41ba-8723-3547d2007a0c', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:01:05.338967', '안녕하세요, 피치 플레이입니다. 매치가 예정보다 지연될 경우, 매치 시작 30분 전까지는 자동으로 알림을 통해 안내드리며, 더 이상의 지연이 있을 경우 추가 안내를 통해 빠르게 알려드립니다. 불편을 드려 죄송하며, 최선을 다해 문제를 해결하겠습니다.', 'ANNOUNCEMENT', '[공지] 매치 지연 시 안내'),
	('96d62985-d363-4695-bf05-4a95ac14bb0e', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 16:59:28.964251', '안녕하세요, 피치 플레이입니다. 오는 11월 18일 매치부터 비·눈이 오는 매치 중 강수 알림톡이 발송된 매치의 환불 규정이 변경됩니다. 아래의 변경 사항을 확인하시어, 서비스 이용에 참고 부탁드립니다. • 변경 전 강수 알림톡 발송 여부 관계없이 매치 중 조기 귀가 시 미참여 시간만큼 포인트 환불 • 변경 후 강수 알림톡이 발송된 매치 참여 중 중도 포기하여 귀가하는 경우 환불 불가 • 변경 시점 2024년 11월 18일 09시 매치부터 적용 항상 저희 서비스를 이용해 주셔서 감사드리며, 앞으로도 플레이어님들께 더욱 신뢰 받는 서비스로 보답할 수 있도록 최선을 다하겠습니다. 감사합니다.', 'ANNOUNCEMENT', '[공지] 강수 알림톡이 발송된 매치 환불 규정 변경'),
	('a5e935d9-075f-4691-bc75-58a9af8a554a', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:00:56.724240', '안녕하세요, 피치 플레이입니다. 2025년 4월부터 매치 예약 시스템이 개선됩니다. 새로운 시스템에서는 보다 직관적인 인터페이스와 빠른 예약 처리 속도를 제공하며, 예약 가능 매치에 대한 실시간 정보도 확인할 수 있습니다. 많은 관심과 이용 부탁드립니다.', 'ANNOUNCEMENT', '[공지] 신규 매치 예약 시스템 도입'),
	('ae43ad03-caa8-40c3-863b-2ab803614dbb', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:01:01.372254', '안녕하세요, 피치 플레이입니다. 2025년 5월 1일부터 결제 취소 규정이 변경됩니다. 매치 결제 후 24시간 이내에 취소 시 전액 환불이 가능하며, 이후 취소 시 환불액이 차등 적용됩니다. 변경된 규정에 대해 자세한 사항은 홈페이지에서 확인해 주세요.', 'ANNOUNCEMENT', '[공지] 결제 취소 규정 변경'),
	('bc91e430-170d-4d3d-9f54-56f6fd69155b', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:26:16.383520', 'A: 매치 예약 시 결제는 카드, 포인트, 캐시 등을 통해 가능합니다. \n• 결제 방법은 매치 예약 페이지에서 선택할 수 있으며, 각 결제 방법에 대한 상세한 안내는 해당 페이지에서 확인할 수 있습니다.', 'FAQ', '매치 예약 시 결제 방법은 무엇인가요?'),
	('bda64fd1-55f7-4471-93a2-b41a1c005eff', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:01:07.185077', '안녕하세요, 피치 플레이입니다. 2025년 6월부터 신규 룸 예약 시스템이 도입됩니다. 더 많은 룸 선택지와, 실시간 예약 상태를 확인할 수 있는 기능이 추가됩니다. 이 시스템은 매치 예약 후 룸 이용이 더욱 편리하도록 도와줄 것입니다. 많은 관심 부탁드립니다.', 'ANNOUNCEMENT', '[공지] 신규 룸 예약 시스템 안내'),
	('c031eb7f-260c-47bf-912a-2640cd940ce3', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 16:59:35.534713', '안녕하세요, 피치 플레이입니다. 2025년부터 새롭게 출시되는 프리미엄 멤버십 서비스에 대한 안내입니다. 프리미엄 멤버십을 가입하시면 매치 예약 시 우선 순위가 제공되며, VIP 전용 룸과 코치 서비스를 이용할 수 있습니다. 회원님의 많은 관심 부탁드립니다.', 'ANNOUNCEMENT', '[공지] 신규 서비스 출시 안내'),
	('cb202ac9-0301-4a42-b807-07795fa3233f', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:25:08.678970', 'A: 충전한 캐시는 환불이 불가능합니다. \n• 캐시는 사용 시 자동으로 차감되며, 환불이 이루어지지 않으므로 신중하게 이용해 주시기 바랍니다.', 'FAQ', '충전한 캐시를 환불받을 수 있나요?'),
	('d0ae18ed-ba50-4f40-8e79-d52cf220618d', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 16:59:33.433073', '안녕하세요, 피치 플레이입니다. 2024년 12월 1일부터 12월 5일까지 결제 시스템 점검이 예정되어 있습니다. 이 기간 동안 결제 서비스가 일시 중단되므로, 이용에 불편함이 없도록 미리 결제를 완료해 주시기 바랍니다. 점검 후에는 안정적인 결제 시스템을 제공하기 위해 최선을 다하겠습니다. 감사합니다.', 'ANNOUNCEMENT', '[공지] 결제 시스템 점검 안내'),
	('df118149-4c26-4dc0-bfa8-1c822302f71f', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:25:02.909918', 'A: 소셜 매치 취소 및 변경 시 유의사항은 다음과 같습니다:\n• 취소 및 변경 시 위 규정에 맞게 환불이 처리됩니다.\n• 변경은 환불 규정에 맞는 경우에만 가능하며, 규정 외 요청은 적용되지 않습니다.\n• 변경 및 취소 시, 미리 나의 플랩에서 취소를 진행해 주시기 바랍니다.', 'FAQ', '소셜 매치 취소 및 변경 시 주의사항은 무엇인가요?'),
	('e54914bf-e03c-4782-b06a-efbc4789b529', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:00:59.436739', '안녕하세요, 피치 플레이입니다. 매치 예약 및 변경 사항에 대한 카카오톡 알림을 수신하려면 앱 내 설정에서 알림을 활성화해야 합니다. 알림을 통해 매치 정보와 공지사항을 놓치지 않도록 설정을 완료해 주세요.', 'ANNOUNCEMENT', '[공지] 카카오톡 알림 설정 안내'),
	('ea930d90-2e4d-48a0-b66e-44b7f3bc3650', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:25:00.936835', 'A: 매치 취소 후 환불 처리 기간은 취소 신청 후 최대 7일 이내에 진행됩니다.\n• 결제 방법에 따라 환불 시간이 달라질 수 있습니다.\n• 결제 후 환불이 완료되면 알림톡을 통해 확인 가능합니다.', 'FAQ', '매치 취소 후 환불 처리 기간은 얼마나 걸리나요?'),
	('eaeac48c-f8f4-4e8f-bc17-137b1fda3d73', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:25:04.786961', 'A: 계정 탈퇴 시, 남아있는 캐시나 포인트는 환불되지 않습니다. \n• 사용하지 않은 포인트 및 캐시는 탈퇴 후 반환되지 않으며, 탈퇴 전에 잔액을 모두 사용해 주시기 바랍니다.', 'FAQ', '계정 탈퇴 시 환불은 어떻게 되나요?'),
	('eedc558e-be53-481a-87a0-b3334e29fbf5', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:22:02.337681', 'A : 소셜 매치 환불 규정이 업데이트되었습니다. 변경된 규정은 아래와 같습니다. \n\n• 매치 3일 전: 무료 취소 \n• 매치 2일 전: 70% 환불 \n• 매치 1일 전: 50% 환불 \n• 당일 ~ 매치 시작 60분 전까지: 20% 환불 \n• 매치 시작 60분 이내: 환불 불가 \n\n그 외 취소 기준은 변경 없이 동일합니다. (기존 규정 참고) \n\n변경된 환불 규정은 2025년 6월 1일부터 적용됩니다.', 'FAQ', '소셜 매치 환불 규정 업데이트 안내'),
	('f0cc93ad-2eaf-4795-8882-f73e7d3c07d1', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:25:12.364825', 'A: 구장 예약은 사용자가 특정 날짜와 시간에 매치를 진행하기 위해 구장을 예약하는 과정입니다. \n• 예약은 플랫폼을 통해 진행되며, 예약된 구장에서만 매치가 진행됩니다. \n• 구장 예약 후 변경이나 취소 시, 해당 규정에 맞춰 환불이 처리됩니다.', 'FAQ', '구장 예약이란 무엇인가요?'),
	('f81f36d7-19f9-47ab-a3f8-6d6c3e593f37', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:01:09.319982', '안녕하세요, 피치 플레이입니다. 2025년 7월부터 리워드 프로그램이 시작됩니다. 회원님께서는 매치 예약 및 참여 시 포인트를 적립할 수 있으며, 이를 통해 다양한 혜택을 받을 수 있습니다. 프로그램에 대한 자세한 내용은 홈페이지에서 확인 가능합니다.', 'ANNOUNCEMENT', '[공지] 리워드 프로그램 시작'),
	('f9290ff1-55df-4032-a163-0698c4ecdbc6', '85180f4c-d3fc-474f-84ed-a9daf0b0f35a', '2025-01-02 17:26:20.931226', 'A: 매치 중 부상이 발생한 경우, 즉시 매치 진행을 중단하고 해당 구장 직원에게 알리세요. \n• 부상에 대한 치료는 개인의 책임이며, 부상으로 인한 환불은 불가합니다. 다만, 사후 처리는 고객센터를 통해 도움을 드릴 수 있습니다.', 'FAQ', '매치 중 부상 시 어떻게 해야 하나요?');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
