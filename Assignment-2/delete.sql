/*Deletes*/ 
/*a*/ 
DELETE FROM address 
	WHERE primary_address = 1 AND address_person_generalization = 1; 
    
/*b*/
DELETE FROM widget 
	WHERE orderType = 3 AND widget_page_fk = 3; 
    
/*c*/
DELETE FROM page 
	WHERE page_website_fk  = 3; 
    
/*d*/
DELETE FROM website 
	WHERE name = 'CNET'; 
