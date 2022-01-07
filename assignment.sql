-- 01. �������� ���̺� ����(��Ű��) ��ȸ
SELECT * FROM col WHERE tname='EMP';
SELECT * FROM cols WHERE table_name='EMP';
SELECT * FROM user_tab_columns WHERE table_name='EMP';

-- 02. �μ� ���̺� ����(��Ű�� ��ȸ)
SELECT * FROM col WHERE tname='DEPT';
SELECT * FROM cols WHERE table_name='DEPT';
SELECT * FROM user_tab_columns WHERE table_name='DEPT';

-- 03. ��ü������ ������� ��ȸ
SELECT * FROM EMP;

-- 04. ��ü�μ��� ������� ��ȸ
SELECT * FROM DEPT;

-- 05. ��ü������ ���, �̸�, �޿�, ��, �Ի��� ������ ��ȸ
SELECT EMPNO, ENAME, SAL, COMM, HIREDATE FROM EMP;

-- 06. �÷��� ���� ���� ����ؼ� ��ȸ
-- ������� : Employee No, Name, Salary, COMMISION, Hire Date
SELECT 
	EMPNO AS "Employee No"
	, ENAME AS NAME
	, SAL AS Salary
	, COMM AS COMMISION
	, HIREDATE AS "Hire Date"
FROM 
	EMP;

-- 07. ���� ��ȸ
-- ������� : �μ���ȣ, ���, �̸�, �޿�, ����
-- ���ı��� : �޿�(��������), �μ���ȣ(��������)
-- ���ı��� : �μ���ȣ(��������), �޿�(��������)
SELECT 
	DEPTNO AS �μ���ȣ
	, EMPNO AS ���
	, ENAME AS �̸�
	, SAL AS �޿�
	, COMM AS ����
FROM 
	EMP
ORDER BY
	SAL DESC
	, DEPTNO ASC;
	
SELECT 
	DEPTNO AS �μ���ȣ
	, EMPNO AS ���
	, ENAME AS �̸�
	, SAL AS �޿�
	, COMM AS ����
FROM 
	EMP
ORDER BY
	DEPTNO ASC
	, SAL DESC;


-- 08. �ߺ��� ���� ��ȸ : distinct
-- ������ ���� ���� ��ȸ
-- ���ı��� : ���� �ø�����
SELECT DISTINCT JOB FROM EMP ORDER BY JOB ASC;

-- 09. ���μ��� �ش� �μ����� ���� ���� ��ȸ
-- ������� : �μ���ȣ, ����
-- ���ı��� : �μ���ȣ �ø�, ���� �ø�
SELECT DISTINCT
	DEPTNO
	, JOB
FROM 
	EMP
ORDER BY
	DEPTNO ASC
	, JOB ASC;

-- 10. ���� ��ȸ
-- ������� : ���, �̸�, �޿�
-- ��ȸ���� : �޿��� 3000�̻��� ����
SELECT
	EMPNO
	, ENAME
	, SAL
FROM
	EMP
WHERE
	SAL >= 3000;

-- 11. �����ȣ�� 7788 ����� �̸� �� �μ���ȣ�� ���
SELECT
	ENAME
	, DEPTNO
FROM
	EMP
WHERE
	EMPNO = 7788;

-- 12. 10�� �μ����߿��� �޿��� 3000�̻��� ����
SELECT * FROM EMP WHERE DEPTNO = 10 AND SAL >= 3000;

-- 13. ������� : �μ���ȣ, ���, �̸�, ����
-- ��ȸ���� : ������ manager �� ����
SELECT
	DEPTNO
	, EMPNO
	, ENAME
	, JOB
FROM
	EMP
WHERE
	JOB = 'MANAGER';

-- 14. ������� : �μ���ȣ, ���, �̸�, ����
-- ��ȸ���� : ������ SALESMAN�� �ƴ� ����
SELECT
	DEPTNO
	, EMPNO
	, ENAME
	, JOB
FROM
	EMP
WHERE
	JOB != 'SALESMAN';
	

-- 15. �޿��� 1500�̻� ~ 2850������ ������ ���ϴ� ����� �̸� �� �޿��� ��ȸ
SELECT
	ENAME
	, SAL
FROM
	EMP
WHERE
	SAL >= 1500
	AND SAL <= 2850;

-- 16. �޿��� 1500�̻� ~ 2850������ ������ ������ �ʴ� ����� �̸� �� �޿��� ��ȸ
SELECT
	ENAME
	, SAL
FROM
	EMP
WHERE
	SAL < 1500
	OR SAL > 2850;

-- 17. ������� : �μ���ȣ, ���, �̸�, �޿�
-- ��ȸ���� : �޿��� 3000�̻��̰ų�, �μ���ȣ 10�� ����
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
	
-- 18. ������� : �μ���ȣ, ���, �̸�, ����
-- ��ȸ���� : �μ���ȣ�� 10, 20 �μ��� ��ȸ
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

