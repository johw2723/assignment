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

select * from A, B, C, D;
-- a, aa, aaa, 
-- b, a, bb, bbb, 
-- c, b, a, cc, ccc,
-- d, c, b, a, dd, ddd

select	* 
from	A, B, C, D
where	A.a = D.a -- A.a = B.a and B.a = C.a and C.a = D.a
and 	B.b = D.b -- B.b = C.b and C.b = D.b
and 	C.c = D.c;
-- ORA-00904 : invalid identifier
   
select * from	A
natural join	B
natural join 	C
natural join 	D;
-- a, b, c, aa, aaa, bb, bbb, cc, ccc, d, dd, ddd

select * from A, B, C, D
where A."a" = D."d" -- A."a" = B."a" and B."a" = C."a" and C."a" = D."a"
and B."b" = D."d" -- B."b" = C."b" and C."b" = D."b"
and C."c" = D."c";
-- a, aa, aaa,
-- b, a, bb, bbb,
-- c, b, a, cc, ccc,
-- d, c, b, a, dd, ddd

-- natural join : equi join 에서 조건이 '=' 일 때 동일한 속성이 두 번 나타나게 되는데, 이 중 중복을 제거하여 같은 속성을 한번만 표기하는 방식 