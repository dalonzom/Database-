/*People*/
use cs5200; 
DELETE FROM person; 

ALTER TABLE person AUTO_INCREMENT = 1; 

INSERT INTO person (first_name, last_name, username,password,email) VALUES('Alice','Wonder','alice','alice','alice@wonder.com'); 
INSERT INTO developer (developer_person_generalization, developer_key) 
SELECT id, '4321rewq'
	FROM person
    WHERE person.id = 1;
INSERT INTO person (first_name, last_name, username,password,email) VALUES('Bob','Marley','bob','bob','bob@marley.com');
INSERT INTO developer (developer_person_generalization, developer_key) 
SELECT id, '5432trew'
	FROM person
    WHERE person.id = 2;
    
INSERT INTO person (first_name, last_name, username,password,email) VALUES('Charles','Garcia','charlie','charlie','chuch@garcia.com');
INSERT INTO developer (developer_person_generalization, developer_key) 
SELECT id, '6543ytre'
	FROM person
    WHERE person.id = 3;

INSERT INTO person (first_name, last_name, username,password,email) VALUES('Dan','Martin','dan','dan','dan@martin.com');
INSERT INTO cs5200.user (user_person_generalization, user_agreement, user_key) 
SELECT id, 1, '7654fda'
	FROM person
    WHERE person.id = 4;

INSERT INTO person (first_name, last_name, username,password,email) VALUES('Ed','Karaz','ed','ed','ed@kar.com');
INSERT INTO user (user_person_generalization, user_agreement, user_key) 
SELECT id, 1, '5678dfgh'
	FROM person
    WHERE person.id = 5;

/*Websites*/ 
DELETE  FROM website; 
ALTER TABLE website AUTO_INCREMENT = 1; 

INSERT INTO website (name, description, created, updated, visits, website_developer_fk)
SELECT 'Facebook', 'an online social media and social networking service', '2018-10-08', '2018-10-08', 1234234, id
	FROM person
	WHERE username = 'alice'; 

INSERT INTO website (name, description, created, updated, visits, website_developer_fk)
SELECT 'Twitter','an online news and social networking service', '2018-10-08','2018-10-08',4321543, id
	FROM person
	where username = 'bob'; 

INSERT INTO website (name, description, created, updated, visits, website_developer_fk) 
SELECT 'Wikipedia', 'a free online encyclopedia','2018-10-08', '2018-10-08', 3456654, id
	FROM person
	WHERE username = 'charlie'; 

INSERT INTO website (name, description, created, updated, visits, website_developer_fk)
SELECT 'CNN', 'an American basic cable and satellite television news channel', '2018-10-08','2018-10-08',6543345, id
	FROM person 
	WHERE username = 'alice'; 

INSERT INTO website (name, description, created, updated, visits, website_developer_fk)
SELECT 'CNET', 'an American media website that publishes reviews, news, articles,blogs,podcasts,and videos on technology and consumer electronics', '2018-10-08', '2018-10-08',5433455, id
	FROM person
	WHERE username = 'bob'; 
 
INSERT INTO website (name, description, created, updated, visits, website_developer_fk)
SELECT 'Gizmodo', 'a design, technology, science and science fiction website that also writes articles on politics', '2018-10-08','2018-10-08',4322345, id
	 FROM person
	WHERE username = 'charlie'; 
/*Facebook*/ 
INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
SELECT 'owner',  id, 1 
		FROM person 
		WHERE username = 'alice'; 

INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
	SELECT 'editor',  id, 1 
		FROM person 
		WHERE username = 'bob'; 

INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
	SELECT 'admin',  id, 1 
	FROM person 
	WHERE username = 'charlie'; 

/*Twitter*/ 
INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
SELECT 'owner',  id, 2 
		FROM person 
		WHERE username = 'bob'; 

INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
SELECT 'editor',  id, 2 
		FROM person 
		WHERE username = 'charlie'; 

INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
SELECT 'admin',  id, 2 
		FROM person 
		WHERE username = 'alice';

/*Wikipedia */ 
INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
SELECT 'owner',  id, 3
		FROM person 
		WHERE username = 'charlie'; 

INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
SELECT 'editor',  id, 3
		FROM person 
		WHERE username = 'alice'; 

INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
SELECT 'admin',  id, 3
		FROM person 
		WHERE username = 'bob';

/*CNN*/ 
INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
SELECT 'owner',  id, 4
		FROM person 
		WHERE username = 'alice'; 

INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
SELECT 'editor',  id, 4
		FROM person 
		WHERE username = 'bob'; 

INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
SELECT 'admin',  id, 4
		FROM person 
		WHERE username = 'charlie'; 