-- 19. 10�� �� 30�� �μ��� ���ϴ� ��� ����� �̸��� �μ� ��ȣ�� ��ȸ�϶�.
-- ��, �̸��� ���ĺ������� �����Ͽ� ����϶�. 
 
-- 1) �÷��� ���� ��ȸ
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

-- 2) alias(����) ���� ��ȸ
SELECT
	ENAME AS �̸�
	, DEPTNO AS �μ���ȣ
FROM
	EMP
WHERE
	DEPTNO = 10
	OR DEPTNO = 30
ORDER BY
	�̸� ASC;

-- 3) ��ȸ �÷��� ���� �ε�����ȣ��  ���� ��ȸ
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


-- ## SQL �񱳿����� ���� �˻�

-- 20. ��� �̸��� A�� ���� �ϴ� ���� �˻�
SELECT ENAME FROM EMP WHERE ENAME LIKE 'A%';

-- 21. ��� �̸��� A�� ���� ���� �˻�
SELECT ENAME FROM EMP WHERE ENAME LIKE '%A%';

-- 22. ����̸��� 3��° ���ڰ� A�� ���� �˻�
SELECT ENAME FROM EMP WHERE ENAME LIKE '__A%';

-- 23. �̸� 5������ ������ ������ ��ȸ
SELECT * FROM EMP WHERE ENAME LIKE '_____';

-- 24. �μ��� 10��, 20�� ���� �˻�
SELECT ENAME FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 20;

-- 25. �μ��� 10��, 20���� �ƴ� ���� �˻�
SELECT ENAME FROM EMP WHERE DEPTNO != 10 AND DEPTNO != 20;

-- 26. �޿��� 1500�̻� ~ 2850������ ������ ���ϴ� ����� �̸� �� �޿��� ��ȸ
SELECT ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 2850;

-- 27. �޿��� 1500�̻� ~ 2850������ ������ ������ �ʴ� ����� �̸� �� �޿��� ��ȸ
SELECT ENAME, SAL FROM EMP WHERE SAL NOT BETWEEN 1500 AND 2850;

-- 28. ������ ���� ���� �˻�
SELECT ENAME FROM EMP WHERE COMM IS NULL;

-- 29. ������ �ִ� ���� �˻�
SELECT ENAME FROM EMP WHERE COMM IS NOT NULL;

-- 30. ���� Ư���� = �޿� + ���� * 20%
-- ������ �ִ� ������ �޿� + ���� * 0.2 Ư�� ��
-- ������ ���� ������ �޿� * 0.2 Ư�� �� 
-- �̸� , �޿�, ����, Ư���� ���� ���

-- 1) ������ �ִ� ���� ���� : 0�� �̻��� ���
SELECT 
	ENAME AS �̸�
	, SAL AS �޿�
	, COMM AS ����
	, (SAL+COMM)*0.2 AS Ư���� 
FROM 
	EMP 
WHERE 
	COMM >= 0;

-- 2) ������ ���� ���� ����
SELECT 
	ENAME AS �̸�
	, SAL AS �޿�
	, COMM AS ����
	, SAL*0.2 AS Ư���� 
FROM 
	EMP 
WHERE 
	COMM IS NULL;

-- 3) ��� ������� Ư���� ����
SELECT 
	ENAME AS �̸�
	, SAL AS �޿�
	, COMM AS ����
	, CASE WHEN COMM IS NULL THEN SAL*0.2 ELSE (SAL+COMM)*0.2 END AS Ư����
FROM 
	EMP 


-- 31. ����� 000�� ������ �̸��� 000�̴�
SELECT CONCAT ( CONCAT ( CONCAT( CONCAT('����� ', EMPNO), '�� ������ �̸��� '), ENAME), '�̴�') FROM EMP
SELECT '����� ' || EMPNO || '�� ������ �̸��� ' || ENAME || '�̴�' FROM EMP

-- 32. �ٹ��Ⱓ�� ���� ����鿡 ���� ������ �����ϱ�� �Ͽ���.
-- �������� ���, �̸�, �Ի���, �ٹ��Ⱓ(���, �����Ϲ���)�� ������ 
-- �ٹ��Ⱓ�� ���� �������� ��ȸ�Ͽ���.
-- �ٹ��Ⱓ = ���糯¥ - �Ի糯¥
-- �ٹ������ 33�� �̻��� ������ ����� ���
SELECT
	EMPNO AS ���
	, ENAME AS �̸�
	, HIREDATE AS �Ի���
	--, (TO_CHAR(sysdate, 'YYYY') - TO_CHAR(HIREDATE, 'YYYY')) AS �ٹ��Ⱓ
	, FLOOR((TRUNC(SYSDATE) - TRUNC(HIREDATE))/365) AS �ٹ��Ⱓ
FROM
	EMP
WHERE
	FLOOR((TRUNC(SYSDATE) - TRUNC(HIREDATE))/365) >= 33
ORDER BY
	�ٹ��Ⱓ ASC;
	
-- ���糯¥ = sysdate
-- ���� ��¥ ��ȸ
select sysdate
from dual;

--SYSDATE
--------
--14/09/05
--14/09/05
