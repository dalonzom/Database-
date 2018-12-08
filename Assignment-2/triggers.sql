DELIMITER $$
CREATE DEFINER=`dalonzom`@`%` TRIGGER `cs5200`.`website_role_AFTER_INSERT` AFTER INSERT ON `website_role` FOR EACH ROW
BEGIN
IF NEW.role = 'owner'   OR NEW.role = 'admin' THEN
	BEGIN
	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
    SELECT 'create', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
        WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk AND websiteRole_website_fk = NEW.websiteRole_website_fk;
        
	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
	SELECT 'update', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
		WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk  AND websiteRole_website_fk = NEW.websiteRole_website_fk;
			
	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
    SELECT 'read', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
        WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk  AND websiteRole_website_fk = NEW.websiteRole_website_fk;

	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
    SELECT 'delete', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
        WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk  AND websiteRole_website_fk = NEW.websiteRole_website_fk;
      
    
    END;
END IF; 
IF NEW.role = 'writer' THEN 
	BEGIN
	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
    SELECT 'create', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
        WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk  AND websiteRole_website_fk = NEW.websiteRole_website_fk;
      
        
	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
	SELECT 'update', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
		WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk;
			
	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
    SELECT 'read', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
        WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk;

    END;
 END IF;  
IF NEW.role = 'editor' THEN
	BEGIN
INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
	SELECT 'update', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
		WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk;
			
	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
    SELECT 'read', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
        WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk;
    END;
END IF;
IF NEW.role = 'reviewer' THEN
BEGIN
	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
    SELECT 'read', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
        WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk;
    
    END;
    
END IF;

END;
$$ 
/*Website_role_update*/ 
CREATE DEFINER=`dalonzom`@`%` TRIGGER `cs5200`.`website_role_AFTER_UPDATE` AFTER UPDATE ON `website_role` FOR EACH ROW
BEGIN

IF NEW.role = 'owner'   OR NEW.role = 'admin' THEN
	BEGIN
	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
    SELECT 'create', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
        WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk AND websiteRole_website_fk = NEW.websiteRole_website_fk; 
        
	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
	SELECT 'update', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
		WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk  AND websiteRole_website_fk = NEW.websiteRole_website_fk;
			
	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
    SELECT 'read', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
        WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk  AND websiteRole_website_fk = NEW.websiteRole_website_fk;

	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
    SELECT 'delete', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
        WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk  AND websiteRole_website_fk = NEW.websiteRole_website_fk;
      
    
    END;
END IF; 
IF NEW.role = 'writer' THEN 
	BEGIN
	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
    SELECT 'create', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
        WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk  AND websiteRole_website_fk = NEW.websiteRole_website_fk;
      
        
	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
	SELECT 'update', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
		WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk;
			
	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
    SELECT 'read', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
        WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk;

    END;
 END IF;   
IF NEW.role = 'editor' THEN
	BEGIN
INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
	SELECT 'update', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
		WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk;
			
	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
    SELECT 'read', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
        WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk;
    END;
END IF; 
IF NEW.role = 'reviewer' THEN
BEGIN
	INSERT INTO website_privilege (priviledge_website, webPriviledge_developer_fk, webPriviledge_website_fk) 
    SELECT 'read', websiteRole_developer_fk, websiteRole_website_fk
		FROM website_role 
        WHERE websiteRole_developer_fk = NEW.websiteRole_developer_fk;
    
    END;
    
END IF;


END
$$
/*Website_role_delete*/ 

CREATE DEFINER=`dalonzom`@`%` TRIGGER `cs5200`.`website_role_AFTER_DELETE` AFTER DELETE ON `website_role` FOR EACH ROW
BEGIN
	DELETE FROM website_privilege WHERE website_privilege.webPriviledge_developer_fk = website_role.websiteRole_developer_fk AND website_role.websiteRole_website_fk = website_privilege.webPriviledge_website_fk; 
END
$$
/*Page_role_create*/ 
CREATE DEFINER=`dalonzom`@`%` TRIGGER `cs5200`.`page_role_AFTER_INSERT` AFTER INSERT ON `page_role` FOR EACH ROW
BEGIN
IF NEW.role = 'owner'   OR NEW.role = 'admin' THEN
	BEGIN
	INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
    SELECT 'create', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    
	INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
    SELECT 'read', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    
   INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
    SELECT 'update', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
   	
  INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
    SELECT 'delete', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    END;
END IF; 
IF NEW.role = 'writer' THEN 
	BEGIN
	INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
	SELECT 'create', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    
	INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk)  
    SELECT 'read', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    
   	INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
    SELECT 'update', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    END;
 END IF;   
IF NEW.role = 'editor' THEN
	BEGIN
	INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
    SELECT 'read', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    
 INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
    SELECT 'update', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    END;
END IF; 
IF NEW.role = 'reviewer' THEN
BEGIN
INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
    SELECT 'read', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    
    END;
END IF;
END
$$
/*Page_role_update*/ 
CREATE DEFINER=`dalonzom`@`%` TRIGGER `cs5200`.`page_role_AFTER_UPDATE` AFTER UPDATE ON `page_role` FOR EACH ROW
BEGIN
 DELETE FROM page_priviledge WHERE pageRole_developer_fk = page_priviledge.pagePriviledge_developer_fk   AND page_priviledge.pagePrivildege_page_fk = page_role.pageRole_page_fk; 
IF NEW.role = 'owner'   OR NEW.role = 'admin' THEN
	BEGIN
	INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
    SELECT 'create', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    
	INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
    SELECT 'read', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    
   INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
    SELECT 'update', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
   	
  INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
    SELECT 'delete', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    END;
END IF; 
IF NEW.role = 'writer' THEN 
	BEGIN
	INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
	SELECT 'create', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    
	INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk)  
    SELECT 'read', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    
   	INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
    SELECT 'update', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    END;
 END IF;   
IF NEW.role = 'editor' THEN
	BEGIN
	INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
    SELECT 'read', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    
 INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
    SELECT 'update', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    END;
END IF; 
IF NEW.role = 'reviewer' THEN
BEGIN
INSERT INTO page_priviledge (priviledge, pagePriviledge_developer_fk, pagePrivildege_page_fk) 
    SELECT 'read', pageRole_developer_fk, pageRole_page_fk
		FROM page_role
        WHERE pageRole_developer_fk = NEW.pageRole_developer_fk AND pageRole_page_fk = NEW.pageRole_page_fk; 
    
    END;
END IF;
END
$$
/*Page_role_delete*/ 
CREATE DEFINER=`dalonzom`@`%` TRIGGER `cs5200`.`page_role_BEFORE_DELETE` BEFORE DELETE ON `page_role` FOR EACH ROW
BEGIN
DELETE FROM page_priviledge WHERE page_role.pageRole_developer_fk = page_priviledge.pagePriviledge_developer_fk   AND page_priviledge.pagePrivildege_page_fk = page_role.pageRole_page_fk; 
END
$$
