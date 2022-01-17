DROP TABLE "A";

CREATE TABLE "A" (
	"a"		VARCHAR(255)		NOT NULL,
	"aa"	VARCHAR(255)		NULL,
	"aaa"	VARCHAR(255)		NULL
);

CREATE TABLE "B" (
	"b"		VARCHAR(255)		NOT NULL,
	"bb"	VARCHAR(255)		NULL,
	"bbb"	VARCHAR(255)		NULL,
	"a"		VARCHAR(255)		NOT NULL
);

CREATE TABLE "C" (
	"c"		VARCHAR(255)		NOT NULL,
	"cc"	VARCHAR(255)		NULL,
	"ccc"	VARCHAR(255)		NULL,
	"b"		VARCHAR(255)		NOT NULL
);

CREATE TABLE "D" (
	"d"		VARCHAR(255)		NOT NULL,
	"dd"	VARCHAR(255)		NULL,
	"ddd"	VARCHAR(255)		NULL,
	"c"		VARCHAR(255)		NOT NULL
);

ALTER TABLE "A" ADD CONSTRAINT "PK_A" PRIMARY KEY (
	"a"
);

ALTER TABLE "B" ADD CONSTRAINT "PK_B" PRIMARY KEY (
	"b"
);

ALTER TABLE "C" ADD CONSTRAINT "PK_C" PRIMARY KEY (
	"c"
);

ALTER TABLE "D" ADD CONSTRAINT "PK_D" PRIMARY KEY (
	"d"
);

ALTER TABLE "B" ADD CONSTRAINT "FK_A_TO_B_1" FOREIGN KEY (
	"a"
)
REFERENCES "A" (
	"a"
);

ALTER TABLE "C" ADD CONSTRAINT "FK_B_TO_C_1" FOREIGN KEY (
	"b"
)
REFERENCES "B" (
	"b"
);

ALTER TABLE "D" ADD CONSTRAINT "FK_C_TO_D_1" FOREIGN KEY (
	"c"
)
REFERENCES "C" (
	"c"
);

select	A."a" as A_a, A."aa" as A_aa, A."aaa" as A_aaa
		, B."b" as B_b, B."bb" as B_bb, B."bbb" as B_bbb, B."a" as B_a
		, C."c" as C_c, C."cc" as C_cc, C."ccc" as C_ccc, C."b" as C_b
		, D."d" as D_d, D."dd" as D_dd, D."ddd" as D_ddd, D."c" as D_c
from 	A, B, C, D;
-- A_A, A_AA, A_AAA, B_B, B_BB, B_BBB, B_A, C_C, C_CC, C_CCC, C_B, D_D, D_DD, D_DDD, D_C

select	A."a" as A_a, A."aa" as A_aa, A."aaa" as A_aaa
		, B."b" as B_b, B."bb" as B_bb, B."bbb" as B_bbb, B."a" as B_a
		, C."c" as C_c, C."cc" as C_cc, C."ccc" as C_ccc, C."b" as C_b
		, D."d" as D_d, D."dd" as D_dd, D."ddd" as D_ddd, D."c" as D_c 
from 	A, B, C, D
where 	A."a" = B."a"
and 	B."b" = C."b"
and 	C."c" = D."c"
-- A_A, A_AA, A_AAA, B_B, B_BB, B_BBB, B_A, C_C, C_CC, C_CCC, C_B, D_D, D_DD, D_DDD, D_C

select	"a" as a, A."aa" as A_aa, A."aaa" as A_aaa
		, "b" as b, B."bb" as B_bb, B."bbb" as B_bbb
		, "c" as c, C."cc" as C_cc, C."ccc" as C_ccc
		, "d" as d, D."dd" as D_dd, D."ddd" as D_ddd
from 	A
natural join	B
natural join 	C
natural join 	D;
-- A, A_AA, A_AAA, B, B_BB, B_BBB, C, C_CC, C_CCC, D, D_DD, D_DDD


insert into B("b", "bb", "bbb", "a") values('2', null, null, null);
--ORA-01400: cannot insert NULL into ("SCOTT"."B"."a")

insert into B("b", "bb", "bbb", "a") values('2', '22', null, '1');
--ORA-02291: integrity constraint (SCOTT.FK_A_TO_B_1) violated - parent key not found

insert into A("a") values ('1');
insert into B("b", "a") values ('2','1');
select * from A; -- a 1, aa null, aaa null
select * from B; -- b 2, bb null, bbb null, a 1

select	A."a" as A_a, A."aa" as A_aa, A."aaa" as A_aaa
		, B."b" as B_b, B."bb" as B_bb, B."bbb" as B_bbb, B."a" as B_a
		, C."c" as C_c, C."cc" as C_cc, C."ccc" as C_ccc, C."b" as C_b
		, D."d" as D_d, D."dd" as D_dd, D."ddd" as D_ddd, D."c" as D_c 
from 	A, B, C, D
where 	A."a" = B."a"
and 	B."b" = C."b"(+)
and 	C."c" = D."c"(+);
-- A_A = 1, A_AA = null, A_AAA = null
-- B_B = 2, B_BB = null, B_BBB = null, B_A = 1
-- C_C = null, C_CC = null, C_CCC = null, C_B = null
-- D_D = null, D_DD = null, D_DDD = null, D_C = null

insert into C("c", "b") values('3','1'); 
--ORA-02291: integrity constraint (SCOTT.FK_B_TO_C_1) violated - parent key not found

insert into C("c", "b") values('3','2');
insert into D("d", "c") values('4','3');

select	A."a" as A_a, A."aa" as A_aa, A."aaa" as A_aaa
		, B."b" as B_b, B."bb" as B_bb, B."bbb" as B_bbb, B."a" as B_a
		, C."c" as C_c, C."cc" as C_cc, C."ccc" as C_ccc, C."b" as C_b
		, D."d" as D_d, D."dd" as D_dd, D."ddd" as D_ddd, D."c" as D_c 
from 	A, B, C, D
where 	A."a" = B."a"
and 	B."b" = C."b"
and 	C."c" = D."c";
-- A_A = 1, A_AA = null, A_AAA = null
-- B_B = 2, B_BB = null, B_BBB = null, B_A = 1
-- C_C = 3, C_CC = null, C_CCC = null, C_B = 2
-- D_D = 4, D_DD = null, D_DDD = null, D_C = 3