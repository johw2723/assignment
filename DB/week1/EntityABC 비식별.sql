--��ĺ�
CREATE TABLE "A" (
	"a"	VARCHAR(255)		NOT NULL
);

CREATE TABLE "B" (
	"b"	VARCHAR(255)		NOT NULL,
	"a"	VARCHAR(255)		NOT NULL
);

CREATE TABLE "C" (
	"c"	VARCHAR(255)		NOT NULL,
	"b"	VARCHAR(255)		NOT NULL
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

select * from A
natural join B
natural join C;

