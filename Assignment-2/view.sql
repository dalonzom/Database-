CREATE VIEW `developer_role_and_privileges` AS
SELECT p.first_name, p.last_name, p.username, p.email, w_role.role, w.name, w.updated,w.visits, w_priv.priviledge_website, page.title, page.views, page.updatedDate, p_role.roles, p_priv.priviledge FROM person p 
JOIN developer d ON d.developer_person_generalization = p.id
JOIN website_role w_role ON w_role.websiteRole_developer_fk = p.id
JOIN website w ON w_role.websiteRole_website_fk = w.id
JOIN website_privilege w_priv ON w_priv.webPriviledge_developer_fk = w_role.websiteRole_developer_fk AND w_priv.webPriviledge_website_fk = w_role.websiteRole_website_fk
JOIN page ON page.page_website_fk = w.id
JOIN page_role p_role ON p_role.pageRole_developer_fk = p.id AND p_role.pageRole_page_fk = page.id
JOIN page_priviledge p_priv ON p_priv.pagePriviledge_developer_fk = p_role.pageRole_developer_fk AND p_priv.pagePrivildege_page_fk = p_role.pageRole_page_fk;
