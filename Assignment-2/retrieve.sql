/* Question 1 */ 
SELECT * FROM developer; 

SELECT * FROM developer 
					WHERE developer_person_generalization = 3; 

SELECT websiteRole_developer_fk FROM website_role
					WHERE websiteRole_website_fk = 2 AND role != 'owner'; 

SELECT page_website_fk FROM page 
					JOIN website ON page.page_website_fk = website.id
					WHERE views < 300000; 

SELECT * FROM page_priviledge 
					WHERE priviledge = 'writer' AND pagePrivildege_page_fk = 4; 

/* Question 2 */ 
SELECT id, name, MIN(visits) FROM website; 

SELECT name FROM website 
			WHERE id = 6; 

SELECT websiteRole_website_fk FROM website_role 
			WHERE role = 'reviewer' AND websiteRole_developer_fk = 2; 

SELECT websiteRole_website_fk FROM website_role 
			WHERE role = 'owner' AND websiteRole_developer_fk = 1;

SELECT websiteRole_website_fk FROM website_role
JOIN website ON website.id = website_role.websiteRole_website_fk
WHERE website_role.role = 'admin' AND website_role.websiteRole_developer_fk = '3' AND website.visits > 6000000; 

/* Question 3 */ 
SELECT id, title, MAX(views) FROM page; 

SELECT title FROM page 
		WHERE id = 2; 

SELECT pageRole_page_fk FROM page_role
		WHERE role = 'editor' AND pageRole_developer_fk = 1; 

SELECT SUM(views) as 'Total Views' FROM page 
		WHERE page_website_fk = 5; 

SELECT AVG(views) as 'Average Views' FROM page 
		WHERE page_website_fk = 3; 

/* Question 4 */ 
SELECT * FROM widget
		WHERE widget_page_fk = 1; 
    
SELECT * FROM widget 
		WHERE dtype = 'youtube'; 
        
SELECT pageRole_page_fk FROM page_role 
		JOIN widget ON widget.widget_page_fk = page_role.pageRole_page_fk
		WHERE page_role.role = 'reviewer' AND page_role.pageRole_developer_fk = 1 AND widget.dtype= 'image'; 
    
SELECT COUNT(widget_page_fk)  FROM widget
		WHERE widget_page_fk = 3; 
    
/* Question 5 */ 
SELECT webPriviledge_website_fk FROM website_privilege 
	WHERE priviledge_website = 'delete' AND webPriviledge_developer_fk = '2'; 

SELECT webPriviledge_website_fk FROM website_privilege 
		WHERE priviledge_website = 'create' AND webPriviledge_developer_fk = '3'; 
        
