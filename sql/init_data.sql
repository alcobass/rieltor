USE rieltoragency;
SET NAMES cp1251;

TRUNCATE TABLE ADVERT_TYPE;
INSERT INTO ADVERT_TYPE VALUE(
	NULL,
	'�������'
);
INSERT INTO ADVERT_TYPE VALUE(
	NULL,
	'�������'
);
INSERT INTO ADVERT_TYPE VALUE(
	NULL,
	'������ �����'
);
INSERT INTO ADVERT_TYPE VALUE(
	NULL,
	'������ �����������'
);
SELECT * FROM ADVERT_TYPE;

TRUNCATE TABLE OBJECT_TYPE;
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'��������'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'�����'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'���������'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'�����������'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'���'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'������'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'���������� �������'
);
SELECT * FROM OBJECT_TYPE;

TRUNCATE TABLE BALCONY;
INSERT INTO BALCONY VALUE(
	NULL,
	'�����������'
);
INSERT INTO BALCONY VALUE(
	NULL,
	'��������������'
);
INSERT INTO BALCONY VALUE(
	NULL,
	'������������'
);
INSERT INTO BALCONY VALUE(
	NULL,
	'����������'
);                 
SELECT * FROM BALCONY;

TRUNCATE TABLE TOILET;
INSERT INTO TOILET VALUE(
	NULL,
	'�����������'
);                    
INSERT INTO TOILET VALUE(
	NULL,
	'����������'
);                 
INSERT INTO TOILET VALUE(
	NULL,
	'�� �����'
);                   
SELECT * FROM TOILET;

TRUNCATE TABLE HEAT;
INSERT INTO HEAT VALUE(
	NULL,
	'�����������'
);                   
INSERT INTO HEAT VALUE(
	NULL,
	'����������� � ������������'
);                  
INSERT INTO HEAT VALUE(
	NULL,
	'����'
);                  
SELECT * FROM HEAT;

TRUNCATE TABLE STOVE;
INSERT INTO STOVE VALUE(
	NULL,
	'�������'
);                  
INSERT INTO STOVE VALUE(
	NULL,
	'�������������'
);              
SELECT * FROM STOVE;

TRUNCATE TABLE STOVE;
INSERT INTO STOVE VALUE(
	NULL,
	'�������'
);                  
INSERT INTO STOVE VALUE(
	NULL,
	'�������������'
);              
SELECT * FROM STOVE;

TRUNCATE TABLE OBJECT_STATE;
INSERT INTO OBJECT_STATE VALUE(
	NULL,
	'������'
);                  
INSERT INTO OBJECT_STATE VALUE(
	NULL,
	'������������������'
);              
INSERT INTO OBJECT_STATE VALUE(
	NULL,
	'�������'
);              
INSERT INTO OBJECT_STATE VALUE(
	NULL,
	'��������'
);               
SELECT * FROM OBJECT_STATE;

TRUNCATE TABLE STATE_TYPE;
INSERT INTO STATE_TYPE VALUE(
	NULL,
	'�����'
);               
INSERT INTO STATE_TYPE VALUE(
	NULL,
	'�������������'
);          
INSERT INTO STATE_TYPE VALUE(
	NULL,
	'����������'
);              
SELECT * FROM STATE_TYPE;

TRUNCATE TABLE REGION;
INSERT INTO REGION VALUE(
	NULL,
	'���������������'
);              
INSERT INTO REGION VALUE(
	NULL,
	'������������'
);       
INSERT INTO REGION VALUE(
	NULL,
	'���������'
);              
INSERT INTO REGION VALUE(
	NULL,
	'���������������'
);              
INSERT INTO REGION VALUE(
	NULL,
	'��������'
);              
SELECT * FROM REGION;