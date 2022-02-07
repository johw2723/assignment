------------ 1NF ------------------ 원자값이 아닌 도메인을 분해
CREATE TABLE 회원_1NF (
	회원ID	VARCHAR(255)	NOT NULL,
	회원명	VARCHAR(255)	NULL
);

ALTER TABLE 회원_1NF ADD CONSTRAINT PK_회원_1NF PRIMARY KEY (
	회원ID
);

CREATE TABLE 연락처 (
	연락처	VARCHAR(255)	NULL,
	회원ID	VARCHAR(255)	NOT NULL
);

ALTER TABLE 연락처 ADD CONSTRAINT FK_TO_연락처 FOREIGN KEY (
	회원ID
)
REFERENCES 회원_1NF (
	회원ID
);

select * from 회원_1NF
insert into 회원_1NF(회원ID, 회원명) values('yjs', '유재석')
insert into 회원_1NF(회원ID, 회원명) values('gang', '강호동')
insert into 회원_1NF(회원ID, 회원명) values('kimsj', '김성주')

select * from 연락처
insert into 연락처(회원ID, 연락처) values('yjs', '010-0000-0000')
insert into 연락처(회원ID, 연락처) values('gang', '010-2222-2222')
insert into 연락처(회원ID, 연락처) values('gang', '031-123-4567')
insert into 연락처(회원ID, 연락처) values('kimsj', '010-3333-3333')
insert into 연락처(회원ID, 연락처) values('kimsj', '02-111-1111')

select 회원_1NF.회원ID, 회원_1NF.회원명, 연락처.연락처
from 회원_1NF, 연락처
where 회원_1NF.회원ID = 연락처.회원ID

------------ 2NF ------------------ 부분적 함수 종속 제거
CREATE TABLE 성적_2NF (
	학번	VARCHAR(255)	NOT NULL,
	과목번호	VARCHAR(255)	NOT NULL,
	성적	VARCHAR(255)	NULL
);

ALTER TABLE 성적_2NF ADD CONSTRAINT PK_성적_2NF PRIMARY KEY (
	학번,
	과목번호
);

CREATE TABLE 학년 (
	학번	VARCHAR(255)	NOT NULL,
	학년	VARCHAR(255)	NULL
);

ALTER TABLE 학년 ADD CONSTRAINT PK_학년 PRIMARY KEY (
	학번
);

select * from 성적_2NF
insert into 성적_2NF(학번, 과목번호, 성적) values(2022101, 'A1', 90)
insert into 성적_2NF(학번, 과목번호, 성적) values(2022201, 'A1', 100)
insert into 성적_2NF(학번, 과목번호, 성적) values(2022201, 'B1', 80)
insert into 성적_2NF(학번, 과목번호, 성적) values(2022301, 'B1', 95)

select * from 학년
insert into 학년(학번, 학년) values(2022101, '1학년')
insert into 학년(학번, 학년) values(2022201, '2학년')
insert into 학년(학번, 학년) values(2022301, '3학년')

select 성적_2NF.학번, 성적_2NF.과목번호, 학년.학년, 성적_2NF.성적
from 성적_2NF, 학년
where 성적_2NF.학번 = 학년.학번

------------ 3NF ------------------ 이행적 함수 종속 제거
CREATE TABLE 학생_3NF (
	학번	VARCHAR(255)	NOT NULL,
	이름	VARCHAR(255)	NULL,
	대학	VARCHAR(255)	NOT NULL
);

ALTER TABLE 학생_3NF ADD CONSTRAINT PK_학생_3NF PRIMARY KEY (
	학번
);

CREATE TABLE 대학 (
	대학	VARCHAR(255)	NOT NULL,
	전공	VARCHAR(255)	NULL
);

ALTER TABLE 대학 ADD CONSTRAINT PK_대학 PRIMARY KEY (
	대학
);

ALTER TABLE 학생_3NF ADD CONSTRAINT FK_TO_학생_3NF FOREIGN KEY (
	대학
)
REFERENCES 대학 (
	대학
);

select * from 대학
insert into 대학(대학, 전공) values('사회과학대학', '행정학전공')
insert into 대학(대학, 전공) values('자연과학대학', '물리학전공')
insert into 대학(대학, 전공) values('공과대학', '전산학전공')

select * from 학생_3NF
insert into 학생_3NF(학번, 이름, 대학) values(2022101, '유재석', '사회과학대학')
insert into 학생_3NF(학번, 이름, 대학) values(2022111, '김성주', '자연과학대학')
insert into 학생_3NF(학번, 이름, 대학) values(2022121, '강호동', '공과대학')

select 학생_3NF.학번, 학생_3NF.이름, 학생_3NF.대학, 대학.전공
from 학생_3NF, 대학
where 학생_3NF.대학 = 대학.대학