/*CNET*/ 
INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
SELECT 'owner',  id, 5
		FROM person 
		WHERE username = 'bob'; 

INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
SELECT 'editor',  id, 5
		FROM person 
		WHERE username = 'charlie'; 
    
INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
SELECT 'admin',  id, 5
		FROM person 
		WHERE username = 'alice'; 
/*Gizmodo*/ 
INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
SELECT 'owner',  id, 6
		FROM person 
		WHERE username = 'charlie'; 

INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
SELECT 'editor',  id, 6
		FROM person 
		WHERE username = 'alice'; 

INSERT INTO website_role (role, websiteRole_developer_fk, websiteRole_website_fk) 
SELECT 'admin',  id, 6
		FROM person 
		WHERE username = 'bob'; 

/*Pages*/ 
DELETE FROM page; 
ALTER TABLE page AUTO_INCREMENT = 1; 

INSERT INTO page (title, description, created, updatedDate ,views, page_website_fk)
SELECT  'Home', 'Landing page', '2018-09-05','2018-10-08',123434, id
		FROM website 
		WHERE website.name = 'CNET'; 

INSERT INTO page (title, description, created, updatedDate ,views, page_website_fk)
SELECT 'About', 'Website Description', '2018-09-05','2018-10-08',234545, id
		FROM website 
		WHERE website.name = 'Gizmodo'; 

INSERT INTO page (title, description, created, updatedDate ,views, page_website_fk)
SELECT 'Contact', 'Addresses,phones, and contact info', '2018-09-05','2018-10-08',345656, id
		FROM website 
		WHERE website.name = 'Wikipedia'; 


INSERT INTO page (title, description, created, updatedDate ,views, page_website_fk)
SELECT 'Preferences', 'Where users can configure their preferences', '2018-09-05','2018-10-08',456776, id
		FROM website 
		WHERE website.name = 'CNN'; 


INSERT INTO page (title, description, created, updatedDate ,views, page_website_fk)
SELECT 'Profile', 'Users can configure their personal information', '2018-09-05','2018-10-08',567878, id
		FROM website 
		WHERE website.name = 'CNET'; 
			
DELETE FROM page_role; 
ALTER TABLE page_role AUTO_INCREMENT = 1; 

DELETE FROM page_priviledge; 
ALTER TABLE page_priviledge AUTO_INCREMENT = 1; 
/*Home*/ 
INSERT INTO page_role (roles, pageRole_developer_fk, pageRole_page_fk) 
SELECT 'editor',  id, 1 
		FROM person 
		WHERE username = 'alice'; 

INSERT INTO page_role (roles, pageRole_developer_fk, pageRole_page_fk) 
SELECT 'reviewer',  id, 1 
			FROM person 
			WHERE username = 'bob'; 

INSERT INTO page_role (roles, pageRole_developer_fk, pageRole_page_fk) 
SELECT 'writer',  id, 1 
		FROM person 
		WHERE username = 'charlie'; 
/*About*/ 
INSERT INTO page_role (roles, pageRole_developer_fk, pageRole_page_fk) 
SELECT 'editor',  id, 2
		FROM person 
		WHERE username = 'bob'; 

INSERT INTO page_role (roles, pageRole_developer_fk, pageRole_page_fk) 
SELECT 'reviewer',  id, 2
		FROM person 
		WHERE username = 'charlie'; 

INSERT INTO page_role (roles, pageRole_developer_fk, pageRole_page_fk) 
SELECT 'writer',  id, 2
		FROM person 
		WHERE username = 'alice'; 
/*Contact*/ 

INSERT INTO page_role (roles, pageRole_developer_fk, pageRole_page_fk) 
SELECT 'editor',  id, 3
	FROM person 
	WHERE username = 'charlie'; 

INSERT INTO page_role (roles, pageRole_developer_fk, pageRole_page_fk) 
SELECT 'reviewer',  id, 3
		FROM person 
		WHERE username = 'alice'; 
    
INSERT INTO page_role (roles, pageRole_developer_fk, pageRole_page_fk) 
SELECT 'writer',  id, 3
			FROM person 
			WHERE username = 'bob';
    
/*Preferences */
INSERT INTO page_role (roles, pageRole_developer_fk, pageRole_page_fk) 
SELECT 'editor',  id, 4
		FROM person 
		WHERE username = 'alice';  

INSERT INTO page_role (roles, pageRole_developer_fk, pageRole_page_fk) 
SELECT 'reviewer',  id, 4
		FROM person 
		WHERE username = 'bob';  

