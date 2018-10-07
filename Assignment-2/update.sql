/*Updates */ 

/*a*/ 
UPDATE phone
SET phone_number = '333-444-5555'
WHERE primary_number = 1 AND phone_person_generalization  = 3; 

/*b*/
UPDATE page 
SET title = CONCAT('CNET = ', title) 
WHERE page_website_fk = 5; 

/*c*/
UPDATE widget 
SET orderType = 3 
WHERE name = 'head345'; 

UPDATE widget 
SET orderType = 1 
WHERE name = 'image345'; 

/*d*/
UPDATE website_role
SET role = 'owner' 
WHERE websiteRole_developer_fk = 3 AND websiteRole_website_fk = 5; 

UPDATE website_role
SET role = 'editor' 
WHERE websiteRole_developer_fk = 2 AND websiteRole_website_fk = 5; 
