-- 01. 직원정보 테이블 구조(스키마) 조회
SELECT * FROM col WHERE tname='EMP';
SELECT * FROM cols WHERE table_name='EMP';
SELECT * FROM user_tab_columns WHERE table_name='EMP';

-- 02. 부서 테이블 구조(스키마 조회)
SELECT * FROM col WHERE tname='DEPT';
SELECT * FROM cols WHERE table_name='DEPT';
SELECT * FROM user_tab_columns WHERE table_name='DEPT';

-- 03. 전체직원의 모든정보 조회
SELECT * FROM EMP;

-- 04. 전체부서의 모든정보 조회
SELECT * FROM DEPT;

-- 05. 전체직원의 사번, 이름, 급여, 상여, 입사일 정보를 조회
SELECT EMPNO, ENAME, SAL, COMM, HIREDATE FROM EMP;

-- 06. 컬럼에 대한 별명 사용해서 조회
-- 출력제목 : Employee No, Name, Salary, COMMISION, Hire Date
SELECT 
	EMPNO AS "Employee No"
	, ENAME AS NAME
	, SAL AS Salary
	, COMM AS COMMISION
	, HIREDATE AS "Hire Date"
FROM 
	EMP;

-- 07. 정렬 조회
-- 출력제목 : 부서번호, 사번, 이름, 급여, 수당
-- 정렬기준 : 급여(높은순서), 부서번호(낮은순서)
-- 정렬기준 : 부서번호(낮은순서), 급여(높은순서)
SELECT 
	DEPTNO AS 부서번호
	, EMPNO AS 사번
	, ENAME AS 이름
	, SAL AS 급여
	, COMM AS 수당
FROM 
	EMP
ORDER BY
	SAL DESC
	, DEPTNO ASC;
	
SELECT 
	DEPTNO AS 부서번호
	, EMPNO AS 사번
	, ENAME AS 이름
	, SAL AS 급여
	, COMM AS 수당
FROM 
	EMP
ORDER BY
	DEPTNO ASC
	, SAL DESC;


-- 08. 중복행 제거 조회 : distinct
-- 직원의 직무 종류 조회
-- 정렬기준 : 직무 올림차순
SELECT DISTINCT JOB FROM EMP ORDER BY JOB ASC;

-- 09. 각부서의 해당 부서원의 직무 종류 조회
-- 출력정보 : 부서번호, 직무
-- 정렬기준 : 부서번호 올림, 직무 올림
SELECT DISTINCT
	DEPTNO
	, JOB
FROM 
	EMP
ORDER BY
	DEPTNO ASC
	, JOB ASC;

-- 10. 조건 조회
-- 출력정보 : 사번, 이름, 급여
-- 조회조건 : 급여가 3000이상인 직원
SELECT
	EMPNO
	, ENAME
	, SAL
FROM
	EMP
WHERE
	SAL >= 3000;

-- 11. 사원번호가 7788 사원의 이름 및 부서번호를 출력
SELECT
	ENAME
	, DEPTNO
FROM
	EMP
WHERE
	EMPNO = 7788;

-- 12. 10번 부서원중에서 급여가 3000이상인 직원
SELECT * FROM EMP WHERE DEPTNO = 10 AND SAL >= 3000;

-- 13. 출력정보 : 부서번호, 사번, 이름, 직무
-- 조회조건 : 직무가 manager 인 직원
SELECT
	DEPTNO
	, EMPNO
	, ENAME
	, JOB
FROM
	EMP
WHERE
	JOB = 'MANAGER';

-- 14. 출력정보 : 부서번호, 사번, 이름, 직무
-- 조회조건 : 직무가 SALESMAN이 아닌 직원
SELECT
	DEPTNO
	, EMPNO
	, ENAME
	, JOB
FROM
	EMP
WHERE
	JOB != 'SALESMAN';
	

-- 15. 급여가 1500이상 ~ 2850이하의 범위에 속하는 사원의 이름 및 급여를 조회
SELECT
	ENAME
	, SAL
FROM
	EMP
WHERE
	SAL >= 1500
	AND SAL <= 2850;

-- 16. 급여가 1500이상 ~ 2850이하의 범위에 속하지 않는 사원의 이름 및 급여를 조회
SELECT
	ENAME
	, SAL
FROM
	EMP
WHERE
	SAL < 1500
	OR SAL > 2850;

-- 17. 출력정보 : 부서번호, 사번, 이름, 급여
-- 조회조건 : 급여가 3000이상이거나, 부서번호 10인 직원
SELECT
	DEPTNO
	, EMPNO
	, ENAME
	, SAL
FROM
	EMP
WHERE
	SAL >= 3000
	OR DEPTNO = 10;
	
-- 18. 출력정보 : 부서번호, 사번, 이름, 직무
-- 조회조건 : 부서번호가 10, 20 부서원 조회
SELECT
	DEPTNO
	, EMPNO
	, ENAME
	, JOB
FROM
	EMP
WHERE
	DEPTNO = 10
	OR DEPTNO = 20;

