USE rieltoragency;
SET NAMES cp1251;

TRUNCATE TABLE ADVERT_TYPE;
INSERT INTO ADVERT_TYPE VALUE(
	NULL,
	'Покупка'
);
INSERT INTO ADVERT_TYPE VALUE(
	NULL,
	'Продажа'
);
INSERT INTO ADVERT_TYPE VALUE(
	NULL,
	'Аренда спрос'
);
INSERT INTO ADVERT_TYPE VALUE(
	NULL,
	'Аренда предложение'
);
SELECT * FROM ADVERT_TYPE;

TRUNCATE TABLE OBJECT_TYPE;
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'Хрущевка'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'Чешка'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'Брежневка'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'Малосемейка'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'ЗГТ'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'Общага'
);
INSERT INTO OBJECT_TYPE VALUE(
	NULL,
	'Повышенной площади'
);
SELECT * FROM OBJECT_TYPE;

TRUNCATE TABLE BALCONY;
INSERT INTO BALCONY VALUE(
	NULL,
	'Отсутствует'
);
INSERT INTO BALCONY VALUE(
	NULL,
	'Незастекленный'
);
INSERT INTO BALCONY VALUE(
	NULL,
	'Застекленный'
);
INSERT INTO BALCONY VALUE(
	NULL,
	'Утепленный'
);                 
SELECT * FROM BALCONY;

TRUNCATE TABLE TOILET;
INSERT INTO TOILET VALUE(
	NULL,
	'Совмещенный'
);                    
INSERT INTO TOILET VALUE(
	NULL,
	'Раздельный'
);                 
INSERT INTO TOILET VALUE(
	NULL,
	'На этаже'
);                   
SELECT * FROM TOILET;

TRUNCATE TABLE HEAT;
INSERT INTO HEAT VALUE(
	NULL,
	'Центральное'
);                   
INSERT INTO HEAT VALUE(
	NULL,
	'Центральное с регулировкой'
);                  
INSERT INTO HEAT VALUE(
	NULL,
	'АОГВ'
);                  
SELECT * FROM HEAT;

TRUNCATE TABLE STOVE;
INSERT INTO STOVE VALUE(
	NULL,
	'Газовая'
);                  
INSERT INTO STOVE VALUE(
	NULL,
	'Электрическая'
);              
SELECT * FROM STOVE;

TRUNCATE TABLE STOVE;
INSERT INTO STOVE VALUE(
	NULL,
	'Газовая'
);                  
INSERT INTO STOVE VALUE(
	NULL,
	'Электрическая'
);              
SELECT * FROM STOVE;

TRUNCATE TABLE OBJECT_STATE;
INSERT INTO OBJECT_STATE VALUE(
	NULL,
	'Плохое'
);                  
INSERT INTO OBJECT_STATE VALUE(
	NULL,
	'Удовлетворительное'
);              
INSERT INTO OBJECT_STATE VALUE(
	NULL,
	'Хорошее'
);              
INSERT INTO OBJECT_STATE VALUE(
	NULL,
	'Отличное'
);               
SELECT * FROM OBJECT_STATE;

TRUNCATE TABLE STATE_TYPE;
INSERT INTO STATE_TYPE VALUE(
	NULL,
	'Новое'
);               
INSERT INTO STATE_TYPE VALUE(
	NULL,
	'Реализованное'
);          
INSERT INTO STATE_TYPE VALUE(
	NULL,
	'Отмененное'
);              
SELECT * FROM STATE_TYPE;

TRUNCATE TABLE REGION;
INSERT INTO REGION VALUE(
	NULL,
	'Железнодорожный'
);              
INSERT INTO REGION VALUE(
	NULL,
	'Левобережный'
);       
INSERT INTO REGION VALUE(
	NULL,
	'Ленинский'
);              
INSERT INTO REGION VALUE(
	NULL,
	'Коминтерновский'
);              
INSERT INTO REGION VALUE(
	NULL,
	'Северный'
);              
SELECT * FROM REGION;