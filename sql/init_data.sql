USE rieltoragency;
SET NAMES cp1251;

TRUNCATE TABLE ADVERT_TYPE;
INSERT INTO ADVERT_TYPE VALUE(
	NULL,
	'���㯪�'
);
INSERT INTO ADVERT_TYPE VALUE(
	NULL,
	'�த���'
);
INSERT INTO ADVERT_TYPE VALUE(
	NULL,
	'�७�� ���'
);
INSERT INTO ADVERT_TYPE VALUE(
	NULL,
	'�७�� �।�������'
);
SELECT * FROM ADVERT_TYPE;

TRUNCATE TABLE OBJECT_TYPE;
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'���饢��'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'��誠'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'�०�����'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'����ᥬ����'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'���'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'��頣�'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'����襭��� ���頤�'
);
SELECT * FROM OBJECT_TYPE;

TRUNCATE TABLE BALCONY;
INSERT INTO BALCONY VALUE(
	NULL,
	'���������'
);
INSERT INTO BALCONY VALUE(
	NULL,
	'�����⥪�����'
);
INSERT INTO BALCONY VALUE(
	NULL,
	'���⥪�����'
);
INSERT INTO BALCONY VALUE(
	NULL,
	'�⥯�����'
);                 
SELECT * FROM BALCONY;

TRUNCATE TABLE TOILET;
INSERT INTO TOILET VALUE(
	NULL,
	'�����饭��'
);                    
INSERT INTO TOILET VALUE(
	NULL,
	'��������'
);                 
INSERT INTO TOILET VALUE(
	NULL,
	'�� �⠦�'
);                   
SELECT * FROM TOILET;

TRUNCATE TABLE HEAT;
INSERT INTO HEAT VALUE(
	NULL,
	'����ࠫ쭮�'
);                   
INSERT INTO HEAT VALUE(
	NULL,
	'����ࠫ쭮� � ॣ㫨஢���'
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
	'�������᪠�'
);              
SELECT * FROM STOVE;

TRUNCATE TABLE STOVE;
INSERT INTO STOVE VALUE(
	NULL,
	'�������'
);                  
INSERT INTO STOVE VALUE(
	NULL,
	'�������᪠�'
);              
SELECT * FROM STOVE;

TRUNCATE TABLE OBJECT_STATE;
INSERT INTO OBJECT_STATE VALUE(
	NULL,
	'���宥'
);                  
INSERT INTO OBJECT_STATE VALUE(
	NULL,
	'������⢮�⥫쭮�'
);              
INSERT INTO OBJECT_STATE VALUE(
	NULL,
	'���襥'
);              
INSERT INTO OBJECT_STATE VALUE(
	NULL,
	'�⫨筮�'
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
	'�⬥������'
);              
SELECT * FROM STATE_TYPE;

TRUNCATE TABLE REGION;
INSERT INTO REGION VALUE(
	NULL,
	'���������஦��'
);              
INSERT INTO REGION VALUE(
	NULL,
	'������०��'
);       
INSERT INTO REGION VALUE(
	NULL,
	'�����᪨�'
);              
INSERT INTO REGION VALUE(
	NULL,
	'������୮�᪨�'
);              
INSERT INTO REGION VALUE(
	NULL,
	'������'
);              
SELECT * FROM REGION;