------------ BCNF ------------------ 결정자이면서 후보키가 아닌 것 제거
CREATE TABLE 성적_BCNF (
	학번	VARCHAR(255)	NOT NULL,
	과목번호	VARCHAR(255)	NOT NULL,
	성적	VARCHAR(255)	NULL
);

ALTER TABLE 성적_BCNF ADD CONSTRAINT PK_성적_BCNF PRIMARY KEY (
	학번,
	과목번호
);

CREATE TABLE 교수 (
	교수번호	VARCHAR(255)	NOT NULL,
	과목번호	VARCHAR(255)	NOT NULL
);

ALTER TABLE 교수 ADD CONSTRAINT PK_교수 PRIMARY KEY (
	교수번호
);

select * from 성적_BCNF
insert into 성적_BCNF(학번, 과목번호, 성적) values(2022101, 'A1', 90)
insert into 성적_BCNF(학번, 과목번호, 성적) values(2022102, 'A2', 80)
insert into 성적_BCNF(학번, 과목번호, 성적) values(2022103, 'A3', 70)

select * from 교수
insert into 교수(교수번호, 과목번호) values('P101', 'A1')
insert into 교수(교수번호, 과목번호) values('P102', 'A2')
insert into 교수(교수번호, 과목번호) values('P103', 'A3')

select 성적_BCNF.학번, 성적_BCNF.과목번호, 교수.교수번호, 성적_BCNF.성적
from 교수, 성적_BCNF
where 교수.과목번호 = 성적_BCNF.과목번호

------------ 4NF ------------------ 다치 종속 제거
drop table 개발자정보_4NF
CREATE TABLE 개발자정보_4NF (
	개발자	VARCHAR(255)	NOT NULL
);

ALTER TABLE 개발자정보_4NF ADD CONSTRAINT PK_개발자정보_4NF PRIMARY KEY (
	개발자
);

CREATE TABLE 자격증_4NF (
	자격증	VARCHAR(255)	NOT NULL
);

ALTER TABLE 자격증_4NF ADD CONSTRAINT PK_자격증_4NF PRIMARY KEY (
	자격증
);

CREATE TABLE 언어_4NF (
	언어	VARCHAR(255)	NOT NULL
);

ALTER TABLE 언어_4NF ADD CONSTRAINT PK_언어_4NF PRIMARY KEY (
	언어
);

CREATE TABLE 개발_자격 (
	개발자	VARCHAR(255)	NOT NULL,
	자격증	VARCHAR(255)	NOT NULL
);

ALTER TABLE 개발_자격 ADD CONSTRAINT FK_TO_개발_자격_1 FOREIGN KEY (
	개발자
)
REFERENCES 개발자정보_4NF (
	개발자
);

ALTER TABLE 개발_자격 ADD CONSTRAINT FK_개발_자격_1 FOREIGN KEY (
	자격증
)
REFERENCES 자격증_4NF (
	자격증
);

CREATE TABLE 개발_언어 (
	개발자	VARCHAR(255)	NOT NULL,
	언어	VARCHAR(255)	NOT NULL
);

ALTER TABLE 개발_언어 ADD CONSTRAINT FK_TO_개발_언어_1 FOREIGN KEY (
	개발자
)
REFERENCES 개발자정보_4NF (
	개발자
);

ALTER TABLE 개발_언어 ADD CONSTRAINT FK_TO_개발_언어_2 FOREIGN KEY (
	언어
)
REFERENCES 언어_4NF (
	언어
);

select * from 개발자정보_4NF
insert into 개발자정보_4NF(개발자) values('유재석')
insert into 개발자정보_4NF(개발자) values('강호동')
insert into 개발자정보_4NF(개발자) values('김성주')

select * from 자격증_4NF
insert into 자격증_4NF(자격증) values('정보처리기사')
insert into 자격증_4NF(자격증) values('빅데이터 분석 기사')

select * from 개발_자격
insert into 개발_자격(개발자, 자격증) values('유재석', '정보처리기사')
insert into 개발_자격(개발자, 자격증) values('유재석', '빅데이터 분석 기사')
insert into 개발_자격(개발자, 자격증) values('강호동', '정보처리기사')
insert into 개발_자격(개발자, 자격증) values('김성주', '정보처리기사')

select * from 언어_4NF
insert into 언어_4NF(언어) values('C')
insert into 언어_4NF(언어) values('JAVA')
insert into 언어_4NF(언어) values('C++')

select * from 개발_언어
insert into 개발_언어(개발자, 언어) values('유재석', 'C')
insert into 개발_언어(개발자, 언어) values('유재석', 'JAVA')
insert into 개발_언어(개발자, 언어) values('강호동', 'C++')
insert into 개발_언어(개발자, 언어) values('김성주', 'C')

select	개발_자격.개발자, 개발_자격.자격증, 개발_언어.언어
from	개발_자격, 개발_언어
where	개발_자격.개발자 = 개발_언어.개발자