-- 19. 10번 및 30번 부서에 속하는 모든 사원의 이름과 부서 번호를 조회하라.
-- 단, 이름을 알파벳순으로 정렬하여 출력하라. 
 
-- 1) 컬럼명 정렬 조회
SELECT
	ENAME
	, DEPTNO
FROM
	EMP
WHERE
	DEPTNO = 10
	OR DEPTNO = 30
ORDER BY
	ENAME ASC;

-- 2) alias(별명) 정렬 조회
SELECT
	ENAME AS 이름
	, DEPTNO AS 부서번호
FROM
	EMP
WHERE
	DEPTNO = 10
	OR DEPTNO = 30
ORDER BY
	이름 ASC;

-- 3) 조회 컬럼명에 대한 인덱스번호로  정렬 조회
SELECT
	ENAME
	, DEPTNO
FROM
	EMP
WHERE
	DEPTNO = 10
	OR DEPTNO = 30
ORDER BY
	1 ASC;


-- ## SQL 비교연산자 조건 검색

-- 20. 사원 이름이 A로 시작 하는 직원 검색
SELECT ENAME FROM EMP WHERE ENAME LIKE 'A%';

-- 21. 사원 이름에 A가 들어가는 직원 검색
SELECT ENAME FROM EMP WHERE ENAME LIKE '%A%';

-- 22. 사원이름의 3번째 문자가 A인 직원 검색
SELECT ENAME FROM EMP WHERE ENAME LIKE '__A%';

-- 23. 이름 5글자인 직원의 정보를 조회
SELECT * FROM EMP WHERE ENAME LIKE '_____';

-- 24. 부서가 10번, 20번 직원 검색
SELECT ENAME FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 20;

-- 25. 부서가 10번, 20번이 아닌 직원 검색
SELECT ENAME FROM EMP WHERE DEPTNO != 10 AND DEPTNO != 20;

-- 26. 급여가 1500이상 ~ 2850이하의 범위에 속하는 사원의 이름 및 급여를 조회
SELECT ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 2850;

-- 27. 급여가 1500이상 ~ 2850이하의 범위에 속하지 않는 사원의 이름 및 급여를 조회
SELECT ENAME, SAL FROM EMP WHERE SAL NOT BETWEEN 1500 AND 2850;

-- 28. 수당이 없는 직원 검색
SELECT ENAME FROM EMP WHERE COMM IS NULL;

-- 29. 수당이 있는 직원 검색
SELECT ENAME FROM EMP WHERE COMM IS NOT NULL;

-- 30. 직원 특별상여 = 급여 + 수당 * 20%
-- 수당이 있는 직원은 급여 + 수당 * 0.2 특별 상여
-- 수당이 없는 직원은 급여 * 0.2 특별 상여 
-- 이름 , 급여, 수당, 특별상여 정보 출력

-- 1) 수당이 있는 직원 정보 : 0원 이상인 사람
SELECT 
	ENAME AS 이름
	, SAL AS 급여
	, COMM AS 수당
	, (SAL+COMM)*0.2 AS 특별상여 
FROM 
	EMP 
WHERE 
	COMM >= 0;

-- 2) 수당이 없는 직원 정보
SELECT 
	ENAME AS 이름
	, SAL AS 급여
	, COMM AS 수당
	, SAL*0.2 AS 특별상여 
FROM 
	EMP 
WHERE 
	COMM IS NULL;

-- 3) 모든 사원에게 특별상여 지급
SELECT 
	ENAME AS 이름
	, SAL AS 급여
	, COMM AS 수당
	, CASE WHEN COMM IS NULL THEN SAL*0.2 ELSE (SAL+COMM)*0.2 END AS 특별상여
FROM 
	EMP 


-- 31. 사번이 000인 직원의 이름은 000이다
SELECT CONCAT ( CONCAT ( CONCAT( CONCAT('사번이 ', EMPNO), '인 직원의 이름은 '), ENAME), '이다') FROM EMP
SELECT '사번이 ' || EMPNO || '인 직원의 이름은 ' || ENAME || '이다' FROM EMP

-- 32. 근무기간에 따른 사원들에 대한 교육을 진행하기로 하였다.
-- 직원들의 사번, 이름, 입사일, 근무기간(년수, 년이하버림)의 정보를 
-- 근무기간이 작은 순서데로 조회하여라.
-- 근무기간 = 현재날짜 - 입사날짜
-- 근무년수가 33년 이상인 직원의 명단을 출력
SELECT
	EMPNO AS 사번
	, ENAME AS 이름
	, HIREDATE AS 입사일
	--, (TO_CHAR(sysdate, 'YYYY') - TO_CHAR(HIREDATE, 'YYYY')) AS 근무기간
	, FLOOR((TRUNC(SYSDATE) - TRUNC(HIREDATE))/365) AS 근무기간
FROM
	EMP
WHERE
	FLOOR((TRUNC(SYSDATE) - TRUNC(HIREDATE))/365) >= 33
ORDER BY
	근무기간 ASC;
	
-- 현재날짜 = sysdate
-- 현재 날짜 조회
select sysdate
from dual;

--SYSDATE
--------
--14/09/05
--14/09/05
