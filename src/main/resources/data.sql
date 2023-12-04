-- FoodCategory 테이블에 5개의 예시 데이터 추가
INSERT INTO food_category (created_at, updated_at, name)
VALUES (NOW(), NOW(), '한식'),
       (NOW(), NOW(), '중식'),
       (NOW(), NOW(), '일식'),
       (NOW(), NOW(), '양식'),
       (NOW(), NOW(), '베트남 음식');

-- Member 테이블에 5개의 예시 데이터 추가
INSERT INTO member (created_at, updated_at, address, age, email, gender, inactivate_date, name, point, social_type,
                    spec_address, status)
VALUES (NOW(), NOW(), '서울시 강남구', 30, 'example1@gmail.com', 'MALE', NULL, '홍길동', 100.0, 'KAKAO', '특별구 주소', 'ACTIVATE'),
       (NOW(), NOW(), '서울시 마포구', 25, 'example2@gmail.com', 'FEMALE', NULL, '김말이', 80.5, 'GOOGLE', '특별구 주소', 'ACTIVATE'),
       (NOW(), NOW(), '경기도 수원시', 35, 'example3@gmail.com', 'MALE', NULL, '이몽룡', 120.0, 'NAVER', '특별구 주소', 'ACTIVATE'),
       (NOW(), NOW(), '경기도 수원시', 35, 'example3@gmail.com', 'MALE', NULL, '나는바보', 120.0, 'NAVER', '특별구 주소', 'ACTIVATE'),
       (NOW(), NOW(), '부산시 해운대구', 28, 'example4@gmail.com', 'FEMALE', NULL, '성춘향', 95.0, 'KAKAO','특별구', 'ACTIVATE');


-- Liked_Food_Category 테이블에 5개의 예시 데이터 추가
INSERT INTO liked_food_category (created_at, updated_at, food_category_id, member_id)
VALUES (NOW(), NOW(), 1, 1),
       (NOW(), NOW(), 2, 2),
       (NOW(), NOW(), 3, 3),
       (NOW(), NOW(), 4, 4),
       (NOW(), NOW(), 5, 1);

-- Terms 테이블에 5개의 예시 데이터 추가
INSERT INTO terms (created_at, updated_at, context, optional, title) VALUES
                                                                         (NOW(), NOW(), '서비스 이용 약관', 0, '서비스 이용 약관'),
                                                                         (NOW(), NOW(), '개인정보 처리 방침', 1, '개인정보 처리 방침'),
                                                                         (NOW(), NOW(), '쿠키 정책', 1, '쿠키 정책'),
                                                                         (NOW(), NOW(), '회원 약관', 0, '회원 약관'),
                                                                         (NOW(), NOW(), '결제 정책', 0, '결제 정책');
-- Member_Agree 테이블에 5개의 예시 데이터 추가
INSERT INTO member_agree (created_at, updated_at, member_id, terms_id) VALUES
                                                                           (NOW(), NOW(), 1, 1),
                                                                           (NOW(), NOW(), 2, 2),
                                                                           (NOW(), NOW(), 3, 3),
                                                                           (NOW(), NOW(), 4, 4),
                                                                           (NOW(), NOW(), 1, 2);


-- Region 테이블에 5개의 예시 데이터 추가
INSERT INTO region (created_at, updated_at, name) VALUES
                                                      (NOW(), NOW(), '서울'),
                                                      (NOW(), NOW(), '경기'),
                                                      (NOW(), NOW(), '부산'),
                                                      (NOW(), NOW(), '대구'),
                                                      (NOW(), NOW(), '광주');

-- Review 테이블에 5개의 예시 데이터 추가

-- Store 테이블에 5개의 예시 데이터 추가
INSERT INTO store (created_at, updated_at, address, name, score, food_category_id) VALUES
                                                                                       (NOW(), NOW(), '서울시 강남구 역삼동', '맛있는 족발집', 4.5, 1),
                                                                                       (NOW(), NOW(), '서울시 강서구 화곡동', '행복한 치킨집', 4.8, 2),
                                                                                       (NOW(), NOW(), '서울시 강북구 미아동', '우리집 피자', 4.2, 3),
                                                                                       (NOW(), NOW(), '서울시 강동구 천호동', '짜장명가', 4.0, 4),
                                                                                       (NOW(), NOW(), '서울시 서초구 서초동', '삼겹살 맛집', 4.7, 5);

-- Store_Region 테이블에 5개의 예시 데이터 추가
INSERT INTO store_region (created_at, updated_at, region_id, store_id) VALUES
                                                                           (NOW(), NOW(), 1, 1),
                                                                           (NOW(), NOW(), 1, 2),
                                                                           (NOW(), NOW(), 2, 3),
                                                                           (NOW(), NOW(), 2, 4),
                                                                           (NOW(), NOW(), 3, 5);


INSERT INTO review (created_at, updated_at, score,content, member_id, store_id) VALUES
                                                                              (NOW(), NOW(),4.5, '정말 맛있어요!', 1, 1),
                                                                              (NOW(), NOW(),4.5, '정말 1!', 1, 1),
                                                                              (NOW(), NOW(),4.5, '정말 2!', 1, 1),
                                                                              (NOW(), NOW(),4.5, '정말 3!', 1, 1),
                                                                              (NOW(), NOW(),4.5, '정말 4!', 1, 1),
                                                                              (NOW(), NOW(),4.5, '정말 5!', 1, 1),
                                                                              (NOW(), NOW(),4.5, '정말 6!', 1, 1),
                                                                              (NOW(), NOW(),4.5, '정말 7!', 1, 1),
                                                                              (NOW(), NOW(),5.0, '서비스도 좋고 음식도 맛있어요!', 2, 2),
                                                                              (NOW(), NOW(),4.8, '가격 대비 만족스러워요.', 3, 3),
                                                                              (NOW(), NOW(),5.0, '분위기가 좋네요.', 4, 4),
                                                                              (NOW(), NOW(),4.4, '다음에 또 방문하고 싶어요.', 1, 5);


-- Mission 테이블에 5개의 예시 데이터 추가
INSERT INTO mission (created_at, updated_at, content, deadline, reward, store_id) VALUES
                                                                                      (NOW(), NOW(), '음식점 리뷰 작성하기', NOW(), 2.3, 1),
                                                                                      (NOW(), NOW(), '맛집 추천하기', NOW(), 4.5, 2),
                                                                                      (NOW(), NOW(), '음식점 방문하기', NOW(), 10.0, 3),
                                                                                      (NOW(), NOW(), '할인 혜택 받기', NOW(), 8.8, 4),
                                                                                      (NOW(), NOW(), '푸드 페스티벌 참가', NOW(), 3.3, 5);
-- Member_Mission 테이블에 5개의 예시 데이터 추가
INSERT INTO Member_Mission (created_at, updated_at, status, member_id, mission_id) VALUES
                                                                                       (NOW(), NOW(), 'ONGOING', 1, 1),
                                                                                       (NOW(), NOW(), 'SUCCESS', 2, 2),
                                                                                       (NOW(), NOW(), 'ONGOING', 3, 3),
                                                                                       (NOW(), NOW(), 'FAILED', 4, 4),
                                                                                       (NOW(), NOW(), 'SUCCESS', 1, 3);