------------ 5NF --------------- 조인 종속성 이용
CREATE TABLE 개발자정보_5NF (
	개발자	VARCHAR(255)	NOT NULL
);

ALTER TABLE 개발자정보_5NF ADD CONSTRAINT PK_개발자정보_5NF PRIMARY KEY (
	개발자
);

CREATE TABLE 자격증_5NF (
	자격증	VARCHAR(255)	NOT NULL
);

ALTER TABLE 자격증_5NF ADD CONSTRAINT PK_자격증_5NF PRIMARY KEY (
	자격증
);

CREATE TABLE 언어_5NF (
	언어	VARCHAR(255)	NOT NULL
);

ALTER TABLE 언어_5NF ADD CONSTRAINT PK_언어_5NF PRIMARY KEY (
	언어
);

CREATE TABLE 개발_자격_5NF (
	개발자	VARCHAR(255)	NOT NULL,
	자격증	VARCHAR(255)	NOT NULL
);

ALTER TABLE 개발_자격_5NF ADD CONSTRAINT FK_TO_개발_자격_5NF_1 FOREIGN KEY (
	개발자
)
REFERENCES 개발자정보_5NF (
	개발자
);

ALTER TABLE 개발_자격_5NF ADD CONSTRAINT FK_TO_개발_자격_5NF_2 FOREIGN KEY (
	자격증
)
REFERENCES 자격증_5NF (
	자격증
);

CREATE TABLE 개발_언어_5NF (
	개발자	VARCHAR(255)	NOT NULL,
	언어	VARCHAR(255)	NOT NULL
);

ALTER TABLE 개발_언어_5NF ADD CONSTRAINT FK_TO_개발_언어_5NF_1 FOREIGN KEY (
	개발자
)
REFERENCES 개발자정보_5NF (
	개발자
);

ALTER TABLE 개발_언어_5NF ADD CONSTRAINT FK_TO_개발_언어_5NF_2 FOREIGN KEY (
	언어
)
REFERENCES 언어_5NF (
	언어
);

CREATE TABLE 자격_언어_5NF (
	자격증	VARCHAR(255)	NOT NULL,
	언어	VARCHAR(255)	NOT NULL
);

ALTER TABLE 자격_언어_5NF ADD CONSTRAINT FK_TO_자격_언어_5NF_1 FOREIGN KEY (
	자격증
)
REFERENCES 자격증_5NF (
	자격증
);

ALTER TABLE 자격_언어_5NF ADD CONSTRAINT FK_TO_자격_언어_5NF_2 FOREIGN KEY (
	언어
)
REFERENCES 언어_5NF (
	언어
);

select * from 개발자정보_5NF
insert into 개발자정보_5NF(개발자) values('유재석')
insert into 개발자정보_5NF(개발자) values('강호동')
insert into 개발자정보_5NF(개발자) values('김성주')

select * from 자격증_5NF
insert into 자격증_5NF(자격증) values('정보처리기사')
insert into 자격증_5NF(자격증) values('빅데이터 분석 기사')

select * from 언어_5NF
insert into 언어_5NF(언어) values('C')
insert into 언어_5NF(언어) values('JAVA')
insert into 언어_5NF(언어) values('C++')

select * from 개발_자격_5NF
insert into 개발_자격_5NF(개발자, 자격증) values('유재석', '정보처리기사')
insert into 개발_자격_5NF(개발자, 자격증) values('유재석', '빅데이터 분석 기사')
insert into 개발_자격_5NF(개발자, 자격증) values('강호동', '정보처리기사')
insert into 개발_자격_5NF(개발자, 자격증) values('김성주', '정보처리기사')

select * from 개발_언어_5NF
insert into 개발_언어_5NF(개발자, 언어) values('유재석', 'C')
insert into 개발_언어_5NF(개발자, 언어) values('유재석', 'JAVA')
insert into 개발_언어_5NF(개발자, 언어) values('강호동', 'C++')
insert into 개발_언어_5NF(개발자, 언어) values('김성주', 'C')

select * from 자격_언어_5NF
insert into 자격_언어_5NF(자격증, 언어) values('정보처리기사', 'C')
insert into 자격_언어_5NF(자격증, 언어) values('빅데이터 분석 기사', 'JAVA')
insert into 자격_언어_5NF(자격증, 언어) values('정보처리기사', 'C++')
insert into 자격_언어_5NF(자격증, 언어) values('정보처리기사', 'C')

select	DISTINCT 개발_자격_5NF.개발자, 개발_자격_5NF.자격증, 개발_언어_5NF.언어
from	개발_자격_5NF, 개발_언어_5NF, 자격_언어_5NF
where	개발_자격_5NF.개발자 = 개발_언어_5NF.개발자
and		개발_언어_5NF.언어 = 자격_언어_5NF.언어
and		자격_언어_5NF.자격증 = 개발_자격_5NF.자격증