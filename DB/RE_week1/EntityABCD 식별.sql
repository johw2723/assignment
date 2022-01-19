CREATE TABLE "A" (
	"a"		VARCHAR(255)		NOT NULL,
	"aa"	VARCHAR(255)		NULL,
	"aaa"	VARCHAR(255)		NULL
);

CREATE TABLE "B" (
	"b"		VARCHAR(255)		NOT NULL,
	"a"		VARCHAR(255)		NOT NULL,
	"bb"	VARCHAR(255)		NULL,
	"bbb"	VARCHAR(255)		NULL
);

CREATE TABLE "C" (
	"c"		VARCHAR(255)		NOT NULL,
	"b"		VARCHAR(255)		NOT NULL,
	"a"		VARCHAR(255)		NOT NULL,
	"cc"	VARCHAR(255)		NULL,
	"ccc"	VARCHAR(255)		NULL
);

CREATE TABLE "D" (
	"d"		VARCHAR(255)		NOT NULL,
	"c"		VARCHAR(255)		NOT NULL,
	"b"		VARCHAR(255)		NOT NULL,
	"a"		VARCHAR(255)		NOT NULL,
	"dd"	VARCHAR(255)		NULL,
	"ddd"	VARCHAR(255)		NULL
);

ALTER TABLE "A" ADD CONSTRAINT "PK_A" PRIMARY KEY (
	"a"
);

ALTER TABLE "B" ADD CONSTRAINT "PK_B" PRIMARY KEY (
	"b",
	"a"
);

ALTER TABLE "C" ADD CONSTRAINT "PK_C" PRIMARY KEY (
	"c",
	"b",
	"a"
);

ALTER TABLE "D" ADD CONSTRAINT "PK_D" PRIMARY KEY (
	"d",
	"c",
	"b",
	"a"
);

ALTER TABLE "B" ADD CONSTRAINT "FK_A_TO_B_1" FOREIGN KEY (
	"a"
)
REFERENCES "A" (
	"a"
);

ALTER TABLE "C" ADD CONSTRAINT "FK_B_TO_C_1" FOREIGN KEY (
	"b", "a"
)
REFERENCES "B" (
	"b", "a"
);

ALTER TABLE "D" ADD CONSTRAINT "FK_C_TO_D_1" FOREIGN KEY (
	"c", "b", "a"
)
REFERENCES "C" (
	"c", "b", "a"
);

select	A."a" as A_a, A."aa" as A_aa, A."aaa" as A_aaa
		, B."b" as B_b, B."bb" as B_bb, B."bbb" as B_bbb, B."a" as B_a
		, C."c" as C_c, C."cc" as C_cc, C."ccc" as C_ccc, C."b" as C_b, C."a" as C_a
		, D."d" as D_d, D."dd" as D_dd, D."ddd" as D_ddd, D."c" as D_c, D."b" as D_b, D."a" as D_a
from A, B, C, D;
-- A_A, A_AA, A_AAA,
-- B_B, B_BB, B_BBB, B_A,
-- C_C, C_CC, C_CCC, C_B, C_A,
-- D_D, D_DD, D_DDD, D_C, D_B, D_A

select	* 
from	A, B, C, D
where	A.a = D.a -- A.a = B.a and B.a = C.a and C.a = D.a
and 	B.b = D.b -- B.b = C.b and C.b = D.b
and 	C.c = D.c;
-- ORA-00904 : invalid identifier
   
select	"a", A."aa" as A_aa, A."aaa" as A_aaa
		, "b", B."bb" as B_bb, B."bbb" as B_bbb
		, "c", C."cc" as C_cc, C."ccc" as C_ccc
		, "d", D."dd" as D_dd, D."ddd" as D_ddd
from	A
natural join	B
natural join 	C
natural join 	D;
-- a, A_AA, A_AAA, b, B_BB, B_BBB, c, C_CC, C_CCC, d, D_DD, D_DDD

select	A."a" as A_a, A."aa" as A_aa, A."aaa" as A_aaa
		, B."b" as B_b, B."bb" as B_bb, B."bbb" as B_bbb, B."a" as B_a
		, C."c" as C_c, C."cc" as C_cc, C."ccc" as C_ccc, C."b" as C_b, C."a" as C_a
		, D."d" as D_d, D."dd" as D_dd, D."ddd" as D_ddd, D."c" as D_c, D."b" as D_b, D."a" as D_a
from 	A, B, C, D
where 	A."a" = D."a" -- A."a" = B."a" and B."a" = C."a" and C."a" = D."a"
and 	B."b" = D."b" -- B."b" = C."b" and C."b" = D."b"
and 	C."c" = D."c";
-- A_A, A_AA, A_AAA,
-- B_B, B_BB, B_BBB, B_A,
-- C_C, C_CC, C_CCC, C_B, C_A,
-- D_D, D_DD, D_DDD, D_C, D_B, D_A

-- natural join : equi join 에서 조건이 '=' 일 때 동일한 속성이 두 번 나타나게 되는데, 이 중 중복을 제거하여 같은 속성을 한번만 표기하는 방식 

SELECT * FROM TAB;			-- 테이블 명과 테이블 타입 조회
SELECT * FROM TABS;			-- 사용자의 모든 테이블 확인
SELECT * FROM USER_TABLES;	-- 사용자의 모든 테이블 확인
SELECT * FROM USER_CATALOG; -- 사용자의 테이블, 뷰, Synonyms(동의어), 시퀀스를 조회
SELECT * FROM USER_INDEXES; -- 사용자가 소유한 인덱스의 정보를 조회
SELECT * FROM USER_TAB_COLUMNS; -- 사용자가 소유한 테이블과 테이블의 컬럼들의 정보 조회
SELECT * FROM USER_COL_COMMENTS;-- 사용자가 소유한 테이블과 칼럼, 코멘트 조회
SELECT * FROM USER_CONSTRAINTS; -- 제약 조건 확인
SELECT * FROM COLS WHERE TABLE_NAME = 'A'; -- 특정 테이블의 모든 컬럼 조회

SELECT TABLE_NAME||'.'||COLUMN_NAME as A_COLS FROM COLS WHERE TABLE_NAME = 'A'

SELECT 
	TB.COLUMN_NAME as COLS
FROM 
	(SELECT COLUMN_NAME FROM COLS WHERE TABLE_NAME = 'A' OR TABLE_NAME = 'B' OR TABLE_NAME = 'C' OR TABLE_NAME = 'D') TB
