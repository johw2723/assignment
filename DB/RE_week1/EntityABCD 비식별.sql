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

select * from A, B, C, D;
-- a, aa, aaa, / b, bb, bbb, a, / c, cc, ccc, b, / d, dd, ddd, c

select * from A, B, C, D
where A."a" = B."a"
and B."b" = C."b"
and C."c" = D."c"
-- a, aa, aaa, / b, bb, bbb, a / c, cc, ccc, b, / d, dd, ddd, c

select * from 	A
natural join	B
natural join 	C
natural join 	D;
-- c, b, a, aa, aaa, bb, bbb, cc, ccc, d, dd, ddd


insert into B("b", "bb", "bbb", "a") values('2', null, null, null);
--ORA-01400: cannot insert NULL into ("SCOTT"."B"."a")

insert into B("b", "bb", "bbb", "a") values('2', '22', null, '1');
--ORA-02291: integrity constraint (SCOTT.FK_A_TO_B_1) violated - parent key not found

insert into A("a") values ('1');
insert into B("b", "a") values ('2','1');
select * from A; -- a 1, aa null, aaa null
select * from B; -- b 2, bb null, bbb null, a 1

select * from A, B, C, D
where A."a" = B."a"
and B."b" = C."b"(+)
and C."c" = D."d"(+);
-- a 1	 , aa null, aaa null
-- b 2   , bb null, bbb null, a 1
-- c null, cc null, ccc null, b null
-- d null, dd null, ddd null, c null

insert into C("c", "b") values('3','1'); 
--ORA-02291: integrity constraint (SCOTT.FK_B_TO_C_1) violated - parent key not found

insert into C("c", "b") values('3','2');
insert into D("d", "c") values('4','3');

select * from A, B, C, D
where A."a" = B."a"
and B."b" = C."b"
and C."c" = D."c";
-- a 1	 , aa null, aaa null
-- b 2   , bb null, bbb null, a 1
-- c 3	 , cc null, ccc null, b 2
-- d 4	 , dd null, ddd null, c 3