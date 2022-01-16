CREATE TABLE EMP_SEQUENCE_TB (
       emp_no      number(10)
     , emp_name    varchar2(30)
);

-- 시퀀스 생성으로 insert 마다 번호 추가
CREATE SEQUENCE emp_seq
START WITH 1
INCREMENT BY 1
MAXVALUE 100000 ;
--DROP SEQUENCE emp_seq;

INSERT INTO EMP_SEQUENCE_TB(emp_no, emp_name) VALUES(emp_seq.NEXTVAL, 'name');

select * from EMP_SEQUENCE_TB;


-- Loop 사용으로 값 넣기
begin 
    for i in 1..100
	loop
	INSERT INTO EMP_SEQUENCE_TB VALUES(i, 'name');
	END LOOP;
end; 