INSERT INTO page_role (roles, pageRole_developer_fk, pageRole_page_fk) 
SELECT 'writer',  id, 4
		FROM person 
		WHERE username = 'charlie';

/*Profile*/ 

INSERT INTO page_role (role, pageRole_developer_fk, pageRole_page_fk) 
SELECT 'editor',  id, 5
		FROM person 
		WHERE username = 'bob';  
    
INSERT INTO page_role (role, pageRole_developer_fk, pageRole_page_fk) 
SELECT 'reviewer',  id, 5
		FROM person 
		WHERE username = 'charlie';  

INSERT INTO page_role (role, pageRole_developer_fk, pageRole_page_fk) 
SELECT 'writer',  id, 5
		FROM person 
		WHERE username = 'alice';  
/*Widgets*/ 
				
DELETE FROM widget; 
ALTER TABLE widget AUTO_INCREMENT = 1; 
INSERT INTO widget (name, dtype, text, orderType, widget_page_fk)
SELECT ' head123','heading','welcome',0, page.id
			FROM page 
			WHERE page.title = 'Home'; 

INSERT INTO widget (name, dtype, text, orderType, widget_page_fk)
		SELECT 'post234', 'html','<p>Lorem</p>',0, page.id
		FROM page 
		WHERE page.title = 'About'; 

INSERT INTO widget (name, dtype, text, orderType, widget_page_fk)
			SELECT 'head345', 'heading','Hi',1, page.id
			FROM page 
			WHERE page.title = 'Contact'; 

INSERT INTO widget (name, dtype, text, orderType, widget_page_fk)
			SELECT 'intro456', 'html','<h1>Hi</h1>',2, page.id
			FROM page 
			WHERE page.title = 'Contact'; 

INSERT INTO widget (name, dtype, orderType,width, height, url, widget_page_fk)
			SELECT 'image345', 'image',3,50,100, '/img/567.png', page.id
			FROM page
			WHERE page.title = 'Contact'; 


INSERT INTO widget (name, dtype, orderType,width, height, url, widget_page_fk)
			SELECT 'video456', 'youtube',0,400,300, 'https://youtu.be/h67VX51QXiQ', page.id
			FROM page
			WHERE page.title = 'Preferences'; 
/*Phones and Addresses*/ 
					
INSERT INTO phone (phone_number, primary_number, phone_person_generalization)
				SELECT '123-234-3456', 1, person.id 
				FROM person
				WHERE person.username = 'alice'; 

INSERT INTO phone (phone_number, primary_number, phone_person_generalization)
				SELECT '234-345-4566', 0, person.id 
				FROM person
				WHERE person.username = 'alice'; 

INSERT INTO phone (phone_number, primary_number, phone_person_generalization)
				SELECT '345-456-5677', 1, person.id 
				FROM person
				WHERE person.username = 'bob'; 

INSERT INTO phone (phone_number, primary_number, phone_person_generalization)
				SELECT '321-432-5435', 1, person.id 
				FROM person
				WHERE person.username = 'charlie'; 

INSERT INTO phone (phone_number, primary_number, phone_person_generalization)
				SELECT '432-432-5433', 0, person.id 
				FROM person
				WHERE person.username = 'charlie'; 

INSERT INTO phone (phone_number, primary_number, phone_person_generalization)
				SELECT '543-543-6544', 0, person.id 
				FROM person
				WHERE person.username = 'charlie'; 
						
INSERT INTO address (street1, city, zip, primary_address, address_person_generalization) 
				SELECT '123 Adam St.', 'Alton', '01234', 1, person.id 
				FROM person
				WHERE person.username = 'alice'; 

INSERT INTO address (street1, city, zip, primary_address, address_person_generalization) 
				SELECT '234 Birch St.', 'Boston', '02345', 0, person.id 
				FROM person
				WHERE person.username = 'alice'; 

INSERT INTO address (street1, city, zip, primary_address, address_person_generalization) 
				SELECT '345 Charles St.', 'Chelms', '03455', 1, person.id 
				FROM person
				WHERE person.username = 'bob'; 

INSERT INTO address (street1, city, zip, primary_address, address_person_generalization) 
			SELECT '456 Down St.', 'Dalton', '04566', 0, person.id 
			FROM person
			WHERE person.username = 'bob'; 

INSERT INTO address (street1, city, zip, primary_address, address_person_generalization) 
				SELECT '543 East St.', 'Everett', '01112', 0, person.id 
				FROM person
				WHERE person.username = 'bob'; 

INSERT INTO address (street1, city, zip, primary_address, address_person_generalization) 
				SELECT '654 Frank St.', 'Foulton', '04322', 1, person.id 
				FROM person
				WHERE person.username = 'charlie'; 
							
							
